package fr.gaminglab.orchestrateur.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.forum.entity.CategorieForum;
import fr.gaminglab.forum.entity.JoueurSujetForum;

public class SujetForumDto implements Serializable {

	public SujetForumDto(Integer idSujet,String libelle,String descriptif, Date dateCreation, Integer note, CategorieForum categorieForum,
			Joueur joueur, Integer nombreCommentaire) {
		this.idSujet = idSujet;
		this.libelle = libelle;
		this.dateCreation = dateCreation;
		this.note = note;
		this.categorieForum = categorieForum;
		this.joueur = joueur;
		this.nombreCommentaires = nombreCommentaire;
	}

	/**
	 * 
	 */
	private Integer idSujet;

	/**
	 * 
	 */
	private String libelle;
	
	/**
	 * 
	 */
	private String descriptif;

	/**
	 * 
	 */
	private Date dateCreation;

	/**
	 * 
	 */
	private Integer note;

	/**
	 * 
	 */
	private Integer nombreCommentaires;

	/**
	 * 
	 */
	private CategorieForum categorieForum;

	/**
	 *
	 */
	private Joueur joueur;

	public Integer getIdSujet() {
		return idSujet;
	}

	public void setIdSujet(Integer paramIdSujet) {
		idSujet = paramIdSujet;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String paramLibelle) {
		libelle = paramLibelle;
	}
	
	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date paramDateCreation) {
		dateCreation = paramDateCreation;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer paramNote) {
		note = paramNote;
	}

	public Integer getNombreCommentaires() {
		return nombreCommentaires;
	}

	public void setNombreCommentaires(Integer nombreCommentaires) {
		this.nombreCommentaires = nombreCommentaires;
	}

	public CategorieForum getCategorieForum() {
		return categorieForum;
	}

	public void setCategorieForum(CategorieForum paramCategorieForum) {
		categorieForum = paramCategorieForum;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur paramJoueur) {
		joueur = paramJoueur;
	}

}
