package KeyCap;

import DB.DB_System;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserManager {
    public static final UserManager INSTANCE = new UserManager();
    private final ArrayList<User> users = new ArrayList<>();
    private User loginUser = null;

    public UserManager() {
        // TODO Delete it later. It is test data.
//        User user = new User();
//        user.setName("admin");
//        user.setId("id");
//        user.setPassword("pw");
//        users.add(user);
//
//        user = new User();
//        user.setName("rlawogns");
//        user.setId("rlawogns123");
//        user.setPassword("wognswogns12");
//        users.add(user);
//
//        user = new User();
//        user.setName("rkdaudgks");
//        user.setId("rkdaudgks1234");
//        user.setPassword("qwerty");
//        users.add(user);
    }

//    public void addUser(User user) {
//        users.add(user);
//
//    }

    public int addUser(User user) {
        int result = 0;

        try {
            String sql = "INSERT INTO POKE VALUES(?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";

            PreparedStatement stmt = DB_System.INSTANCE.getPreparedStatement(sql);
            stmt.setString(1, user.getDetailAddress());
            stmt.setString(2, user.getAddress());
            stmt.setString(3, user.getId());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getGender());
            stmt.setString(6, user.getName());
            stmt.setString(7, user.getNumber());
            stmt.setString(8, user.getEmail());

            result = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getLogin(User user) {
        int result = 0;
        try {
            String sql = "SELECT KCPASS FROM POKE WHERE KCID = ?";
            PreparedStatement stmt = DB_System.INSTANCE.getPreparedStatement(sql);
            stmt.setString(1, user.getId());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String DBpass = rs.getString("KCPASS");
                if (DBpass.equals(user.getPassword())) {
                    result = 1;
                } else {
                    result = 2;
                }
            } else {
                result = 3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        loginUser(user);

        return result;
    }

    public User loginUser(User user) {
        return user;
    }

    public User getLoginUser() {
        return loginUser;
    }

    public Order findUserOrder(String identifier) {
        Order order = new Order();

        try {
            //String sql = "SELECT POKEMON, MATERIALTYPE, PRINTINGMETHOD, PRINTINGPROCESS, PROFILE, NVL(INFORMATION1, ' '), NVL(INFORMATION2, ' '), KEYTYPE FROM POKEORDER WHERE RANDOMNUM = ?";
            String sql = "SELECT * FROM POKEORDER WHERE RANDOMNUM = ?";
            PreparedStatement stmt = DB_System.INSTANCE.getPreparedStatement(sql);
            stmt.setString(1, identifier);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                order.pokemon = rs.getString("POKEMON");
                order.materialType = rs.getString("MATERIALTYPE");
                order.printingMethod = rs.getString("PRINTINGMETHOD");
                order.printingProcess = rs.getString("PRINTINGPROCESS");
                order.profile = rs.getString("PROFILE");
                try {
                    order.extraInfo1 = rs.getString("INFORMATION1");
                } catch (Exception e) {
                    order.extraInfo1 = " ";
                    e.printStackTrace();
                    throw e;
                }
                order.extraInfo2 = rs.getString("INFORMATION2");
                try {
                    order.extraInfo2 = rs.getString("INFORMATION2");
                } catch (Exception e) {
                    order.extraInfo2 = " ";
                    e.printStackTrace();
                    throw e;
                }
                order.setKeyData(rs.getString("KEYTYPE"));
            } else {
                order.pokemon = "null";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return order;
    }

    public boolean deleteUserOrder(String num) {
        boolean result = true;

        try {
            String sql = "SELECT * FROM POKEORDER WHERE RANDOMNUM = ?";
            PreparedStatement stmt = DB_System.INSTANCE.getPreparedStatement(sql);
            stmt.setString(1, num);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                sql = "DELETE FROM POKEORDER WHERE RANDOMNUM = ?";
                stmt = DB_System.INSTANCE.getPreparedStatement(sql);
                stmt.setString(1, num);
            } else {
                result = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // id가 맞고, pwd가 맞고
    public LoginResult login(String id, String password) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getId().equals(id)) {
                if (user.getPassword().equals(password)) {
                    loginUser = user;
                    return LoginResult.SUCCESS;
                } else {
                    return LoginResult.WRONG_PASSWORD;
                }
            }
        }
        return LoginResult.NOT_EXIST_USER;
    }

    public enum LoginResult {
        SUCCESS, WRONG_PASSWORD, NOT_EXIST_USER
    }
}
