package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
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
        TableColumn priorityColumn = new TableColumn("Приоритет");
        TableColumn categoryColumn = new TableColumn("Категория");
        tableStatistics.getColumns().addAll(nameColumn,priorityColumn,categoryColumn);
        paneSt.getChildren().addAll(tableStatistics);
        return paneSt;
    }

    private Pane getPaneAddWord() {
        Pane paneWord = new Pane();
        paneWord.setPrefSize(400,500);

        Text text1 = new Text("Введите слово");
        text1.setTranslateX(15);
        text1.setTranslateY(20);

        TextField wordInput = new TextField();
        wordInput.setTranslateX(15);
        wordInput.setTranslateY(40);

        Text text2 = new Text("Выберите категорию");
        text2.setTranslateX(15);
        text2.setTranslateY(80);

        ComboBox boxCategory = new ComboBox();
        boxCategory.setTranslateX(15);
        boxCategory.setTranslateY(100);

        Text text3 = new Text("Установить приоритет");
        text3.setTranslateX(15);
        text3.setTranslateY(140);

        TextField priority = new TextField();
        priority.setTranslateX(15);
        priority.setTranslateY(160);

        Button but = new Button("Добавить");
        but.setTranslateX(150);
        but.setTranslateY(350);

        paneWord.getChildren().addAll(text1,text2,text3,
                                   but,wordInput,priority,boxCategory);
        return paneWord;
    }
}
