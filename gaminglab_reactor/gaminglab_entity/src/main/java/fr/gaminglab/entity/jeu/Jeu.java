package fr.gaminglab.entity.jeu;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import fr.gaminglab.entity.boutique.Article;
import fr.gaminglab.entity.utilisateur.Joueur;
import org.hibernate.annotations.Type;

/**
 * 
 */
@Entity
@Table
public class Jeu implements Serializable {

    /**
     * Default constructor
     */
    public Jeu() {
    }

    public Jeu(String libelle, String description, Integer creditPlus, Date dateAjout, Date dateRefus, Date dateDemande, String motifRefus, String imageJeu, Boolean estCompatibleMobile, String lien, Integer nbPartie, Joueur joueur, CategorieJeu categorieJeu) {
        this.libelle = libelle;
        this.description = description;
        this.creditPlus = creditPlus;
        this.dateAjout = dateAjout;
        this.dateRefus = dateRefus;
        this.dateDemande = dateDemande;
        this.motifRefus = motifRefus;
        this.imageJeu = imageJeu;
        this.estCompatibleMobile = estCompatibleMobile;
        this.lien = lien;
        this.nbPartie = nbPartie;
        this.joueur = joueur;
        this.categorieJeu = categorieJeu;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idJeu;

    /**
     * 
     */
    @Column(nullable = false)
    private String libelle;

    /**
     *
     */
    @Column(nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String description;

    /**
     * 
     */
    @Column
    private Integer creditPlus;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAjout;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRefus;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDemande;

    /**
     * 
     */
    @Column(length = 255)
    private String motifRefus;

    /**
     * 
     */
    @Column(length = 150)
    private String imageJeu;

    /**
     * 
     */
    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private Boolean estCompatibleMobile;

    /**
     * 
     */
    @Column(length = 150)
    private String lien;

    /**
     *
     */
    @Column(nullable = false)
    private Integer nbPartie;


    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idJoueur")
    private Joueur joueur;

	/**
	 *
	 */
	@OneToMany(mappedBy="jeu")
    @JsonIgnore
	private Set<CommentaireJeu> commentairesJeu;

    /**
     * 
     */
    @OneToMany(mappedBy="jeu")
    private Set<JeuTag> jeuTags;

    /**
     * 
     */
    @OneToMany(mappedBy="jeu")
    @JsonIgnore
    private Set<JoueurJeu> joueursJeu;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idCategorieJeu")
    private CategorieJeu categorieJeu;

    public Integer getIdJeu() {
        return idJeu;
    }

    public void setIdJeu(Integer idJeu) {
        this.idJeu = idJeu;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getCreditPlus() {
        return creditPlus;
    }

    public void setCreditPlus(Integer creditPlus) {
        this.creditPlus = creditPlus;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Date getDateRefus() {
        return dateRefus;
    }

    public void setDateRefus(Date dateRefus) {
        this.dateRefus = dateRefus;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public String getMotifRefus() {
        return motifRefus;
    }

    public void setMotifRefus(String motifRefus) {
        this.motifRefus = motifRefus;
    }

    public String getImageJeu() {
        return imageJeu;
    }

    public void setImageJeu(String imageJeu) {
        this.imageJeu = imageJeu;
    }

    public Boolean getEstCompatibleMobile() {
        return estCompatibleMobile;
    }

    public void setEstCompatibleMobile(Boolean estCompatibleMobile) {
        this.estCompatibleMobile = estCompatibleMobile;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Integer getNbPartie() {
        return nbPartie;
    }

    public void setNbPartie(Integer nbPartie) {
        this.nbPartie = nbPartie;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Set<CommentaireJeu> getCommentairesJeu() {
        return commentairesJeu;
    }

    public void setCommentairesJeu(Set<CommentaireJeu> commentairesJeu) {
        this.commentairesJeu = commentairesJeu;
    }

    public Set<JeuTag> getJeuTags() {
        return jeuTags;
    }

    public void setJeuTags(Set<JeuTag> jeuTags) {
        this.jeuTags = jeuTags;
    }

    public Set<JoueurJeu> getJoueursJeu() {
        return joueursJeu;
    }

    public void setJoueursJeu(Set<JoueurJeu> joueursJeu) {
        this.joueursJeu = joueursJeu;
    }

    public CategorieJeu getCategorieJeu() {
        return categorieJeu;
    }

    public void setCategorieJeu(CategorieJeu categorieJeu) {
        this.categorieJeu = categorieJeu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}