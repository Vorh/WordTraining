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
        startTimer.setFont(Font.font("AGBengaly", 18));
        startTimer.setTranslateX(152);
        startTimer.setTranslateY(355);
        startTimer.setPrefWidth(80);
        startTimer.getStyleClass().add("buttonStart");

        startTimer.setOnMouseClicked(event -> {
            startTimer.setDisable(true);
            timer = new Timer();
            ScheduledTask scheduledTask = new ScheduledTask();
            timer.schedule(scheduledTask, 0);
            TaskPaneWord.clearField();
        });


        Pane paneTimer = new Pane();
        paneTimer.setPrefSize(210, 40);
        paneTimer.getStyleClass().add("paneTimer");
        paneTimer.setTranslateX(99);
        paneTimer.setTranslateY(57);


        timerText = new Text("00 : 00 : 00");
        timerText.setFont(Font.font("AGBengaly", 30));
        timerText.setTranslateX(115);
        timerText.setTranslateY(86);

        getStyleClass().add("paneTask");

        getChildren().addAll(taskPaneWord, paneTimer,timerText, startTimer);
    }




}
