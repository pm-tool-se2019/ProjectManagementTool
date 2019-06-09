package main.java.UI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.io.IOException;

public class taskButton extends VBox {
    private Node view;
    private taskButtonController controller;

    public taskButton() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("taskButton.fxml"));
        fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
            @Override
            public Object call(Class<?> param) {
                return controller = new taskButtonController();
            }
        });
        try {
            view = (Node) fxmlLoader.load();

        } catch (IOException ex) {
        }
        getChildren().add(view);
    }
}
