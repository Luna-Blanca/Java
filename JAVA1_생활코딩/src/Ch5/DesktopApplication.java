package Ch5;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.Toolkit;

public class DesktopApplication {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Hello world GUI");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(400, 300));
                JLabel label = new JLabel("Hello World", SwingConstants.CENTER);
                frame.getContentPane().add(label);

                frame.setLayout(new FlowLayout());
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                JButton btn1 = new JButton("내가 만든 버튼");
                btn1.setLocation(dim.width/2-200/2,dim.height/2-150/2);
                frame.add(btn1);
                frame.setLocation(dim.width / 2 - 400 / 2, dim.height / 2 - 300 / 2);


                JTextField tf = new JTextField(20);
                frame.add(tf);
                JButton btn2 = new JButton("입력 문자 출력");
                btn2.addActionListener((b) -> {
                    System.out.println("input : " + tf.getText());
                });
                frame.add(btn2);

                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
