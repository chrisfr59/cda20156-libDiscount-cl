package fr.afpa.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afpa.dao.beans.UserDAO;
import fr.afpa.dao.services.GestionUserServicesDAO;

/**
 * Servlet implementation class ServletVerifUser
 */
public class ServletVerifUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVerifUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("pseudo");
		String pwd = request.getParameter("pass");
		
		UserDAO user = (UserDAO) new GestionUserServicesDAO().recupPersonneParPseudoEtMdp(login,pwd);
		
		 if(user!= null && login == user.getPseudo() && pwd == user.getPwd()) {
			 
			 request.getRequestDispatcher("/WEB-INF/utilisateurs/MonCompte.html").forward(request, response);
			 
		 }else {
			 System.out.println("Personne non trouvée : ");
		}
	}

}
