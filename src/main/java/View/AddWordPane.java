package View;

import XML.ManagerXmlCategory;
import XML.Word;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AddWordPane extends Pane {

    AddWordPane(){
        setPrefSize(400, 500);

        Font textFont = new Font("AGBengaly",15);
        Font inputFont = new Font("AGBengaly",15);
        VBox vBoxAddWord = new VBox();
        vBoxAddWord.setSpacing(10);
        vBoxAddWord.setTranslateX(15);
        vBoxAddWord.setTranslateY(15);

        Text inputWord = new Text("Введите слово");
        inputWord.setFont(textFont);

        Text selectCategory = new Text("Введите категорию");
        selectCategory.setFont(textFont);

        Text setPriority = new Text("Установить приоритет");
        setPriority.setFont(textFont);

        Text inputTransfer = new Text("Введите перевод");
        inputTransfer.setFont(textFont);

        Text inputTranscription = new Text("Введите транскрипцию");
        inputTranscription.setFont(textFont);

        TextField wordInput = new TextField();
        wordInput.getStyleClass().addAll("inputField");
        wordInput.setFont(inputFont);

        TextField transferInput = new TextField();
        transferInput.getStyleClass().addAll("inputField");
        transferInput.setFont(inputFont);

        TextField transcription = new TextField();
        transcription.getStyleClass().addAll("inputField");
        transcription.setFont(inputFont);

        TextField category = new TextField();
        category.getStyleClass().addAll("inputField");
        category.setFont(inputFont);

        TextField priority = new TextField();
        priority.getStyleClass().addAll("inputField");
        priority.setFont(inputFont);

        Button butAddWord = new Button("Добавить");
        butAddWord.setFont(inputFont);
        butAddWord.setTranslateX(40);
        butAddWord.getStyleClass().addAll("buttonStart");

        vBoxAddWord.getChildren().addAll(inputWord,wordInput,inputTransfer,transferInput,
                inputTranscription,transcription, selectCategory,category, setPriority, priority, butAddWord);

        getStyleClass().add("paneBg");
        getChildren().addAll(vBoxAddWord);


        butAddWord.setOnMouseClicked(event -> {
            Word word = Word.createWord(
                    wordInput.getText(),
                    priority.getText(),
                    transferInput.getText(),
                    transcription.getText(),
                    category.getText()
            );

            ManagerXmlCategory.marshal(word);

            wordInput.setText("");
            priority.setText("");
            transferInput.setText("");
            transcription.setText("");
            category.setText("");

            StatisticsTable.addWordInTable(ManagerXmlCategory.unmarshaller().getList());
        });
    }
}
