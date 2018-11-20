package fr.gaminglab.entity.utilisateur;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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

/**
 * 
 */
@Entity
@Table
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idDemandeSuspension", scope = DemandeSuspension.class)
public class DemandeSuspension implements Serializable {

    /**
     * Default constructor
     */
    public DemandeSuspension() {
    }

    public DemandeSuspension(String contenu, Date dateEmission, Joueur joueurConcerne, Joueur joueurDemande, Admin admin, Motif motif) {
        this.contenu = contenu;
        this.dateEmission = dateEmission;
        this.joueurConcerne = joueurConcerne;
        this.joueurDemande = joueurDemande;
        this.admin = admin;
        this.motif = motif;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idDemandeSuspension;

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
    @ManyToOne
    @JoinColumn(name="idJoueurConcerne", nullable = false)
    private Joueur joueurConcerne;

    /**
     *
     */
    @ManyToOne
    @JoinColumn(name="idJoueurDemande", nullable = false)
    private Joueur joueurDemande;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idAdmin", nullable = false)
    private Admin admin;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idMotif", nullable = false)
    private Motif motif;

	public Integer getIdDemandeSuspension() {
		return idDemandeSuspension;
	}

	public void setIdDemandeSuspension(Integer paramIdDemandeSuspension) {
		idDemandeSuspension = paramIdDemandeSuspension;
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

	public Joueur getJoueurConcerne() {
		return joueurConcerne;
	}

	public void setJoueurConcerne(Joueur paramJoueurConcerne) {
		joueurConcerne = paramJoueurConcerne;
	}

	public Joueur getJoueurDemande() {
		return joueurDemande;
	}

	public void setJoueurDemande(Joueur paramJoueurDemande) {
		joueurDemande = paramJoueurDemande;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin paramAdmin) {
		admin = paramAdmin;
	}

	public Motif getMotif() {
		return motif;
	}

	public void setMotif(Motif paramMotif) {
		motif = paramMotif;
	}
    
    

}