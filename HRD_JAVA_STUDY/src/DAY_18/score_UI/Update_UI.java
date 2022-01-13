package DAY_18.score_UI;

import DAY_18.score_UI.Scoremgm.ScoreVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Update_UI implements ActionListener {
    Scoremgm_UI ui;
    JTextField name_tf;
    JButton btn_search, btn_update, btn_reset;
    ArrayList<JTextField> tf_list;

    public Update_UI() {
    }

    public Update_UI(Scoremgm_UI ui) {
        this.ui = ui;
        init();
    }

    public Update_UI(Scoremgm_UI ui, ScoreVO score) {
        this.ui = ui;
        init();
        name_tf.setText(score.getName());
        tf_list.get(0).setText(score.getName());
        tf_list.get(0).setEditable(false);
        tf_list.get(1).setText(String.valueOf(score.getKor()));
        tf_list.get(2).setText(String.valueOf(score.getEng()));
        tf_list.get(3).setText(String.valueOf(score.getMath()));
    }

    public void init() {
        ui.switch_panel(Scoremgm_UI.UPDATE);
        ui.update_panel.setLayout(new BorderLayout());

        JPanel top_panel = new JPanel();
        JLabel label = new JLabel("수정할 학생명");
        name_tf = new JTextField(20);
        btn_search = new JButton("search");
        top_panel.add(label);
        top_panel.add(name_tf);
        top_panel.add(btn_search);


        ui.update_panel.add(top_panel, BorderLayout.NORTH);
        ui.update_panel.add(update_form(), BorderLayout.CENTER);
        ui.content_panel.add(ui.update_panel);
        ui.repaint();
        ui.setVisible(true);

        btn_search.addActionListener(this);
        name_tf.addActionListener(this);
    }

    public JPanel update_form() {
        tf_list = new ArrayList<JTextField>();
        JPanel up_panel = new JPanel(new BorderLayout());
        JPanel label_panel = new JPanel(new GridLayout(4, 1));
        JPanel tf_panel = new JPanel(new GridLayout(4, 1));
        Panel btn_panel = new Panel();

        String[] namelist = {"이름", "국어", "영어", "수학"};
        for (String name : namelist) {
            JPanel lpanel = new JPanel();
            JPanel tpanel = new JPanel();
            JLabel label = new JLabel(name);
            JTextField tf = new JTextField(15);
            lpanel.add(label);
            tpanel.add(tf);
            label_panel.add(lpanel);
            tf_panel.add(tpanel);
            tf_list.add(tf);
        }

        btn_update = new JButton("수정완료");
        btn_reset = new JButton("다시쓰기");
        btn_panel.add(btn_update);
        btn_panel.add(btn_reset);

        up_panel.setBackground(Color.pink);
        up_panel.add(label_panel, BorderLayout.WEST);
        up_panel.add(tf_panel, BorderLayout.CENTER);
        up_panel.add(btn_panel, BorderLayout.SOUTH);

        btn_update.addActionListener(this);
        btn_reset.addActionListener(this);

        return up_panel;
    }

    public void search_proc() {
        if (validationCheck()) {
            DAY_SCORE_ARRAY.ScoreVO score = ui.system.search(name_tf.getText());
            if (score != null) {
                tf_list.get(0).setText(score.getName());
                tf_list.get(0).setEditable(false);
                tf_list.get(1).setText(String.valueOf(score.getKor()));
                tf_list.get(2).setText(String.valueOf(score.getEng()));
                tf_list.get(3).setText(String.valueOf(score.getMath()));
            } else {
                JOptionPane.showMessageDialog(null, "수정할 데이터가 존재하지 않습니다.");
            }
        }
    }

    public boolean validationCheck() {
        boolean result = false;

        if (name_tf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "학생명을 입력해주세요");
            name_tf.requestFocus();
        } else {
            result = true;
        }

        return result;
    }

    public void update_proc() {
        DAY_SCORE_ARRAY.ScoreVO update_score = new DAY_SCORE_ARRAY.ScoreVO();
        update_score.setName(name_tf.getText());
        update_score.setKor(Integer.parseInt(tf_list.get(1).getText()));
        update_score.setKor(Integer.parseInt(tf_list.get(2).getText()));
        update_score.setKor(Integer.parseInt(tf_list.get(3).getText()));

        boolean result = ui.system.update(update_score);
        if (result) {
            JOptionPane.showMessageDialog(null, "수정완료");
            new Select_UI(ui);
//            name_tf.setText("");
//            for (JTextField tf : tf_list) tf.setText("");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == btn_search || obj == name_tf) {
            search_proc();
        } else if (obj == btn_update) {
            update_proc();
        } else if (obj == btn_reset) {
            name_tf.setText("");
            for (JTextField tf : tf_list) {
                tf.setText("");
            }
            name_tf.requestFocus();
        }
    }
}
