package KeyCap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UI_Order extends JPanel implements ActionListener {
    JButton orderBtn, cancelBtn;
    ButtonGroup radioButtonGroup;
    ArrayList<JComponent> componentList = new ArrayList<>();

    public UI_Order() {
        init();
    }

    public void init() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        JPanel infoP = new JPanel();
        infoP.setLayout(new BorderLayout());

        add(makeTitlePanel(), BorderLayout.NORTH);
        add(makeOrderUIPanel(), BorderLayout.CENTER);
        add(makeButtonPanel(), BorderLayout.SOUTH);
    }

    public JPanel makeTitlePanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("KeyCap OrderList");
        label.setFont(new Font("Forte", Font.PLAIN, 40));
        panel.add(label);

        panel.setPreferredSize(new Dimension(650, 80));
        panel.setBorder(new EmptyBorder(20, 0, 5, 0));

        return panel;
    }

    public JPanel makeOrderUIPanel() {
        String[] panelNameList = {"Pokemon", "Material type", "Printing Method", "Printing process", "profile", "Additional information - 1", "Additional information - 2"};
        JPanel OrderUIPanel = new JPanel(new GridLayout(panelNameList.length, 2));

        for (int i = 0; i < panelNameList.length; i++) {
            JPanel namePanel = new JPanel();
            JLabel label = new JLabel(panelNameList[i]);
            namePanel.add(label);

            JPanel typePanel = new JPanel();
            typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
            JComponent toAddComponent;
            if (i == 0) {
                toAddComponent = new JTextField(20);
            } else if (i == 1) {
                String[] materialType = {" ", "ABS", "PBT"};
                toAddComponent = new JComboBox<String>(materialType);
            } else if (i == 2) {
                String[] printingMethod = {"", "No angle", "Measurement angle", "And angle"};
                toAddComponent = new JComboBox<String>(printingMethod);
            } else if (i == 3) {
                String[] printingProcess = {"", "Pad", "Laser", "Dye-Subilmation", "Double shot"};
                toAddComponent = new JComboBox<String>(printingProcess);
            } else if (i == 4) {
                String[] profile = {"", "SA", "SA Row3", "OEM", "Cherry", "DCS", "XDA", "DSA", "G20"};
                toAddComponent = new JComboBox<String>(profile);
            } else {
                toAddComponent = new JTextField(20);
                if (i == panelNameList.length - 1) {
                    ((JTextField) toAddComponent).addActionListener(this);
                }
            }
            typePanel.add(toAddComponent);
            typePanel.add(Box.createRigidArea(new Dimension(0, 10)));
            componentList.add(toAddComponent);

            label.setFont(new Font("Forte", Font.PLAIN, 20));
            OrderUIPanel.add(namePanel);
            OrderUIPanel.add(typePanel);
        }

        radioButtonGroup = new ButtonGroup();
        JPanel choice3Panel = new JPanel();
        String[] enumNames = {"OUTEMU", "CHERRY", "KAILK_CHOC_V1"};
        String[] Info2 = {"Outemu", "Cherry", "Kailk Choc V1"};
        for (int i = 0; i < Info2.length; i++) {
            JRadioButton radioBtn = new JRadioButton("   " + Info2[i] + "   ");
            radioBtn.setFont(new Font("Forte", Font.PLAIN, 20));
            radioBtn.setActionCommand(enumNames[i]);
            radioButtonGroup.add(radioBtn);
            choice3Panel.add(radioBtn);
        }

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(OrderUIPanel, BorderLayout.CENTER);
        mainPanel.add(choice3Panel, BorderLayout.SOUTH);
        mainPanel.setPreferredSize(new Dimension(650, 350));
        mainPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        return mainPanel;
    }

    public JPanel makeButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 20, 0));

        orderBtn = new JButton("Order");
        cancelBtn = new JButton("Cancel");
        orderBtn.setFont(new Font("Forte", Font.PLAIN, 30));
        cancelBtn.setFont(new Font("Forte", Font.PLAIN, 30));
        orderBtn.setBackground(new Color(240, 240, 240));
        cancelBtn.setBackground(new Color(240, 240, 240));
        buttonPanel.setBackground(new Color(240, 240, 240));
        orderBtn.setBorderPainted(false);
        cancelBtn.setBorderPainted(false);

        buttonPanel.add(orderBtn);
        buttonPanel.add(cancelBtn);

        buttonPanel.setPreferredSize(new Dimension(650, 80));
        buttonPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        orderBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        return buttonPanel;
    }

    private String getTextAt(int index) {
        return ((JTextField) componentList.get(index)).getText();
    }

    private String getSelectedAsString(int index) {
        return (String) ((JComboBox<String>) componentList.get(index)).getSelectedItem();
    }

    private void clearAllComponents() {
        for (JComponent comp : componentList) {
            if (comp instanceof JTextField) {
                ((JTextField) comp).setText("");
            } else if (comp instanceof JComboBox) {
                ((JComboBox) comp).setSelectedIndex(0);
            }
        }
        radioButtonGroup.clearSelection();
    }

    public void orderProc() {
        Order order = new Order();
        order.pokemon = getTextAt(0);
        order.materialType = getSelectedAsString(1);
        order.printingMethod = getSelectedAsString(2);
        order.printingProcess = getSelectedAsString(3);
        order.profile = getSelectedAsString(4);
        order.extraInfo1 = getTextAt(5);
        order.extraInfo2 = getTextAt(6);
        order.keyType = KeyType.valueOf(radioButtonGroup.getSelection().getActionCommand());
        order.setRandomNumber(giveRandomNumber());
        boolean result = order.addOrder(order);

        if (result) {
            JOptionPane.showMessageDialog(null, "해피너스가 주문을 전송했습니다.\n주문번호 : " + order.getRandomNumber(), "𝗦𝗬𝗦𝗧𝗘𝗠 - 𝗦𝗨𝗖𝗖𝗘𝗦𝗦 𝗢𝗥𝗗𝗘𝗥", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "당신의 주문이 로켓단에게 뺏겼습니다.", "𝗦𝗬𝗦𝗧𝗘𝗠 - 𝗜 𝗛𝗔𝗧𝗘 𝗧𝗲𝗮𝗺.𝗥𝗢𝗖𝗞𝗘𝗧", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String giveRandomNumber() {
        String result = "";
        boolean find = true;

        while (find) {
            int num = (int) (Math.random() * 100);
            if (num == 100) {
                find = true;
            } else {
                result = String.valueOf(num);
                int num2 = (int) (Math.random() * 10000);
                int length = (int)(Math.log10(num2)+1);
                if (length == 4) {
                    String changenum = String.valueOf(num2);
                    char[] eachnum = changenum.toCharArray();
                    for (int i = 0; i < 4; i++) {
                        String a = String.valueOf(eachnum[i]);
                        String code;
                        if (a.equals("2") || a.equals("3")) {
                            code = "T";
                        } else if (a.equals("4") || a.equals("5")) {
                            code = "F";
                        } else if (a.equals("6") || a.equals("7")) {
                            code = "S";
                        } else if (a.equals("1") || a.equals("8")) {
                            code = "E";
                        } else {
                            code = "N";
                        }
                        result += code;
                    }
                    find = false;
                } else {
                    find = true;
                }
            }
        }

        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == orderBtn || obj == componentList.get(6)) {
            orderProc();
            clearAllComponents();
        } else if (obj == cancelBtn) {
            clearAllComponents();
        }
    }
}