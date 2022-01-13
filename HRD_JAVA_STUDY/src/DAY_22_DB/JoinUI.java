package DAY_22_DB;

import javafx.scene.shape.HLineTo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class JoinUI extends WindowAdapter implements ActionListener {
    JFrame join_frame;
    JPanel label_panel, tf_panel, btn_panel;
    JButton btn_join, btn_reset, btn_idcheck;
    String[] namelist = {"아이디", "비밀번호", "비밀번호 확인", "이름", "이메일", "휴대폰번호"};
    ArrayList<JTextField> tf_list = new ArrayList<JTextField>();
    boolean idcheck_result = false;

    public JoinUI() {
        init();
    }

    public void init() {
        join_frame = new JFrame("회원가입");
        label_panel = new JPanel(new GridLayout(6, 1));
        tf_panel = new JPanel(new GridLayout(6, 1));
        btn_panel = new JPanel();
        btn_join = new JButton("가입완료");
        btn_reset = new JButton("취소하기");
        btn_panel.add(btn_join);
        btn_panel.add(btn_reset);

        for (String name : namelist) {
            JPanel l_panel = new JPanel();
            JPanel t_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel label = new JLabel(name);
            l_panel.add(label);
            label_panel.add(l_panel);

            if (name.equals("비밀번호") || name.equals("비밀번호 확인")) {
                JPasswordField pass = new JPasswordField(15);
                t_panel.add(pass);
                tf_panel.add(t_panel);
                tf_list.add(pass);
            } else {
                JTextField tf = new JTextField(15);
                t_panel.add(tf);
                tf_panel.add(t_panel);
                tf_list.add(tf);
            }

            if (name.equals("아이디")) {
                btn_idcheck = new JButton("중복확인");
                t_panel.add(btn_idcheck);
            }
        }

        join_frame.add(new JLabel("회원가입 폼"), BorderLayout.NORTH);
        join_frame.add(label_panel, BorderLayout.WEST);
        join_frame.add(tf_panel, BorderLayout.CENTER);
        join_frame.add(btn_panel, BorderLayout.SOUTH);
        join_frame.setSize(450, 400);
        join_frame.setVisible(true);

        btn_idcheck.addActionListener(this);
        btn_join.addActionListener(this);
        btn_reset.addActionListener(this);
        join_frame.addWindowListener(this);
    }

    /**
     * ID 확인
     */
    public int idcheck_proc() {
        int result = 0;
        String id = tf_list.get(0).getText();
        if (id.equals("")) {
            JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
            tf_list.get(0).requestFocus();
        } else {
            EmpMemberDao dao = new EmpMemberDao();
            result = dao.getIdCheck(id);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "이미 사용중인 ID입니다.");
                tf_list.get(0).setText("");
                tf_list.get(0).requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "사용 가능한 ID입니다.");
                tf_list.get(1).requestFocus();
                idcheck_result = true;
            }
        }

        return result;
    }

    /**
     *  회원가입
     */
    public void join_proc() {
        // 1. 비밓번호, 비밀번호 확인, 이름, 이메일 데이터 존재 유무 확인
        if (validationCheck()) {
            // 2. 비밀번호, 비밀번호 확인을 비교하여 데이터가 동일한지 확인
            JTextField pass = tf_list.get(1);
            JTextField cpass = tf_list.get(2);
            if (pass.getText().equals(cpass.getText())) {
                // 3. 중복체크 했는지 확인
                if (idcheck_result) {
                    EmpMemberVO vo = new EmpMemberVO();
                    vo.setId(tf_list.get(0).getText().trim());
                    vo.setPass(tf_list.get(1).getText().trim());
                    vo.setName(tf_list.get(3).getText().trim());
                    vo.setEmail(tf_list.get(4).getText().trim());
                    vo.setHp(tf_list.get(5).getText().trim());

                    EmpMemberDao dao = new EmpMemberDao();
                    int result = dao.getInsertResult(vo);
                    if (result == 1) {
                        JOptionPane.showMessageDialog(null, "회원가입 성공");
                        int check = JOptionPane.showConfirmDialog(null, "로그인화면으로 이동하시겠습니까?");
                        if (check == 0) {
                            new LoginUI();
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "중복체크를 진행해주세요.");
                    btn_idcheck.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.\n다시 입력해주세요.");
                pass.setText("");
                cpass.setText("");
                pass.requestFocus();
            }
        }

    }

    /**
     * 유효성 체크
     */
    public boolean validationCheck() {
        boolean result = false;

        int size = tf_list.size()-1;
        for (int i = 0; i < size; i++) {
            JTextField tf = tf_list.get(i);
            if (tf.getText().equals("")) {
                JOptionPane.showMessageDialog(null, namelist[i] + "값을 입력해주세요.");
                tf.requestFocus();
                i = size;
            } else {
                result = true;
            }
        }
        return result;
    }

    public void WindowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == btn_idcheck) {
            int check_result = idcheck_proc();
        } else if (obj == btn_join) {
            join_proc();
        } else if (obj == btn_reset) {
            System.out.println("reset");
        }
    }
}
