package DAY_21_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * DB연동 단계
 * 1. Driver 준비 : oracle - jdbc 드라이버 - java_home\jre\lib\ext
 * 2. 드라이버 로딩
 * 3. Connection 객체 생성
 * 4. Statement 객체 생성
 * 5. ResultSet 객체 생성
 * 6. 데이터 출력
 * 7. close
 */

public class DBConnectionTest {
    public static void main(String[] args) {
        //2 . 드라이버 로딩
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("SYSTEM : 드라이버 로딩 성공");

            //3 . Connection 객체 생성
            String url = "jdbc:oracle:thin:@localhost:1521:system";
            String user = "SCOTT";
            String pass = "TIGER";
            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("SYSTEM : Connection 객체 생성 성공");

            //4 . Statement 객체 생성
            Statement stmt = conn.createStatement();

            //5 . ResultSet 객체 생성
            String sql = "SELECT * FROM EMP";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println();
            System.out.println("EMPNO\tNAME\tJOB\tMGR\tHIREDATE\tSAL\tCOMM\tDEPTNO");
            while (rs.next()) {
                System.out.print(rs.getInt(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.print(rs.getInt(4) + "\t");
                System.out.print(rs.getString(5) + "\t");
                System.out.print(rs.getDouble(6) + "\t");
                System.out.print(rs.getDouble(7) + "\t");
                System.out.println(rs.getInt(8) + "\t");
            }

            //6 . close
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("!!! 오류가 발생했습니다.");
        }
    }
}
