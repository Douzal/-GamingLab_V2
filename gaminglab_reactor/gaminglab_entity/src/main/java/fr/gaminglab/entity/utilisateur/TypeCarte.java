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
public class TypeCarte implements Serializable {

    /**
     * Default constructor
     */
    public TypeCarte() {
    }

    public TypeCarte(String libelle) {
        this.libelle = libelle;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idTypeCarte;

    /**
     * 
     */
    @Column(nullable = false, length = 50)
    private String libelle;

    /**
     * 
     */
    @OneToMany(mappedBy="typeCarte")
	@JsonIgnore
    private Set<JoueurCarte> joueurCartes;

	public Integer getIdTypeCarte() {
		return idTypeCarte;
	}

	public void setIdTypeCarte(Integer paramIdTypeCarte) {
		idTypeCarte = paramIdTypeCarte;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String paramLibelle) {
		libelle = paramLibelle;
	}

	public Set<JoueurCarte> getJoueurCartes() {
		return joueurCartes;
	}

	public void setJoueurCartes(Set<JoueurCarte> paramJoueurCartes) {
		joueurCartes = paramJoueurCartes;
	}

    
}