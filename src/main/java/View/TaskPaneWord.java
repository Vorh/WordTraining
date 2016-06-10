package View;

import Model.ManagerTask;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TaskPaneWord extends Pane {
    public static Text needWordName;
    public static Text needWordTransfer;
    public static Text wordCount;
    public static Text result;

    TaskPaneWord(){

        VBox vBox = new VBox();

        vBox.setTranslateX(46);
        vBox.setTranslateY(135);

        needWordTransfer = new Text("Перевод:");
        needWordTransfer.setFont(Font.font("AGBengaly",15));

        wordCount = new Text("Количество слов:");
        wordCount.setFont(Font.font("AGBengaly", 15));

        needWordName = new Text("Нужное слово:");
        needWordName.setFont(Font.font("AGBengaly",15));

        result = new Text("Результат:");
        result.setFont(Font.font("AGBengaly",15));

        vBox.setSpacing(15);
        vBox.getChildren().addAll(needWordName,wordCount,needWordTransfer,result);

        TextField inputAnswer = new TextField();
        inputAnswer.setFont(Font.font("AGBengaly",15));
        inputAnswer.setTranslateX(101);
        inputAnswer.setTranslateY(280);
        inputAnswer.getStyleClass().add("inputField");


        inputAnswer.setOnKeyReleased(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                String a = inputAnswer.getText().toLowerCase();
                String b = needWordTransfer.getText().toLowerCase();
                if(a.equals(b)){
                    result.setText("Результат: Правильно");
                    ManagerTask.result(true);
                }else {
                    result.setText("Результат: Не правильно");
                    ManagerTask.result(false);
                }
                wordCount.setText("Количество слов: " + ManagerTask.countWord);
                ManagerTask.installationWord();
                inputAnswer.setText("");
            }
        });

        getChildren().addAll(vBox,inputAnswer);
    }

    public static void clearField(){
        needWordName.setText("Нужное слово:");
        needWordTransfer.setText("Перевод:");
        wordCount.setText("Количество слов:");
        result.setText("Результат:");
    }



}
