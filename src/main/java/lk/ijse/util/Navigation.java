package lk.ijse.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {

    private static Parent rootNode;
    private static Scene scene;
    private static Stage stage;

    public static void switchNavigation(String path, ActionEvent event) throws IOException {
        rootNode = FXMLLoader.load(Navigation.class.getResource("/view/" + path));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();

    }

    public static void switchNavigation1(String path, ActionEvent event) throws IOException {
        rootNode = FXMLLoader.load(Navigation.class.getResource("/view/" + path));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();

    }

    public static void changeState(String fxml, String title)  {
        FXMLLoader fxmlLoader = new FXMLLoader(Navigation.class.getResource(fxml));
        Parent root1 = null;
        try {
           root1 = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();

    }

    public static void switchPaging(Pane pane, String path) throws IOException{
        pane.getChildren().clear();
        FXMLLoader fxmlLoader = new FXMLLoader(Navigation.class.getResource("/view/" + path));
        Parent root = fxmlLoader.load();
        pane.getChildren().add(root);
    }
}
