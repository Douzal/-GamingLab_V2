package fr.gaminglab.dto;

import java.io.Serializable;
import java.util.Date;

import fr.gaminglab.entity.communication.CategorieForum;
import fr.gaminglab.entity.utilisateur.Joueur;

public class SujetForumDto implements Serializable {
	
	public SujetForumDto() {}
	
	public SujetForumDto(Integer idSujet,String libelle,String descriptif, Date dateCreation, Integer note, CategorieForum categorieForum,
			Joueur joueur, Integer nombreCommentaire) {
		this.idSujet = idSujet;
		this.libelle = libelle;
		this.dateCreation = dateCreation;
		this.note = note;
		this.categorieForum = categorieForum;
		this.joueur = joueur;
		this.nombreCommentaires = nombreCommentaire;
		this.descriptif = descriptif;
	}
	
	private Integer idSujet;
	private String libelle;
	private Date dateCreation;
	private Integer note;
	private CategorieForum categorieForum;
	private Joueur joueur;
	private Integer nombreCommentaires;
	private String descriptif;
	
	public Integer getIdSujet() {
		return idSujet;
	}
	public void setIdSujet(Integer idSujet) {
		this.idSujet = idSujet;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Integer getNote() {
		return note;
	}
	public void setNote(Integer note) {
		this.note = note;
	}
	public CategorieForum getCategorieForum() {
		return categorieForum;
	}
	public void setCategorieForum(CategorieForum categorieForum) {
		this.categorieForum = categorieForum;
	}
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public Integer getNombreCommentaires() {
		return nombreCommentaires;
	}
	public void setNombreCommentaires(Integer nombreCommentaires) {
		this.nombreCommentaires = nombreCommentaires;
	}
	public String getDescriptif() {
		return descriptif;
	}
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	
	
	

}
