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
     * Removes a player given its nickname.
     *
     * @param nick Nickname.
     */
    public void removePlayer(String nick) throws Exception {

        boolean found = false;
        for (int i = 0; i < mPlayers.size() && !found; i++) {

            Player player = mPlayers.get(i);
            if (player.getUsername().equals(nick)) {

                found = true;
                mPlayers.remove(i);
            }
        }

        if (!found) {

            throw new Exception("No hay ningún jugador con nombre " + nick + " jugando en la partida.");
        }

    }

    /**
     * Removes a player.
     *
     * @param player Player.
     */
    public void removePlayer(Player player) throws Exception {


        boolean found = false;
        for (int i = 0; i < mPlayers.size() && !found; i++) {

            Player playerFromList = mPlayers.get(i);

            if (playerFromList.getUsername().equals(player.getUsername())) {

                found = true;
                mPlayers.remove(playerFromList);
            }
        }

        if (!found) {

            throw new Exception("There's no player with nickname: " + player.getUsername());
        }
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
