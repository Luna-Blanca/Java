package DAY_18.score_UI;

import DAY_SCORE_ARRAY.ScoreVO;

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


//        ta = new JTextArea(14, 40);
//
//        if (ui.system.scorelist.size() != 0) {
//            ta.append("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
//            ta.append(" 이름\t국어\t영어\t수학\t총점\t평균 \n");
//
//            for (BookVO score : ui.system.scorelist) {
//                ta.append(score.getName() + "\t");
//                ta.append(score.getKor() + "\t");
//                ta.append(score.getEng() + "\t");
//                ta.append(score.getMath() + "\t");
//                ta.append(score.getTot() + "\t");
//                ta.append(score.getAvg() + "\n");
//            }
//            ta.append("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
//
//        } else {
//            ta.append("등록된 데이터가 존재하지 않습니다.");
//        }
//
//        ui.select_panel.add(ta);

        JScrollPane pane = new JScrollPane(table);
        ui.select_panel.add(pane);

        ui.content_panel.add(ui.select_panel);
        ui.repaint();
        ui.setVisible(true);
    }

    public void createJTableData() {

        int no = 1;
        for (ScoreVO score : ui.system.scorelist) {
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
