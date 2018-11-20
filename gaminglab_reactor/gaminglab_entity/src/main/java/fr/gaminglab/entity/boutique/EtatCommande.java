package fr.gaminglab.entity.boutique;

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
public class EtatCommande implements Serializable {

    /**
     * Default constructor
     */
    public EtatCommande() {
    }

    public EtatCommande(String libelle) {
        this.libelle = libelle;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idEtatCommande;

    /**
     * 
     */
    @Column(nullable = false, length = 150)
    private String libelle;

    /**
     * 
     */
    @OneToMany(mappedBy="etatCommande")
	@JsonIgnore
    private Set<Commande> commandes;

	public Integer getIdEtatCommande() {
		return idEtatCommande;
	}

	public void setIdEtatCommande(Integer paramIdEtatCommande) {
		idEtatCommande = paramIdEtatCommande;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String paramLibelle) {
		libelle = paramLibelle;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> paramCommandes) {
		commandes = paramCommandes;
	}
    
    

}