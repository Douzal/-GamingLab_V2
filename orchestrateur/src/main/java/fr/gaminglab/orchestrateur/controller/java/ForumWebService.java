package fr.gaminglab.orchestrateur.controller.java;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;

import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.forum.entity.CategorieForum;
import fr.gaminglab.forum.entity.CommentaireForum;
import fr.gaminglab.forum.entity.JoueurCommentaireForum;
import fr.gaminglab.forum.entity.JoueurSujetForum;
import fr.gaminglab.forum.entity.SujetForum;
import fr.gaminglab.orchestrateur.dto.CommentaireForumDto;
import fr.gaminglab.orchestrateur.dto.JoueurCommentaireForumDto;
import fr.gaminglab.orchestrateur.dto.JoueurSujetForumDto;
import fr.gaminglab.orchestrateur.dto.SujetForumDto;

public class ForumWebService {

	private static final String SUJETS2 = "/sujets";
	private static final String MAJJOUEURCOMMENTAIREFORUM = "/majjoueurcommentaireforum";
	private static final String COMMENTAIRES_ENFANT = "/commentaires_enfant";
	private static final String COMMENTAIRES_PARENT = "/commentaires_parent";
	private static final String SUJETS = SUJETS2;
	private static final String MAJ_JOUEUR_SUJET_FORUM = "/majjoueursujetforum";
	private static final String AJOUTER_JOUEUR_SUJET_FORUM = "/ajouterjoueursujetforum";
	private static final String JOUEUR_SUJET_FORUM = "/joueursujetforum";
	private static final String JOUEUR_COMMENTAIRE_FORUM = "/joueurcommentaireforum";
	private static final String COMMENTAIRE_SUP = "/commentairesup";
	private static final String SUJET_AJOUTER = "/sujetajouter";
	private static final String COMMENTAIRE_AJOUTER = "/commentaireajouter";
	private static final String COMMENTAIRE = "/commentaire";
	private static final String CATEGORIE_JOUEUR = "/categoriejoueur";
	private static final String SUJET = "/sujet";
	private static final String SLASH = "/";
	private static final String CATEGORIE = "/categorie";
	private static final String CATEGORIE_SUJET = "/categoriesujet";
	private RestTemplate restTemplate;
	private String base_url_forum = null;
	private UtilisateurWebService wsUtilisateur = new UtilisateurWebService();

