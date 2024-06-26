package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Launcher extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("/view/login_form.fxml"));
       Scene scene = new Scene(fxmlLoader.load());
       stage.setTitle("Login Form");
       stage.setScene(scene);
       stage.setResizable(false);
       stage.show();

    }
}