package main.java.UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.io.IOException;

public class taskButton extends VBox {
    public static String selected_task_name;
    private Node view;

    //
    //I think task Object can be declare for info
    //
    @FXML
    Button mainButton;
    @FXML
    Text taskName, startDate, endDate, desc;
    @FXML
    VBox backGround;

    public taskButton() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("taskButton.fxml"));
        fxmlLoader.setController(this);
        try {
            view = (Node) fxmlLoader.load();

        } catch (IOException ex) {
        }
        getChildren().add(view);
        changeBackgroundOnHoverUsingEvents(backGround);
        buttonListener();
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
    public void setText(String Name, String startDate, String endDate, String description){
        this.taskName.setText(Name);
        this.startDate.setText(startDate);
        this.endDate.setText(endDate);
        this.desc.setText(description);

        selected_task_name = Name;
    }

    public String getDesc(){
        return desc.getText();
    }
}
