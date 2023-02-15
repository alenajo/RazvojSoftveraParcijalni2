package ptf.rs.parcijala2.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Tab;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public Tab formaTab;
    public Tab tabelaTab;

    public FormaController formaController;
    public TabelaController tabelaController;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabelaTab.selectedProperty().addListener((ov, old, newValue) -> {
            if (newValue) tabelaController.loadItems();
        });
        formaTab.selectedProperty().addListener((ov, old, newValue) -> {
            if (newValue) formaController.resetujPolja(null);
        });
    }
}
