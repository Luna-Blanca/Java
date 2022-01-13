package DAY_Vc.관리자;

import DAY_Vc.AdminUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UI_List {
    AdminUI ui;
    String[] colNames1 = {"ID", "PW", "Name", "Number"};
    String[] colNames2 = {"Name", "Birth", "SSC", "Vaccine", "Pharmaceutical Co.", "Vaccination"};
    DefaultTableModel model1 = new DefaultTableModel(colNames1, 0);
    DefaultTableModel model2 = new DefaultTableModel(colNames2, 0);
    JTable table1 = new JTable(model1);
    JTable table2 = new JTable(model2);
    Object[] row1 = new Object[colNames1.length];
    Object[] row2 = new Object[colNames2.length];
    JPanel listPanel = new JPanel(new BorderLayout());

    public UI_List() {

    }

    public UI_List(AdminUI ui) {
        this.ui = ui;
        init();
    }

    public void init() {
        ui.switchP(AdminUI.LIST);

        //createTableData();
        table1.setModel(model1);
        table2.setModel(model2);

        JScrollPane pane1 = new JScrollPane(table1);
        pane1.setPreferredSize(new Dimension(600, 120));
        ui.listP.add(pane1);
        JScrollPane pane2 = new JScrollPane(table2);
        pane2.setPreferredSize(new Dimension(600, 120));
        ui.listP.add(pane2);

        listPanel.add(pane1);
        listPanel.add(pane2);

        ui.mainP.add(ui.listP);
    }
}
