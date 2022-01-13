package DAY_23;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DB.DBConn;

public class SiboardDao extends DBConn {
    PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;

    /*******
     * select - 전체리스트 출력
     */
    public ArrayList<SiboardVO> select() {
        ArrayList<SiboardVO> list = new ArrayList<SiboardVO>();

        try {
            String sql = "select rownum rno, btitle, bhit, id, to_char(bdate,'yyyy/mm/dd') bdate,bid " +
                    " from (select bid,btitle, bhit, id, bdate from siboard " +
                    "      order by bdate desc)";
            pstmt = getPreparedStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                SiboardVO vo = new SiboardVO();
                vo.setRno(rs.getInt(1));
                vo.setBtitle(rs.getString(2));
                vo.setBhit(rs.getInt(3));
                vo.setId(rs.getString(4));
                vo.setBdate(rs.getString(5));
                vo.setBid(rs.getString(6));

                list.add(vo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return list;
    }

    /*******
     * select - 글내용 확인
     */
    public SiboardVO select(String bid) {
        SiboardVO vo = new SiboardVO();

        try {
            String sql = "select bid, btitle, bcontent, id from siboard where bid=?";
            pstmt = getPreparedStatement(sql);
            pstmt.setString(1, bid);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                vo.setBid(rs.getString(1));
                vo.setBtitle(rs.getString(2));
                vo.setBcontent(rs.getString(3));
                vo.setId(rs.getString(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return vo;
    }


    /*******
     * insert - 글쓰기
     */
    public int insert(SiboardVO vo) {
        int result = 0;

        try {
            String sql = "insert into siboard "
                    + " values('b_'||sequ_siboard_bid.nextval,?,?,0,sysdate,?) ";
            pstmt = getPreparedStatement(sql);

            pstmt.setString(1, vo.getBtitle());
            pstmt.setString(2, vo.getBcontent());
            pstmt.setString(3, vo.getId());

            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    /*******
     * update - 글수정
     */
    public int update(SiboardVO vo) {
        int result = 0;

        try {
            String sql = "update siboard set btitle=?, bcontent=? "
                    + " where bid=?";
            pstmt = getPreparedStatement(sql);
            pstmt.setString(1, vo.getBtitle());
            pstmt.setString(2, vo.getBcontent());
            pstmt.setString(3, vo.getBid());

            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    /*******
     * delete - 글삭제
     */
    public int delete(String bid) {
        int result = 0;

        try {
            String sql = "delete from siboard where bid=?";
            pstmt = getPreparedStatement(sql);
            pstmt.setString(1, bid);
            result = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    /*******
     * updateHit - 조회수 업데이트
     */
    public void updateHit(String bid) {
        try {
            String sql = "update siboard set bhit=bhit+1 where bid=?";
            pstmt = getPreparedStatement(sql);
            pstmt.setString(1, bid);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /****
     * 검색
     */
    public ArrayList<SiboardVO> search(String item, String data) {
        ArrayList<SiboardVO> list = new ArrayList<SiboardVO>();

        try {
            String colname = "";
            if (item.equals("제목")) {
                colname = "btitle";
            } else if (item.equals("내용")) {
                colname = "bcontent";
            } else if (item.equals("작성자")) {
                colname = "id";
            }

            String sql = " select rownum rno, bid, btitle, bhit, to_char(bdate,'yyyy/mm/dd') bdate, id "
                    + " from (select bid, btitle, bhit, bdate, id from siboard "
                    + " where " + colname + " like '%" + data + "%' "
                    + " order by bdate desc)";
//			System.out.println(sql);
            stmt = getStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                SiboardVO vo = new SiboardVO();
                vo.setRno(rs.getInt(1));
                vo.setBid(rs.getString(2));
                vo.setBtitle(rs.getString(3));
                vo.setBhit(rs.getInt(4));
                vo.setBdate(rs.getString(5));
                vo.setId(rs.getString(6));

                list.add(vo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}