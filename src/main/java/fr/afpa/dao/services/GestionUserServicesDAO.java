package fr.afpa.dao.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.afpa.dao.beans.AdresseDAO;
import fr.afpa.dao.beans.UserDAO;
import fr.afpa.session.HibernateUtils;

public class GestionUserServicesDAO {

	
	public static Boolean insertUser(AdresseDAO adresse,UserDAO user) {
		// TODO Auto-generated method stub
		try {
			// Ouverture d'une session Hibernate
			  Session s = HibernateUtils.getSession();
			    	// Début de la transaction
			  Transaction tx = s.beginTransaction();
			    			
			  // Enregistrements de l'objet personne
			  s.persist(adresse);  			
			  s.persist(user);
			    			
			     	    
			    			tx.commit();
			    			s.close();
			    			
		} catch (Exception e) {
		 return false;
		}
		return true;
		
	}


}
