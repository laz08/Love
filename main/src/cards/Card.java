package src.cards;

/**
 * Card.
 */
public abstract class Card {

    String mId;
    String mDescription;

    /**
     * Gets the card type.
     *
     * @return Card type.
     */
    public abstract CardType getType();

    /**
     * Sets the card description.
     *
     * @param description Description.
     */
    public abstract void setDescription(String description);

}
