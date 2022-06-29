module co.edu.poli.game.bianca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;

    opens co.edu.poli.game.bianca to javafx.fxml;
    exports co.edu.poli.game.bianca;
}