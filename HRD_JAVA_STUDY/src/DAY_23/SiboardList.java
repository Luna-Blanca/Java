package DAY_23;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SiboardList extends MouseAdapter implements ActionListener {
    //Field
    SiboardDao boardDao;
    SiboardMain main;
    JPanel north_panel, south_panel, list_panel;
    JButton btn_logout, btn_exit, btn_search, btn_write;
    JTextField tf_search;
    JComboBox<String> search_list;
    JTable list_table;
    DefaultTableModel list_table_model;
    ArrayList<SiboardVO> list;

    //Constructor
    public SiboardList(SiboardMain main) {
        this.main = main;
        init();
    }

    /**
     * 화면 구현
     */
    public void init() {
        boardDao = new SiboardDao();
        main.jf.setTitle("Siboard - 리스트");
        north_panel = new JPanel();
        south_panel = new JPanel();
        list_panel = new JPanel();

        //north_panel : 로그인 아이디 출력, GridBagLayout 적용
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        north_panel.setLayout(gb);
        JPanel p1 = new JPanel();        //이미지, 로그아웃 버튼
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));        //로그인한 아이디
        p2.setBackground(Color.green);

        JLabel img = new JLabel(new ImageIcon("images/burger_king3.png"));
        btn_logout = new JButton("로그아웃");
        btn_logout.setFont(Commons.getFont());
        p1.add(btn_logout);

        c.fill = GridBagConstraints.BOTH;
        gb.setConstraints(img, c);

