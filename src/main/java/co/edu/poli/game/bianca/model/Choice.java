package co.edu.poli.game.bianca.model;

/**
 * Esta clase nos permita modela una opción de respuesta.
 */
public class Choice {

    // Identificador único
    private int code;

    // Imagen de referencia
    private String image;

    // Bandera que nos indica que la opción es correcta.
    private boolean isCorrect;

    /**
     * Constructor
     *
     * @param code      identificador único
     * @param image     imagen de referencia
     * @param isCorrect Bandera que nos indica que la opción es correcta.
     */
    public Choice(int code, String image, boolean isCorrect) {
        this.code = code;
        this.image = image;
        this.isCorrect = isCorrect;
    }

    /**
     * Obtener el identificador
     *
     * @return código
     */
    public int getCode() {
        return code;
    }

    /**
     * Establecer un identificador
     *
     * @param code código
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Obtener la imagen
     *
     * @return imagen
     */
    public String getImage() {
        return image;
    }

    /**
     * Establecer una imagen
     *
     * @param image imagen
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Obtener bandera si es correcta la opción
     *
     * @return Obtener bandera si es correcta la opción
     */
    public boolean isCorrect() {
        return isCorrect;
    }

    /**
     * Establecer bandera si es correcta la opción
     *
     * @param correct Bandera si es correcta la opción
     */
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
