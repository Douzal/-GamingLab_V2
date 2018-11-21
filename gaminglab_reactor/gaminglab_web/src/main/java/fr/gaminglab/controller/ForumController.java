package fr.gaminglab.controller;

import fr.gaminglab.entity.communication.CategorieForum;
import fr.gaminglab.entity.communication.CommentaireForum;
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

@CrossOrigin(origins = "http://localhost:4200")
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

    @DeleteMapping("/sujetSup/{idSujetForum}")
    public void supprimerSujet(@PathVariable Integer idSujetForum){
    	//coucou   ???
//    	Optional<SujetForum> sujetForum = serviceForum..getSujetForumById(idSujetForum);
//    	if (sujetForum.isPresent()) {
//    		Optional<Joueur> joueurForum = serviceUtilisateur.getJoueurById(idSujetForum);
//    		if(joueurForum.isPresent()) {
//    			sujetForum = serviceForum.supprimerSujet(sujetForum, joueurForum);
//    		}
//    		else {
//    			System.out.println("Present joueur");
//    		}
//    	}
    	
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
