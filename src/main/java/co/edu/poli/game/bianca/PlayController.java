package co.edu.poli.game.bianca;

import co.edu.poli.game.bianca.business.Game;
import co.edu.poli.game.bianca.model.Choice;
import co.edu.poli.game.bianca.model.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.String.valueOf;

public class PlayController extends Controller implements Initializable {

    @FXML
    public Label statement;

    @FXML
    public ImageView questionImage;

    @FXML
    public TextField firstValue;

    @FXML
    public GridPane gridChoices;

    @FXML
    public ImageView firstChoiceImage;

    @FXML
    public TextField secondValue;

    @FXML
    public Button secondChoice;

    @FXML
    public ImageView secondChoiceImage;

    @FXML
    public TextField thirdValue;

    @FXML
    public Button thirdChoice;

    @FXML
    public ImageView thirdChoiceImage;

    @FXML
    public TextField fourthValue;

    @FXML
    public Button fourthChoice;

    @FXML
    public ImageView fourthChoiceImage;

    private Game game;

    private Question questionCurrent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.game = new Game();
        play();
    }

    public void onSelectedChoice(ActionEvent actionEvent) {
        Button btnSelected = (Button) actionEvent.getSource();
        String idSelectedValue = "#" + btnSelected.getId().replace("Choice", "Value");
        TextField selectedValue = (TextField) this.gridChoices.getScene().lookup(idSelectedValue);
        Choice selectedChoice = this.questionCurrent.findChoiceByCode(Integer.parseInt(selectedValue.getText()));
        boolean isCorrect = this.game.validateAnswer(this.questionCurrent, selectedChoice);
        String message;
        String image;
        if (isCorrect) {
            message = "Respuesta correcta";
            image = "images/screen/ok.png";
        } else {
            message = "Respuesta incorrecta";
            image = "images/screen/error.png";
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(message);
        ImageView icon = new ImageView(new Image(valueOf(getClass().getResource(image))));
        icon.setFitWidth(50);
        icon.setFitHeight(50);
        alert.setGraphic(icon);
        alert.showAndWait();
        play();
    }

    private void play() {
        this.questionCurrent = this.game.nextQuestion();

        if (this.questionCurrent != null) {
            this.statement.setText(this.questionCurrent.getStatement());

            this.questionImage.setImage(new Image(valueOf(getClass().getResource(this.questionCurrent.getImage()))));

            // Choices
            Choice firstChoiceData = this.questionCurrent.getChoices().get(0);
            this.firstValue.setText(valueOf(firstChoiceData.getCode()));
            this.firstChoiceImage.setImage(new Image(valueOf(getClass().getResource(firstChoiceData.getImage()))));

            Choice secondChoiceData = this.questionCurrent.getChoices().get(1);
            this.secondValue.setText(valueOf(secondChoiceData.getCode()));
            this.secondChoiceImage.setImage(new Image(valueOf(getClass().getResource(secondChoiceData.getImage()))));

            Choice thirdChoiceData = this.questionCurrent.getChoices().get(2);
            this.thirdValue.setText(valueOf(thirdChoiceData.getCode()));
            this.thirdChoiceImage.setImage(new Image(valueOf(getClass().getResource(thirdChoiceData.getImage()))));

            Choice fourthChoiceData = this.questionCurrent.getChoices().get(3);
            this.fourthValue.setText(valueOf(fourthChoiceData.getCode()));
            this.fourthChoiceImage.setImage(new Image(valueOf(getClass().getResource(fourthChoiceData.getImage()))));
        } else {
            openFinalView();
        }
    }

    private void openFinalView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/final.fxml"));
            Parent root = loader.load();
            FinalController controller = loader.getController();
            controller.initialize(this.game.getScore());
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.gridChoices.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(PlayController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Node getReference() {
        return this.gridChoices;
    }
}