package DAY_UI_BOOK.BookAL_UI;

import DAY_UI_BOOK.BookVO;
import DAY_UI_BOOK.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Update_UI implements ActionListener {
    UI ui;
    JTextField name_tf;
    JButton btn_search, btn_update, btn_reset;
    ArrayList<JTextField> tf_list;

    public Update_UI() {

    }
    public Update_UI(UI ui) {
        this.ui = ui;
        init();
    }

    public Update_UI(UI ui, BookVO book) {
        this.ui = ui;
        init();
        name_tf.setText(book.getName());
        tf_list.get(0).setText(book.getName());
        tf_list.get(0).setEditable(false);
        tf_list.get(1).setText(book.getWriter());
        tf_list.get(2).setText(String.valueOf(book.getPrice()));
        tf_list.get(3).setText(String.valueOf(book.getName()));
    }

    public void init() {
        ui.switch_panel(UI.UPDATE);
        ui.update_panel.setLayout(new BorderLayout());

        JPanel top_panel = new JPanel();
        JLabel label = new JLabel("수정할 책 제목");
        name_tf = new JTextField(20);
        btn_search = new JButton("검색");
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
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel labelPanel = new JPanel(new GridLayout(4, 1));
        JPanel emptyPanel = new JPanel(new GridLayout(4, 1));
        Panel buttonPanel = new Panel();

        String[] nameList = {"책 제목", "책 저자", "책 가격", "책 번호"};
        for (String name : nameList) {
            JLabel label = new JLabel(name);
            JPanel typing_panel = new JPanel();
            JTextField textField = new JTextField(20);

            labelPanel.add(label);
            typing_panel.add(textField);
            emptyPanel.add(typing_panel);
            textField.addActionListener(this);
            tf_list.add(textField);
        }

        btn_update = new JButton("수정완료");
        btn_reset = new JButton("다시쓰기");
        buttonPanel.add(btn_update);
        buttonPanel.add(btn_reset);

        mainPanel.add(labelPanel, BorderLayout.WEST);
        mainPanel.add(emptyPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        btn_update.addActionListener(this);
        btn_reset.addActionListener(this);
        return mainPanel;
    }

    public void search_proc() {
        if (validationCheck()) {
            BookVO book = ui.system.search(name_tf.getText());
            if (book != null) {
                tf_list.get(0).setText(book.getName());
                tf_list.get(0).setEditable(false);
                tf_list.get(1).setText(book.getWriter());
                tf_list.get(1).setEditable(false);
                tf_list.get(2).setText(String.valueOf(book.getPrice()));
                tf_list.get(3).setText(String.valueOf(book.getNumber()));
            } else {
                JOptionPane.showMessageDialog(null, "검색하신 도서가 존재하지 않습니다.");
            }
        }
    }

    public boolean validationCheck() {
        boolean result = false;

        if (name_tf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "제목을 입력해주세요.");
            name_tf.requestFocus();
        } else {
            result = true;
        }
        return result;
    }

    public void update_proc() {
        if (name_tf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "제목을 입력해주세요.");
            name_tf.requestFocus();
            return;
        }

        if(tf_list.get(2).getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "가격을 입력해주세요");
            return;
        }

        if(tf_list.get(3).getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "번호를 입력해주세요");
            return;
        }

        BookVO update_book = new BookVO();
        update_book.setName(name_tf.getText());
        update_book.setWriter(tf_list.get(1).getText());
        update_book.setPrice(Integer.parseInt(tf_list.get(2).getText()));
        update_book.setNumber(Integer.parseInt(tf_list.get(3).getText()));

        boolean result = ui.system.update(update_book);
        if (result) {
            JOptionPane.showMessageDialog(null, "수정완료");
            new List_UI(ui); // 생성자 실행
            // update의 UI ui를 이용해서 List_UI의 init()을 할 수 있도록 해보기

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == btn_search || obj == name_tf) {
            search_proc();
        } else if (obj == btn_update || obj == tf_list.get(2) || obj == tf_list.get(3)) {
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
