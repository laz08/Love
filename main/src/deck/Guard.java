package src.deck;

/**
 * Guard card.
 */
public class Guard extends Card {

    /**
     * Constructor.
     */
    public Guard() {

        mId = "Guard";
    }

    @Override
    public CardType getType() {

        return CardType.GUARD;
    }

    @Override
    public void setDescription(String description) {

        mDescription = description;
    }

}
