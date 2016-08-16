/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Etudiant;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author admin
 */
public class NewEtudiantDAO {
    
    public void enregistrerEtudiant (Etudiant e) {
    EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
    em.getTransaction().begin();
    em.persist(e);
    em.getTransaction().commit();
    }
    
}
