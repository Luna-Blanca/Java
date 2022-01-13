package DAY_18;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Event3Object extends WindowAdapter implements ActionListener {
    JFrameEvent3 jf3;
    public Event3Object() {

    }
    public Event3Object(JFrameEvent3 jf3) {
        this.jf3 = jf3;
    }

    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        if (obj == jf3.btn1) {
            System.out.println("→ 버튼 1");
        } else if (obj == jf3.btn2) {
            System.out.println("→ 버튼 2");
        } else if (obj == jf3.jf) {
            System.out.println("→ " + jf3.jf.getText());
        }
//        String btn_name = event.getActionCommand().trim();
//        System.out.println(btn_name + " 클릭");
    }

    public void WindowClosing(WindowEvent event) {
        System.out.println("프로그램 종료");
        System.exit(0);
    }
}
