package src;

import src.api.ApiBot;
import src.config.helpers.ConfigLoader;

/**
 * Main program.
 */
public class Main {

    public static void main(String[] args) {

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
