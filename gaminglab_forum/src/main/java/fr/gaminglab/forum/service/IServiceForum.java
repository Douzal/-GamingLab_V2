package fr.gaminglab.forum.service;

import java.util.List;
import java.util.Optional;


import fr.gaminglab.forum.entity.CategorieForum;
import fr.gaminglab.forum.entity.CommentaireForum;
import fr.gaminglab.forum.entity.JoueurSujetForum;
import fr.gaminglab.forum.entity.SujetForum;

/**
 * 
 */
public interface IServiceForum {

	/**
	 * @param comForum
	 * @param joueur
	 * @return
	 */
	public CommentaireForum ajouterCommentaire(CommentaireForum comForum, Integer idJoueur);

	/**
	 * @param sujet
	 * @param joueur
	 * @return
	 */
	public SujetForum ajouterSujet(SujetForum sujet, Integer idJoueur);

	/**
	 * @return
	 */
	public List<CategorieForum> getAllCategorieForum();

	/**
	 * @return
	 */
	public Optional<CategorieForum> getCategorieForumById(Integer id);

	/**
	 * @param sujet
	 * @return
	 */
	public List<CommentaireForum> getAllCommentaireBySujet(SujetForum sujet);

	/**
	 * @param cat
	 * @return
	 */
	public List<SujetForum> getAllSujetByCategorie(CategorieForum cat);

	/**
	 * @return
	 */
	public Optional<SujetForum> getSujetForumById(Integer id);

	/**
	 * @return
	 */
	public Optional<CommentaireForum> getCommentaireForumById(Integer id);

	/**
	 * @param jeu
	 * @return
	 */
	// public List<SujetForum> getSujetByJeu(Jeu jeu);

	/**
	 * @param libelle
	 * @return
	 */
	public List<SujetForum> getSujetByLibelle(String libelle);

	/**
	 * @param comForum
	 * @param joueur
	 * @return
	 */
	public CommentaireForum noteCommentaire(CommentaireForum comForum, Integer idJoueur);

	/**
	 * @param sujet
	 * @param joueur
	 * @return
	 */
	public SujetForum noteSujet(SujetForum sujet, Integer idJoueur);

	/**
	 * @param comForum
	 * @return
	 */
	public boolean supprimerCommentaire(CommentaireForum comForum);

	/**
	 * @param sujet
	 * @param joueur
	 * @return
	 */
	public boolean supprimerSujet(SujetForum sujet, Integer idJoueur);

	public List<CommentaireForum> getCommentaireForumByJoueur(Integer idUtilisateur);

	public List<SujetForum> getSujetForumByJoueur(Integer idUtilisateur);

	// coucou
	public List<SujetForum> getSujetByJoueur(Integer idUtilisateur);

	// coucou test
	public List<CommentaireForum> getAllCommentaireBySujetTest(Integer idSujetForum);

	public List<SujetForum> getAllSujetForum();
	
	public List<JoueurSujetForum> getJoueurSujetForumByIdJoueurSujet(Integer idUtilisateur, Integer idSujet);
	public void ajouterJoueurSujetForum(JoueurSujetForum joueurSujetForum);
	public void majNoteSujetForum(JoueurSujetForum joueurSujetForum);
}