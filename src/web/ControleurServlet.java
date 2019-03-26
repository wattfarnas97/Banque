package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditMetierImpl;
import metier.ICreditMetier;
@WebServlet(name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {

ICreditMetier metier;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
	metier=new CreditMetierImpl();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("creditModel", new CreditModel());
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * lire les données de la requete
		 */
		double montant=Double.parseDouble(request.getParameter("montant"));
		double taux=Double.parseDouble(request.getParameter("taux"));
		int duree=Integer.parseInt(request.getParameter("duree"));
		/*
		 * stocker les données dans le modele
		 */
		CreditModel model=new CreditModel();
		model.setMontant(montant);
		model.setTaux(taux);
		model.setDuree(duree);
		/*
		 * Faire appel a la couche metier pour effectuer le traitement
		 */
		double res=metier.calculerMensualiteCredit(montant, taux, duree);
		/*
		 * stocker les resultats dans le modèle
		 */
		model.setMensualite(res);
		
		request.setAttribute("creditModel", model);
		/*
		 * faire un foward vers la vue jsp
		 */
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
	}
	
}