	public ForumWebService() {
		restTemplate = new RestTemplate();
		try {
			Properties props = new Properties();
			InputStream is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("ws_java_forum.properties");
			props.load(is);
			is.close();
			this.base_url_forum = props.getProperty("ws_java_forum.base_url");
			System.out.println("ForumJavaController -> base_url_forum=" + base_url_forum);
			
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
		CategorieForum[] categorieForums = restTemplate.getForObject(base_url_forum + CATEGORIE, CategorieForum[].class);
		return Arrays.asList(categorieForums);
	}

	/**
	 * GET URL = /gaminglab/forum/categoriesujet/{idSujetForum}
	 * 
	 * @param idSujetForum
	 * @return
	 */
	public List<CommentaireForumDto> getAllCommentaireBySujet(Integer idSujetForum) {
		CommentaireForum[] commentaireForums = restTemplate
				.getForObject(base_url_forum + CATEGORIE_SUJET + SLASH + idSujetForum, CommentaireForum[].class);
		//coucou
		List<CommentaireForum> listAllCommentaireBySujet = Arrays.asList(commentaireForums);
		List<CommentaireForumDto>  listAllCommentaireBySujetDto = remplirListCommentaireForumDto(listAllCommentaireBySujet);
		return listAllCommentaireBySujetDto;
	}

	/**
	 * GET URL = /gaminglab/forum/categorie/{idCategorieForum}
	 * 
	 * @param idCategorieForum
	 * @return
	 */
	public CategorieForum getCategorieForumById(Integer idCategorieForum) {
		return restTemplate.getForObject(base_url_forum + CATEGORIE + SLASH + idCategorieForum, CategorieForum.class);
	}

	/**
	 * GET URL = /gaminglab/forum/categorie/{idCategorieForum}/sujet
	 * 
	 * @param idCategorieForum
	 * @return
	 */
	public List<SujetForumDto> getAllSujetByCategorieForum(Integer idCategorieForum) {
		SujetForum[] sujetForums = restTemplate.getForObject(base_url_forum + CATEGORIE + SLASH + idCategorieForum + SUJET,
				SujetForum[].class);
		//coucou
		List<SujetForum> listAllSujetByCategorie = Arrays.asList(sujetForums);
		List<SujetForumDto> listAllSujetByCategorieDto = remplirListSujetForumDto(listAllSujetByCategorie);
		return listAllSujetByCategorieDto;
	}

	/**
	 * GET URL = /gaminglab/forum/categoriejoueur/{idJoueur}
	 * 
	 * @param idJoueur
	 * @return
	 */
	public List<SujetForumDto> getSujetForumByJoueur(Integer idJoueur) {
		SujetForum[] sujetForums = restTemplate.getForObject(base_url_forum + CATEGORIE_JOUEUR + SLASH + idJoueur,
				SujetForum[].class);
		//coucou
		List<SujetForum> listSujetForumByJoueur = Arrays.asList(sujetForums);
		List<SujetForumDto> listSujetForumByJoueurDto = remplirListSujetForumDto(listSujetForumByJoueur);
		return 	listSujetForumByJoueurDto;
	}

	/**
	 * GET URL = /gaminglab/forum/sujet/{idSujet}
	 * 
	 * @param idSujet
	 * @return
	 */
	public SujetForumDto getSujetForumDtoById(Integer idSujet) {
		SujetForum sujetForum = getSujetForumById(idSujet);
		SujetForumDto sujetForumDto = remplirSujetForumDto(sujetForum);
		return sujetForumDto;
	}

	public SujetForum getSujetForumById(Integer idSujet) {
		SujetForum sujetForum = restTemplate.getForObject(base_url_forum + SUJET + SLASH + idSujet, SujetForum.class);
		return sujetForum;
	}

	/**
	 * GET URL = /gaminglab/forum/sujet/{idSujetForum}/commentaire
	 * 
	 * @param idSujetForum
	 * @return
	 */
	public List<CommentaireForumDto> getAllCommentaireForumBySujet(Integer idSujetForum) {
		CommentaireForum[] commentaireForums = restTemplate
				.getForObject(base_url_forum + SUJET + SLASH + idSujetForum + COMMENTAIRE, CommentaireForum[].class);
		//coucou
		List<CommentaireForum> listAllCommentaireForumBySujet = Arrays.asList(commentaireForums);
		List<CommentaireForumDto> listAllCommentaireForumBySujetDto = remplirListCommentaireForumDto(listAllCommentaireForumBySujet);
		return listAllCommentaireForumBySujetDto;
	}

	/**
	 * GET URL = /gaminglab/forum/commentaire/{idCommentaire}
	 * 
	 * @param idCommentaire
	 * @return
	 */
	public CommentaireForumDto getCommentaireForumDtoById(Integer idCommentaire) {
		CommentaireForum commentaireForum = getCommentaireForumById(idCommentaire);
		CommentaireForumDto commentaireForumDto = remplirCommentaireForumDto(commentaireForum);
		return commentaireForumDto;
	}

	public CommentaireForum getCommentaireForumById(Integer idCommentaire) {
		CommentaireForum commentaireForum = restTemplate.getForObject(base_url_forum + COMMENTAIRE + SLASH + idCommentaire, CommentaireForum.class);
		return commentaireForum;
	}

	/**
	 * POST URL = /gaminglab/forum/commentaireajouter/{idJoueur}
	 * 
	 * @param commentaireForum
	 * @param idJoueur
	 * @return
	 */
	public CommentaireForumDto ajouterCommentaire (CommentaireForumDto commentaireForumDto) {
		
		Integer idJoueur = commentaireForumDto.getJoueur().getIdUtilisateur();
		
		CommentaireForum commentaireForum = new CommentaireForum(
				commentaireForumDto.getContenu(),
				commentaireForumDto.getDateEmission(),
				commentaireForumDto.getNote(),
				commentaireForumDto.getSujetForum(),
				commentaireForumDto.getIdCommentaireSup(),
				idJoueur);
		
		CommentaireForum commentaireAfterInsert = 
				restTemplate.postForObject(base_url_forum + COMMENTAIRE_AJOUTER + SLASH + idJoueur, 
						commentaireForum, 
						CommentaireForum.class);
		
		return remplirCommentaireForumDto(commentaireAfterInsert);
	}

	/**
	 * POST URL = /gaminglab/forum/sujetajouter/{idJoueur}
	 * 
	 * @param commentaireForum
	 * @param idJoueur
	 * @return
	 */
	public SujetForum ajouterSujet(SujetForum sujetForum, Integer idJoueur) {
		return restTemplate.postForObject(base_url_forum + SUJET_AJOUTER + SLASH + idJoueur, sujetForum, SujetForum.class);
	}

	/**
	 * DELETE URL = /gaminglab/forum/commentairesup/{idCommentaireForum}
	 * 
	 * @param idCommentaireForum
	 */
	public void supprimerCommentaire(Integer idCommentaireForum) {
		restTemplate.delete(base_url_forum + COMMENTAIRE_SUP + SLASH + idCommentaireForum);
	}

	/**
	 * GET URL =
	 * /gaminglab/forum/joueurcommentaireforum/{idUtilisateur}/{idCommentaire}/
	 * 
	 * @param idUtilisateur
	 * @param idCommentaire
	 * @return
	 */
	public JoueurCommentaireForum getJoueurCommentaireForum(Integer idUtilisateur, Integer idCommentaire) {
		return restTemplate.getForObject(
				base_url_forum + JOUEUR_COMMENTAIRE_FORUM + SLASH + idUtilisateur + SLASH + idCommentaire,
				JoueurCommentaireForum.class);		
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
		JoueurSujetForum joueurSujetForum = restTemplate.getForObject(base_url_forum + JOUEUR_SUJET_FORUM + SLASH + idUtilisateur + SLASH + idSujet, JoueurSujetForum.class);
		return joueurSujetForum;
	}

	/**
	 * POST URL = /gaminglab/forum/joueursujetforum
	 * 
	 * @param joueurSujetForum
	 * @return
	 */
	public JoueurSujetForum insertJoueurSujetForum(JoueurSujetForum joueurSujetForum) {
		return restTemplate.postForObject(base_url_forum + JOUEUR_SUJET_FORUM, joueurSujetForum, JoueurSujetForum.class);
	}

	/**
	 * PUT URL = /gaminglab/forum/joueursujetforum
	 * 
	 * @param joueurSujetForum
	 */
	public void updateJoueurSujetForum(JoueurSujetForum joueurSujetForum) {
		restTemplate.put(base_url_forum + JOUEUR_SUJET_FORUM, joueurSujetForum, JoueurSujetForum.class);
	}

	/**
	 * GET URL = /gaminglab/forum/joueurcommentaireforum/{idJoueur}/{idCommentaire}
	 * @param idJoueur
	 * @param idCommentaire
	 * @return
	 */
	public JoueurCommentaireForum getJoueurCommentaireForumByIdJoueurCommentaire(Integer idJoueur,
			Integer idCommentaire) {
		JoueurCommentaireForum joueurCommentaireForum = restTemplate.getForObject(base_url_forum + JOUEUR_COMMENTAIRE_FORUM + SLASH + idJoueur + SLASH + idCommentaire,
						JoueurCommentaireForum.class);
		return joueurCommentaireForum;
	}
	
	/**
	 * POST URL = /gaminglab/forum/joueurcommentaireforum
	 * 
	 * @param joueurSujetForum
	 * @return
	 */
	public JoueurCommentaireForum insertJoueurCommentaireForum(JoueurCommentaireForum joueurCommentaireForum) {
		return restTemplate.postForObject(base_url_forum + JOUEUR_COMMENTAIRE_FORUM, joueurCommentaireForum, JoueurCommentaireForum.class);
	}

	/**
	 * POST URL = /gaminglab/forum/joueurcommentaireforum
	 * 
	 * @param joueurSujetForum
	 */
	public JoueurCommentaireForum updateJoueurCommentaireForum(JoueurCommentaireForum joueurCommentaireForum) {
		return restTemplate.postForObject(base_url_forum + MAJJOUEURCOMMENTAIREFORUM, joueurCommentaireForum, JoueurCommentaireForum.class);
	}
	
	public JoueurSujetForum ajouterJoueurSujetForum(JoueurSujetForum joueurSujetForum) {
		return restTemplate.postForObject(base_url_forum+AJOUTER_JOUEUR_SUJET_FORUM, joueurSujetForum, JoueurSujetForum.class);
	}
	
	public JoueurSujetForum majNoteJoueurSujetForum( JoueurSujetForum joueurSujetForum) {
		return restTemplate.postForObject(base_url_forum+MAJ_JOUEUR_SUJET_FORUM, joueurSujetForum,JoueurSujetForum.class);
	}
	
	public List<SujetForumDto> getAllSujet() {
		SujetForum[] allSujets = restTemplate.getForObject(base_url_forum+SUJETS, SujetForum[].class);
		List<SujetForum> listAllSujets = Arrays.asList(allSujets);
		List<SujetForumDto> listAllSujetsDto = remplirListSujetForumDto(listAllSujets);
		return listAllSujetsDto;
	}

	//Ajout Chris
	public List<CommentaireForumDto> getAllCommentairesForumParent(Integer idSujet) {
		CommentaireForum[] allCommParent = restTemplate.getForObject(base_url_forum+ COMMENTAIRES_PARENT + SLASH + idSujet, CommentaireForum[].class);
		List<CommentaireForum> listAllCommentaires = Arrays.asList(allCommParent);
		List<CommentaireForumDto> listAllCommentaireDto = remplirListCommentaireForumDto(listAllCommentaires);		
		return listAllCommentaireDto;
	}
	
	
	//Ajout Chris
	public List<CommentaireForumDto> getAllCommentairesForumEnfant(Integer idCommentaire) {
		CommentaireForum[] allCommEnfant = restTemplate.getForObject(base_url_forum + COMMENTAIRES_ENFANT + SLASH + idCommentaire, CommentaireForum[].class);
		List<CommentaireForum> listAllCommentaires = Arrays.asList(allCommEnfant);
		List<CommentaireForumDto> listAllCommentaireDto = remplirListCommentaireForumDto(listAllCommentaires);
		return listAllCommentaireDto;
	}
	
	private List<CommentaireForumDto> remplirListCommentaireForumDto(List<CommentaireForum> listAllCommentaireBySujet) {
		List<CommentaireForumDto>  listAllCommentaireBySujetDto = new ArrayList();
		for(CommentaireForum commentaireForum : listAllCommentaireBySujet) {
			CommentaireForumDto commentaireForumDto = remplirCommentaireForumDto(commentaireForum);
			listAllCommentaireBySujetDto.add(commentaireForumDto);
		}
		return listAllCommentaireBySujetDto;
	}

	private CommentaireForumDto remplirCommentaireForumDto(CommentaireForum commentaireForum) {
		Joueur joueur = wsUtilisateur.getJoueurById(commentaireForum.getIdJoueur());
		
		CommentaireForumDto commentaireForumDto = new CommentaireForumDto(
				commentaireForum.getIdCommentaire(),
				commentaireForum.getContenu(),
				commentaireForum.getDateEmission(),
				commentaireForum.getNote(),
				commentaireForum.getSujetForum(),
				commentaireForum.getIdCommentaireSup(),
				joueur);
		return commentaireForumDto;
	}
	
	private List<SujetForumDto> remplirListSujetForumDto(List<SujetForum> listAllSujets) {
		List<SujetForumDto> listAllSujetsDto = new ArrayList();
		for (SujetForum sujetForum : listAllSujets) {
			SujetForumDto sujetForumDto = remplirSujetForumDto(sujetForum);
			listAllSujetsDto.add(sujetForumDto);
		}
		return listAllSujetsDto;
	}

	private SujetForumDto remplirSujetForumDto(SujetForum sujetForum) {
		Joueur joueur = wsUtilisateur.getJoueurById(sujetForum.getIdJoueurCreateur());
		Integer nombreCommentaire = getAllCommentaireBySujet(sujetForum.getIdSujet()).size();
		SujetForumDto sujetForumDto = new SujetForumDto(sujetForum.getIdSujet(),
				sujetForum.getLibelle(),
				sujetForum.getDescriptif(),
				sujetForum.getDateCreation(),
				sujetForum.getNote(),
				sujetForum.getCategorieForum(),
				joueur,
				nombreCommentaire);
		return sujetForumDto;
	}
	
	private List<JoueurCommentaireForumDto> remplirListJoueurCommentaireForumDto(List<JoueurCommentaireForum> listJoueurCommentaires) {
		List<JoueurCommentaireForumDto> listJoueurCommentaireDto = new ArrayList();
		for(JoueurCommentaireForum joueurCommentaireForum : listJoueurCommentaires) {
			JoueurCommentaireForumDto joueurCommentaireForumDto = 
					remplirJoueurCommentaireForumDto(joueurCommentaireForum);
			listJoueurCommentaireDto.add(joueurCommentaireForumDto);				
		}
		return listJoueurCommentaireDto;
	}

	private JoueurCommentaireForumDto remplirJoueurCommentaireForumDto(JoueurCommentaireForum joueurCommentaireForum) {
		Joueur joueur = wsUtilisateur.getJoueurById(joueurCommentaireForum.getIdJoueurCommentaire());
		JoueurCommentaireForumDto joueurCommentaireForumDto = new JoueurCommentaireForumDto(
				                      joueurCommentaireForum.getIdJoueurCommentaire(),
				                      joueurCommentaireForum.getDateNote(),		
				                      joueur,
				                      joueurCommentaireForum.getVote(),
				                      joueurCommentaireForum.getCommentaireForum()
				                      );
		return joueurCommentaireForumDto;
	}
	
	private JoueurSujetForumDto remplirJoueurSujetForumDto(Integer idUtilisateur, JoueurSujetForum joueurSujetForum) {
		return new JoueurSujetForumDto(joueurSujetForum.getIdJoueurSujet(),
				joueurSujetForum.getDateNote(),
				joueurSujetForum.getVote(),
				wsUtilisateur.getJoueurById(idUtilisateur),
				joueurSujetForum.getSujetForum());
	}
	
	//Ajout Chris : 26/11
	public List<SujetForum> getAllSujeLibelle(String libelle) {
		
		SujetForum[] sujets = restTemplate.getForObject(base_url_forum + SUJETS2 + SLASH + libelle, SujetForum[].class);
		
		return Arrays.asList(sujets);
	}
}
