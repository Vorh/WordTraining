package View;

import Model.ScheduledTask;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.Timer;

public class SettingPane extends Pane {

    SettingPane(){
        setPrefSize(400,500);
        VBox vBox = new VBox();
        vBox.setSpacing(10);

        Button start = new Button("Начать");

        start.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Timer timer = new Timer();
                ScheduledTask scheduledTask = new ScheduledTask();
                timer.schedule(scheduledTask,0,1000);
            }
        });

        vBox.getChildren().addAll(start);

        getChildren().addAll(vBox);
    }
}
