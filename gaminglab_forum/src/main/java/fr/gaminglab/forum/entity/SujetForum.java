package fr.gaminglab.forum.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * 
 */
@Entity
@Table
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idSujet", scope = SujetForum.class)
public class SujetForum implements Serializable {

    /**
     * Default constructor
     */
    public SujetForum() {
    }

    public SujetForum(String libelle, String descriptif, Date dateCreation, Integer note, CategorieForum categorieForum,
			Integer idJoueur) {
		this.libelle = libelle;
		this.descriptif = descriptif;
		this.dateCreation = dateCreation;
		this.note = note;
		this.categorieForum = categorieForum;
		this.idJoueurCreateur = idJoueur;
	}
    
    

	public SujetForum(Integer idSujet, String libelle, String descriptif, Date dateCreation, Integer note,
			Set<CommentaireForum> commentairesForum, CategorieForum categorieForum, Integer idJoueurCreateur
			) {
		super();
		this.idSujet = idSujet;
		this.libelle = libelle;
		this.descriptif = descriptif;
		this.dateCreation = dateCreation;
		this.note = note;
		this.categorieForum = categorieForum;
		this.idJoueurCreateur = idJoueurCreateur;
	}



	/**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idSujet;

    /**
     * 
     */
    @Column(nullable = false, length = 150)
    private String libelle;
    
    /**
     * 
     */
    @Column(nullable = false, length = 500)
    private String descriptif;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateCreation;

    /**
     * 
     */
    @Column(nullable = false)
    private Integer note;

    /**
     * 
     */
    @OneToMany(mappedBy="sujetForum")
    @JsonIgnore
    private Set<CommentaireForum> commentairesForum;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idCategorieForum", nullable = false)
    private CategorieForum categorieForum;

    /**
     *
     */
    @Column(nullable = false)
    private Integer idJoueurCreateur;

    /**
     * 
     */
    @OneToMany(mappedBy="sujetForum")
	@JsonIgnore
    private Set<JoueurSujetForum> joueursSujetForum;

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

	public Set<CommentaireForum> getCommentairesForum() {
		return commentairesForum;
	}

	public void setCommentairesForum(Set<CommentaireForum> paramCommentairesForum) {
		commentairesForum = paramCommentairesForum;
	}

	public CategorieForum getCategorieForum() {
		return categorieForum;
	}

	public void setCategorieForum(CategorieForum paramCategorieForum) {
		categorieForum = paramCategorieForum;
	}

	public Set<JoueurSujetForum> getJoueursSujetForum() {
		return joueursSujetForum;
	}

	public void setJoueursSujetForum(Set<JoueurSujetForum> paramJoueursSujetForum) {
		joueursSujetForum = paramJoueursSujetForum;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public Integer getIdJoueurCreateur() {
		return idJoueurCreateur;
	}

	public void setIdJoueurCreateur(Integer idJoueur) {
		this.idJoueurCreateur = idJoueur;
	}
	
}