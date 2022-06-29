package co.edu.poli.game.bianca;

import co.edu.poli.game.bianca.model.Answer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FinalController extends Controller {

    @FXML
    public GridPane gridFinal;

    @FXML
    public Label score;

    @FXML
    public Label messageResult;

    @Override
    protected Node getReference() {
        return this.gridFinal;
    }

    public void onBack(ActionEvent actionEvent) {
        this.closeWindows();
    }

    public void onExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void initialize(int score) {
        this.score.setText(String.valueOf(score));
        if (score > 0) {
            this.messageResult.setText("¡Felicitaciones ganaste!");
        } else {
            this.messageResult.setText("¡Ups.. Lo siento perdiste :( !");
        }
    }
}