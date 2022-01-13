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

public class SiboardContent implements ActionListener {
    //Field
    SiboardList boardList;
    JFrame write_frame;
    JPanel write_panel, south_panel;
    JTextField tf_title, tf_writer;
    JTextArea ta_content;
    JButton btn_update, btn_delete, btn_close, btn_update_result;
    SiboardVO vo;

    public SiboardContent() {}
    public SiboardContent(SiboardList boardList, String bid) {
        this.boardList = boardList;
        vo = boardList.boardDao.select(bid);
        init();
    }

    public void init(){
        write_frame = new JFrame("게시글 상세 내용 화면");

        //layout 정의
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        write_panel = new JPanel(gb);
        south_panel = new JPanel();

        tf_title = new JTextField(20);
        ta_content = new JTextArea(10,20);
        ta_content.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        tf_writer = new JTextField(20);
        tf_title.setFont(Commons.getFont());
        ta_content.setFont(Commons.getFont());
        tf_writer.setFont(Commons.getFont());

        //db에서 가져온 데이터 set
        tf_title.setText(vo.getBtitle());
        ta_content.setText(vo.getBcontent());
        tf_writer.setText(vo.getId());

        btn_update = new JButton("수정하기");
        btn_update_result = new JButton("수정완료");
        btn_delete = new JButton("삭제하기");
        btn_close = new JButton("닫기");
        btn_update.setFont(Commons.getFont());
        btn_delete.setFont(Commons.getFont());
        btn_close.setFont(Commons.getFont());
        btn_update_result.setFont(Commons.getFont());
        btn_update_result.setVisible(false);

        if(!UserInfo.USER_ID.equals(vo.getId())) {
            btn_update.setVisible(false);
            btn_delete.setVisible(false);
        }

        JLabel title_label = new JLabel("제목      ");
        JLabel content_label = new JLabel("내용      ");
        JLabel writer_label = new JLabel("작성자    ");
        title_label.setFont(Commons.getFont());
        content_label.setFont(Commons.getFont());
        writer_label.setFont(Commons.getFont());

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p1.add(title_label);	p1.add(tf_title);
        p2.add(content_label); 	p2.add(ta_content);
        p3.add(writer_label);	p3.add(tf_writer);

        c.gridwidth = GridBagConstraints.REMAINDER;
        gb.setConstraints(p1, c);
        gb.setConstraints(p2, c);
        gb.setConstraints(p3, c);

        write_panel.add(new JLabel(""));
        write_panel.add(p1);
        write_panel.add(p2);
        write_panel.add(p3);

        south_panel.add(btn_update);
        south_panel.add(btn_update_result);
        south_panel.add(btn_delete);
        south_panel.add(btn_close);

        JLabel top_img = new JLabel(new ImageIcon("images/burger_king3.png"));
        write_frame.add(top_img, BorderLayout.NORTH);
        write_frame.add(write_panel, BorderLayout.CENTER);
        write_frame.add(south_panel, BorderLayout.SOUTH);

        //작성자 추가
        tf_writer.setEditable(false);
        tf_title.setEditable(false);
        ta_content.setEditable(false);
        ta_content.setBackground(Color.LIGHT_GRAY);
        tf_title.setBackground(Color.LIGHT_GRAY);

        write_frame.setSize(400, 400);
        write_frame.setVisible(true);

        //이벤트 호출
        btn_update.addActionListener(this);
        btn_delete.addActionListener(this);
        btn_close.addActionListener(this);
        btn_update_result.addActionListener(this);

    }//init

    /******
     * 액션 이벤트 처리
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if(obj == btn_update) {  //수정하기 --> 수정하는 폼으로 전환
            write_frame.setTitle("게시글 수정 화면");
            tf_title.setEditable(true);
            ta_content.setEditable(true);
            tf_title.setBackground(Color.white);
            ta_content.setBackground(Color.white);
            btn_update.setVisible(false);
            btn_update_result.setVisible(true);

        }else if(obj == btn_update_result) {	//수정완료 버튼
            if(tf_title.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "제목을 입력해주세요");
                tf_title.requestFocus();
            }else {
                SiboardVO update_vo = new SiboardVO();
                update_vo.setBtitle(tf_title.getText().trim());
                update_vo.setBcontent(ta_content.getText().trim());
                update_vo.setId(tf_writer.getText().trim());
                update_vo.setBid(vo.getBid());

                //SiboardDao의 update 메소드 호출
                int result = boardList.boardDao.update(update_vo);
                if(result == 1) {
                    JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.");
                    boardList.changeList();
                    write_frame.dispose();
                }
            }

        }else if(obj == btn_delete) {
            int choice = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?");
            if(choice == 0) {
                int result =  boardList.boardDao.delete(vo.getBid());
                if(result == 1) {
                    JOptionPane.showMessageDialog(null,"삭제가 완료되었습니다.");
                    write_frame.dispose();
                    boardList.changeList();
                }
            }

        }else if(obj == btn_close) {
            //조회수 업데이트 후 boardList의 changeList() 메소드 호출
            write_frame.setVisible(false);
            boardList.boardDao.updateHit(vo.getBid());
            boardList.changeList();
        }
    }

}//class
