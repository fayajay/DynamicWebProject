package servlet;

import entity.Etudiant;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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


@WebServlet(name = "ServletForm", urlPatterns = {"/servlet_form"})
public class ServletForm extends HttpServlet {
    
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("connexion.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Etudiant e = new Etudiant();
        
        e.setNumEt(Integer.parseInt(req.getParameter("numEt")));
        e.setNomEt(req.getParameter("nomEt"));
        e.setPrenomEt(req.getParameter("prenomEt"));
       // e.setIdClasse
        
        
        NewEtudiantService es = new NewEtudiantService();
        
        es.enregistrerEtudiant(e);
        
        resp.sendRedirect("servletTest");
        
    }
}
