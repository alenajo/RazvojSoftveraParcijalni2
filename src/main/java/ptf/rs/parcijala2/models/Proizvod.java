package ptf.rs.parcijala2.models;

import javax.persistence.*;
import java.util.Arrays;
import java.util.stream.Collectors;

@Entity
public class Proizvod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv = "", opis = "";
    private int kolicina;
    private double cijena;
    @Enumerated(EnumType.ORDINAL)
    private Proizvod.Kategorija kategorija;
    private boolean popust;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public boolean isPopust() {
        return popust;
    }

    public void setPopust(boolean popust) {
        this.popust = popust;
    }

    public enum Kategorija {
        TEHNIKA, KOZMETIKA, SPORT, GARDEROBA, HRANA_I_PICE;

        private final String name;

        Kategorija() {
            this.name = Arrays.stream(name().split("_")).map(s -> s.charAt(0) + s.substring(1).toLowerCase()).collect(Collectors.joining(" "));
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
