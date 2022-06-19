import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
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
    private TitledPane working_titledPane;
    private TitledPane done_titledPane;


    public void initialize(){       
        working_titledPane = new TitledPane();
        VBox working_VBox = new VBox();
        working_VBox.setSpacing(10);
        Label todo_title;
        HBox working_HBox = new HBox();
        Button Edit = new Button("Edit");
        Button Delete;
        Button Done;
        Edit.setId("button-style");

        working_HBox.getChildren().addAll(Edit);

        working_VBox.getChildren().add(todo_title = new Label());
        working_VBox.getChildren().add(working_HBox);
        todo_title.setStyle("-fx-text-align:center;-fx-font-size:14px");

    }
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
    void Task_button_pressed(ActionEvent event){
        
    }

}
