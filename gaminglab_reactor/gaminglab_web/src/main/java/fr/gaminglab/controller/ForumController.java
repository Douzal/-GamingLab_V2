package fr.gaminglab.controller;

import fr.gaminglab.entity.communication.CategorieForum;
import fr.gaminglab.entity.communication.CommentaireForum;
import fr.gaminglab.entity.communication.JoueurSujetForum;
import fr.gaminglab.entity.communication.SujetForum;
import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.entity.utilisateur.Utilisateur;
import fr.gaminglab.service.api.communication.IServiceForum;
import fr.gaminglab.service.api.utilisateur.IServiceUtilisateur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8182")
@RestController
@RequestMapping("/gaminglab/forum")
public class ForumController {

    public static final Logger logger = LoggerFactory.getLogger(ForumController.class);

    @Autowired
    private IServiceForum serviceForum;
    
    @Autowired
    private IServiceUtilisateur serviceUtilisateur;  

    @GetMapping("/categorie")
    List<CategorieForum> getAllCategorieForum(){
    	//Ok
    	return serviceForum.getAllCategorieForum();
    }
    @GetMapping("/categorieSujet/{idSujetForum}")
    List<CommentaireForum> getAllCommentaireBySujet(@PathVariable Integer idSujetForum){
    	//ok
    	Optional<SujetForum> sujetForum = serviceForum.getSujetForumById(idSujetForum);    	
        if(sujetForum.isPresent()) {        	
    		return serviceForum.getAllCommentaireBySujet(sujetForum.get());
        	//return serviceForum.getAllCommentaireBySujetTest(idSujetForum);
    	} else {    		
    		return null;
    	}
    }   
   

    @GetMapping("/categorie/{idCategorieForum}")
    CategorieForum getCategorieForumById(@PathVariable Integer idCategorieForum){

        return null;
    }

    @GetMapping("/categorie/{idCategorieForum}/sujet")
    List<SujetForum> getAllSujetByCategorieForum (@PathVariable Integer idCategorieForum){
    	// ok
    	Optional<CategorieForum> categorieForum = serviceForum.getCategorieForumById(idCategorieForum);
    	if (categorieForum.isPresent()) {    		
    		return serviceForum.getAllSujetByCategorie(categorieForum.get());
    	}else {    	    	
    		return null;   
    	}
    }
    @GetMapping("/categorieJoueur/{idJoueur}")
    public List<SujetForum> getSujetForumByJoueur(@PathVariable Integer idJoueur) {
    	//ok
    	return serviceForum.getSujetByJoueur(idJoueur);   
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

    @PostMapping("/commentaireAjouter/{idJoueur}")
    public void ajouterCommentaire(@RequestBody CommentaireForum commentaireForum,@PathVariable Integer idJoueur){
    	//coucou     	
    	Optional<Joueur> joueurForum = serviceUtilisateur.getJoueurById(idJoueur);
    	if (joueurForum.isPresent()) {
    		System.out.println("coucou :Present");
    		CommentaireForum restJoueurForum = serviceForum.ajouterCommentaire(commentaireForum, joueurForum.get());    		
    	}else {
    	   System.out.println("Erreur ajouterCommentaire");
    	}
    	
    }
    

    @PostMapping("/sujetAjouter/{idJoueur}")
    public void ajouterSujet(@RequestBody SujetForum sujetForum,@PathVariable Integer idJoueur){
    	//coucou
    	Optional<Joueur> joueurForum = serviceUtilisateur.getJoueurById(idJoueur);
    	if (joueurForum.isPresent()) {
    		SujetForum restSujetForum = serviceForum.ajouterSujet(sujetForum, joueurForum.get());
    	}
    	else {
    		System.out.println("Erreur ajouterSujet");
    	}
    	
    }

    @DeleteMapping("/commentaireSup/{idCommentaireForum}")
    public void supprimerCommentaire(@PathVariable Integer idCommentaireForum){
    	// Ok
    	Optional<CommentaireForum> comForum = serviceForum.getCommentaireForumById(idCommentaireForum);    	
    	if (comForum.isPresent()){
    		boolean rest = serviceForum.supprimerCommentaire(comForum.get());
    	}
    	else {
    		System.out.println("Erreur supprimer commentaire");
    	}
    }  

    @PutMapping("/sujetNoter/{idSujetForum}/{idJoueur}")
    public SujetForum noterSujet(@RequestBody SujetForum sujetForumModifie, @PathVariable Integer idSujetForum, @PathVariable Integer idJoueur){
        
    	Optional<SujetForum> sujetForum = serviceForum.getSujetForumById(idSujetForum);
        Optional<Joueur> joueur = serviceUtilisateur.getJoueurById(idJoueur);
        
        if (sujetForum.isPresent() && joueur.isPresent()) {
        	
        	sujetForum.get().setNote(sujetForumModifie.getNote());
        	     	
        	return serviceForum.noteSujet(sujetForum.get(), joueur.get());
        }
        else {
        	return null;
        }        
    }

    @PutMapping("/commentaireNoter/{idCommentaireForum}/{idJoueur}")
    public CommentaireForum noterCommentaire(@RequestBody CommentaireForum commentaireForumModifie,@PathVariable Integer idCommentaireForum, @PathVariable Integer idJoueur) {
    	Optional<Joueur>joueur = serviceUtilisateur.getJoueurById(idJoueur);
    	Optional<CommentaireForum> commentaireForum = serviceForum.getCommentaireForumById(idCommentaireForum);
    	if(commentaireForum.isPresent() && joueur.isPresent()) {
    		commentaireForum.get().setNote(commentaireForumModifie.getNote());
    		return serviceForum.noteCommentaire(commentaireForum.get(), joueur.get());
    	}else {
    		return null;
    	}
    }
    
    @GetMapping("/sujets")
    List<SujetForum> getAllSujetForum(){
    	return serviceForum.getAllSujetForum();
    }
    
    @GetMapping("/joueurSujetForum/{idUtilisateur}/{idSujet}")
    public List<JoueurSujetForum>getJoueurSujetForumByIdJoueurSujet(@PathVariable Integer idUtilisateur,@PathVariable Integer idSujet){
    	return serviceForum.getJoueurSujetForumByIdJoueurSujet(idUtilisateur, idSujet);
    }
    
}
