package src.cards;

/**
 * Prince card.
 */
public class Prince extends Card {

    /**
     * Constructor.
     */
    public Prince() {

        mId = "Prince";
    }

    @Override
    public CardType getType() {

        return CardType.PRINCE;
    }

    @Override
    public void setDescription(String description) {

        mDescription = description;
    }
}
