package KeyCap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class UIMain extends JFrame implements ActionListener, IScreenChangeEvent {
    private JPanel contentP;

    public JPanel getContentP() {
        return contentP;
    }

    public void setContentP(JPanel contentP) {
        this.contentP = contentP;
    }

    // TODO : 이거 enum으로 불가능한지 물어보기
    public static final int ORDER = 1;
    public static final int CHANGE_ORDER = 2;
    public static final int CHECK_ORDER = 3;
    public static final int OPTION = 4;
    public static final int INFORMATION = 5;

    public UIMain() {  //UI의 모든 부분을 담당

        Font font = new Font("Cafe24 Ssurround air", Font.PLAIN, 16);
        UIManager.put("Button.font", font);
        UIManager.put("Label.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("PasswordField.font", font);
        UIManager.put("TextArea.font", font);
        UIManager.put("Table.font", font);
        UIManager.put("TableHeader.font", font);

        setTitle("Pokemon KeyCaps");
        setSize(960, 720);  //size
        setLocation(540, 200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  //X를 누르면 종료
        initContentPanel();
        changeIcon();
        JComponent.setDefaultLocale(Locale.ENGLISH);
        setVisible(true);  //UI를 실체화
        setToLoginPanel();
    }

    private void changeIcon() {  // GUI 좌측 상단 자바아이콘 변경
        Toolkit toolkit = getToolkit();
        Image image = toolkit.createImage("26Z.png");
        setIconImage(image);
    }

    private void initContentPanel() {
        contentP = new JPanel();
        contentP.setLayout(new BorderLayout()); // 패널을 BL로 변경
        contentP.setBorder(new EmptyBorder(24, 24, 24, 24));
        add(contentP);
    }

    private void repaintPanel() {
        contentP.revalidate();
        contentP.repaint();
    }

    // TODO : Log-in panel class로 분리
    private void setToLoginPanel() {
        contentP.removeAll();
        UI_Login panel = new UI_Login(this);
        contentP.add(panel);
        repaintPanel();
        panel.focusToIDField();
    }

    @Override
    public void onScreenChangeTo(JPanel panel) {
        contentP.removeAll();
        contentP.add(panel);
        repaintPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
