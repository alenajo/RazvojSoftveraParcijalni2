package ptf.rs.parcijala2.utils;

import javafx.scene.control.Alert;

public class Utils {
    public static void displayAlert(String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
