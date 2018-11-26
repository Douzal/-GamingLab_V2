package fr.gaminglab.orchestrateur.dto;

import java.io.Serializable;
import java.util.Date;

import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.forum.entity.SujetForum;

public class JoueurSujetForumDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public JoueurSujetForumDto() {}	
	
	
    public JoueurSujetForumDto(Integer idJoueurSujet, Date dateNote, Integer vote, Joueur joueur,SujetForum sujetForum) 
    {	
    	super();
    	this.idJoueurSujet = idJoueurSujet;
		this.dateNote = dateNote;
		this.vote = vote;
		this.joueur = joueur;
		this.sujetForum = sujetForum;
	}

	private Integer idJoueurSujet;
    private Date dateNote;
    private Integer vote;
    private Joueur joueur;
    private SujetForum sujetForum;

	public Integer getIdJoueurSujet() {
		return idJoueurSujet;
	}
	public void setIdJoueurSujet(Integer idJoueurSujet) {
		this.idJoueurSujet = idJoueurSujet;
	}
	public Date getDateNote() {
		return dateNote;
	}
	public void setDateNote(Date dateNote) {
		this.dateNote = dateNote;
	}
	public Integer getVote() {
		return vote;
	}
	public void setVote(Integer vote) {
		this.vote = vote;
	}
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public SujetForum getSujetForum() {
		return sujetForum;
	}
	public void setSujetForum(SujetForum sujetForum) {
		this.sujetForum = sujetForum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    
	
}
