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
import javax.persistence.NamedQuery;
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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idCommentaire", scope = CommentaireForum.class)
//@NamedQuery(name="CommentaireForum.findBySujetForumTest",
//            query="SELECT b FROM SujetForum b,CategorieForum c WHERE b.idCategorieForum=c.idCategorie and c.idCategorie=?2")
@NamedQuery(name="CommentaireForum.findBySujetForumTest" , 
            query="SELECT b FROM CategorieForum b WHERE b.idCategorie >= ?2")
public class CommentaireForum implements Serializable {

    /**
     * Default constructor
     */
    public CommentaireForum() {
    }

    public CommentaireForum(String contenu, Date dateEmission, Integer vote, SujetForum sujetForum, CommentaireForum commentaireSup, Integer idjoueur) {
        this.contenu = contenu;
        this.dateEmission = dateEmission;
        this.vote = vote;
        this.sujetForum = sujetForum;
        this.commentaireSup = commentaireSup;
        this.idJoueur = idjoueur;
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
    private Integer vote;

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
    @Column(name="idJoueurCreateur", nullable = false)
    private Integer idJoueur;

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

	public Integer getVote() {
		return vote;
	}

	public void setNote(Integer paramVote) {
		vote = paramVote;
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

	public Integer getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(Integer paramIdJoueur) {
		idJoueur = paramIdJoueur;
	}

	public Set<JoueurCommentaireForum> getJoueursCommentaireForum() {
		return joueursCommentaireForum;
	}

	public void setJoueursCommentaireForum(Set<JoueurCommentaireForum> paramJoueursCommentaireForum) {
		joueursCommentaireForum = paramJoueursCommentaireForum;
	}

    
}