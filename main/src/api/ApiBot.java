package src.api;

import org.pircbotx.*;
import src.Game;
import src.LoveLetters;
import src.config.Settings;

/**
 * IRC bot.
 */
public class ApiBot {

    private LoveLettersBot mBot;

    private Game mGame;
    private BotListener mListener;

    public ApiBot() {

        mGame = new Game();

        mListener= new BotListener(mGame);
        Configuration<PircBotX> configuration = new Configuration.Builder()
                .setName(Settings.getUsername())
                .setAutoNickChange(true)
                .setServerHostname(Settings.getHostname())
                .addAutoJoinChannel(Settings.getAutoJoinChannel())
                .addListener(mListener)
                .buildConfiguration();

        mBot = new LoveLettersBot(configuration);
        mListener.setBot(mBot);
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
