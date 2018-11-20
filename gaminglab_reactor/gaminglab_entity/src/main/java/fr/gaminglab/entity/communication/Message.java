package fr.gaminglab.entity.communication;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.gaminglab.entity.utilisateur.Joueur;


/**
 * 
 */
@Entity
@Table
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idMessage", scope = Message.class)
public class Message implements Serializable {

    /**
     * Default constructor
     */
    public Message() {
    }

    public Message(String libelle, String contenu, Boolean estLu, Date dateEmission, Joueur joueurEmetteur, Joueur joueurDestinataire) {
        this.libelle = libelle;
        this.contenu = contenu;
        this.estLu = estLu;
        this.dateEmission = dateEmission;
        this.joueurEmetteur = joueurEmetteur;
        this.joueurDestinataire = joueurDestinataire;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idMessage;

    /**
     * 
     */
    @Column(nullable = false, length = 50)
    private String libelle;

    /**
     * 
     */
    @Column(nullable = false, length = 255)
    private String contenu;

    /**
     * 
     */
    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private Boolean estLu;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateEmission;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idJoueurEmetteur", nullable = false)
    private Joueur joueurEmetteur;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idJoueurDestinataire", nullable = false)
    private Joueur joueurDestinataire;

	public Integer getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Integer paramIdMessage) {
		idMessage = paramIdMessage;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String paramLibelle) {
		libelle = paramLibelle;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String paramContenu) {
		contenu = paramContenu;
	}

	public Boolean getEstLu() {
		return estLu;
	}

	public void setEstLu(Boolean paramEstLu) {
		estLu = paramEstLu;
	}

	public Date getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(Date paramDateEmission) {
		dateEmission = paramDateEmission;
	}

	public Joueur getJoueurEmetteur() {
		return joueurEmetteur;
	}

	public void setJoueurEmetteur(Joueur paramJoueurEmetteur) {
		joueurEmetteur = paramJoueurEmetteur;
	}

	public Joueur getJoueurDestinataire() {
		return joueurDestinataire;
	}

	public void setJoueurDestinataire(Joueur paramJoueurDestinataire) {
		joueurDestinataire = paramJoueurDestinataire;
	}
    
    

}