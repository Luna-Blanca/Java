package Ch5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JLabel resultLabel;
    private JTextField field1;
    private JTextField field2;

    public Calculator() {
        initializeUI();
    }

    public void initializeUI() {
        setSize(550, 400); // 창 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X누르면 바로 꺼짐
        setLayout(new FlowLayout()); // 레이아웃 설정

        resultLabel = new JLabel("결과");
        add(resultLabel);

        field1 = new JTextField(8);
        add(field1);
        field2 = new JTextField(8);
        add(field2);


        // 더하기
        JButton plusButton = new JButton("+");
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate(0);
            }
        });
        add(plusButton);


        // 빼기
        JButton minusButton = new JButton("-");
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate(1);
            }
        });
        add(minusButton);


        // 곱하기
        JButton multiplyButton = new JButton("*");
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate(2);
            }
        });
        add(multiplyButton);


        // 나누기
        JButton divideButton = new JButton("/");
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate(3);
            }
        });
        add(divideButton);

        setVisible(true); // 창 띄우기 -> 창을 그린다
    }

    // 각 모드들 실행
    private void calculate(int mode) {
        int num1 = Integer.parseInt(field1.getText());
        int num2 = Integer.parseInt(field2.getText());
        int result;
        switch (mode) {
            case 0:
                result = num1 + num2;
                break;
            case 1:
                result = num1 - num2;
                break;
            case 2:
                result = num1 * num2;
                break;
            case 3:
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("잘못된 mode가 입력되었습니다.");
        }
        resultLabel.setText(String.valueOf(result));
    }
}
