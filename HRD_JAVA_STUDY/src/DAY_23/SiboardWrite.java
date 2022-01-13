package DAY_23;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SiboardWrite implements ActionListener {
    //Field
    SiboardList boardList;
    JFrame write_frame;
    JPanel write_panel, south_panel;
    JTextField tf_title, tf_writer;
    JTextArea ta_content;
    JButton btn_write, btn_reset, btn_close;

    public SiboardWrite() {
    }

    public SiboardWrite(SiboardList boardList) {
        this.boardList = boardList;
        init();
    }

    public void init() {
        write_frame = new JFrame("게시글 등록 화면");

        //layout 정의
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        write_panel = new JPanel(gb);
        south_panel = new JPanel();

        tf_title = new JTextField(20);
        ta_content = new JTextArea(10, 20);
        ta_content.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        tf_writer = new JTextField(20);
        tf_title.setFont(Commons.getFont());
        ta_content.setFont(Commons.getFont());
        tf_writer.setFont(Commons.getFont());

        btn_write = new JButton("등록완료");
        btn_reset = new JButton("다시쓰기");
        btn_close = new JButton("닫기");
        btn_write.setFont(Commons.getFont());
        btn_reset.setFont(Commons.getFont());
        btn_close.setFont(Commons.getFont());

        JLabel title_label = new JLabel("제목      ");
        JLabel content_label = new JLabel("내용      ");
        JLabel writer_label = new JLabel("작성자    ");
        title_label.setFont(Commons.getFont());
        content_label.setFont(Commons.getFont());
        writer_label.setFont(Commons.getFont());

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p1.add(title_label);
        p1.add(tf_title);
        p2.add(content_label);
        p2.add(ta_content);
        p3.add(writer_label);
        p3.add(tf_writer);

        c.gridwidth = GridBagConstraints.REMAINDER;
        gb.setConstraints(p1, c);
        gb.setConstraints(p2, c);
        gb.setConstraints(p3, c);

        write_panel.add(new JLabel(""));
        write_panel.add(p1);
        write_panel.add(p2);
        write_panel.add(p3);

        south_panel.add(btn_write);
        south_panel.add(btn_reset);
        south_panel.add(btn_close);

        JLabel top_img = new JLabel(new ImageIcon("images/burger_king3.png"));
        write_frame.add(top_img, BorderLayout.NORTH);
        write_frame.add(write_panel, BorderLayout.CENTER);
        write_frame.add(south_panel, BorderLayout.SOUTH);

        //작성자 추가
        tf_writer.setText(UserInfo.USER_ID);
        tf_writer.setEditable(false);

        write_frame.setSize(400, 400);
        write_frame.setVisible(true);

        //이벤트 호출
        btn_write.addActionListener(this);
        btn_reset.addActionListener(this);
        btn_close.addActionListener(this);

    }//init

    /******
     * 액션 이벤트 처리
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == btn_write) {
            if (tf_title.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "제목을 입력해주세요");
                tf_title.requestFocus();
            } else {
                SiboardVO vo = new SiboardVO();
                vo.setBtitle(tf_title.getText().trim());
                vo.setBcontent(ta_content.getText().trim());
                vo.setId(tf_writer.getText().trim());

                //SiboardDao의 insert 메소드 호출
                int result = boardList.boardDao.insert(vo);
                if (result == 1) {
                    JOptionPane.showMessageDialog(null, "등록이 완료되었습니다.");
                    boardList.changeList();
                }
            }

        } else if (obj == btn_reset) {
            tf_title.setText("");
            ta_content.setText("");
            tf_title.requestFocus();
        } else if (obj == btn_close) {
            write_frame.setVisible(false);
        }
    }

}//class