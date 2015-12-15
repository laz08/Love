package src.api;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.NickChangeEvent;
import org.pircbotx.hooks.types.GenericMessageEvent;
import org.pircbotx.output.OutputChannel;
import src.Game;
import src.Player;
import src.config.Settings;

import java.util.List;

/**
 * Bot listener.
 */
public class BotListener extends ListenerAdapter {

    private Game mGame;
    private LoveLettersBot mBot;
    public static String mBotUsername;


    /**
     * Constructor.
     */
    public BotListener(Game game) {

        mGame = game;
        mBotUsername = Settings.getUsername();
    }

    /**
     * Sets bot.
     *
     * @param bot Bot.
     */
    public void setBot(LoveLettersBot bot) {

        mBot = bot;
    }


    //TODO: Change messages so it gets them from LanguageHelper

    @Override
    public void onGenericMessage(GenericMessageEvent event) {

        String message = event.getMessage();
        boolean isCommand = false;
        String channel = Settings.getAutoJoinChannel();
        String nickname = event.getUser().getNick();
        switch (message) {

            case HELP_COMMAND:

                isCommand = true;
                event.respond("Te mando las instrucciones por privado, " + nickname);
                break;

            case JOIN_COMMAND:

                isCommand = true;
                addPlayer(nickname, channel);
                event.respond("El jugador " + nickname + " se ha unido a la partida");
                break;

            case LEAVE_COMMAND:

                isCommand = true;
                removePlayer(nickname, channel);
                event.respond("El jugador " + nickname + " ha dejado la partida");
                break;
            case PLAYERS_LIST_COMMAND:

                isCommand = true;
                sendPlayersList();
                break;

            case PLAY_COMMAND:

                isCommand = true;
                event.respond("Que empiece el juego!");
                startPlay();
                break;

            case NEXT_TURN_COMMAND:

                isCommand = true;
                nextTurn();
                break;

            case DRAW_CARD_COMMAND:

                isCommand = true;
                //WARNING: No se com conseguir el missatge per extreure  el
                //nom de la carta
                String card = null;
                drawCard(nickname, card);
                break;
        }

        if (!isCommand) {

            if (message.startsWith(mBotUsername)) {

                event.respond("Me hablas a mi?");
            }

        }
    }

    /**
     * Adds player to current game.
     *
     * @param nick    User nickname.
     * @param channel Channel.
     */
    private void addPlayer(String nick, String channel) {

        mGame.addPlayer(new Player(nick));
        mBot.sendMessageToChannel("Jugador " + nick + " añadido a la partida.", channel);
    }

    /**
     * Removes player from current game.
     *
     * @param nick    User nickname.
     * @param channel Channel.
     */
    private void removePlayer(String nick, String channel) {

        try {

            mGame.removePlayer(nick);
            mBot.sendMessageToChannel("Jugador " + nick + " borrado de la partida.", channel);
        } catch (Exception e) {

            mBot.sendMessageToChannel(e.getMessage(), channel);
        }
    }


    /**
     * Sends player list.
     */
    private void sendPlayersList() {

        String channel = Settings.getAutoJoinChannel();
        String messageToSend = "";

        mBot.sendMessageToChannel("Listado de jugadores:", channel);

        List<Player> playerList = mGame.getPlayers();
        for (int i = 0; i < playerList.size(); i++) {

            Player player = playerList.get(i);
            String playerInfo = player.getUsername() + " (" + 0 + ")";
            messageToSend += playerInfo;

            if (i != playerList.size() - 1) {

                messageToSend += ", ";
            }
        }
        mBot.sendMessageToChannel(messageToSend, channel);
    }

    @Override
    public void onMessage(MessageEvent event) throws Exception {

        super.onMessage(event);
        if (event.getMessage().startsWith("_listPlayers")) {

            OutputChannel send = event.getChannel().send();
            send.action("List of current players:");
            List<Player> players = mGame.getPlayers();
            for (int i = 0; i < players.size(); i++) {

                send.action(players.get(i).getUsername());
            }
        }

    }

    @Override
    public void onJoin(JoinEvent event) throws Exception {

        super.onJoin(event);
        event.respond("Chupame esta, braulio.");
    }

    @Override
    public void onNickChange(NickChangeEvent event) throws Exception {

        super.onNickChange(event);

        refreshListPlayers(event);
    }

    /**
     * Refreshes players list nick names.
     *
     * @param event Nick Change Event.
     */
    private void refreshListPlayers(NickChangeEvent event) {

        String oldNick = event.getOldNick();
        List<Player> playerList = mGame.getPlayers();
        Player player;

        for (int i = 0; i < playerList.size(); i++) {

            player = playerList.get(i);
            if (player.getUsername().equals(oldNick)) {

                player.setUsername(event.getNewNick());
            }
        }
    }

    /**
     * Initialize the game and start it
     */
    private void startPlay() {
        mGame.startGame();
    }

    /**
     * End the current turn and start next turn
     */
    private void nextTurn() {

    }

    /**
     *
     * @param sourcePlayer Player that draw the card
     * @param cardPlayed Card that is played
     */
    private void drawCard(Player sourcePlayer, String cardPlayed, Player targetPlayer) {

        mGame.playCard(sourcePlayer, cardPlayed, targetPlayer);

    }

    public static final String HELP_COMMAND = "!help";
    public static final String JOIN_COMMAND = "!join";
    public static final String LEAVE_COMMAND = "!leave";
    public static final String PLAYERS_LIST_COMMAND = "!list";
    public static final String PLAY_COMMAND = "!play";
    public static final String NEXT_TURN_COMMAND = "!nextTurn";
    public static final String DRAW_CARD_COMMAND = "!drawCard";
}
