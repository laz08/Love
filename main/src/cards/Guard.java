package src.cards;

public class Guard extends Card {

    @Override
    public CardType getType() {

        return CardType.GUARD;
    }

    public Guard(){

        mId = "Guard";
        mDescription = "Guard description";
    }
}
