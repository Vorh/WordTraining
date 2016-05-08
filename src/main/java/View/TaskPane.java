package View;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class TaskPane extends Pane {

    TaskPane(){
        setPrefSize(400,500);

        Text needWord = new Text();

        TextField inputAnswer = new TextField();

        inputAnswer.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    System.out.println("Проверка");
                }
            }
        });

        VBox vBox = new VBox();
        vBox.setSpacing(10);

        vBox.getChildren().addAll(needWord,inputAnswer);

        getChildren().addAll(vBox);
    }
}
