/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.NewEtudiantDAO;
import entity.Etudiant;

/**
 *
 * @author admin
 */
public class NewEtudiantService {
    
    public void enregistrerEtudiant(Etudiant e) {
        new NewEtudiantDAO().enregistrerEtudiant(e);
    }
    
}
