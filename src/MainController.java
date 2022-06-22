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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class MainController {
    // instance variables
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
    public static JSONArray jArray = new JSONArray();

    // default method which get run on software startup
    public void initialize(){
        // Todo Data Reading process
        File todoFile = new File("todo.json");
        if(todoFile.exists()){
            // json parser
            JSONParser parser = new JSONParser();
            try{
                Object obj = parser.parse(new FileReader("todo.json"));
                
                JSONArray array = (JSONArray) obj;
                jArray = array;
            }catch(Exception e){
                e.printStackTrace();
            }
            
            // Making TitledPane for displaying all todo's
            for (int a=0;a<jArray.size();a++){
                JSONObject jsonObject = (JSONObject) jArray.get(a);
                if((boolean) jsonObject.get("In").equals("working")){
                    TitledPane titledPane = new TitledPane();
                    VBox working_VBox = new VBox();
                    working_VBox.setSpacing(10);
                    Label todo_desc = new Label((String) jsonObject.get("Description"));
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

                    titledPane.setText((String) jsonObject.get("Title"));
                    titledPane.setContent(working_VBox);
                    working_accordion.getPanes().add(titledPane);

                    Edit.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event){
                            // do something
                        }
                    });
                    Done.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event){
                            // DATA
                            jsonObject.put("In", "done");
                            try{
                                FileWriter writer = new FileWriter("todo.json");
                                writer.write(jArray.toJSONString());
                    
                                writer.flush();
                                writer.close();
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                            // GUI
                            working_accordion.getPanes().remove(titledPane);
                            working_VBox.getChildren().remove(working_HBox);
            
                            done_accordion.getPanes().add(titledPane);
                        }
                    });
                    Remove.setOnAction(new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event){
                            // DATA
                            jArray.remove(jsonObject);
                            try{
                                FileWriter writer = new FileWriter("todo.json");
                                writer.write(jArray.toJSONString());
                    
                                writer.flush();
                                writer.close();
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                            // GUI
                            working_accordion.getPanes().remove(titledPane);
                        }
                    }); 
                }else if((Boolean) jsonObject.get("In").equals("done")){
                    TitledPane titledPane = new TitledPane();
                    VBox working_VBox = new VBox();
                    working_VBox.setSpacing(10);
                    Label todo_desc = new Label((String) jsonObject.get("Description"));
                    todo_desc.setId("labels");

                    working_VBox.getChildren().add(todo_desc);

                    titledPane.setText((String) jsonObject.get("Title"));
                    titledPane.setContent(working_VBox);

                    done_accordion.getPanes().add(titledPane);
                }
                
            }

        }
    }
    @FXML
    void Platform_exit(ActionEvent event) {
        Platform.exit();
    }
    @FXML
    void Platform_minimize(ActionEvent event){
        Stage stage = (Stage) minimize_button.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void Task_button_pressed(ActionEvent event) throws IOException{
        // Data writing process
        JSONObject todo = new JSONObject();
        todo.put("Title", task_title_text.getText());
        todo.put("Description", task_description_text.getText());
        todo.put("In", "working");

        jArray.add(todo);

        try{
            FileWriter writer = new FileWriter("todo.json");
            writer.write(jArray.toJSONString());

            writer.flush();
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }

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
                // DATA
                todo.put("In", "done");
                try{
                    FileWriter writer = new FileWriter("todo.json");
                    writer.write(jArray.toJSONString());
        
                    writer.flush();
                    writer.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
                // GUI
                working_accordion.getPanes().remove(titledPane);
                working_VBox.getChildren().remove(working_HBox);

                done_accordion.getPanes().add(titledPane);
            }
        });
        Remove.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                // DATA
                jArray.remove(todo);
                try{
                    FileWriter writer = new FileWriter("todo.json");
                    writer.write(jArray.toJSONString());
        
                    writer.flush();
                    writer.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
                // GUI
                working_accordion.getPanes().remove(titledPane);
            }
        });       
    }
}
