package Chat.JMSHandler;

import org.apache.camel.Message;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.rx.ReactiveCamel;
import rx.Observable;


/**
 * @author F0urth
 */
public class JMSHandler {

    private static final String TOPICURI = "activemq:topic:chat";

    private ReactiveCamel reactiveCamel;


    public Observable<Message> getObservableOfJMS() {
        return reactiveCamel.toObservable(TOPICURI);
    }

    public void sendTo(Observable<String> messages) {
        reactiveCamel.sendTo(messages, TOPICURI);
    }

    public static JMSHandler newInstance() {
        return new JMSHandler();
    }

    private JMSHandler() {
        this.reactiveCamel = new ReactiveCamel(
            new DefaultCamelContext());
    }
}
