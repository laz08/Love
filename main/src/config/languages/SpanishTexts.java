package src.config.languages;

/**
 * Spanish texts.
 */
public class SpanishTexts extends LanguageTexts {

    /**
     * Constructor.
     */
    public SpanishTexts() {

        GUARD_DESCRIPTION = "Adivina la mano de un jugador. Unos prefieren arriesgarse usándolo al principio" +
                " (quizás por temor de un posible Barón). Otros, esperar al final de la partida para" +
                "tener más posibilidades de acierto.";

        PRIEST_DESCRIPTION = "Mira una carta de otro jugador. A pesar de no dar ventaja inmediata, puede ser" +
                "muy útil para descubrir el paradero de la Princesa.";

        BARON_DESCRIPTION = "Compara tus cartas con las de otro jugador en secreto." +
                "El jugador con las cartas más bajas queda eliminado de la ronda. Si conoces el personaje del rival " +
                "y puedes superarle, ¡a por él! \n Pero cuidado, que te puedes llevar sorpresas." +
                "\n ¡Comprueba las cartas descartadas sobre la mesa!";

        MAID_DESCRIPTION = "Ofrece inmunidad hasta el siguiente turno. Puede ser muy útil en las rondas finales " +
                "para evitar ataques de Guardias.";

        PRINCE_DESCRIPTION = "Elige cualquier jugador (puedes escogerte a ti mismo) para que se descarte de una carta " +
                "y tenga que coger otra nueva del mazo.";

        KING_DESCRIPTION = "Intercambia tu mano. Puede ser una opción para pasarle la Princesa a otro jugador y luego " +
                "eliminarlo con el Principe. Otra opción es atacar con el Guardia tras el cambio de mano.";

        COUNTESS_DESCRIPTION = "Descártala si tienes al Rey o al Príncipe en la mano. Si se da el caso de " +
                "tener la Condesa y el Rey/Príncipe a la vez, deberás descartar a la Condesa. Aunque también puedes intentar " +
                "despistar.";

        PRINCESS_DESCRIPTION = "Quedas eliminado de la ronda si la descartas. Aprovéchala si te toca junto a un " +
                "Barón, pero ten cuidado, ya habrá un jugador que sabrá que la tienes y puede eliminarte usando al " +
                "Guardia o al Príncipe.";
    }

    @Override
    public LanguageId getLanguageId() {

        return LanguageId.SPANISH;
    }
}
