package fr.gaminglab.entity.communication;

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

import com.fasterxml.jackson.annotation.*;
import fr.gaminglab.entity.jeu.Jeu;
import fr.gaminglab.entity.utilisateur.Joueur;

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

    public SujetForum(String libelle, Date dateCreation, Integer note, CategorieForum categorieForum, Joueur joueur) {
        this.libelle = libelle;
        this.dateCreation = dateCreation;
        this.note = note;
        this.categorieForum = categorieForum;
        this.joueur = joueur;
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
    @ManyToOne
    @JoinColumn(name="idJoueurCreateur")
    private Joueur joueur;

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

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur paramJoueur) {
		joueur = paramJoueur;
	}

	public Set<JoueurSujetForum> getJoueursSujetForum() {
		return joueursSujetForum;
	}

	public void setJoueursSujetForum(Set<JoueurSujetForum> paramJoueursSujetForum) {
		joueursSujetForum = paramJoueursSujetForum;
	}
    
    

}