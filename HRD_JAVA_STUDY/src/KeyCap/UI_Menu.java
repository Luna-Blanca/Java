package KeyCap;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI_Menu extends JPanel implements ActionListener {
    private JPanel contentPanel = new JPanel();

    public UI_Menu(){
        setupDashboard();
    }

    public void setupDashboard() {
        String[] menuList = {"Order", "Check Order", "Change Order", "Option", "Information"};
        JLabel title = new JLabel("Pokemon KeyCap", JLabel.LEFT);
        title.setFont(new Font("Forte", Font.PLAIN, 70));
        title.setPreferredSize(new Dimension(550, 100));

        JPanel menuP = new JPanel(new GridLayout(menuList.length, 1, 10, 8));
        for (String menu : menuList) {
            JButton jB = new RoundButton(menu);
            jB.setFont(new Font("Forte", Font.PLAIN, 30));
            jB.addActionListener(this);
            jB.setActionCommand(menu);
            menuP.add(jB);
        }
        contentPanel.setBorder(new LineBorder(Color.WHITE, 5, true));
        contentPanel.setLayout(new BorderLayout());

        setLayout(new BorderLayout(10, 10));
        add(title, BorderLayout.NORTH);
        add(menuP, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String title = e.getActionCommand();
        contentPanel.removeAll();
        if (title.equals("Order")){
            contentPanel.add(new UI_Order());
        } else if (title.equals("Check Order")) {
            contentPanel.add(new UI_Check());
        } else if (title.equals("Change Order")) {
            contentPanel.add(new UI_Change());
        } else if (title.equals("Option")) {

        } else if (title.equals("Information")) {
            contentPanel.add(new UI_Information());
        }
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
