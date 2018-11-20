package fr.gaminglab.entity.communication;

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

import com.fasterxml.jackson.annotation.*;
import fr.gaminglab.entity.utilisateur.Joueur;

/**
 * 
 */
@Entity
@Table(name = "Joueur_SujetForum")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idJoueurSujet", scope = JoueurSujetForum.class)
public class JoueurSujetForum implements Serializable {

    /**
     * Default constructor
     */
    public JoueurSujetForum() {
    }

    public JoueurSujetForum(Date dateNote, Joueur joueur, SujetForum sujetForum) {
        this.dateNote = dateNote;
        this.joueur = joueur;
        this.sujetForum = sujetForum;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idJoueurSujet;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateNote;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idJoueur", nullable = false)
    private Joueur joueur;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idSujetForum", nullable = false)
    private SujetForum sujetForum;

	public Integer getIdJoueurSujet() {
		return idJoueurSujet;
	}

	public void setIdJoueurSujet(Integer paramIdJoueurSujet) {
		idJoueurSujet = paramIdJoueurSujet;
	}

	public Date getDateNote() {
		return dateNote;
	}

	public void setDateNote(Date paramDateNote) {
		dateNote = paramDateNote;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur paramJoueur) {
		joueur = paramJoueur;
	}

	public SujetForum getSujetForum() {
		return sujetForum;
	}

	public void setSujetForum(SujetForum paramSujetForum) {
		sujetForum = paramSujetForum;
	}
    
    

}