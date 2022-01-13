package DAY_23;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import DB.DBConn;

public class SiboardMemberDao extends DBConn {
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;

    /**
     * 내용 : 로그인
     */
    public int getLogin(SiboardMemberVO vo) {
        int result = 0;

        try {
            String sql = "select count(*) from siboard_member where id=? and pass=?";
            pstmt = getPreparedStatement(sql);
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getPass());

            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    /**
     * 내용 : 아이디 중복체크
     */
    public int getIdCheck(String id) {
        int result = 0;

        try {
            String sql = "select count(*) from siboard_member where id=?";
            pstmt = getPreparedStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }

//			close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    /**
     * 내용 : 회원 가입 처리
     */
    public int insert(SiboardMemberVO vo) {
        int result = 0;

        try {
            String sql = "insert into siboard_member values(?,?,?,?,sysdate)";
            pstmt = getPreparedStatement(sql);
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getPass());
            pstmt.setString(3, vo.getName());
            pstmt.setString(4, vo.getHp());

            result = pstmt.executeUpdate();
//			close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
