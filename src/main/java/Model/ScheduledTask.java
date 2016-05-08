package Model;

import javafx.scene.text.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class ScheduledTask extends TimerTask {

    Date now;
    SimpleDateFormat format1;
    Text text;

    public ScheduledTask(){

    }
    @Override
    public void run() {
        now = new Date();
        format1 = new SimpleDateFormat("hh:mm:ss");

    }
}
