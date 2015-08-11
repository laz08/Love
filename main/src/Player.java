package src;

/**
 * Player.
 */
public class Player {

    public String mUsername;
    public int mVictories;

    /**
     * Constructor.
     */
    public Player() {

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
}
