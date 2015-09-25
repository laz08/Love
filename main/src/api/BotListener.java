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
        switch (message) {

            case HELP_COMMAND:

                isCommand = true;
                event.respond("Te mando las instrucciones por privado, " + event.getUser().getNick());
                break;

            case JOIN_COMMAND:

                isCommand = true;
                String nick = event.getUser().getNick();
                mGame.addPlayer(new Player(nick));
                event.respond("Jugador " + nick + " añadido a la partida.");
                break;

            case PLAYERS_LIST_COMMAND:

                isCommand = true;
                sendPlayersList();
                break;
        }

        if (!isCommand) {

            if (message.startsWith(mBotUsername)) {

                event.respond("Me hablas a mi?");
            }

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

    public static final String HELP_COMMAND = "!help";
    public static final String JOIN_COMMAND = "!join";
    public static final String PLAYERS_LIST_COMMAND = "!list";
}
