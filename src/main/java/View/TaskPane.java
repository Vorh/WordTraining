package View;

import Model.ScheduledTask;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Timer;

public class TaskPane extends Pane {
    public static Text timerText;
    public static Button startTimer;
    private static Timer timer;

    TaskPane(){
        setPrefSize(400,500);
        TaskPaneWord taskPaneWord = new TaskPaneWord();




        startTimer = new Button("Пуск");
        startTimer.setTranslateX(175);
        startTimer.setTranslateY(350);


        startTimer.setOnMouseClicked(event -> {
            startTimer.setDisable(true);
            timer = new Timer();
            ScheduledTask scheduledTask = new ScheduledTask();
            timer.schedule(scheduledTask, 0);
            TaskPaneWord.clearField();
        });



        timerText = new Text("0 : 0 : 0");
        timerText.setFont(Font.font(50));
        timerText.setTranslateX(120);
        timerText.setTranslateY(90);

        getChildren().addAll(taskPaneWord, timerText, startTimer);
    }




}
