package co.edu.poli.game.bianca.business;

import co.edu.poli.game.bianca.model.Choice;
import co.edu.poli.game.bianca.model.Question;

import java.util.List;

/**
 * Esta clase se encarga de configurar los datos para la partida
 */
public class QuestionData {

    /**
     * Nos permite obtener el listado de preguntas disponibles
     *
     * @return Listado de preguntas
     */
    public static List<Question> get() {
        return List.of(
                new Question(
                        "Elige la figura con el mismo COLOR",
                        "images/questions/first/one_rectangle_yellow.png",
                        List.of(
                                new Choice(111, "images/questions/first/one_square_red.png", false),
                                new Choice(112, "images/questions/first/two_rectangle_yellow.png", true),
                                new Choice(113, "images/questions/first/one_circle_orange.png", false),
                                new Choice(114, "images/questions/first/one_rectangle_green.png", false)
                        )
                ),
                new Question(
                        "Elige la figura con el mismo NÚMERO",
                        "images/questions/second/three_number_red.png",
                        List.of(
                                new Choice(211, "images/questions/second/two_rectangle_yellow.png", false),
                                new Choice(212, "images/questions/second/one_circle_orange.png", false),
                                new Choice(213, "images/questions/second/three_circle_orange.png", true),
                                new Choice(214, "images/questions/second/one_rectangle_green.png", false)
                        )
                ),
                new Question(
                        "Elige la figura con el mismo FORMA",
                        "images/questions/third/one_square_yellow.png",
                        List.of(
                                new Choice(311, "images/questions/third/one_rectangle_green.png", false),
                                new Choice(312, "images/questions/third/one_rectangle_yellow.png", false),
                                new Choice(313, "images/questions/third/two_rectangle_yellow.png", false),
                                new Choice(314, "images/questions/third/one_square_red.png", true)
                        )
                )
        );
    }

}
