package fr.afpa.dao.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "user")
public class UserDAO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_user;
	
	@Column(unique = true)
	private String pseudo;
	private String pwd;
	private String nom;
	private String prenom;
	private String nomLibrairie;
	private String adresse;
	private String mail;
	private long telephone;
	
	
	public UserDAO(String pseudo, String pwd, String nom, String prenom, String nomLibrairie, String adresse,
			String mail, long telephone) {
		super();
		this.pseudo = pseudo;
		this.pwd = pwd;
		this.nom = nom;
		this.prenom = prenom;
		this.nomLibrairie = nomLibrairie;
		this.adresse = adresse;
		this.mail = mail;
		this.telephone = telephone;
	}
	
	
	
	


}
