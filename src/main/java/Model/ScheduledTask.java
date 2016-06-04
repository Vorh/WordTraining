package Model;

import View.TaskPane;
import XML.Settings;

import java.util.TimerTask;

public class ScheduledTask extends TimerTask {

    private int hours;
    private int minutes;
    private int second;

    public ScheduledTask(Settings settings){
        hours = settings.getHours();
        minutes = settings.getMinutes();
        second = settings.getSecond();
    }

    @Override
    public void run() {
        TaskPane.timer.setText(hours+ " : " + minutes+ " : " + second);

        for (int i = 0; i <second ; second--) {
            try {
                Thread.sleep(1000);
                TaskPane.timer.setText(hours+ " : " + minutes + " : " + second);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        minutes--;
        for (int i = 0; i <=hours ; hours--) {
            for (int j = 0; j <=minutes ; minutes--) {
                for (int k = 60; k >0 ; k--) {
                    try {
                        Thread.sleep(1000);
                        TaskPane.timer.setText(hours+ " : " + minutes + " : " + k);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}
