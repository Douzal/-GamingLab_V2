package fr.gaminglab.controller;

import fr.gaminglab.entity.boutique.Commande;
import fr.gaminglab.entity.communication.CommentaireForum;
import fr.gaminglab.entity.communication.SujetForum;
import fr.gaminglab.entity.jeu.CommentaireJeu;
import fr.gaminglab.entity.jeu.Jeu;
import fr.gaminglab.entity.jeu.JoueurJeu;
import fr.gaminglab.entity.utilisateur.*;
import fr.gaminglab.service.api.boutique.IServiceCatalogue;
import fr.gaminglab.service.api.boutique.IServiceCommande;
import fr.gaminglab.service.api.communication.IServiceForum;
import fr.gaminglab.service.api.jeu.IServiceEchange;
import fr.gaminglab.service.api.jeu.IServiceJeu;
import fr.gaminglab.service.api.utilisateur.IServiceCarteBancaire;
import fr.gaminglab.service.api.utilisateur.IServiceUtilisateur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gaminglab/profil")
public class ProfilController {

    public static final Logger logger = LoggerFactory.getLogger(ProfilController.class);

    @Autowired
    private IServiceUtilisateur serviceUtilisateur;

    @Autowired
    private IServiceJeu serviceJeu;

    @Autowired
    private IServiceForum serviceForum;

    @Autowired
    private IServiceEchange serviceEchange;

    @Autowired
    private IServiceCommande serviceCommande;

    @Autowired
    private IServiceCarteBancaire serviceCarteBancaire;


    @GetMapping("/{idUtilisateur}/badge")
    public List<JoueurBadge> getAllBadgeByMembre(@PathVariable Integer idUtilisateur){

        return serviceUtilisateur.getBadgeByJoueur(idUtilisateur);
    }

    @GetMapping("/{idUtilisateur}/commentaireJeu")
    public List<CommentaireJeu> getAllCommentaireJeuByMembre(@PathVariable Integer idUtilisateur){

        return serviceEchange.getCommentaireJeuByJoueur(idUtilisateur);
    }

    @GetMapping("/{idUtilisateur}/commentaireForum")
    public List<CommentaireForum> getAllCommentaireForumByMembre(@PathVariable Integer idUtilisateur){

        return serviceForum.getCommentaireForumByJoueur(idUtilisateur);
    }

    @GetMapping("/{idUtilisateur}/sujetForum")
    public List<SujetForum> getSujetByMembre(@PathVariable Integer idUtilisateur){

        return serviceForum.getSujetForumByJoueur(idUtilisateur);
    }

    @GetMapping("/{idUtilisateur}/jeuJoue")
    public List<JoueurJeu> getJoueurJeuByMembre(@PathVariable Integer idUtilisateur){

        return serviceJeu.getJoueurJeuByJoueur(idUtilisateur);
    }
    @GetMapping("/{idUtilisateur}/jeuAjout")
    public List<Jeu> getJeuByMembre(@PathVariable Integer idUtilisateur){

        return serviceJeu.getJeuxByJoueur(idUtilisateur);
    }


    @GetMapping("/{idUtilisateur}/commande")
    public List<Commande> getAllCommandeByMembre(@PathVariable Integer idUtilisateur){
        List<Commande> commandes = serviceCommande.getAllCommandeByJoueur(idUtilisateur);
        for (Commande cmd: commandes) {
            Commande.calculPrixTotal(cmd);
        }
        return commandes;
    }

    @GetMapping("/{idUtilisateur}/carteBancaire")
    public List<JoueurCarte> getAllCarteBancaireByMembre(@PathVariable Integer idUtilisateur){

        return serviceCarteBancaire.getAllCarteByJoueur(idUtilisateur);
    }

    @PostMapping("/{idUtilisateur}/carteBancaire")
    public JoueurCarte ajouterCarteBancaire(@RequestBody JoueurCarte joueurCarte){

        return serviceCarteBancaire.ajouterJoueurCarte(joueurCarte);
    }

    @DeleteMapping("/{idUtilisateur}/carteBancaire/{idJoueurCarte}")
    public void supprimerCarteBancaire(@PathVariable Integer idJoueurCarte){

        serviceCarteBancaire.supprimerJoueurCarte(idJoueurCarte);
    }

    @GetMapping("/{idUtilisateur}/adresse")
    public List<Adresse> getAllAdresseByMembre(@PathVariable Integer idUtilisateur){

        return serviceUtilisateur.getAdresseByJoueur(idUtilisateur);
    }

    @PostMapping("/{idUtilisateur}/adresse")
    public Adresse ajouterAdresse(@RequestBody Adresse adresse){

        return serviceUtilisateur.ajouterAdresse(adresse);
    }




}
