package fr.gaminglab.entity.jeu;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.gaminglab.entity.utilisateur.Joueur;

/**
 * 
 */
@Entity
@Table(name = "Joueur_Jeu")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idJoueurJeu", scope = JoueurJeu.class)
public class JoueurJeu implements Serializable {

    /**
     * Default constructor
     */
    public JoueurJeu() {
    }

    public JoueurJeu(Integer score, Date tempsJeu, Date dateJouer, Jeu jeu, Joueur joueur) {
        this.score = score;
        this.tempsJeu = tempsJeu;
        this.dateJouer = dateJouer;
        this.jeu = jeu;
        this.joueur = joueur;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idJoueurJeu;

    /**
     * 
     */
    @Column
    private Integer score;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date tempsJeu;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateJouer;

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

	public Integer getIdJoueurJeu() {
		return idJoueurJeu;
	}

	public void setIdJoueurJeu(Integer paramIdJoueurJeu) {
		idJoueurJeu = paramIdJoueurJeu;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer paramScore) {
		score = paramScore;
	}

	public Date getTempsJeu() {
		return tempsJeu;
	}

	public void setTempsJeu(Date paramTempsJeu) {
		tempsJeu = paramTempsJeu;
	}

	public Date getDateJouer() {
		return dateJouer;
	}

	public void setDateJouer(Date paramDateJouer) {
		dateJouer = paramDateJouer;
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
    
    

}