package main.java.UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class taskButtonController implements Initializable{
    @FXML
    Button mainButton;
    @FXML
    Text taskName, startDate, endDate, desc;
    @FXML
    VBox backGround;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taskButton test = new taskButton();
        buttonListener();
        //changeBackgroundOnHoverUsingEvents(backGround);
    }

    private void buttonListener(){
        mainButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    showTaskInfo();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //Adding New Task Button Function, New static field Stage Required
    private Stage addStage = new Stage();
    //stage's initial state cannot be initialized twice, this is state check
    private int isStageFirst =0;
    @FXML
    private void showTaskInfo() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TaskInfo.fxml"));
        Parent rootAdd = (Parent)fxmlLoader.load();
        Scene sceneAdd = new Scene(rootAdd);
        ((TaskInfoController) fxmlLoader.getController()).setStage(addStage);
        addStage.setScene(sceneAdd);
        if(isStageFirst==0) {//state check
            addStage.initStyle(StageStyle.UNDECORATED);
            addStage.initModality(Modality.APPLICATION_MODAL);
            isStageFirst++;
        }//if end
        addStage.showAndWait();//disable Main stage, Only One Popup available. because of static field stage
    }

    public void changeBackgroundOnHoverUsingEvents(final Node node) {//Can't use .css on side buttons. So... meh another method of css :hover
        node.setStyle("-fx-background-color: #ffffff");
        node.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                node.setStyle("-fx-background-color: #a4a4a4");
            }
        });
        node.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                node.setStyle("-fx-background-color: #ffffff");
            }
        });
    }

}
