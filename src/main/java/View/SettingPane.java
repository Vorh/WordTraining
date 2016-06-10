package View;

import XML.ManagerXmlSettings;
import XML.Settings;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;

public class SettingPane extends Pane {

    public static File sound;

    SettingPane(){
        setPrefSize(400,500);
        getStyleClass().add("paneBg");

        Font textFont = new Font("AGBengaly",15);
        Font inputFont = new Font("AGBengaly",13);

        VBox vBoxText = new VBox(15);
        vBoxText.setTranslateX(20);
        vBoxText.setTranslateY(50);

        Text textHours = new Text("Часы");
        textHours.setFont(textFont);

        Text textMinutes = new Text("Минуты");
        textMinutes.setFont(textFont);

        Text textSeconds = new Text("Секунды");
        textSeconds.setFont(textFont);

        Text textCountWords = new Text("Количество слов");
        textCountWords.setFont(textFont);

        Text textPriority = new Text("Приоритет");
        textPriority.setFont(textFont);

        VBox vBoxInput = new VBox(5);
        vBoxInput.setTranslateX(170);
        vBoxInput.setTranslateY(45);

        TextField hours = new TextField();
        hours.setPrefWidth(40);
        hours.setFont(inputFont);
        hours.getStyleClass().add("inputField");

        TextField minutes = new TextField();
        minutes.setPrefWidth(40);
        minutes.setFont(inputFont);
        minutes.getStyleClass().add("inputField");

        TextField seconds = new TextField();
        seconds.setPrefWidth(40);
        seconds.setFont(inputFont);
        seconds.getStyleClass().addAll("inputField");

        TextField countWord = new TextField();
        countWord.setPrefWidth(40);
        countWord.setFont(inputFont);
        countWord.getStyleClass().addAll("inputField");

        TextField priority = new TextField();
        priority.setPrefWidth(40);
        priority.setFont(inputFont);
        priority.getStyleClass().addAll("inputField");


        Button butSaveSettings = new Button("Сохранить");
        butSaveSettings.getStyleClass().addAll("buttonStart");
        butSaveSettings.setTranslateX(150);
        butSaveSettings.setTranslateY(400);
        butSaveSettings.setFont(textFont);

        Button openChooser = new Button("Выбрать звук");
        openChooser.setFont(textFont);
        openChooser.getStyleClass().addAll("buttonStart");

        Text textNameSound = new Text("Название:");
        textNameSound.setFont(Font.font(16));
        textNameSound.setFont(textFont);

        Settings settings = ManagerXmlSettings.unmarshaller();

        if(settings.getSoundFile()!=null) {
            textNameSound.setText("Название: " + settings.getSoundFile().getName());
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
            textNameSound.setText("Название: " + sound.getName());
        });

        butSaveSettings.setOnMouseClicked(event -> {
            settings.setHours(Integer.parseInt(hours.getText()));
            settings.setMinutes(Integer.parseInt(minutes.getText()));
            settings.setSecond(Integer.parseInt(seconds.getText()));
            settings.setCountWord(Integer.parseInt(countWord.getText()));
            settings.setMinPriority(Integer.parseInt(priority.getText()));
            ManagerXmlSettings.marshal(settings);
        });

        vBoxInput.getChildren().addAll(hours,minutes,seconds,countWord,priority);
        vBoxText.getChildren().addAll(textHours,textMinutes,textSeconds, textCountWords,
                                    textPriority,openChooser,textNameSound);
        getChildren().addAll( vBoxText, butSaveSettings, vBoxInput);
    }

}
