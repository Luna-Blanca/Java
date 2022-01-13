package DAY_SCORE_UI_DB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search_UI implements ActionListener {
    Scoremgm_UI ui;
    ScoreVO score;
    JTextField name_tf;
    JPanel jp;
    JButton btn_search, btn_update, btn_delete;
    //JTextArea search_result;
    String[] colNames = {"이름", "국어", "영어", "수학", "총점", "평균"};
    DefaultTableModel model = new DefaultTableModel(colNames, 0);
    JTable table = new JTable(model);
    Object[] row = new Object[6];

    public Search_UI() {
    }

    public Search_UI(Scoremgm_UI ui) {
        this.ui = ui;
        init();
    }

    public void init() {
        ui.switch_panel(Scoremgm_UI.SEARCH);
        table.setModel(model);
        ui.search_panel.setLayout(new BorderLayout());

        JPanel search_panel = new JPanel();
        JLabel name_label = new JLabel("학생명");
        name_tf = new JTextField(10);
        btn_search = new JButton("검색");

        search_panel.add(name_label);
        search_panel.add(name_tf);
        search_panel.add(btn_search);

        JScrollPane panel = new JScrollPane(table);

        //search_result = new JTextArea(8, 30);

        ui.search_panel.add(search_panel, BorderLayout.NORTH);
        ui.search_panel.add(panel, BorderLayout.CENTER);
        ui.content_panel.add(ui.search_panel);
        ui.repaint();
        ui.setVisible(true);

        btn_search.addActionListener(this);
        name_tf.addActionListener(this);
        btn_update.addActionListener(this);
        btn_delete.addActionListener(this);
    }

    public void search_proc() {
        if (validationCheck()) {
            score = ui.dao.select(name_tf.getText());
            if (score != null) {
                jp.setVisible(true);

                model = new DefaultTableModel(colNames, 0);

                row[0] = score.getName();
                row[1] = score.getKor();
                row[2] = score.getEng();
                row[3] = score.getMath();
                row[4] = score.getTot();
                row[5] = score.getAvg();

                model.addRow(row);
                model.fireTableDataChanged();

                table.setModel(model);
            } else {
                DefaultTableModel model3 = new DefaultTableModel(colNames, 0);
                table.setModel(model3);
                JOptionPane.showMessageDialog(null, "검색하신 데이터가 존재하지 않습니다.");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == btn_search || obj == name_tf) {
            search_proc();
        } else if (obj == btn_update) {
            //new Update_UI(ui, score);
        } else if (obj == btn_delete) {
            //new Delete_UI(ui, score);
        }
    }
}
