package View;

import Model.ManagerTask;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class TaskPane extends Pane {


    public static Text needWordName;
    public static Text needWordTransfer;

    TaskPane(){
        setPrefSize(400,500);

        needWordName = new Text();
        needWordTransfer = new Text();
        Text result = new Text();
        TextField inputAnswer = new TextField();

        needWordName.setTranslateX(175);
        needWordName.setTranslateY(50);
        needWordName.setTextAlignment(TextAlignment.CENTER);
        result.setTranslateX(175);
        result.setTranslateY(60);
        result.setTextAlignment(TextAlignment.CENTER);
        inputAnswer.setTranslateX(125);
        inputAnswer.setTranslateY(70);

        needWordName.setVisible(false);
        inputAnswer.setVisible(false);
        result.setVisible(false);

        Button startTask = new Button("Начать");
        startTask.setTranslateX(175);
        startTask.setTranslateY(200);

        startTask.setOnMouseClicked(event1 -> {
            needWordName.setVisible(true);
            inputAnswer.setVisible(true);
            result.setVisible(true);

            startTask.setVisible(false);

            MainWindow.setOnPane(true);
            ManagerTask.extraditionSetWord();
        });

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



        getChildren().addAll(needWordName,inputAnswer,result,startTask);
    }




}
