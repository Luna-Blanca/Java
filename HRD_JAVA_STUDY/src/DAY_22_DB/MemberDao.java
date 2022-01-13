package DAY_22_DB;

import DB.DBConn;

import java.sql.*;

public class MemberDao extends DBConn {
    Statement stmt;
    ResultSet rs;

    public MemberDao() { }

    public int getLoging(MemberVO vo) {
        int result = 0;

        try {
            String sql = "SELECT COUNT(*) RESULT FROM EMP_MEMBER " +
                    "WHERE EID = '" + vo.getEid() + "' AND EPASS = '" + vo.getEpass() + "'";
            stmt = getStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                result = rs.getInt(1);
            }
            close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        return result;
    }
}

