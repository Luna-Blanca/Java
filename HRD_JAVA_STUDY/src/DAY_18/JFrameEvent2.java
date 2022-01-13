package DAY_18;

import javax.swing.*;
import java.awt.event.*;

public class JFrameEvent2 extends WindowAdapter implements ActionListener {
    JFrame frame;
    JPanel jp;
    JButton btn1, btn2;
    JTextField jf;

    public JFrameEvent2() {
        frame = new JFrame("이벤트 테스트");
        jp = new JPanel();
        btn1 = new JButton("  버튼 1  ");
        btn2 = new JButton("  버튼 2  ");
        jf = new JTextField(20);

        jp.add(btn1);
        jp.add(btn2);
        frame.add(jp);
        jp.add(jf);

        frame.setSize(300, 300);
        frame.setVisible(true);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        jf.addActionListener(this);
        frame.addWindowListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        if (obj == btn1) {
            System.out.println("→ 버튼 1");
        } else if (obj == btn2) {
            System.out.println("→ 버튼 2");
        } else if (obj == jf) {
            System.out.println("→ " + jf.getText());
        }
//        String btn_name = event.getActionCommand().trim();
//        System.out.println(btn_name + " 클릭");
    }

    public void WindowClosing(WindowEvent event) {
        System.out.println("프로그램 종료");
        System.exit(0);
    }
}
