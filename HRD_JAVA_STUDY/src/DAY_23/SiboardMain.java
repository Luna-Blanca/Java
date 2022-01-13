package DAY_23;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SiboardMain extends WindowAdapter implements ActionListener {
    //Field
    SiboardMemberDao memberDao;
    JFrame jf;
    JPanel content_panel, bottom_panel;
    JTextField tf_id;
    JPasswordField tf_pass;
    JButton btn_login, btn_find_id, btn_join, btn_exit;

    //Constructor
    public SiboardMain() {
        init();
    }

    /****
     * 메인화면 생성
     */
    public void init() {
        memberDao = new SiboardMemberDao();
        jf = new JFrame("Siboard - 메인화면");
        content_panel = new JPanel();
        bottom_panel = new JPanel(new GridLayout(2, 1));
        tf_id = new JTextField(12);
        tf_pass = new JPasswordField(12);
        btn_login = new JButton("로그인");
        btn_find_id = new JButton("아이디/비밀번호 찾기");
        btn_join = new JButton("회원가입");
        btn_exit = new JButton("종료");

        tf_id.setFont(Commons.getFont());
        tf_pass.setFont(Commons.getFont());
        btn_login.setFont(Commons.getFont());
        btn_find_id.setFont(Commons.getFont());
        btn_join.setFont(Commons.getFont());
        btn_exit.setFont(Commons.getFont());

        //이미지
        ImageIcon img = new ImageIcon("images/burger_king.png");
        JLabel main_img = new JLabel(img);
        content_panel.add(main_img);

        //로그인화면
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JLabel label_id = new JLabel("아이디");
        JLabel label_pass = new JLabel("패스워드");
        label_id.setFont(Commons.getFont());
        label_pass.setFont(Commons.getFont());
        panel1.add(label_id);
        panel1.add(tf_id);
        panel1.add(label_pass);
        panel1.add(tf_pass);
        panel1.add(btn_login);
        panel2.add(btn_find_id);
        panel2.add(btn_join);
        panel2.add(btn_exit);
        bottom_panel.add(panel1);
        bottom_panel.add(panel2);


        //메인 프레임 추가
        jf.add(content_panel, BorderLayout.CENTER);
        jf.add(bottom_panel, BorderLayout.SOUTH);

        jf.setSize(500, 450);
        jf.setVisible(true);

        //이벤트 호출
        jf.addWindowListener(this);
        tf_pass.addActionListener(this);
        btn_login.addActionListener(this);
        btn_find_id.addActionListener(this);
        btn_join.addActionListener(this);
        btn_exit.addActionListener(this);
    }


    /******
     * 윈도우 이벤트 처리 - 프레임 종료
     */
    public void windowClosing(WindowEvent e) {
        memberDao.close();
        System.exit(0);
    }

    /******
     * 로그인 처리
     */
    public void login_proc() {
        if (tf_id.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
            tf_id.requestFocus();
        } else if (tf_pass.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "패스워드를 입력해주세요");
            tf_pass.requestFocus();
        } else {
//			SiboardMemberDao dao = new SiboardMemberDao();
            SiboardMemberVO vo = new SiboardMemberVO();
            vo.setId(tf_id.getText());
            vo.setPass(tf_pass.getText());

            int result = memberDao.getLogin(vo);
            if (result == 1) {
                JOptionPane.showMessageDialog(null, "로그인에 성공하셨습니다.");
                UserInfo.USER_ID = vo.getId();

                tf_id.setText("");
                tf_pass.setText("");
                new SiboardList(this);
            } else {
                JOptionPane.showMessageDialog(null, "로그인에 실패하셨습니다.\n아이디와 패스워드를 확인해주세요");
                tf_id.setText("");
                tf_pass.setText("");
                tf_id.requestFocus();
            }
        }
    }


    /******
     * 액션 이벤트 처리 - 로그인, 아이디/비밀번호찾기, 회원가입
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == tf_pass || obj == btn_login) {
            login_proc();
        } else if (obj == btn_find_id) {
            System.out.println("아이디 찾기");
        } else if (obj == btn_join) { //회원가입
            new SiboardJoin(this);
        } else if (obj == btn_exit) {
            int choice = JOptionPane.showConfirmDialog(null, "정말로 종료하시겠습니까?");
            if (choice == 0) {
                memberDao.close();
                System.exit(0);
            }
        }
    }

}//class
