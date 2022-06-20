import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import JsonData.Todo;
import JsonData.gson;

public class MainController {
    @FXML
    private ImageView minimize_button;

    @FXML
    private TabPane tab_pane;
    @FXML
    private TextField task_title_text;
    @FXML
    private TextArea task_description_text;
    @FXML
    private Button task_button;
    @FXML
    private Accordion working_accordion;
    @FXML
    private Accordion done_accordion;

    @FXML
    void Platform_exit(MouseEvent event) {
        Platform.exit();
    }
    @FXML
    void Platform_file_exit(ActionEvent event) {
        Platform.exit();
    }
    @FXML
    void Platform_minimize(MouseEvent event){
        Stage stage = (Stage) minimize_button.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void Task_button_pressed(ActionEvent event) throws IOException{
        // Data writing process


        // Gui process
        TitledPane titledPane = new TitledPane();
        VBox working_VBox = new VBox();
        working_VBox.setSpacing(10);
        Label todo_desc = new Label(task_description_text.getText());
        todo_desc.setId("labels");

        HBox working_HBox = new HBox();
        Button Edit = new Button("Edit");
        Button Remove = new Button("Remove");
        Button Done = new Button("Done");
        Edit.setId("button-style");
        Remove.setId("button-style");
        Done.setId("button-style");

        working_HBox.getChildren().addAll(Edit,Remove,Done);
        working_HBox.setSpacing(20);

        working_VBox.getChildren().add(todo_desc);
        working_VBox.getChildren().add(working_HBox);

        titledPane.setText(task_title_text.getText());
        titledPane.setContent(working_VBox);
        working_accordion.getPanes().add(titledPane);

        Edit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                // do something
            }
        });
        Done.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                working_accordion.getPanes().remove(titledPane);
                working_VBox.getChildren().remove(working_HBox);

                done_accordion.getPanes().add(titledPane);
            }
        });
        Remove.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                working_accordion.getPanes().remove(titledPane);
            }
        });       
    }
}
