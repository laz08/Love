package src;

import src.config.ConfigLoader;

/**
 * IRC bot.
 */
public class Bot {

    public static void main(String[] args) {


        ConfigLoader loader = new ConfigLoader();

        try {

            loader.readConfig();
        } catch (Exception e) {

            System.err.print(e);
        }
    }
}
