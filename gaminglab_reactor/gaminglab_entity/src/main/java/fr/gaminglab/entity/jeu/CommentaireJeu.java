package fr.gaminglab.entity.jeu;


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
import fr.gaminglab.entity.utilisateur.Joueur;

/**
 * 
 */
@Entity
@Table
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idCommentaireJeu", scope = CommentaireJeu.class)
public class CommentaireJeu implements Serializable {

    /**
     * Default constructor
     */
    public CommentaireJeu() {
    }

    public CommentaireJeu(String contenu, Date dateEmission, Jeu jeu, Joueur joueur, CommentaireJeu commentaireSup) {
        this.contenu = contenu;
        this.dateEmission = dateEmission;
        this.jeu = jeu;
        this.joueur = joueur;
        this.commentaireSup = commentaireSup;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCommentaireJeu;

    /**
     * 
     */
    @Column(nullable = false, length = 255)
    private String contenu;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEmission;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idJeu")
    private Jeu jeu;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idJoueur")
    private Joueur joueur;

    /**
     * 
     */
    @OneToMany(mappedBy="commentaireSup")
	@JsonIgnore
    private Set<CommentaireJeu> commentairesInf;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idCommentaire_sup")
    private CommentaireJeu commentaireSup;

	public Integer getIdCommentaireJeu() {
		return idCommentaireJeu;
	}

	public void setIdCommentaireJeu(Integer paramIdCommentaireJeu) {
		idCommentaireJeu = paramIdCommentaireJeu;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String paramContenu) {
		contenu = paramContenu;
	}

	public Date getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(Date paramDateEmission) {
		dateEmission = paramDateEmission;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu paramJeu) {
		jeu = paramJeu;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur paramJoueur) {
		joueur = paramJoueur;
	}

	public Set<CommentaireJeu> getCommentairesInf() {
		return commentairesInf;
	}

	public void setCommentairesInf(Set<CommentaireJeu> paramCommentairesInf) {
		commentairesInf = paramCommentairesInf;
	}

	public CommentaireJeu getCommentaireSup() {
		return commentaireSup;
	}

	public void setCommentaireSup(CommentaireJeu paramCommentaireSup) {
		commentaireSup = paramCommentaireSup;
	}
    
    

}