package src.deck;

/**
 * Baron card.
 */
public class Baron extends Card {

    /**
     * Constructor.
     */
    public Baron() {

        mId = "Baron";
    }

    @Override
    public CardType getType() {

        return CardType.BARON;
    }

    @Override
    public void setDescription(String description) {

        mDescription = description;
    }
}
