package fr.gaminglab.entity.utilisateur;


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
import fr.gaminglab.entity.boutique.Commande;

/**
 * 
 */
@Entity
@Table(name="Joueur_Carte")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idJoueurCarte", scope = JoueurCarte.class)
public class JoueurCarte implements Serializable {

    /**
     * Default constructor
     */
    public JoueurCarte() {
    }

    public JoueurCarte(String nomTitulaire, String prenomTitulaire, String numeroCarte, String codeVerification, Date dateExpiration, Joueur joueur, TypeCarte typeCarte) {
        this.nomTitulaire = nomTitulaire;
        this.prenomTitulaire = prenomTitulaire;
        this.numeroCarte = numeroCarte;
        this.codeVerification = codeVerification;
        this.dateExpiration = dateExpiration;
        this.joueur = joueur;
        this.typeCarte = typeCarte;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idJoueurCarte;

    /**
     * 
     */
    @Column(nullable = false, length = 50)
    private String nomTitulaire;

    /**
     * 
     */
    @Column(nullable = false, length = 50)
    private String prenomTitulaire;

    /**
     * 
     */
    @Column(nullable = false, length = 15)
    private String numeroCarte;

    /**
     * 
     */
    @Column(nullable = false, length = 5)
    private String codeVerification;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateExpiration;

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
    @JoinColumn(name="idTypeCarte", nullable = false)
    private TypeCarte typeCarte;

    /**
     * 
     */
    @OneToMany(mappedBy="joueurCarte")
	@JsonIgnore
    private Set<Commande> commandes;

	@Override
	public String toString() {
		return "JoueurCarte{" +
				"idJoueurCarte=" + idJoueurCarte +
				", nomTitulaire='" + nomTitulaire + '\'' +
				", prenomTitulaire='" + prenomTitulaire + '\'' +
				", numeroCarte='" + numeroCarte + '\'' +
				", codeVerification='" + codeVerification + '\'' +
				", dateExpiration=" + dateExpiration +
				", joueur=" + joueur +
				", typeCarte=" + typeCarte +
				", commandes=" + commandes +
				'}';
	}

	public Integer getIdJoueurCarte() {
		return idJoueurCarte;
	}

	public void setIdJoueurCarte(Integer paramIdJoueurCarte) {
		idJoueurCarte = paramIdJoueurCarte;
	}

	public String getNomTitulaire() {
		return nomTitulaire;
	}

	public void setNomTitulaire(String paramNomTitulaire) {
		nomTitulaire = paramNomTitulaire;
	}

	public String getPrenomTitulaire() {
		return prenomTitulaire;
	}

	public void setPrenomTitulaire(String paramPrenomTitulaire) {
		prenomTitulaire = paramPrenomTitulaire;
	}

	public String getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(String paramNumeroCarte) {
		numeroCarte = paramNumeroCarte;
	}

	public String getCodeVerification() {
		return codeVerification;
	}

	public void setCodeVerification(String paramCodeVerification) {
		codeVerification = paramCodeVerification;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date paramDateExpiration) {
		dateExpiration = paramDateExpiration;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur paramJoueur) {
		joueur = paramJoueur;
	}

	public TypeCarte getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(TypeCarte paramTypeCarte) {
		typeCarte = paramTypeCarte;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> paramCommandes) {
		commandes = paramCommandes;
	}
    
    

}