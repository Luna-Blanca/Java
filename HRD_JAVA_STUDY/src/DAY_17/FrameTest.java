package DAY_17;

import java.awt.*;

public class FrameTest {
    public static void main(String[] args) {
        Frame f = new Frame("테스트 프레임");
        Panel p = new Panel();

        Button north = new Button("North");
        Button south = new Button("South");
        Button east = new Button("East");
        Button west = new Button("West");
        Button center = new Button("Center");
        p.add(center);

        f.add(north, BorderLayout.NORTH);
        f.add(south, BorderLayout.SOUTH);
        f.add(east, BorderLayout.EAST);
        f.add(west, BorderLayout.WEST);
        f.add(p, BorderLayout.CENTER);

        f.setSize(600, 300);
        f.setVisible(true);
    }
}
