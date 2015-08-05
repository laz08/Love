package src.cards;

/**
 * Card.
 */
public abstract class Card {

    String mId;
    String mDescription;
    int mValue;

    public abstract CardType getType();

}
