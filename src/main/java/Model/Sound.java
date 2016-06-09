package Model;

import View.SettingPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {


    public static void playSound(){
        Media media = new Media(SettingPane.sound.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

    }
}
