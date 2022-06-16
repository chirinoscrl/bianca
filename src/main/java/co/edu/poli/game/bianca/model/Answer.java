package co.edu.poli.game.bianca.model;

/**
 * Esta clase nos permite modelar una respuesta.
 */
public class Answer {

    // Esta variable representa a una pregunta concreta.
    private final Question question;

    // Esta variable representa a una opción seleccionada por el usuario.
    private final Choice choiceSelected;

    // Esta variable nos permite referencia si la respuesta seleccionada es correcta o no.
    private final boolean isCorrect;

    /**
     * Constructor
     *
     * @param question       the question
     * @param choiceSelected the choice selected
     * @param isCorrect      the is correct
     */
    public Answer(Question question, Choice choiceSelected, boolean isCorrect) {
        this.question = question;
        this.choiceSelected = choiceSelected;
        this.isCorrect = isCorrect;
    }

    /**
     * Obtener la pregunta
     *
     * @return Pregunta
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Obtener la opción selecciona por el usuario
     *
     * @return opción seleccionada
     */
    public Choice getChoiceSelected() {
        return choiceSelected;
    }

    /**
     * Obtener si la opción seleccionada es correcta o no.
     *
     * @return Nos retorna True o False si la respuesta es correcta o no.
     */
    public boolean isCorrect() {
        return isCorrect;
    }
}
