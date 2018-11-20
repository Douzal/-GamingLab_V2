package fr.gaminglab.entity.boutique;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.gaminglab.entity.utilisateur.Adresse;
import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.entity.utilisateur.JoueurCarte;

/**
 * 
 */
@Entity
@Table
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idCommande", scope = Commande.class)
public class Commande implements Serializable {

    /**
     * Default constructor
     */
    public Commande() {
    }

	public Commande(Integer idSession, Date dateEnregistrement, Date dateAnnulation, Date dateLivraison, JoueurCarte joueurCarte, Set<LigneCommande> lignesCommande, Joueur joueur, Adresse adresse, EtatCommande etatCommande, Boolean terminee, Boolean aPayeCredit, Double prixTotal, Double creditTotal) {
		this.idSession = idSession;
		this.dateEnregistrement = dateEnregistrement;
		this.dateAnnulation = dateAnnulation;
		this.dateLivraison = dateLivraison;
		this.joueurCarte = joueurCarte;
		this.lignesCommande = lignesCommande;
		this.joueur = joueur;
		this.adresse = adresse;
		this.etatCommande = etatCommande;
		this.terminee = terminee;
		this.aPayeCredit = aPayeCredit;
		this.prixTotal = prixTotal;
		this.creditTotal = creditTotal;
	}

	/**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCommande;

    /**
     * 
     */
    @Column
    private Integer idSession;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateEnregistrement;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAnnulation;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLivraison;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idJoueurCarte")
    private JoueurCarte joueurCarte;

    /**
     * 
     */
    @OneToMany(mappedBy="commande")
    private Set<LigneCommande> lignesCommande;

	/**
	 *
	 */
	@ManyToOne
	@JoinColumn(name="idJoueur", nullable = false)
	private Joueur joueur;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idAdresse")
    private Adresse adresse;

    /**
     *
     */
    @ManyToOne
    @JoinColumn(name="idEtatCommande", nullable = false)
    private EtatCommande etatCommande;

    /**
     *
     */
    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private Boolean terminee;

	/**
	 *
	 */
	@Column(columnDefinition = "TINYINT(1)")
	private Boolean aPayeCredit;

	/**
	 *
	 */
	@Column(columnDefinition = "DECIMAL(10,2)")
	private Double prixTotal;

	/**
	 *
	 */
	@Column(columnDefinition = "DECIMAL(10,2)")
	private Double creditTotal;

	public static void calculPrixTotal(Commande cmd) {
		if (cmd.getLignesCommande().size() >= 1) {
			double prix = 0;
			double credit = 0;
			for (LigneCommande ligneCommande : cmd.getLignesCommande()) {
				prix = prix + ligneCommande.getQuantite() * ligneCommande.getArticle().getPrix();
				credit = credit + ligneCommande.getQuantite()*ligneCommande.getArticle().getCredit();
			}
			cmd.setPrixTotal(prix);
			cmd.setCreditTotal(credit);
		} else {
			cmd.setPrixTotal(0d);
			cmd.setCreditTotal(0d);
		}
	}



	public Integer getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Integer paramIdCommande) {
		idCommande = paramIdCommande;
	}

	public Integer getIdSession() {
		return idSession;
	}

	public void setIdSession(Integer paramIdSession) {
		idSession = paramIdSession;
	}

	public Date getDateEnregistrement() {
		return dateEnregistrement;
	}

	public void setDateEnregistrement(Date paramDateEnregistrement) {
		dateEnregistrement = paramDateEnregistrement;
	}

	public Date getDateAnnulation() {
		return dateAnnulation;
	}

	public void setDateAnnulation(Date paramDateAnnulation) {
		dateAnnulation = paramDateAnnulation;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date paramDateLivraison) {
		dateLivraison = paramDateLivraison;
	}

	public JoueurCarte getJoueurCarte() {
		return joueurCarte;
	}

	public void setJoueurCarte(JoueurCarte paramJoueurCarte) {
		joueurCarte = paramJoueurCarte;
	}

	public Set<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(Set<LigneCommande> paramLignesCommande) {
		lignesCommande = paramLignesCommande;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur paramJoueur) {
		joueur = paramJoueur;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse paramAdresse) {
		adresse = paramAdresse;
	}

	public EtatCommande getEtatCommande() {
		return etatCommande;
	}

	public void setEtatCommande(EtatCommande paramEtatCommande) {
		etatCommande = paramEtatCommande;
	}

	public Boolean getTerminee() {
		return terminee;
	}

	public void setTerminee(Boolean paramTerminee) {
		terminee = paramTerminee;
	}

	public Double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(Double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Double getCreditTotal() {
		return creditTotal;
	}

	public void setCreditTotal(Double creditTotal) {
		this.creditTotal = creditTotal;
	}

	public Boolean getaPayeCredit() {
		return aPayeCredit;
	}

	public void setaPayeCredit(Boolean aPayeCredit) {
		this.aPayeCredit = aPayeCredit;
	}
}