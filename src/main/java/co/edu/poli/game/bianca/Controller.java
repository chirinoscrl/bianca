package co.edu.poli.game.bianca;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;

public abstract class Controller {

    @FXML
    protected Button firstChoice;

    protected abstract Node getReference();

    public void closeWindows() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(this.getViewReturnPath()));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.getReference().getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(PlayController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected String getViewReturnPath() {
        return "view/welcome.fxml";
    }


}
