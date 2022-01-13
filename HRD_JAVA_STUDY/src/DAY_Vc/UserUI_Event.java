package DAY_Vc;

import DAY_Vc.관리자.UI_Enroll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class UserUI_Event implements ActionListener, WindowListener {
    AdminUI ui;

    public UserUI_Event() {

    }

    public UserUI_Event(AdminUI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == ui.button_list.get(0)) {
            new UI_Enroll(ui);
        } else if (obj == ui.button_list.get(1)) {

        } else if (obj == ui.button_list.get(2)) {

        } else if (obj == ui.button_list.get(3)) {

        } else if (obj == ui.button_list.get(4)) {

        }
//        else if (obj == ui.button_list.get(5)) {
//
//        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

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
}
