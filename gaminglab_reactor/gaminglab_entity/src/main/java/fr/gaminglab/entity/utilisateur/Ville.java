package fr.gaminglab.entity.utilisateur;


import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table
public class Ville implements Serializable {

    /**
     * Default constructor
     */
    public Ville() {
    }

    public Ville(Integer departement, Integer latitude, Integer longitude, String nomVille) {
        this.departement = departement;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nomVille = nomVille;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idVille;

    /**
     * 
     */
    @Column
    private Integer departement;

    /**
     * 
     */
    @Column
    private Integer latitude;

    /**
     * 
     */
    @Column
    private Integer longitude;

    /**
     * 
     */
    @Column(nullable = false, length = 100)
    private String nomVille;

    /**
     * 
     */
    @OneToMany(mappedBy="ville")
	@JsonIgnore
    private Set<VilleCodePostal> villeCodePostaux;

    /**
     * 
     */

	public Integer getIdVille() {
		return idVille;
	}

	public void setIdVille(Integer paramIdVille) {
		idVille = paramIdVille;
	}

	public Integer getDepartement() {
		return departement;
	}

	public void setDepartement(Integer paramDepartement) {
		departement = paramDepartement;
	}

	public Integer getLatitude() {
		return latitude;
	}

	public void setLatitude(Integer paramLatitude) {
		latitude = paramLatitude;
	}

	public Integer getLongitude() {
		return longitude;
	}

	public void setLongitude(Integer paramLongitude) {
		longitude = paramLongitude;
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String paramNomVille) {
		nomVille = paramNomVille;
	}

	public Set<VilleCodePostal> getVilleCodePostaux() {
		return villeCodePostaux;
	}

	public void setVilleCodePostaux(Set<VilleCodePostal> paramVilleCodePostaux) {
		villeCodePostaux = paramVilleCodePostaux;
	}
    
    

}