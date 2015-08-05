package src.cards;

/**
 * Princess card.
 */
public class Princess extends Card {

    /**
     * Constructor.
     */
    public Princess() {

        mId = "Princess";
    }

    @Override
    public CardType getType() {

        return CardType.PRINCESS;
    }

    @Override
    public void setDescription(String description) {

        mDescription = description;
    }
}
