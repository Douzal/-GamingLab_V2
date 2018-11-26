package fr.gaminglab.orchestrateur.controller.java;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.springframework.web.client.RestTemplate;

import fr.gaminglab.entity.boutique.Commande;
import fr.gaminglab.entity.communication.CommentaireForum;
import fr.gaminglab.entity.communication.SujetForum;
import fr.gaminglab.entity.jeu.CommentaireJeu;
import fr.gaminglab.entity.jeu.Jeu;
import fr.gaminglab.entity.jeu.JoueurJeu;
import fr.gaminglab.entity.utilisateur.Adresse;
import fr.gaminglab.entity.utilisateur.JoueurBadge;
import fr.gaminglab.entity.utilisateur.JoueurCarte;

public class ProfilWebService {
	
	private static final String SLASH = "/";
	private static final String BADGE = "/badge";
	private static final String COMMENTAIRE_JEU = "/commentaireJeu";
	private static final String COMMENTAIRE_FORUM = "/commentaireForum";
	private static final String SUJET_FORUM = "/sujetForum";
	private static final String JEU_JOUE = "/jeuJoue";
	private static final String JEU_AJOUT = "/jeuAjout";
	private static final String COMMANDE = "/commande";
	private static final String CARTE_BANCAIRE = "/carteBancaire";
	private static final String ADRESSE = "/adresse";
	private RestTemplate restTemplate;
	private String base_url = null;
	
	public ProfilWebService() {
		restTemplate = new RestTemplate();
		try {
			Properties props = new Properties();
			InputStream is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("ws_java_reactor.properties");
			props.load(is);
			is.close();
			this.base_url = props.getProperty("ws_java_reactor_profil.base_url");
			System.out.println("ProfilJavaController -> base_url=" + base_url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
     * GET
	 * URL = /gaminglab/profil/{idUtilisateur}/badge
	 * @param idUtilisateur
	 * @return
	 */
    public List<JoueurBadge> getAllBadgeByMembre(Integer idUtilisateur){
		JoueurBadge[] joueurBadges = restTemplate.getForObject(base_url+SLASH+idUtilisateur+BADGE, JoueurBadge[].class);
		return Arrays.asList(joueurBadges);
    }
	
    /**
     * GET
     * URL = /gaminglab/profil/{idUtilisateur}/commentaireJeu
     * @param idUtilisateur
     * @return
     */
    public List<CommentaireJeu> getAllCommentaireJeuByMembre(Integer idUtilisateur){
		CommentaireJeu[] commentaireJeux = restTemplate.getForObject(base_url+SLASH+idUtilisateur+COMMENTAIRE_JEU, CommentaireJeu[].class);
		return Arrays.asList(commentaireJeux);
    }
    
    /**
     * GET
     * URL = /gaminglab/profil/{idUtilisateur}/commentaireForum
     * @param idUtilisateur
     * @return
     */
    public List<CommentaireForum> getAllCommentaireForumByMembre(Integer idUtilisateur){
    	CommentaireForum[] commentaireForums = restTemplate.getForObject(base_url+SLASH+idUtilisateur+COMMENTAIRE_FORUM, CommentaireForum[].class);
		return Arrays.asList(commentaireForums);
    }
    
    /**
     * GET
     * URL = /gaminglab/profil/{idUtilisateur}/sujetForum
     * @param idUtilisateur
     * @return
     */
    public List<SujetForum> getSujetByMembre(Integer idUtilisateur){
    	SujetForum[] sujetForums = restTemplate.getForObject(base_url+SLASH+idUtilisateur+SUJET_FORUM, SujetForum[].class);
		return Arrays.asList(sujetForums);
    }
    
    /**
     * GET
     * URL = /gaminglab/profil/{idUtilisateur}/jeuJoue
     * @param idUtilisateur
     * @return
     */
    public List<JoueurJeu> getJoueurJeuByMembre(Integer idUtilisateur){
    	JoueurJeu[] joueurJeux = restTemplate.getForObject(base_url+SLASH+idUtilisateur+JEU_JOUE, JoueurJeu[].class);
		return Arrays.asList(joueurJeux);
    }
    
    /**
     * GET
     * URL = /gaminglab/profil/{idUtilisateur}/jeuAjout
     * @param idUtilisateur
     * @return
     */
    public List<Jeu> getJeuByMembre(Integer idUtilisateur){
    	Jeu[] joueurJeux = restTemplate.getForObject(base_url+SLASH+idUtilisateur+JEU_AJOUT, Jeu[].class);
		return Arrays.asList(joueurJeux);
    }
    
    /**
     * GET
     * URL = /gaminglab/profil/{idUtilisateur}/commande
     * @param idUtilisateur
     * @return
     */
    public List<Commande> getAllCommandeByMembre(Integer idUtilisateur){
        Commande[] commandes = restTemplate.getForObject(base_url+SLASH+idUtilisateur+COMMANDE, Commande[].class);
		return Arrays.asList(commandes);
    }
    
    /**
     * GET
     * URL = /gaminglab/profil/{idUtilisateur}/carteBancaire
     * @param idUtilisateur
     * @return
     */
    public List<JoueurCarte> getAllCarteBancaireByMembre(Integer idUtilisateur){
    	JoueurCarte[] joueurCartes = restTemplate.getForObject(base_url+SLASH+idUtilisateur+CARTE_BANCAIRE, JoueurCarte[].class);
		return Arrays.asList(joueurCartes);
    }
    
    /**
     * POST
     * URL = /gaminglab/profil/{idUtilisateur}/carteBancaire
     * @param joueurCarte
     * @return
     */
    public JoueurCarte ajouterCarteBancaire(JoueurCarte joueurCarte){
        Integer idUtilisateur = joueurCarte.getJoueur().getIdUtilisateur();
		return restTemplate.postForObject(base_url+SLASH+idUtilisateur+CARTE_BANCAIRE, joueurCarte, JoueurCarte.class);
    }
    
    /**
     * DELETE
     * URL = /gaminglab/profil/{idUtilisateur}/carteBancaire/{idJoueurCarte}
     * @param idJoueurCarte
     */
    public void supprimerCarteBancaire(Integer idJoueurCarte){
    	//TODO Implementer avec idUtilisateur
    	Integer idUtilisateurFake = 1;
    	restTemplate.delete(base_url+SLASH+idUtilisateurFake+CARTE_BANCAIRE+idJoueurCarte);
    }
    
    /**
     * GET
     * URL = /gaminglab/profil/{idUtilisateur}/adresse
     * @param idUtilisateur
     * @return
     */
    public List<Adresse> getAllAdresseByMembre(Integer idUtilisateur){
    	Adresse[] adresses = restTemplate.getForObject(base_url+SLASH+idUtilisateur+ADRESSE, Adresse[].class);
		return Arrays.asList(adresses);
    }
    
    /**
     * POST
     * URL = /gaminglab/profil/{idUtilisateur}/adresse
     * @param adresse
     * @return
     */
    public Adresse ajouterAdresse(Adresse adresse){
    	//TODO Probleme ? Besoin idUtilisateur ?
        Integer idUtilisateur = adresse.getJoueur().getIdUtilisateur();
		return restTemplate.postForObject(base_url+idUtilisateur+ADRESSE, adresse, Adresse.class);
    }
}
