package fr.afpa.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afpa.dao.beans.UserDAO;
import fr.afpa.dao.services.GestionUserServicesDAO;
import fr.afpa.metier.services.GestionUserService;

/**
 * Servlet implementation class ServletAjoutUser
 */
public class ServletAjoutUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAjoutUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pseudo = request.getParameter("pseudo");
		String pwd = request.getParameter("pwd");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String nomLibrairie = request.getParameter("nomLibrairie");
		int numVoie = Integer.parseInt(request.getParameter("numVoie"));
		String nomVoie = request.getParameter("nomVoie");
		int codePostal = Integer.parseInt(request.getParameter("codePostal"));
		String nomVille = request.getParameter("nomVille");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		boolean admin = Boolean.valueOf(String.valueOf(request.getAttribute("admin")));

		Boolean verification = false;

		if (pseudo != "" && pwd != "" && nom != "" && prenom != "" && nomLibrairie != "" && Integer.toString(numVoie) != ""
				&& nomVoie != "" && Integer.toString(codePostal) != ""
				&& nomVille != "" && mail != "" && phone != "" ) {

			GestionUserService UserService = new GestionUserService();
			
			verification = 	UserService.instanceUser(pseudo, pwd, nom, prenom, nomLibrairie, numVoie, nomVoie, codePostal, nomVille, mail, phone, admin);

			

		}
		if (verification == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("ServletLogin");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(".jsp");
			dispatcher.forward(request, response);
		}
	}

}
