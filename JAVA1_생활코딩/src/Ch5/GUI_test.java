package Ch5;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class GUI_test extends JFrame {
    BufferedImage backgroundImg;

    JPanel groupPanel;
    JPanel padPanel;
    JPanel infoView;
    JLabel title;
    JLabel infoV;
    JLabel infoV2;
    JTextField inputText;

    private final String names[] = {"7", "8", "9", "-", "4", "5", "6", "+", "1", "2", "3", "*", ".", "0", "=", "/"};
    JButton button[] = new JButton[names.length];
    JButton clear;

    public GUI_test() {
        initData();
        setInitLayout();
    }

    public static void main(String[] args) {
        new GUI_test();
    }

    private void initData() {
        setTitle("계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(new BorderLayout(10, 20));

        groupPanel = new JPanel(new BorderLayout(10, 10));
        title = new JLabel("Swing 레이아웃 연습", SwingConstants.CENTER);
        inputText = new JTextField("0", SwingConstants.CENTER);
        padPanel = new JPanel(new GridLayout(4, 4));
        infoView = new JPanel(new BorderLayout(5, 5));
        infoV2 = new JLabel("makeby : Luna Blanca", SwingConstants.RIGHT);
        clear = new JButton("Clear");

        for(int i =0; i<names.length; i++) {
            button[i] = new JButton(names[i]);
        }
    }

    private void setInitLayout() {
        setVisible(true);
        setResizable(false);

        groupPanel.add(title, BorderLayout.NORTH);
        inputText.setHorizontalAlignment(JTextField.RIGHT);
        groupPanel.add(inputText, BorderLayout.CENTER);

        for(int i=0; i<names.length; i++) {
            padPanel.add(button[i]);
        }

        infoView.add(clear, BorderLayout.NORTH);
        infoView.add(infoV2, BorderLayout.SOUTH);

        add(groupPanel, BorderLayout.NORTH);
        add(padPanel, BorderLayout.CENTER);
        add(infoView, BorderLayout.SOUTH);
    }
}

