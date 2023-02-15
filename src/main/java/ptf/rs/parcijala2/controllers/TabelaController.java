package ptf.rs.parcijala2.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ptf.rs.parcijala2.Config;
import ptf.rs.parcijala2.models.Proizvod;
import ptf.rs.parcijala2.repository.ProizvodRepository;
import ptf.rs.parcijala2.utils.Utils;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TabelaController implements Initializable {
    public TableView<Proizvod> tabela;

    private final ProizvodRepository proizvodRepository;
    public TableColumn<Proizvod, Boolean> popustColumn;
    public TableColumn<Proizvod, Double> cijenaColumn;

    public TabelaController() {
        this.proizvodRepository = Config.proizvodRepository;
    }

    public void loadItems() {
        tabela.setItems(FXCollections.observableArrayList(proizvodRepository.getAll()));
        tabela.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        popustColumn.setCellFactory(cellData -> new TableCell<>(){
            @Override
            protected void updateItem(Boolean value, boolean empty) {
                super.updateItem(value, empty);
                if (value == null || empty) setText("");
                else setText(value ? "Da" : "Ne");
            }
        });


        loadItems();
    }

    public void prikazPodataka(ActionEvent actionEvent) {

        tabela.getItems().forEach(Proizvod::getCijena);

        Utils.displayAlert(String.format("Ukupno je kreirano %d proizvoda\nUkupna vrijednost svih unesenih proizvoda: %d",
                tabela.getItems().size(),
                tabela.getItems().stream().filter(Proizvod::isPopust).count()),
                //tabela.getItems().stream().filter(Proizvod::isPopust).mapToDouble(Proizvod::getCijena).sum()),
                Alert.AlertType.INFORMATION);
    }
}
