package fr.gaminglab.orchestrateur.dto;

import java.io.Serializable;
import java.util.Date;

import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.forum.entity.CommentaireForum;

public class JoueurCommentaireForumDto implements Serializable{
	
	public JoueurCommentaireForumDto() {		
	}
	
	public JoueurCommentaireForumDto(Integer idJoueurCommentaire, Date dateNote, Joueur joueur, Integer vote, CommentaireForum commentaireForum) {
		this.idJoueurCommentaire=idJoueurCommentaire;
		this.dateNote = dateNote;
		this.joueur = joueur;
		this.vote = vote;
		this.commentaireForum = commentaireForum;
	}
	
	 private Integer idJoueurCommentaire;
	 private Date dateNote;
     private Integer vote;
	 private Joueur joueur;
	 private CommentaireForum commentaireForum;
	 
	 public Integer getIdJoueurCommentaire() {
		return idJoueurCommentaire;
	}

	public void setIdJoueurCommentaire(Integer idJoueurCommentaire) {
		this.idJoueurCommentaire = idJoueurCommentaire;
	}

	public Date getDateNote() {
		return dateNote;
	}

	public void setDateNote(Date dateNote) {
		this.dateNote = dateNote;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Integer getVote() {
		return vote;
	}

	public void setVote(Integer vote) {
		this.vote = vote;
	}

	public CommentaireForum getCommentaireForum() {
		return commentaireForum;
	}

	public void setCommentaireForum(CommentaireForum commentaireForum) {
		this.commentaireForum = commentaireForum;
	}	
	 
	  
}
