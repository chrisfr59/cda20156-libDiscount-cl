package fr.afpa.metier.services;



import fr.afpa.dao.beans.AdresseDAO;
import fr.afpa.dao.beans.UserDAO;
import fr.afpa.dao.services.GestionUserServicesDAO;

public class GestionUserService {
	

	public boolean instanceUser(String pseudo, String pwd, String nom, String prenom, String nomLibrairie,int numVoie, String nomVoie,int codePostal, String nomVille, String mail, String phone, boolean admin) {

		AdresseDAO adresse = new AdresseDAO(numVoie, nomVoie, codePostal, nomVille);
		UserDAO user = new UserDAO(pseudo, pwd, nomVille, prenom, nomLibrairie, mail, phone, admin, adresse);
		
		return GestionUserServicesDAO.insertUser(adresse,user);
		
		
	}


}
