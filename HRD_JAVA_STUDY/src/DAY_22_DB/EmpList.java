package DAY_22_DB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

public class EmpList extends WindowAdapter implements ActionListener {
    JFrame jf;
    JPanel listP, searchP;
    String[] colNames = {"EMPNO", "ENAME", "JOB", "MGR", "HIREDATE", "SAL", "COMM", "Deptno"};
    DefaultTableModel model = new DefaultTableModel(colNames, 0);
    JTable table = new JTable(model);
    Object[] row = new Object[colNames.length];
    JScrollPane pane;

    JTextField tf_search;
    JButton btn_search;
    JComboBox<String> menulist;


    public EmpList() {
        init();
    }

    public void init() {
        jf = new JFrame("EMP 테이블");
        listP = new JPanel();
        searchP = new JPanel();

        createJTableData();
        table.setModel(model);

        pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(600, 500));
        listP.add(pane);

        String[] mlist = {"전체", "사원번호", "사원명", "부서번호"};
        menulist = new JComboBox<String>(mlist);
        menulist.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
        tf_search = new JTextField(20);
        btn_search = new JButton("검색");
        searchP.add(menulist);
        searchP.add(tf_search);
        searchP.add(btn_search);

        jf.add(listP, BorderLayout.CENTER);
        jf.add(searchP, BorderLayout.NORTH);

        jf.setSize(700, 600);
        jf.setVisible(true);

        tf_search.addActionListener(this);
        btn_search.addActionListener(this);
        jf.addWindowFocusListener(this);
    }

    public void createJTableData() {
        int no = 1;
        model.setRowCount(0);
        EmpDao dao = new EmpDao();
        ArrayList<EmpVO> list = dao.getList();

        for (EmpVO vo : list) {
            row[0] = vo.getEmpno();
            row[1] = vo.getEname();
            row[2] = vo.getJob();
            row[3] = vo.getMgr();
            row[4] = vo.getHiredate();
            row[5] = vo.getSal();
            row[6] = vo.getComm();
            row[7] = vo.getDeptno();

            model.addRow(row);
        }

        model.fireTableDataChanged();

        table.setModel(model);
    }

    public void search() {
        EmpDao dao = new EmpDao();
        ArrayList<EmpVO> search_list = null;

        int idx = menulist.getSelectedIndex();
        String item = menulist.getItemAt(idx);
        if (item.equals("전체")) {
            tf_search.setText("");
            search_list = dao.getSearch(item);

            model.setRowCount(0);
            for (EmpVO vo : search_list) {
                row[0] = vo.getEmpno();
                row[1] = vo.getEname();
                row[2] = vo.getJob();
                row[3] = vo.getMgr();
                row[4] = vo.getHiredate();
                row[5] = vo.getSal();
                row[6] = vo.getComm();
                row[7] = vo.getDeptno();
                model.addRow(row);
            }
            model.fireTableDataChanged();
        } else {
            if (ValicationCheck()) {
                search_list = dao.getSearch(tf_search.getText());

                model.setRowCount(0);
                for (EmpVO vo : search_list) {
                    row[0] = vo.getEmpno();
                    row[1] = vo.getEname();
                    row[2] = vo.getJob();
                    row[3] = vo.getMgr();
                    row[4] = vo.getHiredate();
                    row[5] = vo.getSal();
                    row[6] = vo.getComm();
                    row[7] = vo.getDeptno();
                    model.addRow(row);
                }
                model.fireTableDataChanged();
            }
        }

    }

    public boolean ValicationCheck() {
        boolean result = false;

        if (tf_search.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "사원번호를 입력해주세요.");
            tf_search.requestFocus();
        } else {
            result = true;
        }

        return result;
    }

    public void WindowsClosing(WindowEvent event) {
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == tf_search || obj == btn_search) {
            search();
        }
    }
}
