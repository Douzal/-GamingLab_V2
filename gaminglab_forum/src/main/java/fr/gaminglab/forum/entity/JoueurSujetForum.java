package fr.gaminglab.forum.entity;

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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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

    public JoueurSujetForum(Date dateNote, Integer vote, Integer idJoueur, SujetForum sujetForum) {
		super();
		this.dateNote = dateNote;
		this.vote = vote;
		this.idJoueur = idJoueur;
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
    @Column(nullable = false)
    private Integer vote;

    /**
     * 
     */
    @Column(nullable = false)
    private Integer idJoueur;

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

	public Integer getIdJoueur() {
		return idJoueur;
	}

	public void setJoueur(Integer paramIdJoueur) {
		idJoueur = paramIdJoueur;
	}

	public SujetForum getSujetForum() {
		return sujetForum;
	}

	public void setSujetForum(SujetForum paramSujetForum) {
		sujetForum = paramSujetForum;
	}

	public Integer getVote() {
		return vote;
	}

	public void setVote(Integer vote) {
		this.vote = vote;
	}

	public void setIdJoueur(Integer idJoueur) {
		this.idJoueur = idJoueur;
	}
    
}