package ptf.rs.parcijala2.repository;

import ptf.rs.parcijala2.models.Proizvod;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class JPARepository implements ProizvodRepository {
    private final EntityManager em;

    public JPARepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void addProizvod(Proizvod proizvod) {
        em.getTransaction().begin();
        em.persist(proizvod);
        em.getTransaction().commit();
    }

    @Override
    public List<Proizvod> getAll() {
        CriteriaQuery<Proizvod> cq = em.getCriteriaBuilder().createQuery(Proizvod.class);
        cq.select(cq.from(Proizvod.class));
        return em.createQuery(cq).getResultList();
    }
}
