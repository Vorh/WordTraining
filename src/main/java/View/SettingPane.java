package View;

import XML.ManagerXmlSettings;
import XML.Settings;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;

public class SettingPane extends Pane {

    private  TextField hours;
    private  TextField minutes;
    private  TextField seconds;
    private  TextField countWord;
    private  TextField priority;
    public static File sound;

    SettingPane(){
        setPrefSize(400,500);

        Text text1 = new Text("Часы");
        text1.setTranslateX(10);
        text1.setTranslateY(30);

        hours = new TextField();
        hours.setTranslateX(10);
        hours.setTranslateY(40);
        hours.setPrefWidth(35);

        Text text2 = new Text("Минуты");
        text2.setTranslateX(50);
        text2.setTranslateY(30);
        minutes = new TextField();
        minutes.setTranslateX(55);
        minutes.setTranslateY(40);
        minutes.setPrefWidth(35);

        Text text3 = new Text("Секунды");
        text3.setTranslateX(100);
        text3.setTranslateY(30);
        seconds = new TextField();
        seconds.setTranslateX(105);
        seconds.setTranslateY(40);
        seconds.setPrefWidth(35);

        Text text4 = new Text("Количество слов");
        text4.setTranslateX(170);
        text4.setTranslateY(30);
        countWord = new TextField();
        countWord.setTranslateX(270);
        countWord.setTranslateY(15);
        countWord.setPrefWidth(35);


        Text text5 = new Text("Приоритет");
        text5.setTranslateX(170);
        text5.setTranslateY(60);
        priority = new TextField();
        priority.setTranslateX(270);
        priority.setTranslateY(45);
        priority.setPrefWidth(35);


        Button start = new Button("Сохранить");
        start.setTranslateX(170);
        start.setTranslateY(400);

        Button openChooser = new Button("Выбрать звук");
        openChooser.setTranslateX(10);
        openChooser.setTranslateY(75);

        Text tNameSound = new Text("Название:");
        tNameSound.setFont(Font.font(16));
        tNameSound.setTranslateX(105);
        tNameSound.setTranslateY(90);

        Settings settings = ManagerXmlSettings.unmarshaller();

        if(settings.getSoundFile()!=null) {
            tNameSound.setText("Название: " + settings.getSoundFile().getName());
        }
        hours.setText(String.valueOf(settings.getHours()));
        minutes.setText(String.valueOf(settings.getMinutes()));
        seconds.setText(String.valueOf(settings.getSecond()));
        countWord.setText(String.valueOf(settings.getCountWord()));
        priority.setText(String.valueOf(settings.getMinPriority()));
        sound = settings.getSoundFile();

        openChooser.setOnMouseClicked(event1 -> {
            sound = Chooser.openExplorer();
            settings.setSoundFile(sound);
            tNameSound.setText("Название: " + sound.getName());
        });



        start.setOnMouseClicked( event -> {

        settings.setHours(Integer.parseInt(hours.getText()));
        settings.setMinutes(Integer.parseInt(minutes.getText()));
        settings.setSecond(Integer.parseInt(seconds.getText()));
        settings.setCountWord(Integer.parseInt(countWord.getText()));
        settings.setMinPriority(Integer.parseInt(priority.getText()));
        ManagerXmlSettings.marshal(settings);
        });

        getChildren().addAll(text1, hours, text2, minutes, text3, seconds, start,
                text4, countWord, text5, priority, openChooser,tNameSound);
    }

}
