package dao;

import entity.Etudiant;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class NewEtudiantDAO {
    
    public void enregistrerEtudiant (Etudiant e) {
    EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
    em.getTransaction().begin();
    em.persist(e);
    em.getTransaction().commit();
    }
    
    public List<Etudiant> lister() {
    EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
    return em.createQuery("SELECT e FROM Etudiant e").getResultList();
    }
}
