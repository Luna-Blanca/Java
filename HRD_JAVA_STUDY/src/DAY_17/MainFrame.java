package DAY_17;

import java.awt.*;

public class MainFrame extends Frame {
    Panel menu_panel;
    Label title;
    //Button insert,show,search,update,delete,exit;
    String[] namelist = {"등록", "출력", "검색", "수정", "삭제", "종료"};

    //Constructor
    public MainFrame() {
        menu_panel = new Panel(new GridLayout(6, 1));
        title = new Label("메뉴 테스트");

        for (String name : namelist) {
            Button button = new Button("  " + name + "  ");
            menu_panel.add(button);
        }

        add(title, BorderLayout.NORTH);
        add(menu_panel, BorderLayout.WEST);

        setSize(600, 400);
        setVisible(true);
    }
}
