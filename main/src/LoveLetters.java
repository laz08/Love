package src;

import src.api.ApiBot;
import src.config.helpers.ConfigLoader;

/**
 * Loveletters main program.
 */
public class LoveLetters {

    public static void main(String[] args) {

        initialize();
        loadConfiguration();

    }


    private static void initialize() {

    }

    /**
     * Loads game configuration.
     */
    private static void loadConfiguration() {

        ConfigLoader loader = new ConfigLoader();

        try {

            loader.readConfig();

            ApiBot bot = new ApiBot();
            bot.startBot();

        } catch (Exception e) {

            System.err.print("Error while starting bot: " + e.getMessage());
        }
    }
}
