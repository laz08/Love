package src.cards;

/**
 * Card.
 */
public abstract class Card {

    String mId;
    String mDescription;
    int value;

    public abstract CardType getType();

}
