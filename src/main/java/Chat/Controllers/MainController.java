package Chat.Controllers;

import Chat.JMSHandler.JMSHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import org.apache.camel.Message;
import rx.Observable;

import java.util.UUID;

/**
 * @author F0urth
 */
public class MainController {

    private final String probablyUniqueID = "< ID: " + UUID.randomUUID() + " > ";
    private JMSHandler jmsHandler;


    public MainController() {
        this.jmsHandler = JMSHandler.newInstance();
        this.jmsHandler.getObservableOfJMS()
            .map(Message::getBody)
            .subscribe(next -> this.chatArea.appendText(next + "\n"));
    }


    @FXML
    private TextArea messageArea;
    @FXML
    private TextArea chatArea;

    public void sendAction(ActionEvent event) {
        String potentialMessage = this.messageArea.getText();
        if (!(potentialMessage == null || potentialMessage.trim().isEmpty())) {
            this.jmsHandler.sendTo(Observable.just(probablyUniqueID + potentialMessage));
        }
        messageArea.setText("");
    }
}
