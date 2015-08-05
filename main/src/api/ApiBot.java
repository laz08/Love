package src.api;

import org.pircbotx.*;

/**
 * IRC bot.
 */
public class ApiBot {

    private PircBotX mBot;
    private Configuration<PircBotX> mConfiguration;

    public ApiBot() {

        mConfiguration = new Configuration.Builder()
                .setName("BotDePruebas")
                .setAutoNickChange(true)
                .setServerHostname("")
                .addAutoJoinChannel("")
                .addListener(new BotListener())
                .buildConfiguration();

        mBot = new PircBotX(mConfiguration);
    }

    /**
     * Starts bot.
     */
    public void startBot() {

        try {

            mBot.startBot();
        } catch (Exception e) {

            System.err.println("Error while starting bot" + e);
        }
    }

}
