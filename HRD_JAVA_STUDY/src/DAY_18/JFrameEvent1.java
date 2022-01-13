package DAY_18;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class JFrameEvent1 extends JFrame implements ActionListener, WindowListener {
    JPanel jp;
    JButton btn1, btn2;
    JTextField jf;

    public JFrameEvent1() {
        jp = new JPanel();
        btn1 = new JButton("  버튼 1  ");
        btn2 = new JButton("  버튼 2  ");
        jf = new JTextField(20);

        jp.add(btn1);
        jp.add(btn2);
        add(jp);
        jp.add(jf);

        setSize(300, 300);
        setVisible(true);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        jf.addActionListener(this);

        addWindowListener(this);
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

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("프로그램 종료");
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
