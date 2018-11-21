package fr.gaminglab.orchestrateur.controller.angular;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gaminglab.entity.boutique.Commande;
import fr.gaminglab.entity.boutique.LigneCommande;
import fr.gaminglab.orchestrateur.controller.java.CommandeWebService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gaminglab")
public class CommandeAngularController {

	private CommandeWebService wsCommande = new CommandeWebService();

	@GetMapping("/panier/{idLigneCommande}")
	public LigneCommande getLigneCommandeById(@PathVariable Integer idLigneCommande) {
		return wsCommande.getLigneCommandeById(idLigneCommande);
	}

	@PostMapping("/panier")
	public LigneCommande ajouterLigneCommande(@PathVariable LigneCommande ligneCommande) {
		return wsCommande.ajouterLigneCommande(ligneCommande);
	}

	@DeleteMapping("/panier/{idLigneCommande}")
	public void supprimerLigneCommande(@PathVariable Integer idLigneCommande) {
		wsCommande.supprimerLigneCommande(idLigneCommande);
	}

	@PutMapping("/panier/{idLigneCommande}")
	public LigneCommande modifierLigneCommande(@PathVariable Integer idLigneCommande,
			@RequestBody LigneCommande ligneCommandeModifie) {
		return wsCommande.getLigneCommandeById(idLigneCommande);
	}

	@GetMapping("/commande/{idCommande}")
	public Commande getCommandeById(@PathVariable Integer idCommande) {
		return wsCommande.getCommandeById(idCommande);
	}

	@PostMapping("/commande")
	public Commande ajouterCommande(@RequestBody Commande commande) {
		return wsCommande.ajouterCommande(commande);
	}

	@PutMapping("/commande/{idCommande}")
	public Commande modifierCommande(@PathVariable Integer idCommande, @RequestBody Commande commandeModifie) {
		return wsCommande.modifierCommande(idCommande,commandeModifie);
	}

	@DeleteMapping("/commande/{idCommande}")
	public void supprimerCommande(@PathVariable Integer idCommande) {
		wsCommande.supprimerCommande(idCommande);
	}
}
