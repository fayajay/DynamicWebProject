/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "SevletTest", urlPatterns = {"/servletTest"})
public class SevletTest extends HttpServlet {

@PersistenceUnit
	private EntityManagerFactory em;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		//String query = "SELECT nom_et, prenom_et, date_naiss_et FROM ETUDIANT WHERE date_naiss_et BETWEEN '1987/12/24' AND '1993/12/24'";
                
                String query = "SELECT nom_et, prenom_et FROM ETUDIANT ORDER BY nom_et, prenom_et";
                
                //String query = "SELECT nom_et, prenom_et FROM ETUDIANT e INNER JOIN CLASSE c ON e.id_classe = c.num_classe WHERE nom_classe IN ('BTS SIO A','BTS SIO B')";
                
                /*String query = "SELECT nom_et,prenom_et,AVG(note) as moyenne\n" +
                                    "FROM OBTENIR NATURAL JOIN ETUDIANT e INNER JOIN CLASSE c\n" +
                                    "ON e.id_classe = c.num_classe\n" +
                                    "WHERE nom_classe = \"BTS IG\"\n" +
                                    "GROUP BY num_et\n" +
                                    "HAVING moyenne < (SELECT AVG(note)\n" +
                                    " FROM OBTENIR NATURAL JOIN ETUDIANT e INNER JOIN CLASSE c\n" +
                                    " ON e.id_classe = c.num_classe\n" +
                                    " WHERE nom_classe = \"BTS IG\")";*/
                
                /*String query = "SELECT nom_mat,AVG(note) as moyenne\n" +
                                   "FROM MATIERE NATURAL JOIN OBTENIR NATURAL JOIN ETUDIANT e INNER\n" +
                                   "JOIN CLASSE c\n" +
                                   "ON e.id_classe = c.num_classe\n" +
                                   "WHERE nom_classe = \"BTS IG\"\n" +
                                   "GROUP BY nom_mat\n" +
                                   "HAVING moyenne < 10";*/
                
		List<Object[]> firstList = em.createEntityManager().createNativeQuery(query).getResultList();
		
		out.print("<html><body><table>");
		
		for (Object[] tab : firstList) {
			out.print("<tr>");
			for (Object o : tab) {
				out.print("<td>");
				out.print(o.toString());
				out.print("</td>");
			}
			out.print("</tr>");
		}
		out.print("</html></body></table>");
	}
}

