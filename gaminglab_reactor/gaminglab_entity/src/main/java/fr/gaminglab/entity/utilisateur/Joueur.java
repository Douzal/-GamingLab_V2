package fr.gaminglab.entity.utilisateur;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import fr.gaminglab.entity.boutique.Commande;
import fr.gaminglab.entity.boutique.NoteArticle;
import fr.gaminglab.entity.communication.CommentaireForum;
import fr.gaminglab.entity.communication.JoueurCommentaireForum;
import fr.gaminglab.entity.communication.JoueurSujetForum;
import fr.gaminglab.entity.communication.Message;
import fr.gaminglab.entity.communication.SujetForum;
import fr.gaminglab.entity.jeu.CommentaireJeu;
import fr.gaminglab.entity.jeu.Jeu;
import fr.gaminglab.entity.jeu.JoueurJeu;

/**
 * 
 */
@Entity
@Table
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idUtilisateur", scope = Utilisateur.class)
public class Joueur extends Utilisateur implements Serializable {

    /**
     * Default constructor
     */
    public Joueur() {
    }

    public Joueur(String nom, String prenom, String mail, String pseudo, String password, Date dateInscription, Date dateDesinscription, Civilite civilite, Date dateNaissance, Integer credit, String imageJoueur, String telephone, Boolean estSuspendu, Date dateDebutSuspension, Date dateFinSuspension, String motif) {
        super(nom, prenom, mail, pseudo, password, dateInscription, dateDesinscription, civilite);
        this.dateNaissance = dateNaissance;
        this.credit = credit;
        this.imageJoueur = imageJoueur;
        this.telephone = telephone;
        this.estSuspendu = estSuspendu;
        this.dateDebutSuspension = dateDebutSuspension;
        this.dateFinSuspension = dateFinSuspension;
        this.motif = motif;
    }

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateNaissance;

    /**
     * 
     */
    @Column
    private Integer credit;

    /**
     * 
     */
    @Column(length = 150)
    private String imageJoueur;

    /**
     * 
     */
    @Column(length = 20)
    private String telephone;

    /**
     * 
     */
    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private Boolean estSuspendu;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebutSuspension;

    /**
     * 
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFinSuspension;

    /**
     * 
     */
    @Column(length = 255)
    private String motif;

    /**
     * 
     */
    @OneToMany(mappedBy="joueur")
	@JsonIgnore
    private List<Adresse> adresses;

    /**
     *
     */
    @OneToMany(mappedBy="joueurConcerne")
	@JsonIgnore
    private Set<DemandeSuspension> demandesRecus;

    /**
     *
     */
    @OneToMany(mappedBy="joueurDemande")
	@JsonIgnore
    private Set<DemandeSuspension> demandesEnvoyees;

    /**
     * 
     */
    @OneToMany(mappedBy="joueur")
	@JsonIgnore
    private Set<JoueurBadge> joueurBadges;

    /**
     * 
     */
    @OneToMany(mappedBy="joueur")
	@JsonIgnore
    private Set<JoueurCarte> joueurCartes;

    /**
     * 
     */
    @OneToMany(mappedBy="joueur")
	@JsonIgnore
    private Set<Commande> commandes;

    /**
     * 
     */
    @OneToMany(mappedBy="joueur")
	@JsonIgnore
    private Set<NoteArticle> notesArticles;

    /**
     * 
     */
    @OneToMany(mappedBy="joueurEmetteur")
	@JsonIgnore
    private Set<Message> messagesEnvoyes;

    /**
     * 
     */
    @OneToMany(mappedBy="joueurDestinataire")
	@JsonIgnore
    private Set<Message> messagesRecus;

    /**
     *
     */
    @OneToMany(mappedBy="joueur")
	@JsonIgnore
    private Set<SujetForum> sujets;

    /**
     *
     */
    @OneToMany(mappedBy="joueur")
	@JsonIgnore
    private Set<CommentaireForum> commentaires;

    /**
     * 
     */
    @OneToMany(mappedBy="joueur")
	@JsonIgnore
    private Set<JoueurCommentaireForum> joueurCommentairesForum;

    /**
     * 
     */
    @OneToMany(mappedBy="joueur")
	@JsonIgnore
    private Set<JoueurSujetForum> joueurSujetsForum;

    /**
     * 
     */
    @OneToMany(mappedBy="joueur")
	@JsonIgnore
    private Set<Jeu> jeux;

    /**
     * 
     */
    @OneToMany(mappedBy="joueur")
	@JsonIgnore
    private Set<JoueurJeu> joueurJeux;

    /**
     * 
     */
    @OneToMany(mappedBy="joueur")
	@JsonIgnore
    private Set<CommentaireJeu> commentairesJeu;

