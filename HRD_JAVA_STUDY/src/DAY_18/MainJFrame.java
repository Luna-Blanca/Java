package DAY_18;

import javax.swing.*;
import java.awt.*;

public class MainJFrame extends JFrame {
    // Field
    String[] titleList = {"등록", "출력", "검색", "수정", "삭제", "종료"};

    JPanel jp;

    // Constructor
    public MainJFrame() {
        jp = new JPanel(new GridLayout(6,1, 5, 5));
        for (String menu : titleList) {
            JButton jb_menu = new JButton("   "  + menu + "   ");
            jp.add(jb_menu);
        }

        add(jp, BorderLayout.WEST);
        setSize(600, 400);
        setVisible(true);
    }

    // Method
}
