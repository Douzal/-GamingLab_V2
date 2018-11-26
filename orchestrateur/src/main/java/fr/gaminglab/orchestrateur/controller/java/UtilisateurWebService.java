package fr.gaminglab.orchestrateur.controller.java;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.springframework.web.client.RestTemplate;

import fr.gaminglab.entity.utilisateur.Civilite;
import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.entity.utilisateur.Utilisateur;

public class UtilisateurWebService {

	private static final String SLASH = "/";
	private static final String USER = "/user";
	private static final String INSCRIPTION = "/inscription";
	private static final String CONNEXION = "/connexion";
	private static final String CIVILITE = "/civilite";
	private RestTemplate restTemplate;
	private String base_url = null;

	public UtilisateurWebService() {
		restTemplate = new RestTemplate();
		try {
			Properties props = new Properties();
			InputStream is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("ws_java_reactor.properties");
			props.load(is);
			is.close();
			this.base_url = props.getProperty("ws_java_reactor_utilisateur.base_url");
			System.out.println("UtilisateurJavaController -> base_url=" + base_url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * GET URL = /gaminglab/user
	 * 
	 * @return
	 */
	public List<Joueur> getAllJoueur() {
		Joueur[] joueurs = restTemplate.getForObject(base_url + USER, Joueur[].class);
		return Arrays.asList(joueurs);
	}

	/**
	 * GET URL = /gaminglab/user/{idUtilisateur}
	 * 
	 * @param idUtilisateur
	 * @return
	 */
	public Joueur getJoueurById(Integer idUtilisateur) {
		return restTemplate.getForObject(base_url + USER + SLASH + idUtilisateur, Joueur.class);
	}

	/**
	 * GET URL = /gaminglab/inscription/{mail}
	 * 
	 * @param mail
	 * @return
	 */
	public boolean existMail(String mail) {
		return restTemplate.getForObject(base_url + INSCRIPTION + SLASH + mail, boolean.class);
	}

	/**
	 * GET URL = /gaminglab/inscription/{pseudo}
	 * 
	 * @param pseudo
	 * @return
	 */
	public boolean existPseudo(String pseudo) {
		return restTemplate.getForObject(base_url + INSCRIPTION + SLASH + pseudo, boolean.class);
	}

	/**
	 * POST URL = /gaminglab/connexion/{pseudo}/{password}
	 * 
	 * @param pseudo
	 * @param password
	 * @return
	 */
	public Joueur connexionJoueur(String pseudo, String password) {
		return restTemplate.postForObject(base_url + CONNEXION + SLASH + pseudo + SLASH + password, null,
				Joueur.class);
	}

	/**
	 * POST URL = /gaminglab/inscription
	 * 
	 * @param joueur
	 * @return
	 */
	public Joueur inscriptionJoueur(Joueur joueur) {
		return restTemplate.postForObject(base_url + INSCRIPTION, joueur, Joueur.class);
	}

	/**
	 * PUT URL = /gaminglab/user/{idUtilisateur}
	 * @param idUtilisateur
	 * @param joueurModifie
	 * @return
	 */
	public Utilisateur modifierJoueur(Integer idUtilisateur, Joueur joueurModifie) {
		restTemplate.put(base_url + USER + SLASH + idUtilisateur, joueurModifie);
		return joueurModifie;
	}

	/**
	 * GET URL = /gaminglab/civilite
	 * @return
	 */
	public List<Civilite> getAllCivilite() {
		Civilite[] civilites = restTemplate.getForObject(base_url + CIVILITE, Civilite[].class);
		return Arrays.asList(civilites);
	}

	/**
	 * GET URL = /gaminglab/civilite/{idCivilite}
	 * @param idCivilite
	 * @return
	 */
	public Civilite getCiviliteById(Integer idCivilite) {
		return restTemplate.getForObject(base_url + CIVILITE + SLASH + idCivilite, Civilite.class);
	}
}
