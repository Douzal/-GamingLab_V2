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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idUtilisateur", scope = Utilisateur.class)
public class Utilisateur implements Serializable {

    /**
     * Default constructor
     */
    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String mail, String pseudo, String password, Date dateInscription, Date dateDesinscription, Civilite civilite) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.pseudo = pseudo;
        this.password = password;
        this.dateInscription = dateInscription;
        this.dateDesinscription = dateDesinscription;
        this.civilite = civilite;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idUtilisateur;

    /**
     * 
     */
    @Column(nullable = false, length = 50)
    private String nom;

    /**
     * 
     */
    @Column(nullable = false, length = 50)
    private String prenom;

    /**
     * 
     */
    @Column(nullable = false, length = 50)
    private String mail;

    /**
     * 
     */
    @Column(nullable = false, length = 50)
    private String pseudo;

    /**
     * 
     */
    @Column(nullable = false, length = 50)
    private String password;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateInscription;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDesinscription;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idCivilite")
    private Civilite civilite;

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Date getDateDesinscription() {
        return dateDesinscription;
    }

    public void setDateDesinscription(Date dateDesinscription) {
        this.dateDesinscription = dateDesinscription;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }
    
}