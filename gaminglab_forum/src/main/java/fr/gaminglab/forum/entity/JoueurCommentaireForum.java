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
@Table(name = "Joueur_CommentaireForum")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idJoueurCommentaire", scope = JoueurCommentaireForum.class)
public class JoueurCommentaireForum implements Serializable {

    /**
     * Default constructor
     */
    public JoueurCommentaireForum() {
    }

    public JoueurCommentaireForum(Date dateNote, Integer idJoueur, Integer vote, CommentaireForum commentaireForum) {
		this.dateNote = dateNote;
		this.idJoueur = idJoueur;
		this.vote = vote;
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
    @Column(nullable = false)
    private Integer idJoueur;
    
    /**
     * 
     */
    @Column(nullable = false)
    private Integer vote;

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

	public CommentaireForum getCommentaireForum() {
		return commentaireForum;
	}

	public void setCommentaireForum(CommentaireForum paramCommentaireForum) {
		commentaireForum = paramCommentaireForum;
	}

	public Integer getVote() {
		return vote;
	}

	public void setVote(Integer vote) {
		this.vote = vote;
	}
	
	public Integer getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(Integer idJoueur) {
		this.idJoueur = idJoueur;
	}
    
}