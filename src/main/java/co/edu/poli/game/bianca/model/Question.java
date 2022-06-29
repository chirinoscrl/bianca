package co.edu.poli.game.bianca.model;

import java.util.List;
import java.util.Optional;

/**
 * Esta clase nos permite modela una pregunta
 */
public class Question {

    private String statement;

    private String image;

    private List<Choice> choices;

    /**
     * Constructor
     *
     * @param statement Enunciado de la pregunta
     * @param image     Imagen complementaria
     * @param choices   Listado de opciones
     */
    public Question(String statement, String image, List<Choice> choices) {
        this.statement = statement;
        this.image = image;
        this.choices = choices;
    }

    /**
     * Obtener el enunciado
     *
     * @return enunciado
     */
    public String getStatement() {
        return statement;
    }

    /**
     * Establecer un enunciado
     *
     * @param statement enunciado
     */
    public void setStatement(String statement) {
        this.statement = statement;
    }

    /**
     * Obtener las opciones
     *
     * @return Listado de opciones
     */
    public List<Choice> getChoices() {
        return choices;
    }

    /**
     * Establecer el listado de opciones
     *
     * @param choices Listado de opciones
     */
    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    /**
     * Obtener la opción correcta
     *
     * @return opción correcta
     */
    public Optional<Choice> getAnswerCorrect() {
        return choices.stream().filter(Choice::isCorrect).findFirst();
    }

    public Choice findChoiceByCode(int code) {
        for (Choice choice : this.getChoices()) {
            if (choice.getCode() == code) {
                return choice;
            }
        }
        
        return null;
    }

    public String getImage() {
        return image;
    }
}
