import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
