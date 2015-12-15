package src;

import src.deck.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Game.
 */
public class Game {

    private List<Player> mPlayers;
    private List<Player> droppedPlayers; //Players out of the round
    private LoveLetters loveLetters;
    private Player lastWinner;          //used to decide the order of next turn
    private Player currentPlayer;       //Player that is playing that turn

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

    public Player getPlayer(String nickname) {

        Player player = null;
        for(int i = 0; i < mPlayers.size(); ++i) {
            if(nickname.equals(mPlayers.get(i).getUsername())) {
                player = mPlayers.get(i);
            }
        }
        return player;
    }

    /**
    * Start game
    *
    */
    public void startGame() {

        loveLetters = new LoveLetters();

        for (int i = 0; i < mPlayers.size(); ++i) {

            //Every player begin the game with two cards
            mPlayers.get(i).addCard(loveLetters.draw());
            mPlayers.get(i).addCard(loveLetters.draw());
        }
    }

    public void nextTurn() {

        //Every player gets a new card
        for(int i = 0; i < mPlayers.size(); ++i) {

            mPlayers.get(i).addCard(loveLetters.draw());
        }
    }

    public void playCard(Player sourcePlayer, String cardPlayed, Player targetPlayer) {

        //Is it this player's turn?
        if(currentPlayer == sourcePlayer) {
            ArrayList<String> validCard = new ArrayList<String>(
                    Arrays.asList("Baron", "Countess", "Guard", "King",
                            "Maid", "Priest", "Prince", "Princess"));
            if(validCard.contains(cardPlayed)) {
                Card actualCardPlayed = getCard(cardPlayed);
                //Is that card in the player's hand?
                if(!sourcePlayer.getMano().contains(actualCardPlayed)){
                    //Send error message
                    return;
                }
                //If they have the (Prince or King) AND Countess, they MUST play the Countess.
                Boolean Prince = false;
                Boolean King = false;
                Boolean Countess = false;
                Boolean validPlay = false;
                for(int i = 0; i < sourcePlayer.getMano().size(); ++i) {
                    if (sourcePlayer.getMano().get(i).getType() == CardType.PRINCE) {
                        Prince = true;
                    }
                    else if (sourcePlayer.getMano().get(i).getType() == CardType.KING) {
                        King = true;
                    }
                    else if(sourcePlayer.getMano().get(i).getType() == CardType.COUNTESS) {
                        Countess = true;
                    }
                }
                if( (Prince || King) && Countess) {
                    //Card played MUST be the Countess
                    if(!cardPlayed.equals("Countess")) {
                        //Notify that has to play Countess
                        validPlay = false;
                    }
                }

                //If they are playing an attack card, they need to specify a valid target
                //A valid target is someone who is in the game, not already eliminated
                //and did not play the Handmaid on their last turn
                //Target can only be current player if they are playing the prince.

            }
        }
    }

    private Card getCard(String cardName) {
        Card returnCard;
        switch (cardName) {
            case "Baron":
                returnCard = new Baron();
                break;
            case "Countess":
                returnCard = new Countess();
                break;
            case "Guard":
                returnCard = new Guard();
                break;
            case "King":
                returnCard = new King();
                break;
            case "Maid":
                returnCard = new Maid();
                break;
            case "Priest":
                returnCard = new Priest();
                break;
            case "Prince":
                returnCard = new Prince();
                break;
            case "Princess":
                returnCard = new Princess();
                break;
            default:
                return null;
        }
        return returnCard;

    }
}
