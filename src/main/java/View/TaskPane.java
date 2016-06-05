package View;

import Model.ScheduledTask;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Timer;

public class TaskPane extends Pane {
    public static Text timer;
    public static Button startTimer;

    TaskPane(){
        setPrefSize(400,500);
        TaskPaneWord taskPaneWord = new TaskPaneWord();


        Button startTask = new Button("Дайте мне слова!");
        startTask.setTranslateX(145);
        startTask.setTranslateY(320);


        startTimer = new Button("Пуск");
        startTimer.setTranslateX(175);
        startTimer.setTranslateY(350);

        startTask.setOnMouseClicked(event1 -> {

            MainWindow.setOnPane(true);
        });

        startTimer.setOnMouseClicked(event -> {
            startTimer.setDisable(true);
            Timer timer = new Timer();
            ScheduledTask scheduledTask = new ScheduledTask();
            timer.schedule(scheduledTask,0);
        });



        timer = new Text("00 : 00 : 00");
        timer.setFont(Font.font(50));
        timer.setTranslateX(80);
        timer.setTranslateY(90);

        getChildren().addAll(taskPaneWord, startTask, timer, startTimer);
    }




}
