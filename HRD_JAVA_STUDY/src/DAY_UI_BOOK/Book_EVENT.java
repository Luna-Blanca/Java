package DAY_UI_BOOK;

import DAY_UI_BOOK.BookAL_UI.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Book_EVENT implements ActionListener, WindowListener {

    UI ui;

    public Book_EVENT() {
    }

    public Book_EVENT(UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == ui.button_list.get(0)) {
            new Insert_UI(ui);
        } else if (obj == ui.button_list.get(1)) {
            new List_UI(ui);
        } else if (obj == ui.button_list.get(2)) {
            new Search_UI(ui);
        } else if (obj == ui.button_list.get(3)) {
            new Update_UI(ui);
        } else if (obj == ui.button_list.get(4)) {
            new Delete_UI(ui);
        } else if (obj == ui.button_list.get(5)) {
            int result = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?");
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
}
