package KeyCap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UI_Login extends JPanel implements ActionListener {
    private ArrayList<JTextField> tf_list;
    private final IScreenChangeEvent screenChangeEvent;

    public UI_Login(IScreenChangeEvent screenChangeEvent) {
        this.screenChangeEvent = screenChangeEvent;
        setupLoginPanel();
    }

    public void setupLoginPanel() {
        Font font = new Font("Cafe24 Ssurround air", Font.PLAIN, 16);
        JLabel title = new JLabel("Pokemon KeyCap", JLabel.CENTER);
        title.setFont(new Font("Forte", Font.PLAIN, 70));
        setLayout(new BorderLayout());

        add(title, BorderLayout.NORTH);
        add(makeLoginPanel(), BorderLayout.CENTER);
        add(makeButtonPanel(), BorderLayout.SOUTH);
    }

    public void focusToIDField() {
        tf_list.get(0).requestFocus();
    }

    public void focusToPWField() {
        tf_list.get(1).requestFocus();
    }

    private JPanel makeLoginPanel() {
        tf_list = new ArrayList<JTextField>();
        JPanel outputP = new JPanel();
        JPanel labelPanel = new JPanel(new GridLayout(2, 2, 5, 0));
        String[] Info = {"ID", "PASSWORD"};
        for (int i = 0; i < Info.length; i++) {
            Panel mainP = new Panel();
            JLabel label = new JLabel(Info[i]);
            label.setFont(new Font("Forte", Font.PLAIN, 20));
            label.setHorizontalAlignment(JLabel.CENTER);
            mainP.add(label);

            Panel typeP = new Panel();
            JTextField jTextField;
            if (i == 1) {
                jTextField = new JPasswordField(20);
                jTextField.addActionListener(this);
                jTextField.setActionCommand("login");
            } else {
                jTextField = new JTextField(20);
            }
            typeP.add(jTextField);
            tf_list.add(jTextField);

            labelPanel.add(mainP);
            labelPanel.add(typeP);
        }
        outputP.setPreferredSize(new Dimension(700, 300));
        outputP.setBorder(new EmptyBorder(170, 0, 0, 100));
        outputP.add(labelPanel);
        return outputP;
    }

    private JPanel makeButtonPanel() {
        JPanel btnP = new JPanel();
        btnP.setLayout(new GridLayout(1, 2, 60, 0)); // 패널을 GL로 변경

        JButton loginBtn = new JButton("Log in");
        JButton signupBtn = new JButton("Sign up");
        loginBtn.setFont(new Font("Forte", Font.PLAIN, 40));
        signupBtn.setFont(new Font("Forte", Font.PLAIN, 40));

        loginBtn.setActionCommand("login");
        loginBtn.addActionListener(this);
        signupBtn.setActionCommand("signup");
        signupBtn.addActionListener(this);

        loginBtn.setBackground(new Color(240, 240, 240)); // 버튼 색 변경
        signupBtn.setBackground(new Color(240, 240, 240));
        loginBtn.setBorderPainted(false); // 버튼 테두리 제거
        signupBtn.setBorderPainted(false);

        btnP.add(loginBtn);
        btnP.add(signupBtn);
        btnP.setBackground(new Color(240, 240, 240));
        btnP.setBorder(new EmptyBorder(30, 120, 30, 120));
        return btnP;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCmd = e.getActionCommand();
        if (actionCmd.equals("login")) {
            String id = tf_list.get(0).getText();
            String password = tf_list.get(1).getText();

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.", "𝗦𝗬𝗦𝗧𝗘𝗠 - 𝗜𝗗", JOptionPane.ERROR_MESSAGE);
                focusToIDField();
                return;
            }

            if (password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.", "𝗦𝗬𝗦𝗧𝗘𝗠 - 𝗣𝗔𝗦𝗦𝗪𝗢𝗥𝗗", JOptionPane.ERROR_MESSAGE);
                focusToPWField();
                return;
            }

            User user = new User();
            user.setId(tf_list.get(0).getText());
            user.setPassword(tf_list.get(1).getText());
            int result = UserManager.INSTANCE.getLogin(user);
            if (result == 1) {

                JOptionPane.showMessageDialog(null, "로그인 성공", "𝗦𝗬𝗦𝗧𝗘𝗠 - 𝗦𝗨𝗖𝗖𝗘𝗦𝗦", JOptionPane.PLAIN_MESSAGE);
                screenChangeEvent.onScreenChangeTo(new UI_Menu());
            } else if (result == 2) {
                JOptionPane.showMessageDialog(null, "비밀번호 재확인", "𝗤𝗨𝗘𝗦𝗧𝗜𝗢𝗡 - 𝗣𝗔𝗦𝗦𝗪𝗢𝗥𝗗", JOptionPane.QUESTION_MESSAGE);
            } else if (result == 3) {
                JOptionPane.showMessageDialog(null, "계정 존재 유무 및 아이디 재확인", "𝗤𝗨𝗘𝗦𝗧𝗜𝗢𝗡 - 𝗨𝗦𝗘𝗥 𝗜𝗗𝗘𝗡𝗧𝗜𝗧𝗬", JOptionPane.QUESTION_MESSAGE);
            }
        } else if (actionCmd.equals("signup")) {
            screenChangeEvent.onScreenChangeTo(new UI_SignUp(this, screenChangeEvent));
        }
    }
}
