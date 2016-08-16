/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Etudiant;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.NewEtudiantService;

/**
 *
 * @author admin
 */
@WebServlet(name = "ServletForm", urlPatterns = {"/ServletForm"})
public class ServletForm extends HttpServlet {
    
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("connexion.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Etudiant e = new Etudiant();
        
        e.setNomEt(req.getParameter("nom"));
        e.setPrenomEt(req.getParameter("prenom"));
        
        NewEtudiantService es = new NewEtudiantService();
        
        es.enregistrerEtudiant(e);
        
    }
}
