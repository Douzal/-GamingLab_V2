package fr.gaminglab.orchestrateur.controller.angular;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gaminglab.entity.boutique.Commande;
import fr.gaminglab.entity.communication.CommentaireForum;
import fr.gaminglab.entity.communication.SujetForum;
import fr.gaminglab.entity.jeu.CommentaireJeu;
import fr.gaminglab.entity.jeu.Jeu;
import fr.gaminglab.entity.jeu.JoueurJeu;
import fr.gaminglab.entity.utilisateur.Adresse;
import fr.gaminglab.entity.utilisateur.JoueurBadge;
import fr.gaminglab.entity.utilisateur.JoueurCarte;
import fr.gaminglab.orchestrateur.controller.java.ProfilWebService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gaminglab/profil")
public class ProfilAngularController {

	ProfilWebService wsProfil = new ProfilWebService();

    @GetMapping("/{idUtilisateur}/badge")
    public List<JoueurBadge> getAllBadgeByMembre(@PathVariable Integer idUtilisateur){

        return wsProfil.getAllBadgeByMembre(idUtilisateur);
    }

    @GetMapping("/{idUtilisateur}/commentaireJeu")
    public List<CommentaireJeu> getAllCommentaireJeuByMembre(@PathVariable Integer idUtilisateur){

        return wsProfil.getAllCommentaireJeuByMembre(idUtilisateur);
    }

    @GetMapping("/{idUtilisateur}/commentaireForum")
    public List<CommentaireForum> getAllCommentaireForumByMembre(@PathVariable Integer idUtilisateur){

        return wsProfil.getAllCommentaireForumByMembre(idUtilisateur);
    }

    @GetMapping("/{idUtilisateur}/sujetForum")
    public List<SujetForum> getSujetByMembre(@PathVariable Integer idUtilisateur){

        return wsProfil.getSujetByMembre(idUtilisateur);
    }

    @GetMapping("/{idUtilisateur}/jeuJoue")
    public List<JoueurJeu> getJoueurJeuByMembre(@PathVariable Integer idUtilisateur){

        return wsProfil.getJoueurJeuByMembre(idUtilisateur);
    }
    
    @GetMapping("/{idUtilisateur}/jeuAjout")
    public List<Jeu> getJeuByMembre(@PathVariable Integer idUtilisateur){
        return wsProfil.getJeuByMembre(idUtilisateur);
    }


    @GetMapping("/{idUtilisateur}/commande")
    public List<Commande> getAllCommandeByMembre(@PathVariable Integer idUtilisateur){
        return wsProfil.getAllCommandeByMembre(idUtilisateur);
    }

    @GetMapping("/{idUtilisateur}/carteBancaire")
    public List<JoueurCarte> getAllCarteBancaireByMembre(@PathVariable Integer idUtilisateur){
        return wsProfil.getAllCarteBancaireByMembre(idUtilisateur);
    }

    @PostMapping("/{idUtilisateur}/carteBancaire")
    public JoueurCarte ajouterCarteBancaire(@RequestBody JoueurCarte joueurCarte){
        return wsProfil.ajouterCarteBancaire(joueurCarte);
    }

    @DeleteMapping("/{idUtilisateur}/carteBancaire/{idJoueurCarte}")
    public void supprimerCarteBancaire(@PathVariable Integer idJoueurCarte){
    	wsProfil.supprimerCarteBancaire(idJoueurCarte);
    }

    @GetMapping("/{idUtilisateur}/adresse")
    public List<Adresse> getAllAdresseByMembre(@PathVariable Integer idUtilisateur){
        return wsProfil.getAllAdresseByMembre(idUtilisateur);
    }

    @PostMapping("/{idUtilisateur}/adresse")
    public Adresse ajouterAdresse(@RequestBody Adresse adresse){
        return wsProfil.ajouterAdresse(adresse);
    }

}
