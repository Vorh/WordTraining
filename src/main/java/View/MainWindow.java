package View;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainWindow {

    public TabPane getTabPane() {


        TabPane tabPane = new TabPane();
        tabPane.setTranslateY(0);

        TaskPane taskPane = new TaskPane();
        StatisticsTable statisticsTable = new StatisticsTable();
        AddWordPane AddWordPane = new AddWordPane();
        SettingPane settingPane = new SettingPane();

        Tab taskTab = new Tab("Задача");
        taskTab.setClosable(false);
        taskTab.setContent(taskPane);

        Tab statisticsTab = new Tab("Статистика");
        statisticsTab.setClosable(false);
        statisticsTab.setContent(statisticsTable);

        Tab addWordTab = new Tab("Добавление слова");
        addWordTab.setClosable(false);
        addWordTab.setContent(AddWordPane);

        Tab settingTab = new Tab("Настройка");
        settingTab.setClosable(false);
        settingTab.setContent(settingPane);

        tabPane.getTabs().addAll(taskTab, statisticsTab, addWordTab, settingTab);
        return tabPane;
    }





}
