package View;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class MainWindow {

    private TextField wordInput;
    private TextField transferInput;
    private TextField transcription;
    private TextField category;
    private TextField priority;

    private StatisticsTable statisticsTable;
    private AddTableWord addTableWord;
    private TaskPane taskPane;
    private SettingPane settingPane;

    public TabPane getTabPane() {


        TabPane tabPane = new TabPane();
        tabPane.setTranslateY(0);

        Tab task = new Tab("Задача");
        task.setClosable(false);
        taskPane = new TaskPane();
        task.setContent(taskPane);

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
        settingPane = new SettingPane();
        setting.setContent(settingPane);

        tabPane.getTabs().addAll(task,statistics,addWord,setting);
        return tabPane;
    }




}
