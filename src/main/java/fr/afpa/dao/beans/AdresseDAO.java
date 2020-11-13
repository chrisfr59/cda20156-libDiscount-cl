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

@Entity(name = "adresse")
public class AdresseDAO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adresse")
	private int id_adresse;

	@Column(unique = true)
	private int numeroVoie;
	private String voie;
	private int codePostal;
	private String ville;
	
	public AdresseDAO( int numeroVoie, String voie, int codePostal, String ville) {
		super();
		this.id_adresse = id_adresse;
		this.numeroVoie = numeroVoie;
		this.voie = voie;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	
}
