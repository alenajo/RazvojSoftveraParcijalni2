package ptf.rs.parcijala2.repository;

import ptf.rs.parcijala2.models.Proizvod;

import java.util.List;

public interface ProizvodRepository {
    void addProizvod(Proizvod proizvod);
    List<Proizvod> getAll();
}
