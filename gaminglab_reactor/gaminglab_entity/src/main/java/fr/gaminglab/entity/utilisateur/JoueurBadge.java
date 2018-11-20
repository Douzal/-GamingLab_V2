package fr.gaminglab.entity.utilisateur;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 */
@Entity
@Table(name = "Joueur_Badge")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idJoueurBadge", scope = JoueurBadge.class)
public class JoueurBadge implements Serializable {

    /**
     * Default constructor
     */
    public JoueurBadge() {
    }

    public JoueurBadge(Integer compteur, Date dateDebloque, Badge badge, Joueur joueur) {
        this.compteur = compteur;
        this.dateDebloque = dateDebloque;
        this.badge = badge;
        this.joueur = joueur;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idJoueurBadge;

    /**
     * 
     */
    @Column(nullable = false)
    private Integer compteur;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebloque;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idBadge", nullable = false)
    private Badge badge;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idJoueur", nullable = false)
    private Joueur joueur;

	public Integer getIdJoueurBadge() {
		return idJoueurBadge;
	}

	public void setIdJoueurBadge(Integer paramIdJoueurBadge) {
		idJoueurBadge = paramIdJoueurBadge;
	}

	public Integer getCompteur() {
		return compteur;
	}

	public void setCompteur(Integer paramCompteur) {
		compteur = paramCompteur;
	}

	public Date getDateDebloque() {
		return dateDebloque;
	}

	public void setDateDebloque(Date paramDateDebloque) {
		dateDebloque = paramDateDebloque;
	}

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge paramBadge) {
		badge = paramBadge;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur paramJoueur) {
		joueur = paramJoueur;
	}
    
    

}