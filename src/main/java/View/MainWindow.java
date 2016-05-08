package View;

import Model.ManagerXML;
import Model.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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
    private ObservableList records;
    private TableColumn name;
    private TableColumn transferColumn;
    private TableColumn priorityColumn;
    private TableColumn categoryColumn;
    private TableColumn transcriptionColumn;
    private TableView tableStatistics;


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
        paneSt.setPrefSize(400,450);

        tableStatistics = new TableView();
        tableStatistics.setEditable(true);
        tableStatistics.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableStatistics.setPrefSize(395, 400);
        tableStatistics.setTableMenuButtonVisible(true);
        name = new TableColumn("Название");
        transferColumn = new TableColumn("Перевод");
        transcriptionColumn = new TableColumn("Транскрипция");
        priorityColumn = new TableColumn("Приоритет");
        categoryColumn = new TableColumn("Категория");

        records = FXCollections.observableArrayList();
        List<Word> list = ManagerXML.unmarshaller().getList();

        addWordInTable(list);


        name.setCellFactory(TextFieldTableCell.<Word>forTableColumn());
        name.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Word, String>>() {
            public void handle(TableColumn.CellEditEvent<Word, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue());
                ManagerXML.marshalSave(records);
            }
        });

        transferColumn.setCellFactory(TextFieldTableCell.<Word>forTableColumn());
        transferColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Word, String>>() {
            public void handle(TableColumn.CellEditEvent<Word, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setTransfer(event.getNewValue());
                ManagerXML.marshalSave(records);
            }
        });

        priorityColumn.setCellFactory(TextFieldTableCell.<Word>forTableColumn());
        priorityColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Word, String>>() {
            public void handle(TableColumn.CellEditEvent<Word, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setPriority(event.getNewValue());
                ManagerXML.marshalSave(records);
            }
        });

        categoryColumn.setCellFactory(TextFieldTableCell.<Word>forTableColumn());
        categoryColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Word, String>>() {
            public void handle(TableColumn.CellEditEvent<Word, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setCategory(event.getNewValue());
                ManagerXML.marshalSave(records);
            }
        });

        transcriptionColumn.setCellFactory(TextFieldTableCell.<Word>forTableColumn());
        transcriptionColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Word, String>>() {
            public void handle(TableColumn.CellEditEvent<Word, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setTranscription(event.getNewValue());
                ManagerXML.marshalSave(records);
            }
        });

        Button deleteWord = new Button("Удалить слово");
        deleteWord.setTranslateX(10);
        deleteWord.setTranslateY(410);

        deleteWord.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                int s =  tableStatistics.getSelectionModel().getSelectedIndex();
                tableStatistics.getItems().remove(s);
                ManagerXML.marshalSave(records);
            }
        });

        tableStatistics.getColumns().addAll(name, transferColumn, priorityColumn, categoryColumn, transcriptionColumn);
        paneSt.getChildren().addAll(tableStatistics,deleteWord);
        return paneSt;
    }

    private void addWordInTable(List<Word> list) {
        records.clear();
        for(Word record : list){
            records.addAll(record);
            name.setCellValueFactory(new PropertyValueFactory<Word, String>("name"));
            transferColumn.setCellValueFactory(new PropertyValueFactory<Word, String>("transfer"));
            priorityColumn.setCellValueFactory(new PropertyValueFactory<Word, String>("priority"));
            categoryColumn.setCellValueFactory(new PropertyValueFactory<Word, String>("category"));
            transcriptionColumn.setCellValueFactory(new PropertyValueFactory<Word, String>("transcription"));
            tableStatistics.setItems(records);
        }
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

                addWordInTable(ManagerXML.unmarshaller().getList());
            }
        });


        return paneWord;
    }




}
