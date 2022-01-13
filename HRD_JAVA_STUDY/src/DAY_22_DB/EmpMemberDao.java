package DAY_22_DB;

import DB.DBConn;
import com.sun.org.apache.xpath.internal.SourceTree;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.sql.Statement;

public class EmpMemberDao extends DBConn {
    Statement stmt;
    ResultSet rs;

    public EmpMemberDao() { }

    public int getInsertResult(EmpMemberVO vo) {
        int result = 0;

        try {
            String sql = "INSERT INTO EMP_MEMBER VALUES('" + vo.getId() + "' ,"
                    + "'" + vo.getPass() + "' ,"
                    + "'" + vo.getName() + "' ,"
                    + "'" + vo.getEmail() + "' ,"
                    + "'" + vo.getHp() + "', SYSDATE)";
            stmt = getStatement();
            result = stmt.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public int getIdCheck(String id) {
        int result = 0;

        try {
            String sql = "SELECT COUNT(*) FROM EMP_MEMBER WHERE ID = '" + id + "'";
            stmt = getStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public int getLogin(EmpMemberVO vo) {
        int result = 0;

        try {
            String sql = "SELECT COUNT(*) FROM EMP MEMBER WHERE ID = '" + vo.getId() + "' AND PASS = '" + vo.getPass() + "'";

            stmt = getStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
