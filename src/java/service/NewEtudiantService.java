package service;

import dao.NewEtudiantDAO;
import entity.Etudiant;
import java.util.List;

public class NewEtudiantService {
    
    public void enregistrerEtudiant(Etudiant e) {
        new NewEtudiantDAO().enregistrerEtudiant(e);
    }
   
    public List<Etudiant> lister() {
        return new NewEtudiantDAO().lister();
    }
}
