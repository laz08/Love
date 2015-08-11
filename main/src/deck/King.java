package src.deck;

/**
 * King card.
 */
public class King extends Card {

    /**
     * Constructor.
     */
    public King() {

        mId = "King";
    }

    @Override
    public CardType getType() {

        return CardType.KING;
    }

    @Override
    public void setDescription(String description) {

        mDescription = description;
    }
}
