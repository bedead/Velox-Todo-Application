
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }
    private Scene scene;
    public void start(Stage stage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("FXML/MainWindow.fxml"));
        
        // Root scene 
        scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        
        // setting stylesheet for pane
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        
        // settings for window
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.getIcons().add(new Image("IMAGES/Velox Todo logo.png"));
        stage.centerOnScreen();
        stage.setTitle("Velox Todo");
        stage.show();
    }
}
