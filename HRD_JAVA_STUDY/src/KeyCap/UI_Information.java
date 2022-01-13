package KeyCap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UI_Information extends JPanel {
    public UI_Information() {
        init();
    }

    public void init() {
        JPanel informationPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel(
                "<html>Made by Kim JaeHun<br>" +
                        "<br>" +
                        "Thank you for Nintendo<br>" +
                        "<br>" +
                        "Pokemon KeyCap<br>" +
                        "Type : ABS, PBT<br>" +
                        "Method : No Angle, Measurement Angel, And Angle<br>" +
                        "Process : Pad, Laser, Dye-Sublimation, Double shot<br>" +
                        "Profile : SA, SA Row3, OEM, Cherry, DCS, XDA, DSA, G20<br>" +
                        "Switch : Outemu, Cherry, Kailh Choc V1<br>" +
                        "<br>" +
                        "Version 0 . 0 . 6<br>" +
                        "Update 21/11/23</html>"
        );
        informationPanel.add(label);

        label.setFont(new Font("G마켓 산스 TTF Light", Font.PLAIN, 16));
        informationPanel.setPreferredSize(new Dimension(650, 400));
        informationPanel.setBorder(new EmptyBorder(0, 10, 0, 0));
        //informationPanel.setBackground(new Color(100, 100, 0));
        add(informationPanel, BorderLayout.CENTER);
    }
}
