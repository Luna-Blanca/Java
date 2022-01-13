package DAY_UI_BOOK.BookAL_UI;

import DAY_UI_BOOK.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Delete_UI implements ActionListener {
    UI ui;
    JTextField name_tf;
    JButton btn_search, btn_delete, btn_reset;
    ArrayList<JTextField> tf_list;

    public Delete_UI() {

    }
    public Delete_UI(UI ui) {
        this.ui = ui;
        init();
    }

    public Delete_UI(UI ui, DAY_UI_BOOK.BookVO book) {
        this.ui = ui;
        init();
        name_tf.setText(book.getName());
        tf_list.get(0).setText(book.getName());
        tf_list.get(0).setEditable(false);
        tf_list.get(1).setText(book.getWriter());
        tf_list.get(2).setText(String.valueOf(book.getPrice()));
        tf_list.get(3).setText(String.valueOf(book.getNumber()));
    }

    public void init() {
        tf_list = new ArrayList<JTextField>();
        ui.switch_panel((UI.DELETE));
        ui.delete_panel.setLayout(new BorderLayout());

        JPanel top_panel = new JPanel();
        JLabel label = new JLabel("삭제할 책 제목");
        name_tf = new JTextField(20);
        btn_search = new JButton("검색");
        top_panel.add(label);
        top_panel.add(name_tf);
        top_panel.add(btn_search);

        ui.delete_panel.add(top_panel, BorderLayout.NORTH);
        ui.delete_panel.add(delete_form(), BorderLayout.CENTER);
        ui.content_panel.add(ui.delete_panel);
        ui.repaint();
        ui.setVisible(true);

        btn_search.addActionListener(this);
        name_tf.addActionListener(this);

        ui.content_panel.add(ui.delete_panel);
        ui.setVisible(true);
    }

    public JPanel delete_form() {
        tf_list = new ArrayList<JTextField>();
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel labelPanel = new JPanel(new GridLayout(4, 1));
        JPanel emptyPanel = new JPanel(new GridLayout(4, 1));
        Panel buttonPanel = new Panel();

        String[] nameList = {"책 제목", "책 저자", "책 가격", "책 번호"};
        for (String name : nameList) {
            JPanel name_panel = new JPanel();
            JPanel typing_panel = new JPanel();
            JLabel label = new JLabel(name);
            JTextField textField = new JTextField(20);

            name_panel.add(label);
            typing_panel.add(textField);
            labelPanel.add(name_panel);
            emptyPanel.add(typing_panel);
            textField.setEditable(false);
            tf_list.add(textField);
        }

        btn_delete = new JButton("삭제완료");
        btn_reset = new JButton("취소하기");
        buttonPanel.add(btn_delete);
        buttonPanel.add(btn_reset);

        mainPanel.add(labelPanel, BorderLayout.WEST);
        mainPanel.add(emptyPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        btn_delete.addActionListener(this);
        btn_reset.addActionListener(this);

        return mainPanel;
    }

    public void search_proc() {
        if (validationCheck()) {
            DAY_UI_BOOK.BookVO book = ui.system.search(name_tf.getText());
            if(book != null) {
                tf_list.get(0).setText(book.getName());
                tf_list.get(0).setEditable(false);
                tf_list.get(1).setText(book.getWriter());
                tf_list.get(2).setText(String.valueOf(book.getPrice()));
                tf_list.get(3).setText(String.valueOf(book.getNumber()));
            } else {
                JOptionPane.showMessageDialog(null, "수정할 책이 존재하지 않습니다.");
            }
        }
    }

    public boolean validationCheck() {
        boolean result = false;

        if (name_tf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "책 제목을 입력해주세요");
            name_tf.requestFocus();
        } else {
            result = true;
        }

        return result;
    }

    public void delete_proc() {
        int choice = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?");
        if (choice == 0) {
            boolean result = ui.system.delete(name_tf.getText());
            if (result) {
                JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
                name_tf.setText("");
                for (JTextField tf : tf_list) {
                    tf.setText("");
                }
                name_tf.requestFocus();
                new List_UI(ui);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == btn_search || obj == name_tf) {
            search_proc();
        } else if (obj == btn_delete) {
            delete_proc();
        } else if (obj == btn_reset) {
            name_tf.setText("");
            for (JTextField tf : tf_list) {
                tf.setText("");
            }
            name_tf.requestFocus();
        }
    }
}
