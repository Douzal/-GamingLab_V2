package fr.gaminglab.orchestrateur.controller.java;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import fr.gaminglab.forum.entity.CategorieForum;
import fr.gaminglab.forum.entity.CommentaireForum;
import fr.gaminglab.forum.entity.JoueurCommentaireForum;
import fr.gaminglab.forum.entity.SujetForum;
import fr.gaminglab.forum.entity.JoueurSujetForum;

public class ForumWebService {

	private static final String COMMENTAIRES_ENFANT = "/commentaires_enfant";
	private static final String COMMENTAIRES_PARENT = "/commentaires_parent";
	private static final String SUJETS = "/sujets";
	private static final String MAJ_JOUEUR_SUJET_FORUM = "/majjoueursujetforum";
	private static final String AJOUTER_JOUEUR_SUJET_FORUM = "/ajouterjoueursujetforum";
	private static final String JOUEUR_SUJET_FORUM = "/joueursujetforum";
	private static final String JOUEUR_COMMENTAIRE_FORUM = "/joueurcommentaireforum";
	private static final String COMMENTAIRE_SUP = "/commentairesup";
	private static final String SUJET_AJOUTER = "/sujetajouter";
	private static final String COMMENTAIRE_AJOUTER = "/commentaireajouter";
	private static final String COMMENTAIRE = "commentaire";
	private static final String CATEGORIE_JOUEUR = "/categoriejoueur";
	private static final String SUJET = "/sujet";
	private static final String SLASH = "/";
	private static final String CATEGORIE = "/categorie";
	private static final String CATEGORIE_SUJET = "/categoriesujet";
	private RestTemplate restTemplate;
	private String base_url = null;

