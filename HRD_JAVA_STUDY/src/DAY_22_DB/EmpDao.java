package DAY_22_DB;

import DB.DBConn;

import java.sql.*;
import java.util.ArrayList;

public class EmpDao extends DBConn {
    Statement stmt;
    ResultSet rs;

    public EmpDao() { }

    public ArrayList<EmpVO> getList() {
        ArrayList<EmpVO> list = new ArrayList<EmpVO>();
        stmt = getStatement();

        try {
            String sql = "select empno, ename, job, mgr, to_char(hiredate, 'yyyy/mm/dd') hiredate, to_char(sal, '99,999') sal, to_char(comm, '99,999'), deptno from emp ";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                EmpVO vo = new EmpVO();
                vo.setEmpno(rs.getInt(1));
                vo.setEname(rs.getString(2));
                vo.setJob(rs.getString(3));
                vo.setMgr(rs.getInt(4));
                vo.setHiredate(rs.getString(5));
                vo.setSal(rs.getString(6));
                vo.setComm(rs.getString(7));
                vo.setDeptno(rs.getInt(8));

                list.add(vo);
            }
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<EmpVO> getSearch(String item, String param) {
        ArrayList<EmpVO> list = new ArrayList<>();
        stmt = getStatement();

        String col_name = " ";
        if(item.equals("사원번호"))  {
            col_name = "empno";
        } else if(item.equals("사원명")) {
            col_name = "ename";
            param = "'" + param + "'";
        } else if(item.equals("부서번호")) {
            col_name = "deptno";
        }
        try {
            String sql = "SELECT EMPNO, ENAME, JOB, MGR, TO_CHAR(HIREDATE, 'YYYY/MM/DD'), TO_CHAR(SAL, '99,999'), TO_CHAR(NVL(COMM, 0), '99,999'), DEPTNO FROM EMP WHERE "+ col_name + " = " + param;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                EmpVO vo = new EmpVO();
                vo.setEmpno(rs.getInt(1));
                vo.setEname(rs.getString(2));
                vo.setJob(rs.getString(3));
                vo.setMgr(rs.getInt(4));
                vo.setHiredate(rs.getString(5));
                vo.setSal(rs.getString(6));
                vo.setComm(rs.getString(7));
                vo.setDeptno(rs.getInt(8));
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
        return list;
    }

    public ArrayList<EmpVO> getSearch(String item) {
        ArrayList<EmpVO> list = new ArrayList<>();
        stmt = getStatement();
        try {
            String sql = "SELECT EMPNO, ENAME, JOB, MGR, TO_CHAR(HIREDATE, 'YYYY/MM/DD'), TO_CHAR(SAL, '99,999'), TO_CHAR(NVL(COMM, 0), '99,999'), DEPTNO FROM EMP WHERE EMPNO FROM EMP";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                EmpVO vo = new EmpVO();
                vo.setEmpno(rs.getInt(1));
                vo.setEname(rs.getString(2));
                vo.setJob(rs.getString(3));
                vo.setMgr(rs.getInt(4));
                vo.setHiredate(rs.getString(5));
                vo.setSal(rs.getString(6));
                vo.setComm(rs.getString(7));
                vo.setDeptno(rs.getInt(8));
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
        return list;
    }
}
