package src.api;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;

/**
 * LoveLetters bot.
 */
public class LoveLettersBot extends PircBotX {

    private Configuration<PircBotX> mConfiguration;

    /**
     * Constructor.
     *
     * @param configuration Configuration.
     */
    public LoveLettersBot(Configuration<PircBotX> configuration) {

        super(configuration);
        mConfiguration = configuration;
    }


    /**
     * Sends message.
     *
     * @param message Message.
     * @param channel Channel target.
     */
    public void sendMessageToChannel(String message, String channel) {

        sendRawLineToServer("PRIVMSG " + channel + " :" + message);
    }
}
