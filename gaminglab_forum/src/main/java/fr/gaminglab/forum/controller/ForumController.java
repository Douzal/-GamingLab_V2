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
import fr.gaminglab.forum.entity.SujetForum;
import fr.gaminglab.forum.service.IServiceForum;

@CrossOrigin(origins = "http://localhost:4200")
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

	@GetMapping("/categorieSujet/{idSujetForum}")
	List<CommentaireForum> getAllCommentaireBySujet(@PathVariable Integer idSujetForum) {
		// ok
		Optional<SujetForum> sujetForum = serviceForum.getSujetForumById(idSujetForum);
		if (sujetForum.isPresent()) {
			return serviceForum.getAllCommentaireBySujet(sujetForum.get());
			// return serviceForum.getAllCommentaireBySujetTest(idSujetForum);
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

	@GetMapping("/categorieJoueur/{idJoueur}")
	public List<SujetForum> getSujetForumByJoueur(@PathVariable Integer idJoueur) {
		// ok
		return serviceForum.getSujetByJoueur(idJoueur);
	}

	@GetMapping("/sujet/{idSujet}")
	SujetForum getSujetById(@PathVariable Integer idSujet) {

		return null;
	}

	@GetMapping("/sujet/{idSujetForum}/commentaire")
	List<CommentaireForum> getAllCommentaireForumBySujet(@PathVariable Integer idSujetForum) {

		return null;
	}

	@GetMapping("/commentaire/{idCommentaire}")
	CommentaireForum getCommentaireForumById(@PathVariable Integer idCommentaire) {

		return null;
	}

	@PostMapping("/commentaireAjouter/{idJoueur}")
	public void ajouterCommentaire(@RequestBody CommentaireForum commentaireForum, @PathVariable Integer idJoueur) {
		System.out.println("coucou :Present");
		CommentaireForum restJoueurForum = serviceForum.ajouterCommentaire(commentaireForum, idJoueur);
	}

	@PostMapping("/sujetAjouter/{idJoueur}")
	public void ajouterSujet(@RequestBody SujetForum sujetForum, @PathVariable Integer idJoueur) {
		SujetForum restSujetForum = serviceForum.ajouterSujet(sujetForum, idJoueur);

	}

	@DeleteMapping("/commentaireSup/{idCommentaireForum}")
	public void supprimerCommentaire(@PathVariable Integer idCommentaireForum) {
		// Ok
		Optional<CommentaireForum> comForum = serviceForum.getCommentaireForumById(idCommentaireForum);
		if (comForum.isPresent()) {
			boolean rest = serviceForum.supprimerCommentaire(comForum.get());
		} else {
			System.out.println("Erreur supprimer commentaire");
		}
	}

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

	@GetMapping("/sujets")
	List<SujetForum> getAllSujetForum() {
		return serviceForum.getAllSujetForum();
	}

}
