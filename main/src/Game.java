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

    public void addPlayer(Player player) {

        mPlayers.add(player);
    }

}
