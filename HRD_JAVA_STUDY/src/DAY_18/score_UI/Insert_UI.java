package DAY_18.score_UI;

import DAY_SCORE_ARRAY.ScoreVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Insert_UI implements ActionListener {
    //Scoremgm sms = new Scoremgm();
    Scoremgm_UI ui;
    JButton btn_insert, btn_cancel;
    ArrayList<JTextField> tf_list;


    public Insert_UI() {
    }

    public Insert_UI(Scoremgm_UI ui) {
        this.ui = ui;
        init();

    }

    public void init() {
        ui.switch_panel(Scoremgm_UI.INSERT);
        ui.insert_panel.add(new JLabel("***** 등록 *****"));

        tf_list = new ArrayList<JTextField>();
        ui.insert_panel.setLayout(new BorderLayout());
        JPanel title_panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel label_panel = new JPanel(new GridLayout(4, 1));
        JPanel tf_panel = new JPanel(new GridLayout(4, 1));
        JPanel btn_panel = new JPanel();

        JLabel title = new JLabel("----- 성적 등록 화면 -----");
        title_panel.add(title);
        btn_insert = new JButton("등록하기");
        btn_cancel = new JButton("다시쓰기");
        btn_panel.add(btn_insert);
        btn_panel.add(btn_cancel);

        String[] namelist = {"이름", "국어", "영어", "수학"};
        for (String name : namelist) {
            JPanel name_panel = new JPanel();
            JPanel t_panel = new JPanel();
            JLabel label = new JLabel(name);
            JTextField tf = new JTextField(15);
            name_panel.add(label);
            t_panel.add(tf);
            label_panel.add(name_panel);
            tf_panel.add(t_panel);
            tf_list.add(tf);
        }

        ui.insert_panel.add(title_panel, BorderLayout.NORTH);
        ui.insert_panel.add(label_panel, BorderLayout.WEST);
        ui.insert_panel.add(tf_panel, BorderLayout.CENTER);
        ui.insert_panel.add(btn_panel, BorderLayout.SOUTH);

        ui.content_panel.add(ui.insert_panel);
        ui.repaint();
        ui.setVisible(true);

        btn_insert.addActionListener(this);
        btn_cancel.addActionListener(this);
        tf_list.get(3).addActionListener(this);
    }

    public void insert_proc() {
        if (validationCheck()) {
            DAY_SCORE_ARRAY.ScoreVO score = new ScoreVO();
            score.setName(tf_list.get(0).getText());
            score.setKor(Integer.parseInt(tf_list.get(1).getText()));
            score.setEng(Integer.parseInt(tf_list.get(2).getText()));
            score.setMath(Integer.parseInt(tf_list.get(3).getText()));

            boolean result = ui.system.insert(score);
            if (result) {
                JOptionPane.showMessageDialog(null, "등록완료");
                for (JTextField tf : tf_list) tf.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "등록실패");
            }
        }
    }

    public boolean validationCheck() {
        boolean result = false;
        String[] msglist = {"이름", "국어", "영어", "수학"};

        for (int i = 0; i < msglist.length; i++) {
            JTextField tf = tf_list.get(i);
            if (tf.getText().equals("")) {
                JOptionPane.showMessageDialog(null, msglist[i] + "데이터를 입력해주세요.");
                tf.requestFocus();
                i = msglist.length;
            } else if (i == msglist.length - 1) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == btn_insert || obj == tf_list.get(3)) {
            insert_proc();
        } else if (obj == btn_cancel) {
            for (JTextField tf : tf_list) tf.setText("");
        }
    }
}
