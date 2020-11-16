package fr.afpa.dao.services;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.afpa.dao.beans.AdresseDAO;
import fr.afpa.dao.beans.UserDAO;
import fr.afpa.session.HibernateUtils;

public class GestionUserServicesDAO {

	public static Boolean insertUser(AdresseDAO adresse, UserDAO user) {
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
	
	public UserDAO recupPersonneParPseudo(String pseudo) {
		// Ouverture d'une session Hibernate
				Session		s = HibernateUtils.getSession();
				
				Query q = s.getNamedQuery("trouverPersonneParSonPseudo");
				
			    q.setParameter("val", pseudo);
				
				UserDAO user = (UserDAO) q.getSingleResult();
				
				s.close();
				return user;
	}

}
