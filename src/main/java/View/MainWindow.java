package View;

import Model.ManagerXML;
import Model.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

public class MainWindow {

    private TextField wordInput;
    private TextField transferInput;
    private TextField transcription;
    private TextField category;
    private TextField priority;


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
        Pane paneSt = getPaneStatistics();
        statistics.setContent(paneSt);

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

    private Pane getPaneStatistics() {
        Pane paneSt = new Pane();
        paneSt.setPrefSize(400,500);

        TableView tableStatistics = new TableView();
        tableStatistics.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableStatistics.setPrefSize(395,500);
        tableStatistics.setTableMenuButtonVisible(true);
        TableColumn nameColumn = new TableColumn("Название");
        TableColumn transferColumn = new TableColumn("Перевод");
        TableColumn transcriptionColumn = new TableColumn("Транскрипция");
        TableColumn priorityColumn = new TableColumn("Приоритет");
        TableColumn categoryColumn = new TableColumn("Категория");

        ObservableList records = FXCollections.observableArrayList();
        List<Word> list = ManagerXML.unmarshaller().getList();

        for(Word record : list){
            records.addAll(record);
            nameColumn.setCellValueFactory(new PropertyValueFactory<Word, String>("name"));
            transferColumn.setCellValueFactory(new PropertyValueFactory<Word, String>("transfer"));
            priorityColumn.setCellValueFactory(new PropertyValueFactory<Word, String>("priority"));
            categoryColumn.setCellValueFactory(new PropertyValueFactory<Word, String>("category"));
            transcriptionColumn.setCellValueFactory(new PropertyValueFactory<Word, String>("transcription"));
            tableStatistics.setItems(records);
        }

        tableStatistics.getColumns().addAll(nameColumn,transferColumn,priorityColumn,categoryColumn,transcriptionColumn);
        paneSt.getChildren().addAll(tableStatistics);
        return paneSt;
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

        Text text2 = new Text("Выберите категорию");
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
            }
        });


        return paneWord;
    }




}
