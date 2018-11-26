package fr.gaminglab.forum.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gaminglab.forum.entity.CategorieForum;
import fr.gaminglab.forum.entity.CommentaireForum;
import fr.gaminglab.forum.entity.JoueurCommentaireForum;
import fr.gaminglab.forum.entity.JoueurSujetForum;
import fr.gaminglab.forum.entity.SujetForum;
import fr.gaminglab.forum.service.IServiceForum;
import fr.gaminglab.forum.service.ServiceForum;

@CrossOrigin(origins = "http://localhost:8182")
@RestController
@RequestMapping("/gaminglab/forum")
public class ForumController {

	public static final Logger logger = LoggerFactory.getLogger(ForumController.class);

	@Autowired
	private IServiceForum serviceForum;	
	

	@GetMapping("/categorie")
	List<CategorieForum> getAllCategorieForum() {
		// Ok
		return serviceForum.getAllCategorieForum();
	}

	@GetMapping("/categoriesujet/{idSujetForum}")
	List<CommentaireForum> getAllCommentaireBySujet(@PathVariable Integer idSujetForum) {
		// ok
		Optional<SujetForum> sujetForum = serviceForum.getSujetForumById(idSujetForum);
		if (sujetForum.isPresent()) {
			return serviceForum.getAllCommentaireBySujet(sujetForum.get());			
		} else {
			return null;
		}
	}

	@GetMapping("/categorie/{idCategorieForum}")
	CategorieForum getCategorieForumById(@PathVariable Integer idCategorieForum) {

		return null;
	}

	@GetMapping("/categorie/{idCategorieForum}/sujet")
	List<SujetForum> getAllSujetByCategorieForum(@PathVariable Integer idCategorieForum) {
		// ok
		Optional<CategorieForum> categorieForum = serviceForum.getCategorieForumById(idCategorieForum);
		if (categorieForum.isPresent()) {
			return serviceForum.getAllSujetByCategorie(categorieForum.get());
		} else {
			return null;
		}
	}

	@GetMapping("/categoriejoueur/{idJoueur}")
	public List<SujetForum> getSujetForumByJoueur(@PathVariable Integer idJoueur) {
		// ok
		return serviceForum.getSujetByJoueur(idJoueur);
	}

	@GetMapping("/sujet/{idSujet}")
	SujetForum getSujetById(@PathVariable Integer idSujet) {
		return serviceForum.getSujetForumById(idSujet).get();
	}
	
	@GetMapping("/sujets")
	List<SujetForum> getAllSujet() {
		return serviceForum.getAllSujetForum();
	}

	@GetMapping("/sujet/{idSujetForum}/commentaire")
	List<CommentaireForum> getAllCommentaireForumBySujet(@PathVariable Integer idSujetForum) {
		return null;
	}

	@GetMapping("/commentaire/{idCommentaire}")
	CommentaireForum getCommentaireForumById(@PathVariable Integer idCommentaire) {
		Optional<CommentaireForum> optComm = serviceForum.getCommentaireForumById(idCommentaire);
		
		CommentaireForum comm;
		if (optComm.isPresent()) {
			comm = optComm.get();
		} else {
			comm = null;
		}
		
		return comm;
	}

	@PostMapping("/commentaireajouter/{idJoueur}")
	public CommentaireForum ajouterCommentaire(@RequestBody CommentaireForum commentaireForum, @PathVariable Integer idJoueur) {
		return serviceForum.ajouterCommentaire(commentaireForum, idJoueur);
	}

	@PostMapping("/sujetajouter/{idJoueur}")
	public void ajouterSujet(@RequestBody SujetForum sujetForum, @PathVariable Integer idJoueur) {
		SujetForum restSujetForum = serviceForum.ajouterSujet(sujetForum, idJoueur);

	}

	@DeleteMapping("/commentairesup/{idCommentaireForum}")
	public void supprimerCommentaire(@PathVariable Integer idCommentaireForum) {
		// Ok
		Optional<CommentaireForum> comForum = serviceForum.getCommentaireForumById(idCommentaireForum);
		if (comForum.isPresent()) {
			boolean rest = serviceForum.supprimerCommentaire(comForum.get());
		} else {
			System.out.println("Erreur supprimer commentaire");
		}
	}

	/*
	 * methode deprecated (remplacee)
	@PutMapping("/sujetNoter/{idSujetForum}/{idJoueur}")
	public SujetForum noterSujet(@RequestBody SujetForum sujetForumModifie, @PathVariable Integer idSujetForum,
			@PathVariable Integer idJoueur) {

		Optional<SujetForum> sujetForum = serviceForum.getSujetForumById(idSujetForum);

		if (sujetForum.isPresent()) {

			sujetForum.get().setNote(sujetForumModifie.getNote());

			return serviceForum.noteSujet(sujetForum.get(),idJoueur);
		} else {
			return null;
		}
	}
	*/

