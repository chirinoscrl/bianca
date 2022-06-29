package co.edu.poli.game.bianca.business;

import co.edu.poli.game.bianca.model.Answer;
import co.edu.poli.game.bianca.model.Choice;
import co.edu.poli.game.bianca.model.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase nos permite gestionar toda la lógica del juego.
 */
public class Game {

    private static final int POINTS_EARNED = 50;

    // Listado de preguntas que componente una partida
    private final List<Question> questions;

    // Listado de preguntas, respuestas seleccionadas y bandera de acierto
    private final List<Answer> answers = new ArrayList<>();

    // Esta variable de control nos registra el índice de la pregunta en curso.
    private int questionIndexCurrent = 0;

    // Esta variable acumulado llevara el puntaje acumulado por el usuario
    private int score = 0;

    /**
     * Crea un nuevo juego
     * Obtiene las preguntas y demás configuración de la partida.
     */
    public Game() {
        this.questions = QuestionData.get();
    }

    /**
     * Este método nos retorna la siguiente pregunta a mostrar.
     *
     * @return Preguntas que podemos mostrar o un valor nulo si no existe más preguntas.
     */
    public Question nextQuestion() {
        if (questions.size() > questionIndexCurrent) {
            Question question = questions.get(questionIndexCurrent);
            questionIndexCurrent++;

            return question;
        }

        return null;
    }

    /**
     * Nos permite obtener el listado de preguntas de una partida.
     *
     * @return Listado de preguntas
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * Nos valida si la respuesta seleccionada es válido o no.
     * Además, nos permite guardar la respuesta.
     *
     * @param question       Pregunta en curso
     * @param choiceSelected Opción seleccionada por el usuario.
     * @return Nos retorna True o False si la respuesta es correcta o no.
     */
    public boolean validateAnswer(Question question, Choice choiceSelected) {
        boolean isCorrect = question.getAnswerCorrect().orElseThrow().getCode() == choiceSelected.getCode();
        this.score = isCorrect ? (this.score + POINTS_EARNED) : this.score;
        Answer answer = new Answer(question, choiceSelected, isCorrect);
        answers.add(answer);

        return isCorrect;
    }

    /**
     * Nos permite obtener el resumen de preguntas y respuestas seleccionadas.
     *
     * @return Listado de respuestas
     */
    public List<Answer> getAnswers() {
        return answers;
    }

    /**
     * Permite obtener el score acumulado por el usuario
     *
     * @return score acumulado
     */
    public int getScore() {
        return score;
    }
}
