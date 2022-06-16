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
                        "Elige las figuras con el mismo COLOR",
                        "rectangulo_amarillo.png",
                        List.of(
                                new Choice(111,"tres_redondos_naranjas.png", true),
                                new Choice(112,"dos_rombos_amarillos.png", false),
                                new Choice(113,"tres_cuadrados_rojos.png", false),
                                new Choice(114,"un_rectangulo_verde.png", false)
                        )
                ),
                new Question(
                        "Elige las figuras con el mismo NÚMERO",
                        "numero_tres_rojo.png",
                        List.of(
                                new Choice(211,"tres_redondos_naranjas.png", true),
                                new Choice(212,"dos_rombos_amarillos.png", false),
                                new Choice(213,"tres_cuadrados_rojos.png", false),
                                new Choice(214,"un_rectangulo_verde.png", false)
                        )
                ),
                new Question(
                        "Elige las figuras con el mismo FORMA",
                        "cuadrado_morado.png",
                        List.of(
                                new Choice(311,"tres_redondos_naranjas.png", true),
                                new Choice(312,"dos_rombos_amarillos.png", false),
                                new Choice(313,"tres_cuadrados_rojos.png", false),
                                new Choice(314,"un_rectangulo_verde.png", false)
                        )
                )
        );
    }

}
