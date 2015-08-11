package src.api;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.FingerEvent;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.NoticeEvent;
import org.pircbotx.hooks.types.GenericMessageEvent;
import src.config.Settings;

/**
 * Bot listener.
 */
public class BotListener extends ListenerAdapter {

    /**
     * Constructor.
     */
    public BotListener(){

    }

    //TODO: Change messages so it gets them from LanguageHelper

    @Override
    public void onGenericMessage(GenericMessageEvent event) {

        //When someone says ?helloworld respond with "Hello World"
        if (event.getMessage().startsWith(".help"))
            event.respond("Me pides ayuda?");

        if(event.getMessage().contains(Settings.getUsername())){

            event.respond("Me hablas a mi?");
        }
    }

    @Override
    public void onJoin(JoinEvent event) throws Exception {

        super.onJoin(event);
        event.respond("Chupame esta, braulio.");
    }



}
