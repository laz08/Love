package src.api;

import org.pircbotx.*;
import src.config.Settings;

/**
 * IRC bot.
 */
public class ApiBot {

    private PircBotX mBot;
    private Configuration<PircBotX> mConfiguration;

    public ApiBot() {

        mConfiguration = new Configuration.Builder()
                .setName(Settings.getUsername())
                .setAutoNickChange(true)
                .setServerHostname(Settings.getHostname())
                .addAutoJoinChannel(Settings.getAutoJoinChannel())
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
