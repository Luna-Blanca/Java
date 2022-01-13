package DAY_SCORE_UI_DB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Select_UI {
    Scoremgm_UI ui;
    String[] colNames = {"번호", "이름", "국어", "영어", "수학", "총점", "평균"};
    DefaultTableModel model = new DefaultTableModel(colNames, 0);
    JTable table = new JTable(model);
    Object[] row = new Object[7];
    //JTextArea ta;

    public Select_UI() {}
    public Select_UI(Scoremgm_UI ui) {
        this.ui = ui;
        init();
    }

    public void init() {
        ui.switch_panel(Scoremgm_UI.SELECT);

        //table에 데이터를 넣는 작업
        createJTableData();
        table.setModel(model);

        JScrollPane pane = new JScrollPane(table);
        ui.select_panel.add(pane);

        ui.content_panel.add(ui.select_panel);
        ui.repaint();
        ui.setVisible(true);
    }

    public void createJTableData() {

        int no = 1;
        model.setRowCount(0);
        for (ScoreVO score : ui.dao.select()) {
            row[0] = no;
            row[1] = score.getName();
            row[2] = score.getKor();
            row[3] = score.getEng();
            row[4] = score.getMath();
            row[5] = score.getTot();
            row[6] = score.getAvg();

            model.addRow(row);
            no++;
        }

        model.fireTableDataChanged();
    }

}
