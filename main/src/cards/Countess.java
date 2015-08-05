package src.cards;

/**
 * Countess card.
 */
public class Countess extends Card {

    /**
     * Constructor.
     */
    public Countess() {

        mId = "Countess";
    }

    @Override
    public CardType getType() {

        return CardType.COUNTESS;
    }

    @Override
    public void setDescription(String description) {

        mDescription = description;
    }
}
