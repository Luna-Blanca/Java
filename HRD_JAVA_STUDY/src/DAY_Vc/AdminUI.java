package DAY_Vc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AdminUI extends JFrame {
    public DBAction DB;
    String[] menuList = {" ", "등록", "목록", "검색", "수정", "삭제", " "};
    //String[] menuList = {"등록", "목록", "검색", "수정", "삭제", "종료"};
    public JPanel menuP, titleP, mainP, empty1P, empty2P, enrollP, listP, searchP, editP, deleteP;
    //public JPanel menuP, titleP, mainP, empty1P, empty2P, enrollP, listP, searchP, editP, deleteP, exitP;
    UserUI_Event event;
    ArrayList<JButton> button_list = new ArrayList<>(menuList.length);

    public static final int EMPTY1 = 1;
    public static final int ENROLL = 2;
    public static final int LIST = 3;
    public static final int SEARCH = 4;
    public static final int EDIT = 5;
    public static final int DELETE = 6;
    public static final int EMPTY2 = 7;
    //public final int EXIT = 6;

    public AdminUI() {
        init();
    }

    public void init() {
        setTitle("VACCINE . SYSTEM_MODE");

        Font font = new Font("맑은 고딕", Font.PLAIN, 16);
        UIManager.put("Button.font", font);
        UIManager.put("Label.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("TextArea.font", font);
        UIManager.put("Table.font", font);
        UIManager.put("TableHeader.font", font);

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

        DB = new DBAction();
        event = new UserUI_Event(this);
        titleP = new JPanel(new BorderLayout());
        mainP = new JPanel();
        empty1P = new JPanel();
        enrollP = new JPanel();
        listP = new JPanel();
        searchP = new JPanel();
        editP = new JPanel();
        deleteP = new JPanel();
        empty2P = new JPanel();
        //exitP = new JPanel();

        menuP = new JPanel(new GridLayout(7, 1, 1, 1));
        //menuP = new JPanel(new GridLayout(6, 1, 2, 2));
        JLabel jl1 = new JLabel("  Vaccine  ", JLabel.CENTER);
        titleP.add(jl1, BorderLayout.CENTER);

        for (String menu : menuList) {
            JButton jb_menu = new JButton(" " + menu + " ");
            menuP.add(jb_menu);
            jb_menu.addActionListener(event);
            button_list.add(jb_menu);
        }

        mainP.add(new JLabel(" -- MAIN UI -- ", JLabel.CENTER));
        add(menuP, BorderLayout.WEST);
        add(titleP, BorderLayout.NORTH);
        add(mainP, BorderLayout.CENTER);

        setSize(800, 350);
        setVisible(true);
    }

    public void switchP(int menu) {
        mainP.removeAll();
        empty1P.setVisible(false);
        enrollP.setVisible(false);
        listP.setVisible(false);
        searchP.setVisible(false);
        editP.setVisible(false);
        deleteP.setVisible(false);
        empty2P.setVisible(false);
        //exitP.setVisible(false);

        switch (menu) {
            case EMPTY1:
                empty1P.removeAll();
                empty1P.setVisible(false);
            case ENROLL:
                enrollP.removeAll();
                enrollP.setVisible(true);
                break;
            case LIST:
                listP.removeAll();
                listP.setVisible(true);
                break;
            case SEARCH:
                searchP.removeAll();
                searchP.setVisible(true);
                break;
            case EDIT:
                editP.removeAll();
                editP.setVisible(true);
                break;
            case DELETE:
                deleteP.removeAll();
                deleteP.setVisible(true);
                break;
            case EMPTY2:
                empty2P.removeAll();
                empty2P.setVisible(false);
            //case EXIT;
                //exitP.removeall();
                //exitP.setVisible(true);
                //break;
        }
    }
}
