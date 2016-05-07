package View;

import Model.ManagerXML;
import Model.Word;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {

        ManagerXML.isWordFile();
        primaryStage.setWidth(400);
        primaryStage.setHeight(500);
        primaryStage.setResizable(false);
        primaryStage.setTitle("WordTraining");

        TabPane tabPane = getTabPane();

        Scene scene = new Scene(tabPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private TabPane getTabPane() {


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
        tableStatistics.setPrefSize(400,500);
        TableColumn nameColumn = new TableColumn("Название");
        TableColumn transferColumn = new TableColumn("Перевод");
        TableColumn priorityColumn = new TableColumn("Приоритет");
        TableColumn categoryColumn = new TableColumn("Категория");
        tableStatistics.getColumns().addAll(nameColumn,transferColumn,priorityColumn,categoryColumn);
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
        TextField wordInput = new TextField();

        Text text4 = new Text("Введите перевод");
        TextField transferInput = new TextField();

        Text text5 = new Text("Введите транскрипцию");
        TextField transcription = new TextField();

        Text text2 = new Text("Выберите категорию");
        ComboBox boxCategory = new ComboBox();


        Text text3 = new Text("Установить приоритет");
        TextField priority = new TextField();


        Button butAddWord = new Button("Добавить");
        butAddWord.setTranslateX(35);

        vBoxAddWord.getChildren().addAll(text1,wordInput,text4,transferInput,
               text5,transcription, text2,boxCategory, text3, priority, butAddWord);



        paneWord.getChildren().addAll(vBoxAddWord);

        butAddWord.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               Word word =  Word.createWord(
                       wordInput.getText(),
                        priority.getText(),
                        transferInput.getText(),
                        transcription.getText()
                );
                ManagerXML.marshal(word);

            }
        });


        return paneWord;
    }
}
