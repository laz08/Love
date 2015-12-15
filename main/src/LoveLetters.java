package src;

import src.api.ApiBot;
import src.config.helpers.ConfigLoader;
import src.deck.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Loveletters main program.
 */
public class LoveLetters {

    private static ArrayList<Card> deck;
    private static Random randomGenerator;

    public static void main(String[] args) {

        initialize();
        loadConfiguration();

    }

    /**
    * Initialize the deck
    */
    private static void initialize() {

        randomGenerator = new Random();
        deck = new ArrayList<Card>();

        int numGuards = 5;
        int numSpecialCards = 2;

        for(int guards = 0; guards < numGuards; ++guards) 
            deck.add(new Guard());
        for(int priests = 0; priests < numSpecialCards; ++priests) 
            deck.add(new Priest());
        for(int barons = 0; barons < numSpecialCards; ++barons)
            deck.add(new Baron());
        for(int handmaids = 0; handmaids < numSpecialCards; ++handmaids)
            deck.add(new Maid());
        for(int princess = 0; princess < numSpecialCards; ++princess)
            deck.add(new Prince());
        deck.add(new King());
        deck.add(new Countess());
        deck.add(new Princess());
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

    /**
     * Draw a random card and remove it from the deck
     *
     * @return a random card from the deck
     */
    public Card draw() {
        int randIndex = (randomGenerator.nextInt())%deck.size();
        Card drawnCard = deck.get(randIndex);
        deck.remove(randIndex);

        return drawnCard;
    }
}
