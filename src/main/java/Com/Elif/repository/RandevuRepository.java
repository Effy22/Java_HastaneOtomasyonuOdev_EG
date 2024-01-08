package Com.Elif.repository;

import Com.Elif.entity.Randevu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.time.LocalDate;
import java.util.List;

public class RandevuRepository extends RepositoryManager<Randevu,Long> {
    public RandevuRepository() {
        super(new Randevu());
    }

    public List<Randevu> findByHastaIdAndDateRange(Long hastaId, LocalDate startDate, LocalDate endDate) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRM");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Randevu> criteriaQuery = criteriaBuilder.createQuery(Randevu.class);
        Root<Randevu> root = criteriaQuery.from(Randevu.class);
        criteriaQuery.select(root);

        Predicate hastaIdPredicate = criteriaBuilder.equal(root.get("hastaid"), hastaId);
        Predicate dateRangePredicate = criteriaBuilder.between(root.get("tarih"), startDate, endDate);

        criteriaQuery.where(criteriaBuilder.and(hastaIdPredicate, dateRangePredicate));

        return em.createQuery(criteriaQuery).getResultList();
    }



}
