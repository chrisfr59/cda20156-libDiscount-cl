package fr.afpa.dao.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "utilisateur")
public class UserDAO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
	private int id_user;
	
	@Column(unique = true)
	private String pseudo;
	private String pwd;
	private String nom;
	private String prenom;
	private String nomLibrairie;
	private String mail;
	private String telephone;
	private boolean admin;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse")
	private AdresseDAO adresse;

	public UserDAO(String pseudo, String pwd, String nom, String prenom, String nomLibrairie, String mail,
			String telephone, boolean admin, AdresseDAO adresse) {
		super();
		this.pseudo = pseudo;
		this.pwd = pwd;
		this.nom = nom;
		this.prenom = prenom;
		this.nomLibrairie = nomLibrairie;
		this.mail = mail;
		this.telephone = telephone;
		this.admin = admin;
		this.adresse = adresse;
	}
	
	

	
	

	
	
	
	


}
