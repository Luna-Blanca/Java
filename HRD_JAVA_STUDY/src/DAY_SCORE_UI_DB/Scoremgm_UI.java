package DAY_SCORE_UI_DB;

import DAY_SCORE_UI_DB.Scoremgm.Scoremgm;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Scoremgm_UI extends JFrame {
    //Field
    Scoremgm system;
    ScoreDao dao = new ScoreDao();
    String[] menuList = {"등록", "조회", "검색", "수정", "삭제", "종료"};
    JPanel menu_panel, title_panel, content_panel, insert_panel, select_panel, search_panel, update_panel, delete_panel, count_panel;
    Scoremgm_Event event_object;
    ArrayList<JButton> button_list = new ArrayList<JButton>(menuList.length);
    JTextField tf_count;

    public static final int INSERT = 1;
    public static final int SELECT = 2;
    public static final int SEARCH = 3;
    public static final int UPDATE = 4;
    public static final int DELETE = 5;


    //Constructor
    public Scoremgm_UI() {
        init();
    }

    //Method
    public void init() {
        setTitle("성적관리시스템");
        system = new Scoremgm();
        event_object = new Scoremgm_Event(this);
        title_panel = new JPanel(new BorderLayout());
        content_panel = new JPanel();
        insert_panel = new JPanel();
        select_panel = new JPanel();
        search_panel = new JPanel();
        update_panel = new JPanel();
        delete_panel = new JPanel();
        count_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        tf_count = new JTextField("0");
        tf_count.setEditable(true);
        count_panel.add(new JLabel("등록인원 : " + system.scorelist.size()));
        count_panel.setEnabled(true);

        menu_panel = new JPanel(new GridLayout(6, 1, 3, 3));
        JLabel j1 = new JLabel("*******************", JLabel.CENTER);
        JLabel j2 = new JLabel("성적 관리 시스템", JLabel.CENTER);
        JLabel j3 = new JLabel("*******************", JLabel.CENTER);
        title_panel.add(j1, BorderLayout.NORTH);
        title_panel.add(j2, BorderLayout.CENTER);
        title_panel.add(j3, BorderLayout.SOUTH);

        for (String menu : menuList) {
            JButton jb_menu = new JButton("   " + menu + "   ");
            menu_panel.add(jb_menu);
            jb_menu.addActionListener(event_object);
            button_list.add(jb_menu);
        }

//        score_panel.setLayout(new BorderLayout());
//        score_panel.add(new JLabel("Score", JLabel.CENTER));

        content_panel.setLayout(new BorderLayout());
        content_panel.add(new JLabel("-- MAIN --", JLabel.CENTER));

        //content_panel.add(new JLabel("***** 메인 *****"));
        add(menu_panel, BorderLayout.WEST);
        add(title_panel, BorderLayout.NORTH);
        add(content_panel, BorderLayout.CENTER);
        add(count_panel, BorderLayout.SOUTH);

        addWindowListener(event_object);

        setSize(700, 350);
        setVisible(true);

        new CountObject(this, system).start();
    }

    //Method
    public void switch_panel(int menu) {
        content_panel.setLayout(new FlowLayout());
        content_panel.removeAll();
        insert_panel.setVisible(false);
        select_panel.setVisible(false);
        search_panel.setVisible(false);
        update_panel.setVisible(false);
        delete_panel.setVisible(false);
//        switch (menu) {
//            case INSERT:
//            case SELECT:
//            case SEARCH:
//            case UPDATE:
//            case DELETE:
//                content_panel.removeAll();
//                insert_panel.setVisible(true);
//                break;
//        }
        switch (menu) {
            case INSERT:
                insert_panel.removeAll();
                insert_panel.setVisible(true);
                break;
            case SELECT:
                select_panel.removeAll();
                select_panel.setVisible(true);
                break;
            case SEARCH:
                search_panel.removeAll();
                search_panel.setVisible(true);
                break;
            case UPDATE:
                update_panel.removeAll();
                update_panel.setVisible(true);
                break;
            case DELETE:
                delete_panel.removeAll();
                delete_panel.setVisible(true);
                break;
        }
    }
}
