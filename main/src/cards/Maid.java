package src.cards;

/**
 * Maid card.
 */
public class Maid extends Card {

    /**
     * Constructor.
     */
    public Maid() {

        mId = "Maid";
    }

    @Override
    public CardType getType() {

        return CardType.MAID;
    }

    @Override
    public void setDescription(String description) {

        mDescription = description;
    }
}