	public ForumWebService() {
		restTemplate = new RestTemplate();
		try {
			Properties props = new Properties();
			InputStream is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("ws_java_forum.properties");
			props.load(is);
			is.close();
			this.base_url = props.getProperty("ws_java_forum.base_url");
			System.out.println("ForumJavaController -> base_url=" + base_url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * GET URL = /gaminglab/forum/categorie
	 * 
	 * @return
	 */
	public List<CategorieForum> getAllCategorieForum() {
		CategorieForum[] categorieForums = restTemplate.getForObject(base_url + CATEGORIE, CategorieForum[].class);
		return Arrays.asList(categorieForums);
	}

	/**
	 * GET URL = /gaminglab/forum/categoriesujet/{idSujetForum}
	 * 
	 * @param idSujetForum
	 * @return
	 */
	public List<CommentaireForum> getAllCommentaireBySujet(Integer idSujetForum) {
		CommentaireForum[] commentaireForums = restTemplate
				.getForObject(base_url + CATEGORIE_SUJET + SLASH + idSujetForum, CommentaireForum[].class);
		return Arrays.asList(commentaireForums);
	}

	/**
	 * GET URL = /gaminglab/forum/categorie/{idCategorieForum}
	 * 
	 * @param idCategorieForum
	 * @return
	 */
	public CategorieForum getCategorieForumById(Integer idCategorieForum) {
		return restTemplate.getForObject(base_url + CATEGORIE + SLASH + idCategorieForum, CategorieForum.class);
	}

	/**
	 * GET URL = /gaminglab/forum/categorie/{idCategorieForum}/sujet
	 * 
	 * @param idCategorieForum
	 * @return
	 */
	public List<SujetForum> getAllSujetByCategorieForum(Integer idCategorieForum) {
		SujetForum[] sujetForums = restTemplate.getForObject(base_url + CATEGORIE + SLASH + idCategorieForum + SUJET,
				SujetForum[].class);
		return Arrays.asList(sujetForums);
	}

	/**
	 * GET URL = /gaminglab/forum/categoriejoueur/{idJoueur}
	 * 
	 * @param idJoueur
	 * @return
	 */
	public List<SujetForum> getSujetForumByJoueur(Integer idJoueur) {
		SujetForum[] sujetForums = restTemplate.getForObject(base_url + CATEGORIE_JOUEUR + SLASH + idJoueur,
				SujetForum[].class);
		return Arrays.asList(sujetForums);
	}

	/**
	 * GET URL = /gaminglab/forum/sujet/{idSujet}
	 * 
	 * @param idSujet
	 * @return
	 */
	public SujetForum getSujetById(Integer idSujet) {
		return restTemplate.getForObject(base_url + SUJET + SLASH + idSujet, SujetForum.class);
	}

	/**
	 * GET URL = /gaminglab/forum/sujet/{idSujetForum}/commentaire
	 * 
	 * @param idSujetForum
	 * @return
	 */
	public List<CommentaireForum> getAllCommentaireForumBySujet(Integer idSujetForum) {
		CommentaireForum[] commentaireForums = restTemplate
				.getForObject(base_url + SUJET + SLASH + idSujetForum + COMMENTAIRE, CommentaireForum[].class);
		return Arrays.asList(commentaireForums);
	}

	/**
	 * GET URL = /gaminglab/forum/commentaire/{idCommentaire}
	 * 
	 * @param idCommentaire
	 * @return
	 */
	public CommentaireForum getCommentaireForumById(Integer idCommentaire) {
		return restTemplate.getForObject(base_url + COMMENTAIRE + SLASH + idCommentaire, CommentaireForum.class);
	}

	/**
	 * POST URL = /gaminglab/forum/commentaireajouter/{idJoueur}
	 * 
	 * @param commentaireForum
	 * @param idJoueur
	 * @return
	 */
	public CommentaireForum ajouterCommentaire(CommentaireForum commentaireForum, Integer idJoueur) {
		return restTemplate.postForObject(base_url + COMMENTAIRE_AJOUTER + SLASH + idJoueur, commentaireForum,
				CommentaireForum.class);
	}

	/**
	 * POST URL = /gaminglab/forum/sujetajouter/{idJoueur}
	 * 
	 * @param commentaireForum
	 * @param idJoueur
	 * @return
	 */
	public SujetForum ajouterSujet(SujetForum sujetForum, Integer idJoueur) {
		return restTemplate.postForObject(base_url + SUJET_AJOUTER + SLASH + idJoueur, sujetForum, SujetForum.class);
	}

	/**
	 * DELETE URL = /gaminglab/forum/commentairesup/{idCommentaireForum}
	 * 
	 * @param idCommentaireForum
	 */
	public void supprimerCommentaire(Integer idCommentaireForum) {
		restTemplate.delete(base_url + COMMENTAIRE_SUP + SLASH + idCommentaireForum);
	}

	/**
	 * GET URL =
	 * /gaminglab/forum/joueurcommentaireforum/{idUtilisateur}/{idCommentaire}/
	 * 
	 * @param idUtilisateur
	 * @param idCommentaire
	 * @return
	 */
	public List<JoueurCommentaireForum> getJoueurCommentaireForum(Integer idUtilisateur, Integer idCommentaire) {
		JoueurCommentaireForum[] joueurCommentaireForums = restTemplate.getForObject(
				base_url + JOUEUR_COMMENTAIRE_FORUM + SLASH + idUtilisateur + SLASH + idCommentaire,
				JoueurCommentaireForum[].class);
		return Arrays.asList(joueurCommentaireForums);
	}

	//Modif Chris
	/**
	 * GET URL = /gaminglab/forum/joueursujetforum/{idUtilisateur}/{idCommentaire}/
	 * 
	 * @param idUtilisateur
	 * @param idCommentaire
	 * @return
	 */
	public JoueurSujetForum getJoueurSujetForumByIdJoueurSujet(Integer idUtilisateur, Integer idSujet) {
		
		return restTemplate.getForObject(base_url + JOUEUR_SUJET_FORUM + SLASH + idUtilisateur + SLASH + idSujet, JoueurSujetForum.class);
	}

	/**
	 * POST URL = /gaminglab/forum/joueursujetforum
	 * 
	 * @param joueurSujetForum
	 * @return
	 */
	public JoueurSujetForum insertJoueurSujetForum(JoueurSujetForum joueurSujetForum) {
		return restTemplate.postForObject(base_url + JOUEUR_SUJET_FORUM, joueurSujetForum, JoueurSujetForum.class);
	}

	/**
	 * PUT URL = /gaminglab/forum/joueursujetforum
	 * 
	 * @param joueurSujetForum
	 */
	public void updateJoueurSujetForum(JoueurSujetForum joueurSujetForum) {
		restTemplate.put(base_url + JOUEUR_SUJET_FORUM, joueurSujetForum, JoueurSujetForum.class);
	}

	/**
	 * GET URL = /gaminglab/forum/joueurcommentaireforum/{idJoueur}/{idCommentaire}
	 * @param idJoueur
	 * @param idCommentaire
	 * @return
	 */
	public JoueurCommentaireForum getJoueurCommentaireForumByIdJoueurCommentaire(Integer idJoueur,
			Integer idCommentaire) {
		return restTemplate.getForObject(base_url + JOUEUR_COMMENTAIRE_FORUM + SLASH + idJoueur + SLASH + idCommentaire,
				JoueurCommentaireForum.class);
	}
	
	/**
	 * POST URL = /gaminglab/forum/joueurcommentaireforum
	 * 
	 * @param joueurSujetForum
	 * @return
	 */
	public JoueurCommentaireForum insertJoueurCommentaireForum(JoueurCommentaireForum joueurCommentaireForum) {
		return restTemplate.postForObject(base_url + JOUEUR_COMMENTAIRE_FORUM, joueurCommentaireForum, JoueurCommentaireForum.class);
	}

	/**
	 * PUT URL = /gaminglab/forum/joueurcommentaireforum
	 * 
	 * @param joueurSujetForum
	 */
	public void updateJoueurCommentaireForum(JoueurCommentaireForum joueurCommentaireForum) {
		restTemplate.put(base_url + JOUEUR_COMMENTAIRE_FORUM, joueurCommentaireForum, joueurCommentaireForum, JoueurCommentaireForum.class);
	}
	
	public JoueurSujetForum ajouterJoueurSujetForum(JoueurSujetForum joueurSujetForum) {
		return restTemplate.postForObject(base_url+AJOUTER_JOUEUR_SUJET_FORUM, joueurSujetForum, JoueurSujetForum.class);
	}
	
	public void majNoteJoueurSujetForum( JoueurSujetForum joueurSujetForum) {
		restTemplate.put(base_url+MAJ_JOUEUR_SUJET_FORUM, joueurSujetForum,JoueurSujetForum.class);
	}
	
	public List<SujetForum> getAllSujet() {
		SujetForum[] allSujets = restTemplate.getForObject(base_url+SUJETS, SujetForum[].class);
		return Arrays.asList(allSujets);
	}
	
	//Ajout Chris
	public List<CommentaireForum> getAllCommentairesForumParent(Integer idSujet) {
		CommentaireForum[] allCommParent = restTemplate.getForObject(base_url+ COMMENTAIRES_PARENT + SLASH + idSujet, CommentaireForum[].class);
		return Arrays.asList(allCommParent);
	}
	
	//Ajout Chris
	public List<CommentaireForum> getAllCommentairesForumEnfant(Integer idCommentaire) {
		CommentaireForum[] allCommEnfant = restTemplate.getForObject(base_url+ COMMENTAIRES_ENFANT + SLASH + idCommentaire, CommentaireForum[].class);
		return Arrays.asList(allCommEnfant);
	}
	
}
