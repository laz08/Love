package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Game.
 */
public class Game {

    private List<Player> mPlayers;

    /**
     * Constructor.
     */
    public Game() {

        mPlayers = new ArrayList<>();
    }

    /**
     * Adds player to game.
     *
     * @param player Player.
     */
    public void addPlayer(Player player) {

        mPlayers.add(player);
    }

    /**
     * Gets game players.
     *
     * @return Players.
     */
    public List<Player> getPlayers() {

        return mPlayers;
    }
}
