package fr.gaminglab.forum.entity;

import java.io.Serializable;
import java.util.Comparator;
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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * 
 */
@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCommentaire", scope = CommentaireForum.class)
@NamedQuery(name = "CommentaireForum.findByIdCommentaireAndCommentaireSupQuery", query = "SELECT b FROM CommentaireForum b WHERE b.idCommentaireSup = :idCommentaire")
//@NamedQuery(name = "CommentaireForum.findByIdCommentaireAndCommentaireSupQuery", query = "SELECT b FROM CommentaireForum b WHERE b.idCommentaire=?1 And b.idCommentaire=b.commentaireSup.idCommentaire")
public class CommentaireForum implements Serializable, Comparable<CommentaireForum> {

	/**
	 * Default constructor
	 */
	public CommentaireForum() {
	}

	public CommentaireForum(String contenu, Date dateEmission, Integer note, SujetForum sujetForum,
			Integer idCommentaireSup, Integer idjoueur) {
		this.contenu = contenu;
		this.dateEmission = dateEmission;
		this.note = note;
		this.sujetForum = sujetForum;
		this.idCommentaireSup = idCommentaireSup;
		this.idJoueur = idjoueur;
	}
	
	public CommentaireForum(Integer idCommentaire, String contenu, Date dateEmission, Integer note,
			SujetForum sujetForum, Integer idCommentaireSup,
			Integer idJoueur) {
		super();
		this.idCommentaire = idCommentaire;
		this.contenu = contenu;
		this.dateEmission = dateEmission;
		this.note = note;
		this.sujetForum = sujetForum;
		this.idCommentaireSup = idCommentaireSup;
		this.idJoueur = idJoueur;
	}



	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@JoinColumn(name = "idSujetForum", nullable = false)
	private SujetForum sujetForum;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "idCommentaireSup")
	@JsonIgnore
	private Set<CommentaireForum> commentairesInf;

	/**
	 * 
	 */
//	@ManyToOne
//	@JoinColumn(name = "idCommentaireSup")
	@Column(name="idCommentaireSup")
	private Integer idCommentaireSup;

	/**
	 *
	 */
	@Column(name = "idJoueurCreateur", nullable = false)
	private Integer idJoueur;

	/**
	 * 
	 */
	@OneToMany(mappedBy = "commentaireForum")
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

	public Integer getIdCommentaireSup() {
		return idCommentaireSup;
	}

	public void setIdCommentaireSup(Integer paramIdCommentaireSup) {
		idCommentaireSup = paramIdCommentaireSup;
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

	@Override
	public int compareTo(CommentaireForum commentaireForum1) {
		Integer compare = 0;
		Integer noteThis = this.getNote();
		Integer noteCompare = commentaireForum1.getNote();
		if (noteThis != null && noteCompare != null) {
			compare = noteThis.compareTo(noteCompare);
			if (compare == 0) {
				Date dateEmissionThis = this.getDateEmission();
				Date dateEmissionCompare = commentaireForum1.getDateEmission();
				if (dateEmissionThis != null && dateEmissionCompare != null) {
					compare = dateEmissionThis.compareTo(dateEmissionCompare);
				}

			}
		}

		return compare;
	}

	@Override
	public String toString() {
		return "CommentaireForum [idCommentaire=" + idCommentaire + ", contenu=" + contenu + ", dateEmission="
				+ dateEmission + ", note=" + note + ", sujetForum=" + sujetForum.getIdSujet() + ", commentairesInf="
				+ commentairesInf + ", commentaireSup=" + idCommentaireSup + ", idJoueur=" + idJoueur
				+ ", joueursCommentaireForum=" + joueursCommentaireForum + "]";
	}
	
	

}