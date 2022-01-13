package DAY_UI_BOOK.BookAL_UI;

import DAY_UI_BOOK.BookVO;
import DAY_UI_BOOK.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Insert_UI implements ActionListener {
    UI ui;
    JButton btn_insert, btn_cancel;
    ArrayList<JTextField> tf_list;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();


    public Insert_UI() {

    }

    public Insert_UI(UI ui) {
        this.ui = ui;
        init();
    }

    public void init() {
        ui.switch_panel(UI.INSERT);
        ui.insert_panel.setLayout(new BorderLayout());

        tf_list = new ArrayList<JTextField>();
        Panel mainPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        Panel labelPanel = new Panel(new GridLayout(4, 1));
        Panel emptyPanel = new Panel(new GridLayout(4, 1));
        Panel buttonPanel = new Panel();

        JLabel title = new JLabel("도서 등록");
        mainPanel.add(title);
        btn_insert = new JButton("등록");
        btn_cancel = new JButton("다시쓰기");
        buttonPanel.add(btn_insert);
        buttonPanel.add(btn_cancel);

        String[] namelist = {"책 제목", "책 저자", "책 가격", "책 번호"};
        for (String name : namelist) {
            Panel name_panel = new Panel();
            JLabel label = new JLabel(name);
            name_panel.add(label);

            Panel typing_panel = new Panel();
            JTextField textField = new JTextField(20);
            typing_panel.add(textField);

            labelPanel.add(name_panel);
            emptyPanel.add(typing_panel);
            tf_list.add(textField);
        }

        ui.insert_panel.add(mainPanel, BorderLayout.NORTH);
        ui.insert_panel.add(labelPanel, BorderLayout.WEST);
        ui.insert_panel.add(emptyPanel, BorderLayout.CENTER);
        ui.insert_panel.add(buttonPanel, BorderLayout.SOUTH);

        ui.content_panel.add(ui.insert_panel);
        ui.repaint();
        ui.setVisible(true);

        btn_insert.addActionListener(this);
        btn_cancel.addActionListener(this);
        tf_list.get(3).addActionListener(this);
    }

    public void insert_proc() {
        if (validationCheck()) {
            BookVO book = new BookVO();
            book.setName(tf_list.get(0).getText());
            book.setWriter(tf_list.get(1).getText());
            book.setPrice(Integer.parseInt(tf_list.get(2).getText()));
            book.setNumber(Integer.parseInt(tf_list.get(3).getText()));

            boolean result = ui.system.insert(book);
            if (result) {
                JOptionPane.showMessageDialog(null, "등록완료");
                for(JTextField tf : tf_list) tf.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "등록실패");
            }

            tf_list.get(0).requestFocus();
        }
    }

    public boolean validationCheck() {
        boolean result = false;
        String[] nameList = {"책 제목", "책 저자", "책 가격", "책 넘버"};

        for (int i = 0; i < nameList.length; i++) {
            JTextField tf = tf_list.get(i);
            if (tf.getText().equals("")) {
                JOptionPane.showMessageDialog(null, nameList);
                tf.requestFocus();
                i = nameList.length;
            } else if (i == nameList.length - 1) {
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
            for(JTextField tf : tf_list) tf.setText("");
        }
    }
}
