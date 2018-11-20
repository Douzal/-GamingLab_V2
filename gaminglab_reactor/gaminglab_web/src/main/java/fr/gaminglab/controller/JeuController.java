package fr.gaminglab.controller;

import fr.gaminglab.entity.jeu.*;
import fr.gaminglab.entity.utilisateur.Utilisateur;
import fr.gaminglab.service.api.communication.IServiceForum;
import fr.gaminglab.service.api.jeu.IServiceEchange;
import fr.gaminglab.service.api.jeu.IServiceJeu;
import fr.gaminglab.service.api.utilisateur.IServiceUtilisateur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.xml.stream.events.Comment;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gaminglab/game")
public class JeuController {

    public static final Logger logger = LoggerFactory.getLogger(JeuController.class);

    @Autowired
    private IServiceJeu serviceJeu;

    @Autowired
    private IServiceEchange serviceEchange;

    @Autowired
    private IServiceForum serviceForum;

    @GetMapping("/categorie")
    public List<CategorieJeu> getAllCategorieJeu(){
        return serviceJeu.getAllCategorieJeux();
    }

    @GetMapping("/categorie/{idCategorieJeu}")
    public CategorieJeu getCategorieJeuById(@PathVariable Integer idCategorieJeu){
        Optional<CategorieJeu> categorieJeu = serviceJeu.getCategorieJeuById(idCategorieJeu);
        if (categorieJeu.isPresent()){
            return categorieJeu.get();
        }
        else{
            return null;
        }
    }

    @GetMapping("/jeu")
    public List<Jeu> getAllJeux(){

        return serviceJeu.getAllJeux();
    }

    @GetMapping("/jeu/{idJeu}")
    public Jeu getJeuById(@PathVariable Integer idJeu){
        Optional<Jeu> jeu = serviceJeu.getJeuById(idJeu);
        if (jeu.isPresent()){
            return jeu.get();
        }
        else{
            return null;
        }
    }

    @GetMapping("/categorie/{idCategorieJeu}/jeu")
    public List<Jeu> getAllJeuxByCategorie(@PathVariable Integer idCategorieJeu){

        return serviceJeu.getJeuxByCategorie(idCategorieJeu);
    }

    @GetMapping("/tag")
    public List<Tag> getAllTag(){

        return serviceJeu.getAllTag();
    }

    @PostMapping("/ajoutJeu")
    public Jeu ajouterJeu(@RequestBody Jeu jeu){

        return serviceJeu.ajouterJeu(jeu);
    }

    @PutMapping("/jeu/{idJeu}")
    public void modifierJeu(@PathVariable Integer idJeu,@RequestBody Jeu jeuModifie){

        serviceJeu.modifierJeu(jeuModifie);
    }

    @GetMapping("/jeu/{idJeu}/commentaire")
    public List<CommentaireJeu> getAllCommentaireJeuByJeu(@PathVariable Integer idJeu){

        return serviceEchange.getCommentaireByJeu(idJeu);
    }

    @GetMapping("/jeu/{idJeu}/joueur")
    public List<JoueurJeu> getMeilleurJoueurByJeu(@PathVariable Integer idJeu){

        return serviceJeu.getMeilleurJoueurByJeu(idJeu);
    }

    @GetMapping("/jeu/{idJeu}/joueur/{idUtilisateur}")
    public JoueurJeu getJoueurJeuByJeuAndJoueur(@PathVariable Integer idJeu, @PathVariable Integer idUtilisateur){

        return serviceJeu.getJoueurJeuByJeuAndJoueur(idJeu, idUtilisateur);
    }

    @PostMapping("/joueurJeu")
    public JoueurJeu ajouterJoueurJeu(@RequestBody JoueurJeu joueurJeu){

        return serviceJeu.ajouterJoueurJeu(joueurJeu);
    }

    @PostMapping("/commentaireJeu")
    public CommentaireJeu ajouterCommentaireJeu(@RequestBody CommentaireJeu commentaireJeu){

        return serviceEchange.ajouterCommentaire(commentaireJeu);
    }

    @PutMapping("/joueurJeu/{idJoueurJeu}")
    public JoueurJeu modifierJoueurJeu(@PathVariable Integer idJoueurJeu,@RequestBody JoueurJeu joueurJeuModifie){

        Optional<JoueurJeu> joueurJeu = serviceJeu.getJoueurJeuById(idJoueurJeu);
        if (joueurJeu.isPresent()){
            joueurJeu.get().setDateJouer(new Date());
            joueurJeu.get().setScore(joueurJeuModifie.getScore());
            joueurJeu.get().setTempsJeu(joueurJeuModifie.getTempsJeu());
            return serviceJeu.modifierJoueurJeu(joueurJeu.get());
        } else {
            return null;
        }
    }


}
