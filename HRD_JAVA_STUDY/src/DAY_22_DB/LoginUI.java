package DAY_22_DB;

import javafx.scene.shape.HLineTo;
import sun.misc.VM;
import sun.security.jgss.LoginConfigImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Locale;

public class LoginUI extends JFrame implements ActionListener, WindowListener {
    //Field
    JPanel label_panel, tf_panel, btn_panel;
    JButton btn_login, btn_reset,btn_join;
    JTextField tf_id;
    JPasswordField tf_pass;

    //Constructor
    public LoginUI() {
        init();
    }

    //Method
    public void init() {  //Login에서 실행
        String[] namelist = {"*","ID","PW"};
        label_panel = new JPanel(new GridLayout(4,1));
        tf_panel = new JPanel(new GridLayout(4,1));
        btn_panel = new JPanel();  //button 넣을 패널
        btn_login = new JButton("Login");  //button 1 Login
        btn_reset = new JButton("Reset");  //button 2 Reset
        btn_join = new JButton("JOIN");
        btn_join.setBackground(Color.cyan);

        for(String name : namelist) {
            JPanel l_panel = new JPanel();
            JPanel t_panel = new JPanel();

            if(name.equals("*") ) {  //패널 이름이 없을 경우
                label_panel.add(l_panel.add(new JLabel(" ")));  //label_panel에 빈칸
                tf_panel.add(t_panel.add(new JLabel(" ")));  //tf_panel에 빈칸
            }else if(name.equals("ID") ) {  //name에 들어있는 값이 ID라면
                label_panel.add(l_panel.add(new JLabel("  "+name+"   ")));  //label_panel에 이름
                tf_id = new JTextField(15);  //tf_panel에 텍스트필드
                tf_panel.add(t_panel.add(tf_id));
            }else if(name.equals("PW")){
                label_panel.add(l_panel.add(new JLabel("  "+name+"   ")));
                tf_pass = new JPasswordField(15);
                tf_panel.add(t_panel.add(tf_pass));
            }
        }//for

        btn_panel.add(btn_login);
        btn_panel.add(btn_reset);
        btn_panel.add(btn_join);

        ImageIcon img = new ImageIcon("D:\\Program_code\\JAVA\\HRD_JAVA_STUDY\\Images\\duke.png");
        JLabel login_img = new JLabel(img);

        add(login_img, BorderLayout.NORTH);
        add(label_panel, BorderLayout.WEST);
        add(tf_panel, BorderLayout.CENTER);
        add(btn_panel, BorderLayout.SOUTH);
        add(new JLabel("      "), BorderLayout.EAST);

        setSize(300,330);
        setVisible(true);

        tf_pass.addActionListener(this);
        btn_login.addActionListener(this);
        btn_reset.addActionListener(this);
        btn_join.addActionListener(this);
        addWindowListener(this);

    }//init

    /**
     * 로그인 처리
     */
    public void login_proc() {

        if(validationCheck()) {
            EmpMemberDao dao = new EmpMemberDao();
            EmpMemberVO vo = new EmpMemberVO();
            vo.setId(tf_id.getText().trim());
            vo.setPass(tf_pass.getText().trim());
            int result = dao.getLogin(vo);

            if(result == 1) {
                JOptionPane.showMessageDialog(null, "로그인 성공");
                setVisible(false);  //로그인창 숨기기
                new EmpList();
            }else {
                JOptionPane.showMessageDialog(null, "로그인 실패");
                tf_id.setText("");
                tf_pass.setText("");
                tf_id.requestFocus();
            }
        }

    }

    /**
     * 데이터 검증 : 아이디, 패스워드 공백체크
     */
    public boolean validationCheck() {
        boolean result = false;

        if(tf_id.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
            tf_id.requestFocus();
        }else if(tf_pass.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "패스워드를 입력해주세요");
            tf_pass.requestFocus();
        }else {
            result = true;
        }
        return result;
    }

    /**
     * 이벤트 처리
     */
    @Override
    public void	windowActivated(WindowEvent e) {}
    @Override
    public void	windowClosed(WindowEvent e) {}
    @Override
    public void	windowClosing(WindowEvent e) {	System.exit(0); 	}
    @Override
    public void	windowDeactivated(WindowEvent e) {}
    @Override
    public void	windowDeiconified(WindowEvent e) {}
    @Override
    public void	windowIconified(WindowEvent e) {}
    @Override
    public void	windowOpened(WindowEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == tf_pass || obj == btn_login) {
            login_proc();
        }else if(obj == btn_reset) {
            tf_id.setText("");
            tf_pass.setText("");
            tf_id.requestFocus();
        } else if (obj == btn_join) {
            new JoinUI();
        }
    }



}
