package src;

import src.deck.Card;

import java.util.ArrayList;

/**
 * Player.
 */
public class Player {

    public String mUsername;
    public int mVictories;
    public ArrayList<Card> mano;

    /**
     * Constructor.
     */
    public Player() {

        mano = new ArrayList<>();
        mVictories = 0;
    }

    /**
     * Constructor.
     *
     * @param username Username.
     */
    public Player(String username) {

        this();
        mUsername = username;
    }

    /**
     * Increments one unit the player victories.
     */
    public void incrementVictories() {

        mVictories++;
    }

    /**
     * Gets player username.
     *
     * @return
     */
    public String getUsername() {

        return mUsername;
    }

    /**
     * Sets player username.
     *
     * @param username Username.
     */
    public void setUsername(String username) {

        mUsername = username;
    }


    /*
     * Return the cards of the player
     */
    public ArrayList<Card> getMano() {

        return mano;
    }

    public void addCard(Card card) {

        mano.add(card);
    }

    public boolean removeCard(String card) {

        //TODO: dicotomic search if the number of cards grow
        int it = 0;
        boolean finded = false;
        while (it < mano.size() && !finded) {
            if(card.equals(mano.get(it))) {
                mano.remove(it);
                finded = true;
            }
        }
        return finded;
    }
}
