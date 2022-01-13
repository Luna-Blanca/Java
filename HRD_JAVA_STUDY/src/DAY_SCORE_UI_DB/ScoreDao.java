package DAY_SCORE_UI_DB;

import DB.DBConn;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ScoreDao extends DBConn {
    Statement stmt;
    ResultSet rs;

    public ScoreDao() {
    }

    /**
     * 데이터 추가 : insert
     */
    public int insert(ScoreVO vo) {
        int result = 0;

        try {
            String sql = "INSERT INTO SCORE VALUES('" + vo.getName() + "'"
                    + "," + vo.getKor()
                    + "," + vo.getEng()
                    + "," + vo.getMath()
                    + ", SYSDATE)";

            stmt = getStatement();
            result = stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 데이터 조회 : select
     */
    public ArrayList<ScoreVO> select() {
        ArrayList<ScoreVO> list = new ArrayList<ScoreVO>();

        try {
            String sql = "SELECT NAME, KOR, ENG, MATH, KOR+ENG+MATH TOT, (KOR+ENG+MATH)/3 AVG FROM SCORE";
            stmt = getStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ScoreVO vo = new ScoreVO();
                vo.setName(rs.getString(1));
                vo.setKor(rs.getInt(2));
                vo.setEng(rs.getInt(3));
                vo.setMath(rs.getInt(4));
                vo.setTot(rs.getInt(5));
                vo.setAvg(rs.getInt(6));
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ScoreVO select(String name) {
        ScoreVO vo = new ScoreVO();

        try {
            String sql = "SELECT NAME, KOR, ENG, MATH, KOR+ENG+MATH TOT, (KOR+ENG+MATH)/3 AVG FROM SCORE WHERE NAME = '" + name + "'";

            stmt = getStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                vo.setName(rs.getString(1));
                vo.setKor(rs.getInt(2));
                vo.setEng(rs.getInt(3));
                vo.setMath(rs.getInt(4));
                vo.setTot(rs.getInt(5));
                vo.setAvg(rs.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }

    public int update(ScoreVO vo) {
        int result = 0;

        try {
            String sql = "UPDATE SCORE SET KOR = " + vo.getKor() + ", ENG = " + vo.getEng() + ", MATH = " + vo.getMath() + "WHERE NAME = '" + vo.getName() + "'";
            stmt = getStatement();
            result = stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(String name) {
        int result = 0;

        try {
            String sql = "DELETE FROM SCORE WHERE NAME = '" + name + "'";
            stmt = getStatement();
            result = stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
