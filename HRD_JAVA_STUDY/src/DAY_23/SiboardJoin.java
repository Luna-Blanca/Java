package DAY_23;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SiboardJoin implements ActionListener {
    //Field
    SiboardMain main;
    JPanel join_panel, tf_panel, label_panel, btn_panel;
    JButton btn_join, btn_reset, btn_idcheck, btn_main, btn_exit;
    String[] namelist = {"아이디", "비밀번호", "비밀번호확인", "이름", "핸드폰번호"};
    ArrayList<JTextField> tf_list = new ArrayList<JTextField>();
    boolean check_result = false;


    //Constructor
    public SiboardJoin() {
    }

    public SiboardJoin(SiboardMain main) {
        this.main = main;
        init();
    }

    /*****
     * 회원가입 화면 생성
     */
    public void init() {
        main.jf.setTitle("Siboard - 회원가입");
        join_panel = new JPanel(new BorderLayout());
        tf_panel = new JPanel(new GridLayout(namelist.length, 1));
        label_panel = new JPanel(new GridLayout(namelist.length, 1));
        btn_panel = new JPanel();
        btn_join = new JButton("가입완료");
        btn_reset = new JButton("다시쓰기");
        btn_idcheck = new JButton("중복체크");
        btn_join.setFont(Commons.getFont());
        btn_reset.setFont(Commons.getFont());
        btn_idcheck.setFont(Commons.getFont());

        btn_main = new JButton("메인화면");
        btn_main.setFont(Commons.getFont());
        btn_exit = new JButton("종료");
        btn_exit.setFont(Commons.getFont());

        btn_panel.add(btn_join);
        btn_panel.add(btn_reset);
        btn_panel.add(btn_main);
        btn_panel.add(btn_exit);


        for (String name : namelist) {
            JPanel l_panel = new JPanel();
            JPanel t_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel label = new JLabel("     " + name + "     ");
            label.setFont(Commons.getFont());
            l_panel.add(label);
            label_panel.add(l_panel);

            //JTextField, JPasswordField 생성
            if (name.equals("비밀번호") || name.equals("비밀번호확인")) {
                JPasswordField pass = new JPasswordField(20);
                t_panel.add(pass);
                tf_panel.add(t_panel);
                tf_list.add(pass);
            } else {
                JTextField tf = new JTextField(20);
                tf.setFont(Commons.getFont());
                t_panel.add(tf);
                tf_panel.add(t_panel);
                tf_list.add(tf);
            }

            if (name.equals("아이디")) {
                t_panel.add(btn_idcheck);
            }
        }//for

        JPanel north_panel = new JPanel();
        north_panel.add(new JLabel(new ImageIcon("images/burger_king2.png")));
        join_panel.add(north_panel, BorderLayout.NORTH);
        join_panel.add(label_panel, BorderLayout.WEST);
        join_panel.add(tf_panel, BorderLayout.CENTER);
        join_panel.add(btn_panel, BorderLayout.SOUTH);

        main.content_panel.setVisible(false);
        main.bottom_panel.setVisible(false);
        main.jf.add(join_panel, BorderLayout.CENTER);

        //이벤트 호출
        btn_main.addActionListener(this);
        btn_exit.addActionListener(this);
        btn_join.addActionListener(this);
        btn_reset.addActionListener(this);
        btn_idcheck.addActionListener(this);

    }

    /******
     * 아이디 중복체크
     */
    public int idcheck(String id) {
        SiboardMemberDao dao = new SiboardMemberDao();
        return dao.getIdCheck(id);
    }

    /******
     * 아이디 중복체크
     */
    public void idcheck() {
//		SiboardMemberDao dao = new SiboardMemberDao();
        int result = 0;
        JTextField tf = tf_list.get(0);

        if (tf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
            tf.requestFocus();
        } else {
            result = main.memberDao.getIdCheck(tf.getText());
            if (result == 1) {
                JOptionPane.showMessageDialog(null, "이미 사용중인 아이디 입니다.");
                tf.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "사용 가능한 아이디 입니다.");
                tf_list.get(1).requestFocus();
                check_result = true;
            }
        }
    }//idcheck

    /******
     * 회원 가입완료 처리
     */
    public void join_proc() {
        int check_count = 0;
        for (int i = 0; i < tf_list.size(); i++) {
            JTextField tf = tf_list.get(i);
            if (tf.getText().equals("")) {
                JOptionPane.showMessageDialog(null, namelist[i] + "를 입력해주세요");
                tf.requestFocus();
                i = tf_list.size();
            } else {
                check_count++;
            }
        }

        if (check_count == tf_list.size()) {
            if (check_result) {
                //DB - siboard_member 테이블에 insert
                //1. SiboardMemberVO에 데이터 set
                SiboardMemberVO vo = new SiboardMemberVO();
                vo.setId(tf_list.get(0).getText());
                vo.setPass(tf_list.get(1).getText());
                vo.setName(tf_list.get(3).getText());
                vo.setHp(tf_list.get(4).getText());

                //2. vo 객체를 dao의 insert 메소드에 전달
                //   dao.insert(vo)
//				SiboardMemberDao dao = new SiboardMemberDao();
                int result = main.memberDao.insert(vo);

                //3. insert 메소드 결과를 통해 가입완료 메시지를 출력
                if (result == 1) {
                    //JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
                    int choice = JOptionPane.showConfirmDialog(null, "회원가입이 완료되었습니다\n로그인 화면으로 이동하시겠습니까?");
                    if (choice == 0) {
                        join_panel.removeAll();
                        join_panel.setVisible(false);

                        main.jf.setTitle("Siboard - 메인화면");
                        main.content_panel.setVisible(true);
                        main.bottom_panel.setVisible(true);

                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "중복체크를 진행해주세요");
                btn_idcheck.requestFocus();
            }
        }

    }//join_proc


    /******
     * 액션 이벤트 처리 - 가입완료, 다시쓰기, 메인화면, 종료
     */
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == btn_join) {        //가입완료
            join_proc();

        } else if (obj == btn_reset) { //다시쓰기
            for (JTextField tf : tf_list) tf.setText("");
            tf_list.get(0).requestFocus();

        } else if (obj == btn_idcheck) {    //중복체크
            idcheck();

        } else if (obj == btn_main) {    //메인화면
            join_panel.removeAll();
            join_panel.setVisible(false);

            main.jf.setTitle("Siboard - 메인화면");
            main.content_panel.setVisible(true);
            main.bottom_panel.setVisible(true);

        } else if (obj == btn_exit) {    //종료
            int choice = JOptionPane.showConfirmDialog(null, "정말로 종료하시겠습니까?");
            if (choice == 0) {
                main.memberDao.close();
                System.exit(0);
            }
        }
    }//actionPerformed

}//class