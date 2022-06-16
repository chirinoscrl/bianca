package co.edu.poli.game.bianca;

import co.edu.poli.game.bianca.business.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * The type Hello controller.
 */
public class MainController {
    @FXML
    private Label welcomeText;

    private Game game = new Game();

    /**
     * On hello button click.
     */
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(game.nextQuestion().getStatement());
    }
}