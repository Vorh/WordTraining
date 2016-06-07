package Model;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

public class Sound {
    static{
        JFXPanel fxPanel = new JFXPanel();
    }

    private ClassLoader classLoader;

    public void playSound(){
        classLoader = Sound.class.getClassLoader();
        URL file = classLoader.getResource("1.mp3");
        Media media  = new Media(file.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.seek(mediaPlayer.getStartTime());


    }

    public static void main(String[] args) {
        Sound sound = new Sound();
        sound.playSound();
    }
}
