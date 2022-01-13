package KeyCap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UI_Change extends JPanel implements ActionListener {
    ArrayList<JLabel> labelList = new ArrayList<>();
    JButton updateBtn, cancelBtn;
    JTextField searchBox;
    ButtonGroup radioButtonGroup;
    ArrayList<JComponent> componentList = new ArrayList<>();
    ArrayList<JRadioButton> radioButtons = new ArrayList<>();

    public UI_Change() {
        init();
    }

    public void init() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        JPanel infoP = new JPanel();
        infoP.setLayout(new BorderLayout());

        add(makeSearchPanel(), BorderLayout.NORTH);
        add(makeUpdatePanel(), BorderLayout.CENTER);
        add(makeButtonArea(), BorderLayout.SOUTH);
    }

    private JPanel makeSearchPanel() {
        JPanel searchPanel = new JPanel(new GridLayout(1, 1));

        //JPanel namePanel = new JPanel();
        //JLabel label = new JLabel("Search");
        //label.setFont(new Font("Forte", Font.PLAIN, 30));
        //namePanel.add(label);
        //searchPanel.add(namePanel);

        JPanel typePanel = new JPanel();
        searchBox = new JTextField(20);
        typePanel.add(searchBox);
        searchPanel.add(typePanel);

        searchPanel.setPreferredSize(new Dimension(650, 80));
        searchPanel.setBorder(new EmptyBorder(30, 0, 5, 0));

        searchBox.addActionListener(this);
        return searchPanel;
    }

    private JPanel makeUpdatePanel() {
        String[] panelNameList = {"Pokemon", "Material type", "Printing Method", "Printing process", "profile", "Additional information - 1", "Additional information - 2"};
        JPanel UpdateUIPanel = new JPanel(new GridLayout(panelNameList.length, 2));

        for (int i = 0; i < panelNameList.length; i++) {
            Panel namePanel = new Panel();
            JLabel label = new JLabel(panelNameList[i]);
            namePanel.add(label);

            Panel typePanel = new Panel();

            typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
            JComponent toAddComponent;
            if (i == 0) {
                toAddComponent = new JTextField(20);
            } else if (i == 1) {
                String[] materialType = {"", "ABS", "PBT"};
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
            UpdateUIPanel.add(namePanel);
            UpdateUIPanel.add(typePanel);
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
            radioButtons.add(radioBtn);
            choice3Panel.add(radioBtn);
        }

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(UpdateUIPanel, BorderLayout.CENTER);
        mainPanel.add(choice3Panel, BorderLayout.SOUTH);
        mainPanel.setPreferredSize(new Dimension(650, 350));
        mainPanel.setBorder(new EmptyBorder(10, 0, 10, 0));

        return mainPanel;
    }

    private JPanel makeButtonArea() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 20, 0));

        updateBtn = new JButton("Update");
        cancelBtn = new JButton("Cancel");
        updateBtn.setFont(new Font("Forte", Font.PLAIN, 30));
        cancelBtn.setFont(new Font("Forte", Font.PLAIN, 30));
        updateBtn.setBackground(new Color(240, 240, 240));
        cancelBtn.setBackground(new Color(240, 240, 240));
        buttonPanel.setBackground(new Color(240, 240, 240));
        updateBtn.setBorderPainted(false);
        cancelBtn.setBorderPainted(false);

        buttonPanel.add(updateBtn);
        buttonPanel.add(cancelBtn);

        buttonPanel.setPreferredSize(new Dimension(650, 80));
        buttonPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        updateBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        return buttonPanel;
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

    private void updateProc() {
        //User user = UserManager.INSTANCE.findUserOrder(searchBox.getText());
        Order order = UserManager.INSTANCE.findUserOrder(searchBox.getText());
        if (order.pokemon.equals("null")) {
            JOptionPane.showMessageDialog(null, "주문을 아직 안했다고 해피너스가 말합니다", "𝗦𝗬𝗦𝗧𝗘𝗠 - 𝗡𝗢 𝗢𝗥𝗗𝗘𝗥", JOptionPane.ERROR_MESSAGE);
            searchBox.setText("");
            return;
        } else if (order == null) {
            JOptionPane.showMessageDialog(null, "주문을 찾지 못했다고 해피너스가 말합니다", "𝗦𝗬𝗦𝗧𝗘𝗠 - 𝗡𝗢𝗧 𝗙𝗢𝗨𝗡𝗗 𝟰𝟬𝟰", JOptionPane.QUESTION_MESSAGE);
            return;
        }

        order.pokemon = ((JTextField) componentList.get(0)).getText();
        order.materialType = (String) ((JComboBox<String>) componentList.get(1)).getSelectedItem();
        order.printingMethod = (String) ((JComboBox<String>) componentList.get(2)).getSelectedItem();
        order.printingProcess = (String) ((JComboBox<String>) componentList.get(3)).getSelectedItem();
        order.profile = (String) ((JComboBox<String>) componentList.get(4)).getSelectedItem();
        order.extraInfo1 = ((JTextField) componentList.get(5)).getText();
        order.extraInfo2 = ((JTextField) componentList.get(6)).getText();
        order.keyType = KeyType.valueOf(radioButtonGroup.getSelection().getActionCommand());

        JOptionPane.showMessageDialog(null, "해피너스가 주문을 재전송합니다", "𝗦𝗬𝗦𝗧𝗘𝗠 - 𝗨𝗣𝗗𝗔𝗧𝗘", JOptionPane.INFORMATION_MESSAGE);
    }

    private void fillInfoProc() {
        Order order = UserManager.INSTANCE.findUserOrder(searchBox.getText());
        if (order == null) {
            JOptionPane.showMessageDialog(null, "계정 아이디 및 이름 재확인", "𝗤𝗨𝗘𝗦𝗧𝗜𝗢𝗡 - 𝗨𝗦𝗘𝗥 𝗜𝗗𝗘𝗡𝗧𝗜𝗧𝗬", JOptionPane.QUESTION_MESSAGE);
            searchBox.setText("");
            return;
        } else if (order.pokemon.equals("null")) {
            JOptionPane.showMessageDialog(null, "주문을 아직 안했다고 해피너스가 말합니다", "𝗦𝗬𝗦𝗧𝗘𝗠 - 𝗡𝗢 𝗢𝗥𝗗𝗘𝗥", JOptionPane.ERROR_MESSAGE);
            return;
        }

        labelList.get(0).setText(order.pokemon);
        labelList.get(1).setText(order.materialType);
        labelList.get(2).setText(order.printingMethod);
        labelList.get(3).setText(order.printingProcess);
        labelList.get(4).setText(order.profile);
        labelList.get(5).setText(order.extraInfo1);
        labelList.get(6).setText(order.extraInfo2);
        radioButtonGroup.setSelected((ButtonModel) radioButtons.get(order.keyType.ordinal()), true);

//        JComponent comp = componentList.get(1);
//        JComboBox<String> comboBox = (JComboBox<String>)comp;
//        comboBox.setSelectedItem(order.materialType);
//        int selectedKeyTypeIndex = order.keyType.ordinal();
//        JRadioButton rbutton = radioButtons.get(selectedKeyTypeIndex);
//        radioButtonGroup.setSelected((ButtonModel) rbutton, true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == updateBtn) {
            updateProc();
        } else if (source == cancelBtn) {
            clearAllComponents();
        } else if (source == searchBox) {
            fillInfoProc();
        }
    }
}
