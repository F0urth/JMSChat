package Chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author F0urth
 */

public
    class MainApp
        extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/Views/MainFrame.fxml"));
        primaryStage.setTitle("Chat");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
