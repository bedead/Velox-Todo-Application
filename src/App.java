import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }
    private Scene scene;
    public void start(Stage stage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("FXML/MainWindow.fxml"));
        

        scene = new Scene(root);
        String stylesheet = getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Velox Todo");
        stage.show();
    }
}
