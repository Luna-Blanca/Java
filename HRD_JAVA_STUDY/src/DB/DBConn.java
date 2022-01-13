package DB;

import java.sql.*;

public class DBConn {
    String url = "jdbc:oracle:thin:@localhost:1521:system";
    String user = "SCOTT";
    String pass = "TIGER";

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;

    public DBConn() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        try {
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stmt;
    }

    public PreparedStatement getPreparedStatement(String sql) {
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    public void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
