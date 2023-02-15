package ptf.rs.parcijala2;

import ptf.rs.parcijala2.repository.JPARepository;
import ptf.rs.parcijala2.repository.ProizvodRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Config {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    private static final EntityManager em = emf.createEntityManager();
    public static final ProizvodRepository proizvodRepository = new JPARepository(em);

}
