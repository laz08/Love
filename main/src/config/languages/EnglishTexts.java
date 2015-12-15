package src.config.languages;

/**
 * English texts.
 */
public class EnglishTexts extends LanguageTexts {

    /**
     * Constructor.
     */
    public EnglishTexts() {

        //TODO Translate texts from SpanishTexts
        PRIEST_DESCRIPTION = "When you discard the Priest, you can look at one other player's hand." +
                " Do not reveal the hand to all players.";

        BARON_DESCRIPTION = "When discarded, chose one other player still in the round. You and that player "+
                "secretly compare you hands. The player with the lower rank is knocked out of the round. "+
                "In case of a tie, nothing happens. If all other players still in the round are protected "+
                "by the Hanmaid, this card does nothing.";

        PRINCE_DESCRIPTION = "Choose one player still in the round (including yourself). That player discards "+
                "his or her hand (do not aplly its effect) and draws a new card. If the deck is empty, that player "+
                "draws the card that was removed at the start of the round.";

        KING_DESCRIPTION = "When you discard King Arnaud IV, trade the card in yout hand with the "+
                "card held by another player of yout choice. You cannot trade with a player who is "+
                "who is out of the round, nor with someone protected by the Handmaid. If all other "+
                "players still in the round are protected by the Handmaid, this card does nothing.";

        COUNTESS_DESCRIPTION = "Unlike other cards, which take effect when discarded, the text on the "+
                "Countess applies while she is in yout hand. In fact, she has no effect when you discard her. "+
                "If you ever have the Countess and either the King or Prince in you hand, you must discard "+
                "the Countess. You do not have to reveal the other card in your hand. Of course, you can also "+
                "discard the Countess even if you do not have a royal family member in your hand. She likes "+
                "to play mind games...";

        PRINCESS_DESCRIPTION = "If you discard the Princess -no matter how or why- she has tossed" +
                "your letter into the fire. You are knocked out of the round.";

        GUARD_DESCRIPTION = "When you discard the Guard, choose a player and name a card (other than Guard)." +
                "If that player has that card, that player is knocked out of the round. If all other players still in the round" + 
                "are protected by the Handmaid, thins card does nothing.";

        MAID_DESCRIPTION = "When you discard the Hanmaid, you are inmune to the effects of other players' "+
                "cards until the start of your next turn. If all players other than the player whose turn it "+
                "is are protected by Susannah, the player must choose him- or herself if possible.";
    }

    @Override
    public LanguageId getLanguageId() {

        return LanguageId.ENGLISH;
    }
}
