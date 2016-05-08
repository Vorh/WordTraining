package View;

import Model.ManagerXML;
import Model.Word;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class AddTableWord extends Pane {

    private TextField wordInput;
    private TextField transferInput;
    private TextField transcription;
    private TextField category;
    private TextField priority;

    AddTableWord(){
        setPrefSize(400, 500);

        VBox vBoxAddWord = new VBox();
        vBoxAddWord.setSpacing(10);
        vBoxAddWord.setTranslateX(15);
        vBoxAddWord.setTranslateY(15);
        Text text1 = new Text("Введите слово");
        wordInput = new TextField();

        Text text4 = new Text("Введите перевод");
        transferInput = new TextField();

        Text text5 = new Text("Введите транскрипцию");
        transcription = new TextField();

        Text text2 = new Text("Введите категорию");
        category = new TextField();


        Text text3 = new Text("Установить приоритет");
        priority = new TextField();


        Button butAddWord = new Button("Добавить");
        butAddWord.setTranslateX(35);

        vBoxAddWord.getChildren().addAll(text1,wordInput,text4,transferInput,
                text5,transcription, text2,category, text3, priority, butAddWord);



        getChildren().addAll(vBoxAddWord);

        butAddWord.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Word word = Word.createWord(
                        wordInput.getText(),
                        priority.getText(),
                        transferInput.getText(),
                        transcription.getText(),
                        category.getText()
                );
                ManagerXML.marshal(word);

                wordInput.setText("");
                priority.setText("");
                transferInput.setText("");
                transcription.setText("");
                category.setText("");

                StatisticsTable.addWordInTable(ManagerXML.unmarshaller().getList());
            }
        });
    }
}
