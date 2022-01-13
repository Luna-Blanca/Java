package KeyCap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UI_Check extends JPanel implements ActionListener {
    ArrayList<JLabel> labelList = new ArrayList<>();

    public UI_Check() {
        init();
    }

    public void init() {
        //setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        setLayout(new BorderLayout());

        add(makeSearchPanel(), BorderLayout.NORTH);
        add(makeReceiptPanel(), BorderLayout.CENTER);
        add(makeButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel makeSearchPanel() {
        JPanel nameP = new JPanel();
        JTextField tf = new JTextField(20);
        tf.addActionListener(this);
        tf.setActionCommand("search");
        nameP.add(tf);

        nameP.setPreferredSize(new Dimension(650, 80));
        nameP.setBorder(new EmptyBorder(30, 0, 5, 0));

        return nameP;
    }

    private JPanel makeReceiptPanel() {
        JPanel receiptP = new JPanel(new BorderLayout());
        JLabel titleL = new JLabel("Receipt", JLabel.CENTER);
        titleL.setFont(new Font("Forte", Font.PLAIN, 30));

        String[] nameValues = {"Pokemon", "Material type", "Printing Method", "Printing process", "profile", "Additional information ①", "Additional information ②", "KeyType"};
        JPanel receiptInfoP = new JPanel(new GridLayout(8, 2, 10, 10));
        for (int i = 0; i < nameValues.length; i++) {
            JLabel nameL = new JLabel(nameValues[i]);
            nameL.setFont(new Font("Cafe24 Ssurround air", Font.PLAIN, 16));
            JLabel null2L = new JLabel(" ");
            labelList.add(null2L);

            receiptInfoP.add(nameL);
            receiptInfoP.add(null2L);
        }

        receiptP.add(titleL, BorderLayout.NORTH);
        receiptP.add(receiptInfoP, BorderLayout.CENTER);
        receiptP.setBorder(new EmptyBorder(10, 30, 20, 30));
        return receiptP;
    }

    private JPanel makeButtonPanel() {
        JButton button = new JButton("Delete");
        button.setFont(new Font("Forte", Font.PLAIN, 30));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);

        button.setBackground(new Color(240, 240, 240)); // 버튼 색 변경
        button.setBorderPainted(false);
        buttonPanel.setBackground(new Color(240, 240, 240));
        buttonPanel.setBorder(new EmptyBorder(30, 120, 30, 120));

        button.addActionListener(this);
        button.setActionCommand("Delete");
        return buttonPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("search")) {
            JTextField tf = (JTextField) e.getSource();
            Order order = UserManager.INSTANCE.findUserOrder(tf.getText());
            if (order == null) {
                JOptionPane.showMessageDialog(null, "주문을 아직 안했다고 해피너스가 말합니다", "𝗦𝗬𝗦𝗧𝗘𝗠 - 𝗡𝗢𝗧 𝗙𝗢𝗨𝗡𝗗 𝟰𝟬𝟰", JOptionPane.QUESTION_MESSAGE);
                tf.setText("");
                return;
            }

            if (order.pokemon.equals("null")) {
                JOptionPane.showMessageDialog(null, "주문을 찾지 못했다고 해피너스가 말합니다", "𝗦𝗬𝗦𝗧𝗘𝗠 - 𝗡𝗢𝗧 𝗙𝗢𝗨𝗡𝗗 𝟰𝟬𝟰", JOptionPane.QUESTION_MESSAGE);
                return;
            }
            labelList.get(0).setText(order.pokemon);
            labelList.get(1).setText(order.materialType);
            labelList.get(2).setText(order.printingMethod);
            labelList.get(3).setText(order.printingProcess);
            labelList.get(4).setText(order.profile);
            labelList.get(5).setText(order.extraInfo1);
            labelList.get(6).setText(order.extraInfo2);
            labelList.get(7).setText(order.getKeyData());

        } else if (e.getActionCommand().equals("Delete")) {
            JTextField tf = (JTextField) e.getSource();
            Order order = UserManager.INSTANCE.findUserOrder(tf.getText());
            if (order == null) {
                JOptionPane.showMessageDialog(null, "해피너스가 주문을 찾지 못했습니다", "𝗦𝗬𝗦𝗧𝗘𝗠 - 𝗡𝗢𝗧 𝗙𝗢𝗨𝗡𝗗 𝟰𝟬𝟰", JOptionPane.ERROR_MESSAGE);
            } else {

                //UserManager.INSTANCE.getLoginUser().deleteOrder();
                boolean result = UserManager.INSTANCE.deleteUserOrder(tf.getText());
                if (result) {
                    JOptionPane.showMessageDialog(null, "해피너스가 주문을 삭제했습니다.", "𝗦𝗬𝗦𝗧𝗘𝗠 - 𝗖𝗢𝗠𝗣𝗟𝗘𝗧𝗘", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "해피너스가 주문을 찾지 못했습니다.", "𝗦𝗬𝗦𝗧𝗘𝗠 - 𝗡𝗢𝗧 𝗙𝗢𝗨𝗡𝗗 𝟰𝟬𝟰", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