//		c.weightx = 0.0;
        c.gridwidth = GridBagConstraints.REMAINDER;
        gb.setConstraints(p1, c);

        c.weightx = 1.0;
        JLabel login_info = new JLabel("[" + UserInfo.USER_ID + "] 님, 환영합니다.");
        login_info.setFont(Commons.getFont());
        p2.add(login_info);
        gb.setConstraints(p2, c);

        north_panel.add(img);
        north_panel.add(new JLabel("          "));
        north_panel.add(p1);
        north_panel.add(p2);

        //south_panel
        btn_exit = new JButton("종료");
        south_panel.setLayout(new BorderLayout());
        south_panel.add(btn_exit);

        //list_panel
        list_panel.setLayout(new BorderLayout());
        JPanel list_panel_north = new JPanel();
        JPanel list_panel_center = new JPanel();
        JPanel list_panel_south = new JPanel();
        list_panel_north.setBackground(Color.ORANGE);
        list_panel_center.setBackground(Color.ORANGE);
        list_panel_south.setBackground(Color.ORANGE);

        //-- list_panel_north : 검색조건
        list_panel_north.setLayout(new FlowLayout(FlowLayout.RIGHT));
        String[] search_name_list = {"제목", "내용", "작성자", "전체"};
        JLabel search_label = new JLabel("검색조건");
        search_list = new JComboBox<String>(search_name_list);
        tf_search = new JTextField(15);
        btn_search = new JButton("검색");
        search_label.setFont(Commons.getFont());
        search_list.setFont(Commons.getFont());
        tf_search.setFont(Commons.getFont());
        btn_search.setFont(Commons.getFont());

        list_panel_north.add(search_label);
        list_panel_north.add(search_list);
        list_panel_north.add(tf_search);
        list_panel_north.add(btn_search);

        //list_panel_center - 게시판 리스트
        list_panel_center = createList(list_panel_center);

        //list_panel_south - 글쓰기 버튼
        list_panel_south.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btn_write = new JButton("글쓰기");
        btn_write.setFont(Commons.getFont());
        list_panel_south.add(btn_write);

        list_panel.add(list_panel_north, BorderLayout.NORTH);
        list_panel.add(list_panel_center, BorderLayout.CENTER);
        list_panel.add(list_panel_south, BorderLayout.SOUTH);

        main.content_panel.setVisible(false);
        main.bottom_panel.setVisible(false);
        main.jf.add(north_panel, BorderLayout.NORTH);
        main.jf.add(list_panel, BorderLayout.CENTER);
        main.jf.add(south_panel, BorderLayout.SOUTH);

        //이벤트 호출
        btn_logout.addActionListener(this);
        tf_search.addActionListener(this);
        btn_search.addActionListener(this);
        btn_write.addActionListener(this);
        btn_exit.addActionListener(this);


    }//init

    /**
     * 게시판 리스트 화면 구현
     */
    public JPanel createList(JPanel list_panel_center) {
        //list_panel_center.setBackground(Color.yellow);
        //컬럼 생성
        Vector<String> col_list = new Vector<String>();
        col_list.add("번호");
        col_list.add("제목");
        col_list.add("작성자");
        col_list.add("조회수");
        col_list.add("작성일");

        list_table_model = new DefaultTableModel(col_list, 0);
        list_table = new JTable(list_table_model);

        //테이블 내용 생성
        list = boardDao.select();
        for (SiboardVO vo : list) {
            Vector<String> row = new Vector<String>();
            row.add(String.valueOf(vo.getRno()));    //번호
            row.add(vo.getBtitle());    //제목
            row.add(vo.getId());    //작성자
            row.add(String.valueOf(vo.getBhit())); //조회수
            row.add(vo.getBdate());    //작성일

            list_table_model.addRow(row);
        }

        list_table.setModel(list_table_model);

        JScrollPane scroll_pane = new JScrollPane(list_table);
        scroll_pane.setPreferredSize(new Dimension(470, 250));

        list_panel_center.add(scroll_pane);

        //JTable 이벤트 호출
        list_table.addMouseListener(this);

        return list_panel_center;
    }

    /**
     * 게시판 리스트 변경 시 호출 - 글쓰기 등록완료/수정 후
     */
    public void changeList() {

        list_table_model.setRowCount(0);

        //테이블 내용 생성
        list = boardDao.select();
        for (SiboardVO vo : list) {
            Vector<String> row = new Vector<String>();
            row.add(String.valueOf(vo.getRno()));    //번호
            row.add(vo.getBtitle());    //제목
            row.add(vo.getId());    //작성자
            row.add(String.valueOf(vo.getBhit())); //조회수
            row.add(vo.getBdate());    //작성일

            list_table_model.addRow(row);
        }

        list_table_model.fireTableDataChanged();
    }

    /**
     * 게시판 리스트 검색 결과 출력
     */
    public void changeList(ArrayList<SiboardVO> list) {

        list_table_model.setRowCount(0);

        //테이블 내용 생성
        //list = boardDao.select();
        for (SiboardVO vo : list) {
            Vector<String> row = new Vector<String>();
            row.add(String.valueOf(vo.getRno()));    //번호
            row.add(vo.getBtitle());    //제목
            row.add(vo.getId());    //작성자
            row.add(String.valueOf(vo.getBhit())); //조회수
            row.add(vo.getBdate());    //작성일

            list_table_model.addRow(row);
        }

        list_table_model.fireTableDataChanged();

    }

    /**
     * 액션 이벤트 처리
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == btn_logout) {    //로그아웃 버튼
            UserInfo.USER_ID = "";
            main.jf.setTitle("Siboard - 메인 화면");
            north_panel.setVisible(false);
            list_panel.setVisible(false);
            south_panel.setVisible(false);

            main.content_panel.setVisible(true);
            main.bottom_panel.setVisible(true);

        } else if (obj == tf_search || obj == btn_search) {
            String search_title = search_list.getItemAt(search_list.getSelectedIndex());
            String search_data = tf_search.getText();

            if (search_title.equals("전체")) {
                tf_search.setText("");
                changeList();    //전체리스트
            } else {
                if (search_data.equals("")) {
                    JOptionPane.showMessageDialog(null, "검색할 데이터를 입력해주세요");
                    tf_search.requestFocus();
                } else {
                    list = boardDao.search(search_title, search_data);
                    changeList(list);    //검색리스트
                }
            }

        } else if (obj == btn_write) {    //글쓰기 버튼

            new SiboardWrite(this);

        } else if (obj == btn_exit) {
            int choice = JOptionPane.showConfirmDialog(null, "정말로 종료하시겠습니까?");
            if (choice == 0) {
                main.memberDao.close();
                boardDao.close();
                System.exit(0);
            }
        }
    }

    /***
     * 마우스 이벤트 처리 - JTable row 선택 시
     */
    public void mouseClicked(MouseEvent e) {
        int row_number = list_table.getSelectedRow();
        SiboardVO vo = list.get(row_number);

        //상세조회화면 생성
        new SiboardContent(this, vo.getBid());

    }

}