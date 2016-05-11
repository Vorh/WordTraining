package View;

import Model.ScheduledTask;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Timer;

public class SettingPane extends Pane {

    private final TextField hours;
    private final TextField minutes;
    private final TextField seconds;

    SettingPane(){
        setPrefSize(400,500);
        VBox vBox = new VBox();
        vBox.setTranslateX(10);
        vBox.setTranslateY(10);
        vBox.setSpacing(10);

        final Text text1 = new Text("Часы");
        hours = new TextField("0");


        Text text2 = new Text("Минуты");
        minutes = new TextField("0");

        Text text3 = new Text("Секунды");
        seconds = new TextField("0");


        Button start = new Button("Начать");

        start.setOnMouseClicked( event -> {

        int hour = Integer.parseInt(hours.getText());
        int minute = Integer.parseInt(minutes.getText());
        int second = Integer.parseInt(seconds.getText());

        long timeTask = hour * 3600 + minute * 60 + second;
        timeTask = timeTask * 1000;
        Timer timer = new Timer();
        ScheduledTask scheduledTask = new ScheduledTask();
        timer.schedule(scheduledTask,timeTask);

        });


        vBox.getChildren().addAll(text1, hours,text2, minutes,text3, seconds,start);

        getChildren().addAll(vBox);
    }
}
