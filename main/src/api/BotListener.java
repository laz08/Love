package src.api;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.*;
import org.pircbotx.hooks.types.GenericMessageEvent;
import src.Game;
import src.Player;
import src.config.Settings;

/**
 * Bot listener.
 */
public class BotListener extends ListenerAdapter {

    private Game mGame;

    /**
     * Constructor.
     */
    public BotListener(Game game){

        mGame = game;
    }

    //TODO: Change messages so it gets them from LanguageHelper

    @Override
    public void onGenericMessage(GenericMessageEvent event) {

        if (event.getMessage().startsWith("_help"))
            event.respond("Me pides ayuda, payaso?");

        if(event.getMessage().contains(Settings.getUsername())){

            event.respond("Me hablas a mi?");
        }

        if(event.getMessage().startsWith("_join")){

            String nick = event.getUser().getNick();
            mGame.addPlayer(new Player(nick));
            event.respond("Jugador " + nick +  " añadido a la partida.");
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
        //TODO: Check if user is playing. If not, ignore it. Else, update player class.
        //event.getOldNick() && event.getNewNick()
    }
}
