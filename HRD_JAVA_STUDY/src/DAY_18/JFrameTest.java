package DAY_18;

import javax.swing.*;
import java.awt.*;

public class JFrameTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame("JFrame Test");

        JButton north = new JButton("NORTH");
        JButton south = new JButton("SOUTH");
        JButton west = new JButton("WEST");
        JButton east = new JButton("EAST");
        JButton center = new JButton("CENTER");

        jf.add(north, BorderLayout.NORTH);
        jf.add(south, BorderLayout.SOUTH);
        jf.add(west, BorderLayout.WEST);
        jf.add(east, BorderLayout.EAST);
        jf.add(center, BorderLayout.CENTER);

        jf.setSize(330, 300);
        jf.setVisible(true);

    }
}
