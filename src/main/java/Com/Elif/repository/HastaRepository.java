package Com.Elif.repository;

import Com.Elif.entity.Hasta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class HastaRepository extends RepositoryManager<Hasta,Long> {
    public HastaRepository() {
        super(new Hasta());
    }

    public List<Object[]> getAddCount(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("CRM");
        EntityManager manager=emf.createEntityManager();
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Hasta> root = criteriaQuery.from(Hasta.class);
        criteriaQuery.groupBy(root.get("ad"));
        criteriaQuery.multiselect(root.get("doktorid"), criteriaBuilder.count(root));
        //Root dediğimizde satırı saydırmış oluyoruz.
        return manager.createQuery(criteriaQuery).getResultList();
    }

    public List<Object[]> branslaraGoreHastaListesi(String hastaIsmi){
        EntityManager entityManager=Persistence.createEntityManagerFactory("CRM").createEntityManager();
        List<Object[]> resultList = entityManager.createNativeQuery("SELECT h.hasta_adi AS hasta_adi, d.ad AS doktor_adi," +
                        " b.ad AS brans_adi FROM tbldoktor as d JOIN tblrandevu as r ON d.id = r.doktor_id JOIN tblhasta as h" +
                        " ON h.id = r.hasta_id  JOIN tblbrans as b ON b.id = d.brans_id WHERE h.hasta_adi ='"+hastaIsmi+"'")
                .getResultList();
        return resultList;

    }



}
