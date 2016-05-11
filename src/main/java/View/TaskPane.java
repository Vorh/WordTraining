package View;

import Model.ManagerTask;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class TaskPane extends Pane {


    public static Text needWordName;
    public static Text needWordTransfer;

    TaskPane(){
        setPrefSize(400,500);

        needWordName = new Text();

        Text result = new Text();


        TextField inputAnswer = new TextField();


        inputAnswer.setOnKeyReleased(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                String a = inputAnswer.getText().toLowerCase();
                String b = needWordTransfer.getText().toLowerCase();
                if(a.equals(b)){
                    result.setText("Правильно");
                    ManagerTask.result(true);
                }else {
                    result.setText("Не правильно");
                    ManagerTask.result(false);
                }
                ManagerTask.installationWord();
                inputAnswer.setText("");
            }
        });

        VBox vBox = new VBox();
        vBox.setSpacing(10);

        vBox.getChildren().addAll(needWordName,inputAnswer,result);

        getChildren().addAll(vBox);
    }


}
