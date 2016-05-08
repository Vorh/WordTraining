package View;

import Model.ManagerXML;
import Model.Word;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainWindow {

    private TextField wordInput;
    private TextField transferInput;
    private TextField transcription;
    private TextField category;
    private TextField priority;

    private StatisticsTable statisticsTable;

    public TabPane getTabPane() {


        TabPane tabPane = new TabPane();
        tabPane.setTranslateY(0);

        Tab task = new Tab("Задача");
        task.setClosable(false);
        Pane paneTask = new Pane();
        paneTask.setPrefSize(400, 500);
        task.setContent(paneTask);

        Tab statistics = new Tab("Статистика");
        statistics.setClosable(false);
        statisticsTable = new StatisticsTable();
        statistics.setContent(statisticsTable);

        Tab addWord = new Tab("Добавление слова");
        addWord.setClosable(false);
        Pane paneWord = getPaneAddWord();
        addWord.setContent(paneWord);

        Tab setting = new Tab("Настройка");
        setting.setClosable(false);
        Pane paneSetting = new Pane();
        paneSetting.setPrefSize(400,500);
        setting.setContent(paneSetting);

        tabPane.getTabs().addAll(task,statistics,addWord,setting);
        return tabPane;
    }


    private Pane getPaneAddWord() {
        Pane paneWord = new Pane();
        paneWord.setPrefSize(400,500);

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



        paneWord.getChildren().addAll(vBoxAddWord);

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

                statisticsTable.addWordInTable(ManagerXML.unmarshaller().getList());
            }
        });


        return paneWord;
    }




}
