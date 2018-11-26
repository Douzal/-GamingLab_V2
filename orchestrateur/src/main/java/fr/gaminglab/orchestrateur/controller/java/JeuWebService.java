package fr.gaminglab.orchestrateur.controller.java;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.springframework.web.client.RestTemplate;

import fr.gaminglab.entity.jeu.CategorieJeu;
import fr.gaminglab.entity.jeu.CommentaireJeu;
import fr.gaminglab.entity.jeu.Jeu;
import fr.gaminglab.entity.jeu.JoueurJeu;
import fr.gaminglab.entity.jeu.Tag;

public class JeuWebService {

	private static final String SLASH = "/";
	private static final String CATEGORIE = "/categorie";
	private static final String JEU = "/jeu";
	private static final String TAG = "/tag";
	private static final String AJOUT_JEU = "/ajoutJeu";
	private static final String COMMENTAIRE = "/commentaire";
	private static final String JOUEUR = "/joueur";
	private static final String JOUEUR_JEU = "/joueurJeu";
	private static final String COMMENTAIRE_JEU = "/commentaireJeu";
	private RestTemplate restTemplate;
	private String base_url = null;

	public JeuWebService() {
		restTemplate = new RestTemplate();
		try {
			Properties props = new Properties();
			InputStream is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("ws_java_reactor.properties");
			props.load(is);
			is.close();
			this.base_url = props.getProperty("ws_java_reactor_jeu.base_url");
			System.out.println("JeuJavaController -> base_url=" + base_url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<CategorieJeu> getAllCategorieJeu() {
		CategorieJeu[] categorieJeu = restTemplate.getForObject(base_url + CATEGORIE, CategorieJeu[].class);
		return Arrays.asList(categorieJeu);
	}
	
    public CategorieJeu getCategorieJeuById(Integer idCategorieJeu){
        return restTemplate.getForObject(base_url + CATEGORIE + SLASH + idCategorieJeu, CategorieJeu.class);
    }

	public List<Jeu> getAllJeux() {
		Jeu[] jeux = restTemplate.getForObject(base_url + JEU, Jeu[].class);
		return Arrays.asList(jeux);
	}

	public Jeu getJeuById(Integer idJeu) {
		return restTemplate.getForObject(base_url + JEU + SLASH + idJeu, Jeu.class);
	}

	public List<Jeu> getAllJeuxByCategorie(Integer idCategorieJeu) {
		Jeu[] jeux = restTemplate.getForObject(base_url + CATEGORIE + SLASH + idCategorieJeu + JEU, Jeu[].class);
		return Arrays.asList(jeux);
	}

	public List<Tag> getAllTag() {
		Tag[] tags = restTemplate.getForObject(base_url + TAG, Tag[].class);
		return Arrays.asList(tags);
	}

	public Jeu ajouterJeu(Jeu jeu) {
		return restTemplate.postForObject(base_url + AJOUT_JEU, jeu, Jeu.class);
	}

	public void modifierJeu(Integer idJeu, Jeu jeuModifie) {
		restTemplate.put(base_url + JEU + SLASH + idJeu, jeuModifie);
	}

	public List<CommentaireJeu> getAllCommentaireJeuByJeu(Integer idJeu) {
		CommentaireJeu[] commentairesJeu = restTemplate.getForObject(base_url + JEU + SLASH + idJeu + COMMENTAIRE,
				CommentaireJeu[].class);
		return Arrays.asList(commentairesJeu);
	}

	public List<JoueurJeu> getMeilleurJoueurByJeu(Integer idJeu) {
		JoueurJeu[] joueursJeu = restTemplate.getForObject(base_url + JEU + SLASH + idJeu + JOUEUR, JoueurJeu[].class);
		return Arrays.asList(joueursJeu);
	}

	public JoueurJeu getJoueurJeuByJeuAndJoueur(Integer idJeu, Integer idUtilisateur) {
		return restTemplate.getForObject(base_url + JEU + SLASH + idJeu + JOUEUR + SLASH + idUtilisateur,
				JoueurJeu.class);
	}

	public JoueurJeu ajouterJoueurJeu(JoueurJeu joueurJeu) {
		return restTemplate.postForObject(base_url + JOUEUR_JEU, joueurJeu, JoueurJeu.class);
	}
	
    public CommentaireJeu ajouterCommentaireJeu(CommentaireJeu commentaireJeu){
		return restTemplate.postForObject(base_url + COMMENTAIRE_JEU, commentaireJeu, CommentaireJeu.class);
    }
    
    public JoueurJeu modifierJoueurJeu(Integer idJoueurJeu,JoueurJeu joueurJeuModifie){
    	restTemplate.put(base_url + JOUEUR_JEU + SLASH + idJoueurJeu, joueurJeuModifie);
        return joueurJeuModifie;
    }
}
