package KeyCap;

import DB.DB_System;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Order {

    public String pokemon;
    public String materialType;
    public String printingMethod;
    public String printingProcess;
    public String profile;
    public String extraInfo1;
    public String extraInfo2;
    public KeyType keyType;
    private String KeyData;
    private String randomNumber;

    public String getKeyData() {
        return KeyData;
    }

    public void setKeyData(String keyData) {
        KeyData = keyData;
    }

    public String getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(String randomNumber) {
        this.randomNumber = randomNumber;
    }

    public boolean addOrder(Order order) {
        try {
            String sql = "INSERT INTO POKEORDER VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = DB_System.INSTANCE.getPreparedStatement(sql);
            stmt.setString(1, order.pokemon);
            stmt.setString(2, order.materialType);
            stmt.setString(3, order.printingMethod);
            stmt.setString(4, order.printingProcess);
            stmt.setString(5, order.profile);
            stmt.setString(6, order.extraInfo1);
            stmt.setString(7, order.extraInfo2);
            stmt.setString(8, String.valueOf(order.keyType));
            stmt.setString(9, order.getRandomNumber());

            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
