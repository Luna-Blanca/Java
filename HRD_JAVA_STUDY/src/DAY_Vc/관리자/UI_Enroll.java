package DAY_Vc.관리자;

import DAY_Vc.UserDB;
import DAY_Vc.AdminUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UI_Enroll implements ActionListener {
    AdminUI ui;
    JButton btEnroll, btCancel;
    ArrayList<JTextField> tfList;
    String[] nameList = {"Name", "Birth", "SSC", "Vaccine", "Pharmaceutical Co.", "Vaccination"};

    public UI_Enroll() {

    }

    public UI_Enroll(AdminUI ui) {
        this.ui = ui;
        init();
    }

    public void init() {
        ui.switchP(AdminUI.ENROLL);
        ui.enrollP.setLayout(new BorderLayout());

        tfList = new ArrayList<>();
        Panel mainP = new Panel(new FlowLayout(FlowLayout.CENTER));
        Panel nameP = new Panel(new GridLayout(nameList.length, 1));
        Panel emptyP = new Panel(new GridLayout(nameList.length, 1));
        Panel btP = new Panel();

        JLabel title = new JLabel("Add Vaccine List");
        mainP.add(title);
        btEnroll = new JButton("등록하기");
        btCancel = new JButton("취소하기");
        btP.add(btEnroll);
        btP.add(btCancel);

        for (String name : nameList) {
            Panel name_panel = new Panel();
            Panel typing_panel = new Panel();
            JLabel label = new JLabel(name);
            JTextField textField = new JTextField(20);

            name_panel.add(label);
            typing_panel.add(textField);
            nameP.add(name_panel);
            emptyP.add(typing_panel);

            tfList.add(textField);
        }

        ui.enrollP.add(mainP, BorderLayout.NORTH);
        ui.enrollP.add(nameP, BorderLayout.WEST);
        ui.enrollP.add(emptyP, BorderLayout.CENTER);
        ui.enrollP.add(btP, BorderLayout.SOUTH);

        ui.mainP.add(ui.enrollP);
        ui.repaint();
        ui.setVisible(true);

        btEnroll.addActionListener(this);
        btCancel.addActionListener(this);
    }

    public void enroll_proc() {
        if (tfList.get(0).getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "이름를 입력해주세요.");
            return;
        }
        if (tfList.get(1).getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "생일을 입력해주세요.");
            return;
        }
        if (tfList.get(2).getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "주민등록번호을 입력해주세요.");
            return;
        }
        if (tfList.get(3).getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "백신 종류를 입력해주세요.");
            return;
        }
        if (tfList.get(4).getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "제약 회사를 입력해주세요.");
            return;
        }
        if (tfList.get(5).getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "SYSTEM\n누락정보 - 접종일");
            return;
        }

        if (check()) {
            UserDB db = new UserDB();
            db.setID(tfList.get(0).getText());
            db.setUserName(tfList.get(1).getText());
            db.setVaccine(tfList.get(2).getText());
            db.setCompany(tfList.get(3).getText());
            db.setDate(tfList.get(4).getText());

            boolean result = ui.DB.enroll(db);
            if (result) {
                JOptionPane.showMessageDialog(null, "등록 완료");
                for (JTextField tf : tfList) tf.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "등록 실패");
            }
            tfList.get(0).requestFocus();
        }
    }

    public boolean check() {
        boolean result = false;

        String[] nameList = {"ID", "NAME", "Vaccine", "COMPANY", "DATE"};
        for (int i = 0; i < nameList.length; i++) {
            JTextField tf = tfList.get(i);
            if (tf.getText().equalsIgnoreCase(" ")) {
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

        if (obj == btEnroll || obj == tfList.get(4)) {
            enroll_proc();
        } else if (obj == btCancel) {
            init();
        } else if (obj == tfList.get(0) || obj == tfList.get(1) || obj == tfList.get(2) || obj == tfList.get(3)) {

        }

    }
}
