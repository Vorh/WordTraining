package View;

import Model.ManagerXML;
import Model.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;

import java.util.List;

public class StatisticsTable extends Pane {

    private static ObservableList records;
    private static TableColumn name;
    private static TableColumn transferColumn;
    private static TableColumn priorityColumn;
    private static TableColumn categoryColumn;
    private static TableColumn transcriptionColumn;
    private static TableView tableStatistics;


    StatisticsTable(){
        this.setPrefSize(400, 450);

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

        deleteWord.setOnMouseClicked(event -> {
            int s =  tableStatistics.getSelectionModel().getSelectedIndex();
            tableStatistics.getItems().remove(s);
            ManagerXML.marshalSave(records);
        });

        tableStatistics.getColumns().addAll(name, transferColumn, priorityColumn, categoryColumn, transcriptionColumn);
        this.getChildren().addAll(tableStatistics,deleteWord);
    }

    public static void addWordInTable(List<Word> list) {
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

}

