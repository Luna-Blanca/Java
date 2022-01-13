package DAY_UI_BOOK.BookAL_UI;

import DAY_UI_BOOK.BookVO;
import DAY_UI_BOOK.UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search_UI implements ActionListener {
    UI ui;
    BookVO book;
    JTextField name_tf;
    JButton btn_search, btn_update, btn_delete;
    String[] colNames = {"책 이름", "책 저자", "책 가격", "책 넘버"};
    DefaultTableModel model;
    JTable table = new JTable();
    Object[] row = new Object[colNames.length];

    public Search_UI(UI ui) {
        this.ui = ui;
        init();
    }

    public void init() {
        ui.switch_panel(UI.SEARCH);
        ui.search_panel.setLayout(new BorderLayout());

        JPanel search_panel = new JPanel();
        JLabel name_label = new JLabel("책 제목");
        name_tf = new JTextField(20);
        btn_search = new JButton("검색");

        search_panel.add(name_label);
        search_panel.add(name_tf);
        search_panel.add(btn_search);

        ui.search_panel.add(search_panel, BorderLayout.NORTH);
        ui.content_panel.add(ui.search_panel);

        JScrollPane pane = new JScrollPane(table);
        ui.search_panel.add(pane, BorderLayout.CENTER);

        ui.repaint();
        ui.setVisible(true);

        btn_search.addActionListener(this);
        name_tf.addActionListener(this);
    }

    public void search_proc() {
        model = new DefaultTableModel(colNames, 0);
        table.setModel(model);

        if (valivationCheck()) {
            BookVO book = ui.system.search(name_tf.getText());
            if (book == null) {
                JOptionPane.showMessageDialog(null, "찾으시는 도서가 없습니다.");
            } else {
                row[0] = book.getName();
                row[1] = book.getWriter();
                row[2] = book.getPrice();
                row[3] = book.getNumber();

                model.addRow(row);
                model.fireTableDataChanged();
            }


//            if (book != null) {
//                search_result.append("");
//                search_result.append("책 제목\t책 저자\t책 가격\t책 넘버\n");
//                search_result.append(book.getName() + "\t");
//                search_result.append(book.getWriter() + "\t");
//                search_result.append(book.getPrice() + "\t");
//                search_result.append(book.getNumber() + "\n");
//            } else {
//
//            }
        }
    }

    public boolean valivationCheck() {
        boolean result = false;

        if (name_tf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "책 제목을 입력해주세요.");
            name_tf.requestFocus();
        } else {
            result = true;
        }
//        else if(!name_tf.getText().equals(book.getName())){
//            JOptionPane.showMessageDialog(null, "등록되지 않은 책 제목입니다.");
//            result = true;
//        }

        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == btn_search || obj == name_tf) {
            search_proc();
        } else if (obj == btn_update) {
            new Update_UI(ui, book);
        } else if (obj == btn_delete) {
            new Delete_UI(ui, book);
        }
    }
}
