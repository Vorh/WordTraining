package View;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class MainWindow {

    private TextField wordInput;
    private TextField transferInput;
    private TextField transcription;
    private TextField category;
    private TextField priority;

    private StatisticsTable statisticsTable;
    private AddTableWord addTableWord;

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
        addTableWord = new AddTableWord();
        addWord.setContent(addTableWord);

        Tab setting = new Tab("Настройка");
        setting.setClosable(false);
        Pane paneSetting = new Pane();
        paneSetting.setPrefSize(400,500);
        setting.setContent(paneSetting);

        tabPane.getTabs().addAll(task,statistics,addWord,setting);
        return tabPane;
    }




}
