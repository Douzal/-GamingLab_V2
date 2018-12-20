package fr.gaminglab.orchestrateur.controller.angular;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gaminglab.entity.utilisateur.Civilite;
import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.entity.utilisateur.Utilisateur;
import fr.gaminglab.orchestrateur.controller.java.UtilisateurWebService;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8186"})
@RestController
@RequestMapping("/gaminglab")
public class UtilisateurAngularController {

	private UtilisateurWebService wsUtilisateur = new UtilisateurWebService();

	@GetMapping("/user")
	public List<Joueur> getAllJoueur(){
		return wsUtilisateur.getAllJoueur();
	}

	@GetMapping("/user/{idUtilisateur}")
	public Joueur getJoueurById(@PathVariable Integer idUtilisateur){
		return wsUtilisateur.getJoueurById(idUtilisateur);
	}

	@GetMapping("/inscription/{mail}")
	public boolean existMail(@PathVariable String mail){

		return wsUtilisateur.existMail(mail);
	}

	@GetMapping("/inscription/{pseudo}")
	public boolean existPseudo(@PathVariable String pseudo){
		return wsUtilisateur.existPseudo(pseudo);
	}

	@PostMapping("/connexion/{pseudo}/{password}")
	public Utilisateur connexionJoueur(@PathVariable String pseudo,@PathVariable String password){
		return wsUtilisateur.connexionJoueur(pseudo, password);
	}

	@PostMapping("/inscription")
	public Joueur inscriptionJoueur(@RequestBody Joueur joueur){
		return wsUtilisateur.inscriptionJoueur(joueur);
	}

	@PutMapping("/user/{idUtilisateur}")
	public Utilisateur modifierJoueur(@PathVariable Integer idUtilisateur,@RequestBody Joueur joueurModifie){
		return wsUtilisateur.modifierJoueur(idUtilisateur, joueurModifie);
	}

	@GetMapping("/civilite")
	public List<Civilite> getAllCivilite(){
		return wsUtilisateur.getAllCivilite();
	}

	@GetMapping("/civilite/{idCivilite}")
	public Civilite getCiviliteById(@PathVariable Integer idCivilite){
		return wsUtilisateur.getCiviliteById(idCivilite);
	}
}
