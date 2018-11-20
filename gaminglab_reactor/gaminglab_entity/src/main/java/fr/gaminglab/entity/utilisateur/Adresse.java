package fr.gaminglab.entity.utilisateur;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.*;
import fr.gaminglab.entity.boutique.Commande;

/**
 * 
 */
@Entity
@Table
public class Adresse implements Serializable {

    /**
     * Default constructor
     */
    public Adresse() {
    }

    public Adresse(Integer numero, String voie, String libelle, String prenomDestinataire, String nomDestinataire, Joueur joueur, VilleCodePostal villeCodePostal) {
        this.numero = numero;
        this.voie = voie;
        this.libelle = libelle;
        this.prenomDestinataire = prenomDestinataire;
        this.nomDestinataire = nomDestinataire;
        this.joueur = joueur;
        this.villeCodePostal = villeCodePostal;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idAdresse;

    /**
     * 
     */
    @Column(nullable = false)
    private Integer numero;

    /**
     * 
     */
    @Column(nullable = false)
    private String voie;

    /**
     * 
     */
    @Column(nullable = false, length = 100)
    private String libelle;

    /**
     * 
     */
    @Column(nullable = false, length = 50)
    private String prenomDestinataire;

    /**
     * 
     */
    @Column(nullable = false, length = 50)
    private String nomDestinataire;

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
    @JoinColumn(name="idVilleCodePostal", nullable = false)
    private VilleCodePostal villeCodePostal;

    /**
     * 
     */
    @OneToMany(mappedBy="adresse")
    @JsonIgnore
    private Set<Commande> commandes;

    public Integer getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Integer idAdresse) {
        this.idAdresse = idAdresse;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getPrenomDestinataire() {
        return prenomDestinataire;
    }

    public void setPrenomDestinataire(String prenomDestinataire) {
        this.prenomDestinataire = prenomDestinataire;
    }

    public String getNomDestinataire() {
        return nomDestinataire;
    }

    public void setNomDestinataire(String nomDestinataire) {
        this.nomDestinataire = nomDestinataire;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }

    public VilleCodePostal getVilleCodePostal() {
        return villeCodePostal;
    }

    public void setVilleCodePostal(VilleCodePostal villeCodePostal) {
        this.villeCodePostal = villeCodePostal;
    }
}