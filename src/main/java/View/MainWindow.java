package View;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainWindow {


    private static StatisticsTable statisticsTable;
    private static AddTableWord addTableWord;
    private static TaskPane taskPane;
    private static SettingPane settingPane;

    private static Tab taskTab;
    private static Tab statisticsTab;
    private static Tab addWordTab;
    private static Tab settingTab;

    public TabPane getTabPane() {


        TabPane tabPane = new TabPane();
        tabPane.setTranslateY(0);

        taskTab = new Tab("Задача");
        taskTab.setClosable(false);
        taskPane = new TaskPane();
        taskTab.setContent(taskPane);

        statisticsTab = new Tab("Статистика");
        statisticsTab.setClosable(false);
        statisticsTable = new StatisticsTable();
        statisticsTab.setContent(statisticsTable);

        addWordTab = new Tab("Добавление слова");
        addWordTab.setClosable(false);
        addTableWord = new AddTableWord();
        addWordTab.setContent(addTableWord);

        settingTab = new Tab("Настройка");
        settingTab.setClosable(false);
        settingPane = new SettingPane();
        settingTab.setContent(settingPane);

        tabPane.getTabs().addAll(taskTab, statisticsTab, addWordTab, settingTab);
        return tabPane;
    }

    public static void setOnPane(boolean flag){
        addWordTab.setDisable(flag);
        settingTab.setDisable(flag);
        statisticsTab.setDisable(flag);
    }




}
