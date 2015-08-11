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
     * Sets player username.
     *
     * @param username
     */
    public void setUsername(String username) {

        mUsername = username;
    }

}
