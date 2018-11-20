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
import fr.gaminglab.entity.utilisateur.Joueur;

/**
 * 
 */
@Entity
@Table
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idCommentaire", scope = CommentaireForum.class)
public class CommentaireForum implements Serializable {

    /**
     * Default constructor
     */
    public CommentaireForum() {
    }

    public CommentaireForum(String contenu, Date dateEmission, Integer note, SujetForum sujetForum, CommentaireForum commentaireSup, Joueur joueur) {
        this.contenu = contenu;
        this.dateEmission = dateEmission;
        this.note = note;
        this.sujetForum = sujetForum;
        this.commentaireSup = commentaireSup;
        this.joueur = joueur;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCommentaire;

    /**
     * 
     */
    @Column(nullable = false, length = 255)
    private String contenu;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateEmission;

    /**
     * 
     */
    @Column(nullable = false)
    private Integer note;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idSujetForum", nullable = false)
	private SujetForum sujetForum;

    /**
     * 
     */
    @OneToMany(mappedBy="commentaireSup")
	@JsonIgnore
    private Set<CommentaireForum> commentairesInf;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idCommentaireSup")
    private CommentaireForum commentaireSup;

    /**
     *
     */
    @ManyToOne
    @JoinColumn(name="idJoueurCreateur", nullable = false)
    private Joueur joueur;

    /**
     * 
     */
    @OneToMany(mappedBy="commentaireForum")
	@JsonIgnore
    private Set<JoueurCommentaireForum> joueursCommentaireForum;

	public Integer getIdCommentaire() {
		return idCommentaire;
	}

	public void setIdCommentaire(Integer paramIdCommentaire) {
		idCommentaire = paramIdCommentaire;
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

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer paramNote) {
		note = paramNote;
	}

	public SujetForum getSujetForum() {
		return sujetForum;
	}

	public void setSujetForum(SujetForum paramSujetForum) {
		sujetForum = paramSujetForum;
	}

	public Set<CommentaireForum> getCommentairesInf() {
		return commentairesInf;
	}

	public void setCommentairesInf(Set<CommentaireForum> paramCommentairesInf) {
		commentairesInf = paramCommentairesInf;
	}

	public CommentaireForum getCommentaireSup() {
		return commentaireSup;
	}

	public void setCommentaireSup(CommentaireForum paramCommentaireSup) {
		commentaireSup = paramCommentaireSup;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur paramJoueur) {
		joueur = paramJoueur;
	}

	public Set<JoueurCommentaireForum> getJoueursCommentaireForum() {
		return joueursCommentaireForum;
	}

	public void setJoueursCommentaireForum(Set<JoueurCommentaireForum> paramJoueursCommentaireForum) {
		joueursCommentaireForum = paramJoueursCommentaireForum;
	}

    
}