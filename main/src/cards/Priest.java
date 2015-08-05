package src.cards;

/**
 * Priest card.
 */
public class Priest extends Card {

    /**
     * Constructor.
     */
    public Priest(){

        mId = "Priest";
    }

    @Override
    public CardType getType() {

        return CardType.PRIEST;
    }

    @Override
    public void setDescription(String description) {

        mDescription = description;
    }
}
