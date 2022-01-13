package DAY_SCORE_UI_DB;

import javax.swing.*;
import java.awt.event.*;

public class Scoremgm_Event implements ActionListener, WindowListener, WindowStateListener, WindowFocusListener {

    Scoremgm_UI ui;

    public Scoremgm_Event() {

    }

    public Scoremgm_Event(Scoremgm_UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == ui.button_list.get(0)) {
            new Insert_UI(ui);
        } else if (obj == ui.button_list.get(1)) {
            new Select_UI(ui);
        } else if (obj == ui.button_list.get(2)) {
            new Search_UI(ui);
        } else if (obj == ui.button_list.get(3)) {
            new Update_UI(ui);
        } else if (obj == ui.button_list.get(4)) {
            new Delete_UI(ui);
        } else if (obj == ui.button_list.get(5)) {
            int result = JOptionPane.showConfirmDialog(null, "정말로 종료하시겠습니까?");
            if (result == 0) {
                System.exit(0);
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("프로그램 종료");
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
    }
}
