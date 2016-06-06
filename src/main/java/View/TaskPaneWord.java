package View;

import Model.ManagerTask;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class TaskPaneWord extends Pane {
    public static Text needWordName;
    public static Text needWordTransfer;
    public static Text wordCount;
    public static Text result;

    TaskPaneWord(){
        needWordTransfer = new Text("Перевод:");
        needWordTransfer.setTranslateX(125);
        needWordTransfer.setTranslateY(210);

        wordCount = new Text("Количество слов:");
        wordCount.setTranslateX(125);
        wordCount.setTranslateY(190);

        needWordName = new Text("Нужное слово:");
        needWordName.setTranslateX(125);
        needWordName.setTranslateY(150);
        needWordName.setTextAlignment(TextAlignment.CENTER);

        result = new Text("Результат:");
        result.setTranslateX(125);
        result.setTranslateY(170);
        result.setTextAlignment(TextAlignment.CENTER);

        TextField inputAnswer = new TextField();
        inputAnswer.setTranslateX(125);
        inputAnswer.setTranslateY(250);

        needWordTransfer.setVisible(false);

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

        getChildren().addAll(needWordName,needWordTransfer, result,inputAnswer,wordCount);
    }

    public static void clearField(){
        needWordName.setText("Нужное слово:");
        needWordTransfer.setText("Перевод:");
        wordCount.setText("Количество слов:");
        result.setText("Результат:");
    }



}
