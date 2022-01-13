package KeyCap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class UI_SignUp extends JPanel implements ActionListener {
    JButton signupBtn, cancelBtn;
    ArrayList<JTextField> tfList = new ArrayList<>();
    private final IScreenChangeEvent screenChangeEvent;
    private final UI_Login loginPanel;

    public UI_SignUp(UI_Login loginPanel, IScreenChangeEvent screenChangeEvent) {
        this.loginPanel = loginPanel;
        this.screenChangeEvent = screenChangeEvent;
        setupSignupPanel();
    }

    private void setupSignupPanel() {
        setLayout(new BorderLayout());

        JLabel mainLabel = new JLabel("Pokemon KeyCap", JLabel.LEFT);
        mainLabel.setFont(new Font("Forte", Font.PLAIN, 60));
        mainLabel.setPreferredSize(new Dimension(600, 80));
        add(mainLabel, BorderLayout.NORTH);

        add(makeInfoPanel(), BorderLayout.CENTER);

        add(makeButton(), BorderLayout.SOUTH);
    }

    private JPanel makeInfoPanel() {
        String[] labels = {"Address", "Detail Address", "ID", "PASSWORD", "GENDER (M/W)", "NAME", "NUMBER", "E-MAIL"};
        JPanel mainP = new JPanel(new GridLayout(labels.length, 2));
        mainP.setBorder(new EmptyBorder(50, 0, 50, 0));

        for (int i = 0; i < labels.length; i++) {
            JPanel nameP = new JPanel();
            JLabel label = new JLabel(labels[i]);
            label.setFont(new Font("Forte", Font.PLAIN, 20));
            nameP.add(label);
            mainP.add(nameP);

            JPanel typeP = new JPanel();
            JTextField tf = new JTextField(20);
            typeP.add(tf);
            tfList.add(tf);
            mainP.add(typeP);
        }
        tfList.get(7).addActionListener(this);

        return mainP;
    }

    private JPanel makeButton() {
        JPanel buttonP = new JPanel(new GridLayout(1, 2, 60, 0));
        buttonP.setBorder(new EmptyBorder(30, 120, 30, 120));

        signupBtn = new JButton("Sign Up");
        cancelBtn = new JButton("Cancel");
        signupBtn.setFont(new Font("Forte", Font.PLAIN, 40));
        cancelBtn.setFont(new Font("Forte", Font.PLAIN, 40));
        signupBtn.setBackground(new Color(240, 240, 240));
        cancelBtn.setBackground(new Color(240, 240, 240));
        buttonP.setBackground(new Color(240, 240, 240));
        signupBtn.setBorderPainted(false);
        cancelBtn.setBorderPainted(false);
        buttonP.add(signupBtn);
        buttonP.add(cancelBtn);

        signupBtn.setActionCommand("Sign Up");
        signupBtn.addActionListener(this);
        cancelBtn.setActionCommand("Cancel");
        cancelBtn.addActionListener(this);

        return buttonP;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String actionCmd = e.getActionCommand();
        if (actionCmd.equals("Sign Up") || source == tfList.get(7)) {
            User user = new User();
            user.setAddress(tfList.get(0).getText());
            user.setDetailAddress(tfList.get(1).getText());
            user.setId(tfList.get(2).getText());
            user.setPassword(tfList.get(3).getText());
            user.setGender(tfList.get(4).getText());
            user.setName(tfList.get(5).getText());
            user.setNumber(tfList.get(6).getText());
            user.setEmail(tfList.get(7).getText());

            int result = UserManager.INSTANCE.addUser(user);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "해피너스가 당신의 정보를 추가했습니다", "𝗦𝗬𝗦𝗧𝗘𝗠 - 𝗦𝗜𝗚𝗡 𝗨𝗣 𝗦𝗨𝗖𝗖𝗘𝗦𝗦", JOptionPane.PLAIN_MESSAGE);
                screenChangeEvent.onScreenChangeTo(loginPanel);
            } else {
                JOptionPane.showMessageDialog(null, "해피너스가 당신의 정보를 추가하지 못했습니다", "𝗦𝗬𝗦𝗧𝗘𝗠 - 𝗦𝗜𝗚𝗡 𝗨𝗣 𝗘𝗥𝗥𝗢𝗥" , JOptionPane.ERROR_MESSAGE);
            }
        } else if (actionCmd.equals("Cancel")) {
            screenChangeEvent.onScreenChangeTo(loginPanel);
        }
    }
}