	/*
	 * methode deprecated (remplacee)
	@PutMapping("/commentaireNoter/{idCommentaireForum}/{idJoueur}")
	public CommentaireForum noterCommentaire(@RequestBody CommentaireForum commentaireForumModifie,
			@PathVariable Integer idCommentaireForum, @PathVariable Integer idJoueur) {
		Optional<CommentaireForum> commentaireForum = serviceForum.getCommentaireForumById(idCommentaireForum);
		if (commentaireForum.isPresent()) {
			commentaireForum.get().setNote(commentaireForumModifie.getVote());
			return serviceForum.noteCommentaire(commentaireForum.get(), idJoueur);
		} else {
			return null;
		}
	}
	*/
	
	//Modif Chris
	@GetMapping("/joueursujetforum/{idUtilisateur}/{idSujet}")
    public JoueurSujetForum getJoueurSujetForumByIdJoueurSujet(@PathVariable Integer idUtilisateur,@PathVariable Integer idSujet){
    	return serviceForum.getJoueurSujetForumByIdJoueurSujet(idUtilisateur, idSujet);
    }
	
	//Modif Chris
	@PostMapping("/ajouterjoueursujetforum")
	public JoueurSujetForum ajouterJoueurSujetForum(@RequestBody JoueurSujetForum joueurSujetForum) {
		return serviceForum.ajouterJoueurSujetForum(joueurSujetForum);
	}
	
	@PostMapping("/majjoueursujetforum")
	public JoueurSujetForum majNoteJoueurSujetForum(@RequestBody JoueurSujetForum joueurSujetForum) {
		return serviceForum.majNoteSujetForum(joueurSujetForum);
	}

	@GetMapping("/commentaires_parent/{idSujet}") 
	public List<CommentaireForum>getAllCommentairesForumParent(@PathVariable Integer idSujet){
		List<CommentaireForum> allCommentairesForumParent = serviceForum.getAllCommentairesForumParent(idSujet);
		return allCommentairesForumParent;
	}
	
	@GetMapping("/commentaires_enfant/{idCommentaire}") 
	public List<CommentaireForum>getAllCommentairesForumEnfant(@PathVariable Integer idCommentaire){
		return serviceForum.getAllCommentairesForumEnfant(idCommentaire);
	}
	
	//Modif Chris
	@GetMapping("/joueurcommentaireforum/{idUtilisateur}/{idCommentaire}")
	//@ResponseBody
	public JoueurCommentaireForum getJoueurCommentaireForum(@PathVariable Integer idUtilisateur,
														   @PathVariable Integer idCommentaire) {
		/*
		 * SELECT * FROM JoueurCommentaireForum WHERE IdJoueur = idJoueur AND idComm = idComm 
		 */
		
		// get JoueurCommentaireForumByIdJoueurCommentaire (Integer idUtilisateur,
		// Integer idCommentaire) {}
		/* A JARTER mais pour idee
		 * Optional<SujetForum> sujetForum = serviceForum.getSujetForumById(idSujetForum);
		if (sujetForum.isPresent()) {
			return serviceForum.getAllCommentaireBySujet(sujetForum.get());
			// return serviceForum.getAllCommentaireBySujetTest(idSujetForum);
		} else {
			return null;
		}*/
		return serviceForum.getJoueurCommentaireForum(idUtilisateur, idCommentaire);
	}
	
	//Ajout Chris
	@PostMapping("/joueurcommentaireforum")
	public JoueurCommentaireForum insertJoueurCommentaireForum(@RequestBody JoueurCommentaireForum joueurCommentaireForum) {
		return serviceForum.insertJoueurCommentaireForum(joueurCommentaireForum);
	}
	
	//Ajout Chris
	@PostMapping("/majjoueurcommentaireforum")
	public JoueurCommentaireForum updateJoueurCommentaireForum(@RequestBody JoueurCommentaireForum joueurCommentaireForum) {
		return serviceForum.updateJoueurCommentaireForum(joueurCommentaireForum);
	}
	
	//Ajout Chris 26/11
	@GetMapping("/sujets/{libelle}")
    public List<SujetForum> getAllSujetsByLibelle (@PathVariable String libelle) {
    	return serviceForum.getAllSujetsByLibelle(libelle);
    }
}
