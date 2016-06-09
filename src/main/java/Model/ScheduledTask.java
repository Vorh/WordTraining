package Model;

import View.TaskPane;
import XML.ManagerXmlSettings;
import XML.Settings;

import java.util.TimerTask;

public class ScheduledTask extends TimerTask {

    private int hours;
    private int minutes;
    private int second;
    public static int amountWord;

    public ScheduledTask(){
        Settings settings = ManagerXmlSettings.unmarshaller();
        amountWord = settings.getCountWord();
        hours = settings.getHours();
        minutes = settings.getMinutes();
        second = settings.getSecond();
    }

    @Override
    public void run() {


        for (int i = 0; i <=second ; second--) {
            try {
                Thread.sleep(1000);
                updetText(hours,minutes,second);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        minutes--;
        for (int i = 0; i <=hours ; hours--) {
            for (int j = 0; j <=minutes ; minutes--) {
                for (int k = 60; k >=0 ; k--) {
                    try {
                        Thread.sleep(1000);
                        updetText(hours,minutes,k);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        ManagerTask.extraditionSetWord(amountWord);
        Sound.playSound();

    }

    private void updetText(int hours, int minutes , int second){
        String sHours = String.valueOf(hours);
        String sMinutes = String.valueOf(minutes);
        String sSeound = String.valueOf(second);
        if(hours<10){
            sHours = "0" + sHours;
        }
        if (minutes <10){
            sMinutes = "0" + sMinutes;
        }
        if (second <10){
            sSeound = "0" + second;
        }
        TaskPane.timerText.setText(sHours+ " : " + sMinutes + " : " + sSeound);
    }


}
