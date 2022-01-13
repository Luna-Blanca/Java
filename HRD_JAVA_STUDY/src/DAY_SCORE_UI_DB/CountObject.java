package DAY_SCORE_UI_DB;

import DAY_SCORE_UI_DB.Scoremgm.Scoremgm;

public class CountObject extends Thread {
    Scoremgm_UI ui;
    Scoremgm system;

    public CountObject() {
    }

    public CountObject(Scoremgm_UI ui, Scoremgm system) {
        this.ui = ui;
        this.system = system;
    }

    public void run() {
        while (true) {
            int count = system.scorelist.size();
            ui.tf_count.setText(String.valueOf(system.scorelist.size()));
            try {
                Thread.sleep(10000);
            } catch (Exception e) {

            }
        }
    }
}
