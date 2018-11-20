package fr.gaminglab.service.api.communication;

import fr.gaminglab.entity.communication.CategorieForum;
import fr.gaminglab.entity.communication.CommentaireForum;
import fr.gaminglab.entity.communication.SujetForum;
import fr.gaminglab.entity.jeu.Jeu;
import fr.gaminglab.entity.utilisateur.Joueur;

import java.util.List;
import java.util.Optional;

/**
 * 
 */
public interface IServiceForum {

    /**
     * @param comForum 
     * @param joueur 
     * @return
     */
    public CommentaireForum ajouterCommentaire(CommentaireForum comForum, Joueur joueur);

    /**
     * @param sujet 
     * @param joueur 
     * @return
     */
    public SujetForum ajouterSujet(SujetForum sujet, Joueur joueur);

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
    public List<SujetForum> getSujetByJeu(Jeu jeu);

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
    public CommentaireForum noteCommentaire(CommentaireForum comForum, Joueur joueur);

    /**
     * @param sujet 
     * @param joueur 
     * @return
     */
    public SujetForum noteSujet(SujetForum sujet, Joueur joueur);

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
    public boolean supprimerSujet(SujetForum sujet, Joueur joueur);

    public List<CommentaireForum> getCommentaireForumByJoueur(Integer idUtilisateur);

    public List<SujetForum> getSujetForumByJoueur(Integer idUtilisateur);

}