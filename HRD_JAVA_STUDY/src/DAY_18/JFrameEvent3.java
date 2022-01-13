package DAY_18;

import javax.swing.*;

public class JFrameEvent3 {
    JFrame frame;
    JPanel jp;
    JButton btn1, btn2;
    JTextField jf;

    public JFrameEvent3() {
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

        Event3Object event_object = new Event3Object(this);
        btn1.addActionListener(event_object);
        btn2.addActionListener(event_object);
        jf.addActionListener(event_object);
        frame.addWindowListener(event_object);
    }
}
