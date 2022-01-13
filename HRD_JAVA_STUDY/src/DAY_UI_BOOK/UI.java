package DAY_UI_BOOK;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI extends JFrame {
    public Book system;
    String[] menuList = {"등록", "목록", "검색", "수정", "삭제", "종료"};
    public JPanel menu_panel, title_panel, content_panel, insert_panel, list_panel, search_panel, update_panel, delete_panel, exit_panel;
    Book_EVENT event_object;
    ArrayList<JButton> button_list = new ArrayList<JButton>(menuList.length);

    public static final int INSERT = 1;
    public static final int LIST = 2;
    public static final int SEARCH = 3;
    public static final int UPDATE = 4;
    public static final int DELETE = 5;

    public UI() {
        init();
    }

    public void init() {
        setTitle("도서 목록 조회.exe");

        // 창 폰트
        Font font = new Font("맑은 고딕", Font.PLAIN, 12);
        UIManager.put("Button.font", font);
        UIManager.put("Label.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("TextArea.font", font);
        UIManager.put("Table.font", font);
        UIManager.put("TableHeader.font", font);

        // 현재 실행되는 플랫폼 스타일로 보여짐
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        system = new Book();
        event_object = new Book_EVENT(this);
        title_panel = new JPanel(new BorderLayout());
        content_panel = new JPanel();
        insert_panel = new JPanel();
        list_panel = new JPanel();
        search_panel = new JPanel();
        update_panel = new JPanel();
        delete_panel = new JPanel();

        menu_panel = new JPanel(new GridLayout(6, 1, 2, 2));
        JLabel jl1 = new JLabel("도서 관리 프로그램", JLabel.CENTER);
        title_panel.add(jl1, BorderLayout.CENTER);

        for (String menu : menuList) {
            JButton jb_menu = new JButton("  " + menu + "  ");
            menu_panel.add(jb_menu);
            jb_menu.addActionListener(event_object);
            button_list.add(jb_menu);
        }


        content_panel.add(new JLabel("-- MAIN --", JLabel.CENTER));
        add(menu_panel, BorderLayout.WEST);
        add(title_panel, BorderLayout.NORTH);
        add(content_panel, BorderLayout.CENTER);

        addWindowListener(event_object);

        setSize(600, 300);
        setVisible(true);
    }

    public void switch_panel(int menu) {
        content_panel.removeAll();
        insert_panel.setVisible(false);
        list_panel.setVisible(false);
        search_panel.setVisible(false);
        update_panel.setVisible(false);
        delete_panel.setVisible(false);

        switch (menu) {
            case INSERT:
                insert_panel.removeAll();
                insert_panel.setVisible(true);
                break;
            case LIST:
                list_panel.removeAll();
                list_panel.setVisible(true);
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
