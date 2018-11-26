package fr.gaminglab.orchestrateur.controller.java;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.web.client.RestTemplate;

import fr.gaminglab.entity.boutique.Commande;
import fr.gaminglab.entity.boutique.LigneCommande;

public class CommandeWebService {

	private static final String SLASH = "/";
	private static final String PANIER = "/panier";
	private static final String COMMANDE = "/commande";
	private RestTemplate restTemplate;
	private String base_url = null;

	public CommandeWebService() {
		restTemplate = new RestTemplate();
		try {
			Properties props = new Properties();
			InputStream is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("ws_java_reactor.properties");
			props.load(is);
			is.close();
			this.base_url = props.getProperty("ws_java_reactor_commande.base_url");
			System.out.println("CommandeJavaController -> base_url=" + base_url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LigneCommande getLigneCommandeById(Integer idLigneCommande) {
		return restTemplate.getForObject(base_url + PANIER + idLigneCommande, LigneCommande.class);
	}

	public LigneCommande ajouterLigneCommande(LigneCommande ligneCommande) {
		return restTemplate.postForObject(base_url + PANIER, ligneCommande, LigneCommande.class);
	}

	public LigneCommande modifierLigneCommande(Integer idLigneCommande, LigneCommande ligneCommandeModifie) {
		restTemplate.put(base_url + PANIER + SLASH + idLigneCommande, ligneCommandeModifie);
		return ligneCommandeModifie;
	}

	public void supprimerLigneCommande(Integer idLigneCommande) {
		restTemplate.delete(base_url + PANIER + SLASH + idLigneCommande);
	}

	public Commande getCommandeById(Integer idCommande) {
		return restTemplate.getForObject(base_url + COMMANDE + SLASH + idCommande, Commande.class);
	}

	public Commande ajouterCommande(Commande commande) {
		return restTemplate.postForObject(base_url + COMMANDE, commande, Commande.class);
	}

	public Commande modifierCommande(Integer idCommande, Commande commandeModifie) {
		restTemplate.put(base_url + COMMANDE + SLASH + idCommande, commandeModifie);
		return commandeModifie;
	}

	public void supprimerCommande(Integer idCommande) {
		restTemplate.delete(base_url + COMMANDE + SLASH + idCommande);
	}
}