	@Override
	public String toString() {
		return "Joueur{" +
				"dateNaissance=" + dateNaissance +
				", credit=" + credit +
				", imageJoueur='" + imageJoueur + '\'' +
				", telephone='" + telephone + '\'' +
				", estSuspendu=" + estSuspendu +
				", dateDebutSuspension=" + dateDebutSuspension +
				", dateFinSuspension=" + dateFinSuspension +
				", motif='" + motif + '\'' +
				", adresses=" + adresses +
				", demandesRecus=" + demandesRecus +
				", demandesEnvoyees=" + demandesEnvoyees +
				", joueurBadges=" + joueurBadges +
				", joueurCartes=" + joueurCartes +
				", commandes=" + commandes +
				", notesArticles=" + notesArticles +
				", messagesEnvoyes=" + messagesEnvoyes +
				", messagesRecus=" + messagesRecus +
				", sujets=" + sujets +
				", commentaires=" + commentaires +
				", joueurCommentairesForum=" + joueurCommentairesForum +
				", joueurSujetsForum=" + joueurSujetsForum +
				", jeux=" + jeux +
				", joueurJeux=" + joueurJeux +
				", commentairesJeu=" + commentairesJeu +
				'}';
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public String getImageJoueur() {
		return imageJoueur;
	}

	public void setImageJoueur(String imageJoueur) {
		this.imageJoueur = imageJoueur;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Boolean getEstSuspendu() {
		return estSuspendu;
	}

	public void setEstSuspendu(Boolean estSuspendu) {
		this.estSuspendu = estSuspendu;
	}

	public Date getDateDebutSuspension() {
		return dateDebutSuspension;
	}

	public void setDateDebutSuspension(Date dateDebutSuspension) {
		this.dateDebutSuspension = dateDebutSuspension;
	}

	public Date getDateFinSuspension() {
		return dateFinSuspension;
	}

	public void setDateFinSuspension(Date dateFinSuspension) {
		this.dateFinSuspension = dateFinSuspension;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Set<DemandeSuspension> getDemandesRecus() {
		return demandesRecus;
	}

	public void setDemandesRecus(Set<DemandeSuspension> demandesRecus) {
		this.demandesRecus = demandesRecus;
	}

	public Set<DemandeSuspension> getDemandesEnvoyees() {
		return demandesEnvoyees;
	}

	public void setDemandesEnvoyees(Set<DemandeSuspension> demandesEnvoyees) {
		this.demandesEnvoyees = demandesEnvoyees;
	}

	public Set<JoueurBadge> getJoueurBadges() {
		return joueurBadges;
	}

	public void setJoueurBadges(Set<JoueurBadge> joueurBadges) {
		this.joueurBadges = joueurBadges;
	}

	public Set<JoueurCarte> getJoueurCartes() {
		return joueurCartes;
	}

	public void setJoueurCartes(Set<JoueurCarte> joueurCartes) {
		this.joueurCartes = joueurCartes;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	public Set<NoteArticle> getNotesArticles() {
		return notesArticles;
	}

	public void setNotesArticles(Set<NoteArticle> notesArticles) {
		this.notesArticles = notesArticles;
	}

	public Set<Message> getMessagesEnvoyes() {
		return messagesEnvoyes;
	}

	public void setMessagesEnvoyes(Set<Message> messagesEnvoyes) {
		this.messagesEnvoyes = messagesEnvoyes;
	}

	public Set<Message> getMessagesRecus() {
		return messagesRecus;
	}

	public void setMessagesRecus(Set<Message> messagesRecus) {
		this.messagesRecus = messagesRecus;
	}

	public Set<SujetForum> getSujets() {
		return sujets;
	}

	public void setSujets(Set<SujetForum> sujets) {
		this.sujets = sujets;
	}

	public Set<CommentaireForum> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Set<CommentaireForum> commentaires) {
		this.commentaires = commentaires;
	}

	public Set<JoueurCommentaireForum> getJoueurCommentairesForum() {
		return joueurCommentairesForum;
	}

	public void setJoueurCommentairesForum(Set<JoueurCommentaireForum> joueurCommentairesForum) {
		this.joueurCommentairesForum = joueurCommentairesForum;
	}

	public Set<JoueurSujetForum> getJoueurSujetsForum() {
		return joueurSujetsForum;
	}

	public void setJoueurSujetsForum(Set<JoueurSujetForum> joueurSujetsForum) {
		this.joueurSujetsForum = joueurSujetsForum;
	}

	public Set<Jeu> getJeux() {
		return jeux;
	}

	public void setJeux(Set<Jeu> jeux) {
		this.jeux = jeux;
	}

	public Set<JoueurJeu> getJoueurJeux() {
		return joueurJeux;
	}

	public void setJoueurJeux(Set<JoueurJeu> joueurJeux) {
		this.joueurJeux = joueurJeux;
	}

	public Set<CommentaireJeu> getCommentairesJeu() {
		return commentairesJeu;
	}

	public void setCommentairesJeu(Set<CommentaireJeu> commentairesJeu) {
		this.commentairesJeu = commentairesJeu;
	}
}