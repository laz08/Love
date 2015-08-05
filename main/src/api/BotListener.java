package src.api;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

/**
 * Bot listener.
 */
public class BotListener extends ListenerAdapter {

    /**
     * Constructor.
     */
    public BotListener(){

    }

    @Override
    public void onGenericMessage(GenericMessageEvent event) {
        //When someone says ?helloworld respond with "Hello World"
        if (event.getMessage().startsWith(""))
            event.respond("Hola hola!");
    }
}
