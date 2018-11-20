package fr.gaminglab.controller;

import fr.gaminglab.entity.boutique.Commande;
import fr.gaminglab.entity.boutique.LigneCommande;
import fr.gaminglab.entity.communication.CommentaireForum;
import fr.gaminglab.entity.utilisateur.Utilisateur;
import fr.gaminglab.service.api.boutique.IServiceCommande;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gaminglab")
public class CommandeController {

    public static final Logger logger = LoggerFactory.getLogger(Commande.class);

    @Autowired
    private IServiceCommande serviceCommande;


    @GetMapping("/panier/{idLigneCommande}")
    public LigneCommande getLigneCommandeById(@PathVariable Integer idLigneCommande){
        Optional<LigneCommande> ligneCommande = serviceCommande.getLigneCommandeById(idLigneCommande);
        if (ligneCommande.isPresent()){
            return ligneCommande.get();
        } else {
            return null;
        }
    }

    @PostMapping("/panier")
    public LigneCommande ajouterLigneCommande (@PathVariable LigneCommande ligneCommande){

        return serviceCommande.ajouterLigneCommande(ligneCommande);
    }

    @DeleteMapping("/panier/{idLigneCommande}")
    public void supprimerLigneCommande (@PathVariable Integer idLigneCommande){

        serviceCommande.supprimerLigneCommande(idLigneCommande);
    }

    @PutMapping("/panier/{idLigneCommande}")
    public LigneCommande modifierLigneCommande (@PathVariable Integer idLigneCommande ,@RequestBody LigneCommande ligneCommandeModifie){
        Optional<LigneCommande> ligneCommande = serviceCommande.getLigneCommandeById(idLigneCommande);
        if(ligneCommande.isPresent()){
            ligneCommande.get().setQuantite(ligneCommandeModifie.getQuantite());
            return serviceCommande.modifierLigneCommande(ligneCommande.get());
        } else {
            return null;
        }
    }

    @GetMapping("/commande/{idCommande}")
    public Commande getCommandeById(@PathVariable Integer idCommande){
        Optional<Commande> commande = serviceCommande.getCommandeById(idCommande);
        if (commande.isPresent()){
            Commande.calculPrixTotal(commande.get());
            return commande.get();
        } else {
            return null;
        }
    }

    @PostMapping("/commande")
    public Commande ajouterCommande(@RequestBody Commande commande){

        return serviceCommande.ajouterCommande(commande);
    }

    @PutMapping("/commande/{idCommande}")
    public Commande modifierCommande(@PathVariable Integer idCommande,@RequestBody Commande commandeModifie){
        Optional<Commande> commande = serviceCommande.getCommandeById(idCommande);
        if(commande.isPresent()){
            commande.get().setAdresse(commandeModifie.getAdresse());
            commande.get().setDateLivraison(commandeModifie.getDateLivraison());
            commande.get().setEtatCommande(commandeModifie.getEtatCommande());
            commande.get().setIdSession(commandeModifie.getIdSession());
            commande.get().setTerminee(commandeModifie.getTerminee());
            commande.get().setCreditTotal(commandeModifie.getCreditTotal());
            commande.get().setPrixTotal(commandeModifie.getPrixTotal());
            commande.get().setLignesCommande(commandeModifie.getLignesCommande());
            commande.get().setJoueurCarte(commandeModifie.getJoueurCarte());
            return serviceCommande.modifierCommande(commande.get());
        }
        else {
            return null;
        }
    }

    @DeleteMapping("/commande/{idCommande}")
    public void supprimerCommande(@PathVariable Integer idCommande){

        serviceCommande.supprimerCommande(idCommande);
    }

}
