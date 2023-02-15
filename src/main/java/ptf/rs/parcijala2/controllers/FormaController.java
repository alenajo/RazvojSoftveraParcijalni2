package ptf.rs.parcijala2.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import ptf.rs.parcijala2.Config;
import ptf.rs.parcijala2.models.Proizvod;
import ptf.rs.parcijala2.repository.ProizvodRepository;
import ptf.rs.parcijala2.utils.Utils;
import ptf.rs.parcijala2.utils.Validators;

import java.net.URL;
import java.util.ResourceBundle;

public class FormaController implements Initializable {
    public TextField nazivField;
    public TextArea opisArea;
    public TextField cijenaField;
    public TextField kolicinaField;
    public ComboBox<Proizvod.Kategorija> kategorijaBox;
    public CheckBox popustCheck;

    private final ProizvodRepository proizvodRepository;

    public FormaController(ProizvodRepository proizvodRepository) {
        this.proizvodRepository = proizvodRepository;
    }

    public FormaController() {
        this(Config.proizvodRepository);
    }


    public void kreirajProizvod(ActionEvent actionEvent) {
        try {
            Validators.checkRequiredField(nazivField.getText(), "Naziv");
            Validators.checkRequiredField(cijenaField.getText(), "Cijena");
            Validators.checkRequiredField(kolicinaField.getText(), "Kolicina");
            Validators.checkPositiveInteger(Integer.parseInt(kolicinaField.getText()),"Kolicina");
            Validators.checkPositiveDouble(Double.parseDouble(cijenaField.getText()),"Cijena");

            Validators.checkMaxLength(nazivField.getText(), 50, "Naziv");
            Validators.checkMaxLength(opisArea.getText(), 100, "Opis");

            Proizvod proizvod = new Proizvod();
            proizvod.setNaziv(nazivField.getText());
            proizvod.setOpis(opisArea.getText());
            proizvod.setCijena(Double.parseDouble(cijenaField.getText()));
            proizvod.setKolicina(Integer.parseInt(kolicinaField.getText()));
            proizvod.setKategorija(kategorijaBox.getSelectionModel().getSelectedItem());
            proizvod.setPopust(popustCheck.isSelected());

            proizvodRepository.addProizvod(proizvod);
            resetujPolja(null);
        } catch (Exception e) {
            Utils.displayAlert(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void resetujPolja(ActionEvent actionEvent) {
        nazivField.setText("");
        opisArea.setText("");
        cijenaField.setText("");
        kolicinaField.setText("");
        kategorijaBox.getSelectionModel().selectFirst();
        popustCheck.setSelected(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resetujPolja(null);
        kategorijaBox.setItems(FXCollections.observableArrayList(Proizvod.Kategorija.values()));
        kategorijaBox.getSelectionModel().selectFirst();
    }
}
