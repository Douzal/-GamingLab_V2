package fr.gaminglab.controller;

import java.util.List;
import java.util.Optional;

import fr.gaminglab.entity.utilisateur.Civilite;
import fr.gaminglab.entity.utilisateur.Utilisateur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.service.api.utilisateur.IServiceUtilisateur;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gaminglab")
public class UtilisateurController {

	public static final Logger logger = LoggerFactory.getLogger(Utilisateur.class);
	
	@Autowired
	private IServiceUtilisateur serviceUtilisateur;

	@GetMapping("/user")
	public List<Joueur> getAllJoueur(){
		List<Joueur> joueurs = serviceUtilisateur.getAllJoueur();
		return joueurs;
	}

	@GetMapping("/user/{idUtilisateur}")
	public Joueur getJoueurById(@PathVariable Integer idUtilisateur){
		Optional<Joueur> joueur = serviceUtilisateur.getJoueurById(idUtilisateur);
		if (joueur.isPresent()){
			return joueur.get();
		}
		else{
			return null;
		}
	}

	@GetMapping("/inscription/{mail}")
	public boolean existMail(@PathVariable String mail){

		return serviceUtilisateur.existeMail(mail);
	}

	@GetMapping("/inscription/{pseudo}")
	public boolean existPseudo(@PathVariable String pseudo){

		return serviceUtilisateur.existePseudo(pseudo);
	}

	@PostMapping("/connexion/{pseudo}/{password}")
	public Utilisateur connexionJoueur(@PathVariable String pseudo,@PathVariable String password){
		return serviceUtilisateur.connexion(pseudo, password);
	}

	@PostMapping("/inscription")
	public Joueur inscriptionJoueur(@RequestBody Joueur joueur){

		return serviceUtilisateur.inscrire(joueur);
	}

	@PutMapping("/user/{idUtilisateur}")
	public Utilisateur modifierJoueur(@PathVariable Integer idUtilisateur,@RequestBody Joueur joueurModifie){
		Optional<Joueur> joueur = serviceUtilisateur.getJoueurById(idUtilisateur);
		if (joueur.isPresent()){
			joueur.get().setCredit(joueurModifie.getCredit());
			return serviceUtilisateur.modifierJoueur(joueur.get());
		} else {
			return null;
		}
	}

	@GetMapping("/civilite")
	public List<Civilite> getAllCivilite(){
		List<Civilite> civilites = serviceUtilisateur.getAllCivilite();
		return civilites;
	}

	@GetMapping("/civilite/{idCivilite}")
	public Civilite getCiviliteById(@PathVariable Integer idCivilite){
		Optional<Civilite> civilite = serviceUtilisateur.getCiviliteById(idCivilite);
		if (civilite.isPresent()){
			return civilite.get();
		}
		else{
			return null;
		}
	}
}
