package Chat.JMSHandler;

import org.apache.camel.Message;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.rx.ReactiveCamel;
import rx.Observable;


/**
 * @author F0urth
 */
public
    class JMSHandler {

    private DefaultCamelContext camelContext;
    private ReactiveCamel reactiveCamel;


    public Observable<Message> getObservableOf() {
        return reactiveCamel
            .toObservable("activemq:topic:JMSChat");
    }

    /**
     * Factory method
     * @return new Instance
     */
    public static JMSHandler newInstance() {
        return new JMSHandler();
    }

    private JMSHandler() {
        this.camelContext = new DefaultCamelContext();
        this.reactiveCamel = new ReactiveCamel(this.camelContext);
    }
}
