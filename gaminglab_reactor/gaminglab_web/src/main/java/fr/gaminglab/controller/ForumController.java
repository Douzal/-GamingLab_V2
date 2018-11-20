package fr.gaminglab.controller;

import fr.gaminglab.entity.communication.CategorieForum;
import fr.gaminglab.entity.communication.CommentaireForum;
import fr.gaminglab.entity.communication.SujetForum;
import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.entity.utilisateur.Utilisateur;
import fr.gaminglab.service.api.communication.IServiceForum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gaminglab/forum")
public class ForumController {

    public static final Logger logger = LoggerFactory.getLogger(ForumController.class);

    @Autowired
    private IServiceForum serviceForum;

    @GetMapping("/categorie")
    List<CategorieForum> getAllCategorieForum(){

        return null;
    }

    @GetMapping("/categorie/{idCategorieForum}")
    CategorieForum getCategorieForumById(@PathVariable Integer idCategorieForum){

        return null;
    }

    @GetMapping("/categorie/{idCategorieForum}/sujet")
    List<SujetForum> getAllSujetByCategorieForum (@PathVariable Integer idCategorieForum){

        return null;
    }

    @GetMapping("/sujet/{idSujet}")
    SujetForum getSujetById(@PathVariable Integer idSujet){

        return null;
    }

    @GetMapping("/sujet/{idSujetForum}/commentaire")
    List<CommentaireForum> getAllCommentaireForumBySujet(@PathVariable Integer idSujetForum){

        return null;
    }

    @GetMapping("/commentaire/{idCommentaire}")
    CommentaireForum getCommentaireForumById (@PathVariable Integer idCommentaire){

        return null;
    }

    @PostMapping("/commentaire")
    public void ajouterCommentaire(@RequestBody CommentaireForum commentaireForum){

    }

    @PostMapping("/sujet")
    public void ajouterSujet(@RequestBody SujetForum sujet){

    }

    @DeleteMapping("/commentaire/{idCommentaireForum}")
    public void supprimerCommentaire(@PathVariable Integer idCommentaireForum){

    }

    @DeleteMapping("/sujet/{idSujetForum}")
    public void supprimerSujet(@PathVariable Integer idSujetForum){

    }

    @PutMapping("/sujet/{idSujetForum}")
    public SujetForum noterSujet(@PathVariable Integer idSujetForum, @RequestBody SujetForum sujetForumModifie,@RequestBody Joueur joueur){
        Optional<SujetForum> sujetForum = serviceForum.getSujetForumById(idSujetForum);
        if (sujetForum.isPresent()){
            sujetForum.get().setNote(sujetForumModifie.getNote());
            return serviceForum.noteSujet(sujetForum.get(), joueur);
        } else {
            return null;
        }
    }

    @PutMapping("/commentaire/{idCommentaireForum}")
    public CommentaireForum noterCommentaire(@PathVariable Integer idCommentaireForum,@RequestBody CommentaireForum commentaireForumModifie,@RequestBody Joueur joueur){
        Optional<CommentaireForum> commentaireForum = serviceForum.getCommentaireForumById(idCommentaireForum);
        if (commentaireForum.isPresent()){
            commentaireForum.get().setNote(commentaireForumModifie.getNote());
            return serviceForum.noteCommentaire(commentaireForum.get(), joueur);
        } else {
            return null;
        }
    }
}
