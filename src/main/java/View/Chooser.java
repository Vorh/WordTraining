package View;


import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Chooser {

    private static Stage stage;

    public static File openExplorer(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выбрать mp3 файл");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.mp3"));
        File sound = fileChooser.showOpenDialog(stage);
        if(sound != null){
            return sound;
        }
        return null;
    }

    public static void setStage(Stage stage) {
        Chooser.stage = stage;
    }

    public static Stage getStage() {
        return stage;
    }


}

