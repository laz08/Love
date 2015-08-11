package src.api;

import org.pircbotx.*;
import src.Game;
import src.config.Settings;

/**
 * IRC bot.
 */
public class ApiBot {

    private PircBotX mBot;
    private Configuration<PircBotX> mConfiguration;
    private Game mGame;

    public ApiBot() {

        mGame = new Game();

        mConfiguration = new Configuration.Builder()
                .setName(Settings.getUsername())
                .setAutoNickChange(true)
                .setServerHostname(Settings.getHostname())
                .addAutoJoinChannel(Settings.getAutoJoinChannel())
                .addListener(new BotListener(mGame))
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
