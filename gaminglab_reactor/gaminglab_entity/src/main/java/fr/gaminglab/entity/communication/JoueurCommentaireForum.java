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
@Table(name = "Joueur_CommentaireForum")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idJoueurCommentaire", scope = JoueurCommentaireForum.class)
public class JoueurCommentaireForum implements Serializable {

    /**
     * Default constructor
     */
    public JoueurCommentaireForum() {
    }

    public JoueurCommentaireForum(Date dateNote, Joueur joueur, CommentaireForum commentaireForum) {
        this.dateNote = dateNote;
        this.joueur = joueur;
        this.commentaireForum = commentaireForum;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idJoueurCommentaire;

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
    @JoinColumn(name="idCommentaireForum", nullable = false)
    private CommentaireForum commentaireForum;

	public Integer getIdJoueurCommentaire() {
		return idJoueurCommentaire;
	}

	public void setIdJoueurCommentaire(Integer paramIdJoueurCommentaire) {
		idJoueurCommentaire = paramIdJoueurCommentaire;
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

	public CommentaireForum getCommentaireForum() {
		return commentaireForum;
	}

	public void setCommentaireForum(CommentaireForum paramCommentaireForum) {
		commentaireForum = paramCommentaireForum;
	}
    
    

}