package main.java.UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {


    @FXML
    VBox personalRecentTask, prjRecentTask;
    @FXML
    ScrollPane timeline;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    //Adding New Task Button Function, New static field Stage Required
    private Stage addStage = new Stage();
    //stage's initial state cannot be initialized twice, this is state check
    private int isStageFirst =0;
    @FXML
private void testButtonClicked() throws IOException {
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
}
