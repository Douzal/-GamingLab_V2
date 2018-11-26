package fr.gaminglab.orchestrateur.controller.angular;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.gaminglab.forum.entity.CategorieForum;
import fr.gaminglab.forum.entity.CommentaireForum;
import fr.gaminglab.forum.entity.JoueurCommentaireForum;
import fr.gaminglab.forum.entity.JoueurSujetForum;
import fr.gaminglab.forum.entity.SujetForum;
import fr.gaminglab.orchestrateur.controller.java.ForumWebService;
import fr.gaminglab.orchestrateur.dto.CommentaireForumDto;
import fr.gaminglab.orchestrateur.dto.JoueurCommentaireForumDto;
import fr.gaminglab.orchestrateur.dto.JoueurSujetForumDto;
import fr.gaminglab.orchestrateur.dto.SujetForumDto;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gaminglab/forum")
public class ForumAngularController {

	private ForumWebService wsForum = new ForumWebService();	
	
	@GetMapping("/categorie")
	List<CategorieForum> getAllCategorieForum() {
		// Ok
		return wsForum.getAllCategorieForum();
	}

	@GetMapping("/categorieSujet/{idSujetForum}")
	List<CommentaireForumDto> getAllCommentaireBySujet(@PathVariable Integer idSujetForum) {
		return wsForum.getAllCommentaireBySujet(idSujetForum);
	}

	@GetMapping("/categorie/{idCategorieForum}")
	CategorieForum getCategorieForumById(@PathVariable Integer idCategorieForum) {
		return wsForum.getCategorieForumById(idCategorieForum);
	}

	@GetMapping("/categorie/{idCategorieForum}/sujet")
	List<SujetForumDto> getAllSujetByCategorieForum(@PathVariable Integer idCategorieForum) {
		return wsForum.getAllSujetByCategorieForum(idCategorieForum);
	}
	
	@GetMapping("/categorieJoueur/{idJoueur}")
	public List<SujetForumDto> getSujetForumByJoueur(@PathVariable Integer idJoueur) {
		return wsForum.getSujetForumByJoueur(idJoueur);
	}

	@GetMapping("/sujet/{idSujet}")
	SujetForumDto getSujetById(@PathVariable Integer idSujet) {
		return wsForum.getSujetForumDtoById(idSujet);
	}

	@GetMapping("/sujet/{idSujetForum}/commentaire")
	List<CommentaireForumDto> getAllCommentaireForumBySujet(@PathVariable Integer idSujetForum) {
		return wsForum.getAllCommentaireForumBySujet(idSujetForum);
	}

	@GetMapping("/commentaire/{idCommentaire}")
	CommentaireForumDto getCommentaireForumById(@PathVariable Integer idCommentaire) {
		return wsForum.getCommentaireForumDtoById(idCommentaire);
	}

	//Modif Chris 25/11
	@PostMapping("/commentaire")
	public CommentaireForumDto ajouterCommentaire(@RequestBody CommentaireForumDto commentaireForumDto) {
		
		return wsForum.ajouterCommentaire(commentaireForumDto);
	}

	@PostMapping("/sujetajouter/{idJoueur}")
	public SujetForum ajouterSujet(@RequestBody SujetForumDto sujetForumDto, @PathVariable Integer idJoueur) {
		SujetForum sujetForum = wsForum.getSujetForumById(sujetForumDto.getIdSujet());
		return wsForum.ajouterSujet(sujetForum, idJoueur);
	}
	
	@GetMapping("/sujets")
	List<SujetForumDto> getAllSujet() {
		return wsForum.getAllSujet();
	}

	@DeleteMapping("/commentairesup/{idCommentaireForum}")
	public void supprimerCommentaire(@PathVariable Integer idCommentaireForum) {
		// Ok
		wsForum.supprimerCommentaire(idCommentaireForum);
	}

	@GetMapping("/joueurcommentaireforum/{idUtilisateur}/{idCommentaire}/")
	//@ResponseBody
	JoueurCommentaireForum getJoueurCommentaireForum(@PathVariable Integer idUtilisateur,
														   @PathVariable Integer idCommentaire) {

		return wsForum.getJoueurCommentaireForum(idUtilisateur, idCommentaire);
	}
	
	//Modif Chris
	@GetMapping("/joueursujetforum/{idUtilisateur}/{idSujet}")
    public JoueurSujetForum getJoueurSujetForumByIdJoueurSujet(@PathVariable Integer idUtilisateur,@PathVariable Integer idSujet){
    	return wsForum.getJoueurSujetForumByIdJoueurSujet(idUtilisateur, idSujet);
    }
	
	@PostMapping("/joueursujetforum")
	public JoueurSujetForum ajouterJoueurSujetForum(@RequestBody JoueurSujetForum joueurSujetForum) {
		return wsForum.ajouterJoueurSujetForum(joueurSujetForum);
	}
	
	@PostMapping("/majjoueursujetforum")
	public JoueurSujetForum majNoteJoueurSujetForum(@RequestBody JoueurSujetForum joueurSujetForum) {
		return wsForum.majNoteJoueurSujetForum(joueurSujetForum);
	}
	
	//Ajout Chris
	@GetMapping("/joueurcommentaireforum/{idUtilisateur}/{idCommentaire}")
    public JoueurCommentaireForum getJoueurCommentaireForumByIdJoueurCommentaire(@PathVariable Integer idUtilisateur,@PathVariable Integer idCommentaire){
    	return wsForum.getJoueurCommentaireForumByIdJoueurCommentaire(idUtilisateur, idCommentaire);
    }
	
	//Ajout Chris
	@PostMapping("/joueurcommentaireforum")
	public JoueurCommentaireForum insertJoueurCommentaireForum(@RequestBody JoueurCommentaireForum joueurCommentaireForum) {
		return wsForum.insertJoueurCommentaireForum(joueurCommentaireForum);
	}
	
	//Ajout Chris
	@PostMapping("/majjoueurcommentaireforum")
	public JoueurCommentaireForum updateJoueurCommentaireForum(@RequestBody JoueurCommentaireForum joueurCommentaireForum) {
		return wsForum.updateJoueurCommentaireForum(joueurCommentaireForum);
	}
	
	//Ajout Chris
	@GetMapping("/commentaires_parent/{idSujet}")
	public List<CommentaireForumDto> getAllCommentairesForumParent(@PathVariable Integer idSujet) {
		return wsForum.getAllCommentairesForumParent(idSujet);
	}
	
	//Ajout Chris
	@GetMapping("/commentaires_enfant/{idCommentaire}")
	public List<CommentaireForumDto> getAllCommentairesForumEnfant(@PathVariable Integer idCommentaire) {		
		return wsForum.getAllCommentairesForumEnfant(idCommentaire);
	}
	
}
