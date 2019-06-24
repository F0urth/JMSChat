package Chat.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.Random;

public
    class MainController {

    private final Integer probablyUniqueID = new Random().nextInt(1000) + 1;

    @FXML private TextArea messageArea;
    @FXML private TextArea chatArea;

    public void sendAction(ActionEvent event) {


    }
}
