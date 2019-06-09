package main.java.UI;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import main.java.TaskLists.TaskListFuncs;

import java.awt.*;
import java.util.ResourceBundle;

public class TaskListController{
    @FXML
    private AnchorPane baseAnchorPane;
    @FXML
    private Button back;
    
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TaskList.fxml"));





}
