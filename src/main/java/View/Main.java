package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Main extends  Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            primaryStage.setWidth(400);
            primaryStage.setHeight(500);
            primaryStage.setResizable(false);
            primaryStage.setTitle("WordTraining");

            TabPane tabPane = new MainWindow().getTabPane();

            Scene scene = new Scene(tabPane);
            primaryStage.setScene(scene);
            primaryStage.show();

        }
}
