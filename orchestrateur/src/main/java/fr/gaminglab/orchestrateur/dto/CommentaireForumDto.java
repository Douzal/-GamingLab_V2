package fr.gaminglab.orchestrateur.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.forum.entity.CommentaireForum;
import fr.gaminglab.forum.entity.JoueurCommentaireForum;
import fr.gaminglab.forum.entity.SujetForum;

public class CommentaireForumDto implements Serializable {
	
	public CommentaireForumDto() {		
	}
	
	public CommentaireForumDto(Integer idCommentaire, String contenu, Date dateEmission, Integer note, SujetForum sujetForum,
			CommentaireForum commentaireSup, Joueur joueur) {
		this.idCommentaire = idCommentaire;
		this.contenu = contenu;
		this.dateEmission = dateEmission;
		this.note = note;
		this.sujetForum = sujetForum;
		this.commentaireSup = commentaireSup;
		this.joueur = joueur;
	}
	
	private Integer idCommentaire;
	private String contenu;
	private Date dateEmission;
	private Integer note;
	private SujetForum sujetForum;
	private Set<CommentaireForum> commentairesInf;
	private CommentaireForum commentaireSup;
	private Joueur joueur;
	
	@JsonIgnore
	private Set<JoueurCommentaireForum> joueursCommentaireForum;
	public Integer getIdCommentaire() {
		return idCommentaire;
	}

	public void setIdCommentaire(Integer idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(Date dateEmission) {
		this.dateEmission = dateEmission;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public SujetForum getSujetForum() {
		return sujetForum;
	}

	public void setSujetForum(SujetForum sujetForum) {
		this.sujetForum = sujetForum;
	}

	public Set<CommentaireForum> getCommentairesInf() {
		return commentairesInf;
	}

	public void setCommentairesInf(Set<CommentaireForum> commentairesInf) {
		this.commentairesInf = commentairesInf;
	}

	public CommentaireForum getCommentaireSup() {
		return commentaireSup;
	}

	public void setCommentaireSup(CommentaireForum commentaireSup) {
		this.commentaireSup = commentaireSup;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Set<JoueurCommentaireForum> getJoueursCommentaireForum() {
		return joueursCommentaireForum;
	}

	public void setJoueursCommentaireForum(Set<JoueurCommentaireForum> joueursCommentaireForum) {
		this.joueursCommentaireForum = joueursCommentaireForum;
	}
	
	
}
