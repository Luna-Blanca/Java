package DAY_UI_BOOK.BookAL_UI;

import DAY_UI_BOOK.BookVO;
import DAY_UI_BOOK.UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class List_UI implements ActionListener {
    UI ui;
    JTextArea textArea;
    String[] colNames = {"번호","책 이름", "책 저자", "책 가격", "책 넘버"};
    DefaultTableModel model = new DefaultTableModel(colNames, 0);
    JTable table = new JTable(model);
    Object[] row = new Object[colNames.length];

    public List_UI() {

    }

    public List_UI(UI ui) {
        this.ui = ui;
        init();
    }
    public void init() {
        ui.switch_panel(UI.LIST);

        //textArea = new JTextArea(16, 40);
        createTableData();
        table.setModel(model);

//        if (ui.system.booklist.size() != 0) {
//            textArea.append("");
//            textArea.append("책 이름\t\t책 저자\t책 가격\t책 넘버\n");
//
//            for (BookVO book : ui.system.booklist) {
//                textArea.append(book.getName() + "\t\t");
//                textArea.append(book.getWriter() + "\t");
//                textArea.append(book.getPrice() + "\t");
//                textArea.append(book.getNumber() + "\n");
//            }
//            textArea.append("");
//        } else {
//            textArea.append("등록된 책이 없습니다.");
//        }

//        ui.list_panel.add(textArea);

        JScrollPane pane = new JScrollPane(table);
        ui.list_panel.add(pane);

        ui.content_panel.add(ui.list_panel);
        ui.repaint();
        ui.setVisible(true);
    }

    public void createTableData() {
        int no = 1;
        for (BookVO vo : ui.system.booklist) {
            row[0] = no;
            row[1] = vo.getName();
            row[2] = vo.getWriter();
            row[3] = vo.getPrice();
            row[4] = vo.getNumber();

            model.addRow(row);
            no++;
        }
        model.fireTableDataChanged();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
