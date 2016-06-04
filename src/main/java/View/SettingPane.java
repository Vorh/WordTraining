package View;

import Model.ScheduledTask;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.Timer;

public class SettingPane extends Pane {

    private  TextField hours;
    private  TextField minutes;
    private  TextField seconds;
    private  TextField countWord;
    private  TextField priority;

    SettingPane(){
        setPrefSize(400,500);

        final Text text1 = new Text("Часы");
        text1.setTranslateX(10);
        text1.setTranslateY(30);

        hours = new TextField();
        hours.setTranslateX(10);
        hours.setTranslateY(40);
        hours.setPrefWidth(35);

        Text text2 = new Text("Минуты");
        text2.setTranslateX(50);
        text2.setTranslateY(30);
        minutes = new TextField();
        minutes.setTranslateX(55);
        minutes.setTranslateY(40);
        minutes.setPrefWidth(35);

        Text text3 = new Text("Секунды");
        text3.setTranslateX(100);
        text3.setTranslateY(30);
        seconds = new TextField();
        seconds.setTranslateX(105);
        seconds.setTranslateY(40);
        seconds.setPrefWidth(35);

        Text text4 = new Text("Количество слов");
        text4.setTranslateX(170);
        text4.setTranslateY(30);
        countWord = new TextField();
        countWord.setTranslateX(270);
        countWord.setTranslateY(15);
        countWord.setPrefWidth(35);


        Text text5 = new Text("Приоритет");
        text5.setTranslateX(170);
        text5.setTranslateY(60);
        priority = new TextField();
        priority.setTranslateX(270);
        priority.setTranslateY(45);
        priority.setPrefWidth(35);


        Button start = new Button("Сохранить");
        start.setTranslateX(170);
        start.setTranslateY(400);

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

        getChildren().addAll(text1,hours,text2,minutes,text3,seconds,start,
                text4,countWord,text5,priority);
    }
}
