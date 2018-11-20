package fr.gaminglab.service.impl.communication;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import fr.gaminglab.entity.communication.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gaminglab.dao.api.communication.IDaoCategorieForum;
import fr.gaminglab.dao.api.communication.IDaoCommentaireForum;
import fr.gaminglab.dao.api.communication.IDaoJoueurCommentaireForum;
import fr.gaminglab.dao.api.communication.IDaoJoueurSujet;
import fr.gaminglab.dao.api.communication.IDaoSujetForum;
import fr.gaminglab.entity.jeu.Jeu;
import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.service.api.communication.IServiceForum;

import javax.transaction.Transactional;

/**
 * 
 */
@Service
@Transactional
public class ServiceForum implements IServiceForum {

    public ServiceForum() {
    }

    @Autowired
    private IDaoJoueurSujet daoJoueurSujet;

    @Autowired
    private IDaoCategorieForum daoCategorieForum;

    @Autowired
    private IDaoSujetForum daoSujetForum;

    @Autowired
    private IDaoJoueurCommentaireForum daoJoueurCommentaireForum;

    @Autowired
    private IDaoCommentaireForum daoCommentaireForum;



    @Override
    public Optional<CategorieForum> getCategorieForumById(Integer id) {
        return daoCategorieForum.findById(id);
    }

    @Override
    public Optional<SujetForum> getSujetForumById(Integer id) {
        return daoSujetForum.findById(id);
    }

    @Override
    public Optional<CommentaireForum> getCommentaireForumById(Integer id) {
        return daoCommentaireForum.findById(id);
    }

    /**
     * @param comForum 
     * @param joueur 
     * @return
     */
    public CommentaireForum ajouterCommentaire(CommentaireForum comForum, Joueur joueur) {
        // TODO implement here
        return null;
    }

    /**
     * @param sujet 
     * @param joueur 
     * @return
     */
    public SujetForum ajouterSujet(SujetForum sujet, Joueur joueur) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public List<CategorieForum> getAllCategorieForum() {
        // TODO implement here
        return null;
    }

    /**
     * @param sujet 
     * @return
     */
    public List<CommentaireForum> getAllCommentaireBySujet(SujetForum sujet) {
        // TODO implement here
        return null;
    }

    /**
     * @param cat 
     * @return
     */
    public List<SujetForum> getAllSujetByCategorie(CategorieForum cat) {
        // TODO implement here
        return null;
    }

    /**
     * @param jeu 
     * @return
     */
    public List<SujetForum> getSujetByJeu(Jeu jeu) {
        // TODO implement here
        return null;
    }

    /**
     * @param libelle 
     * @return
     */
    public List<SujetForum> getSujetByLibelle(String libelle) {

        return daoSujetForum.findTop5ByLibelleStartingWith(libelle);
    }

    /**
     * @param comForum 
     * @param joueur 
     * @return
     */
    public CommentaireForum noteCommentaire(CommentaireForum comForum, Joueur joueur) {
        JoueurCommentaireForum joueurCommentaireForum = new JoueurCommentaireForum();
        joueurCommentaireForum.setJoueur(joueur);
        joueurCommentaireForum.setCommentaireForum(comForum);
        joueurCommentaireForum.setDateNote(new Date());
        daoJoueurCommentaireForum.save(joueurCommentaireForum);
        return daoCommentaireForum.save(comForum);
    }

    /**
     * @param sujet 
     * @param joueur 
     * @return
     */
    public SujetForum noteSujet(SujetForum sujet, Joueur joueur) {
        JoueurSujetForum joueurSujetForum = new JoueurSujetForum();
        joueurSujetForum.setJoueur(joueur);
        joueurSujetForum.setSujetForum(sujet);
        joueurSujetForum.setDateNote(new Date());
        daoJoueurSujet.save(joueurSujetForum);
        return daoSujetForum.save(sujet);
    }

    /**
     * @param comForum 
     * @return
     */
    public boolean supprimerCommentaire(CommentaireForum comForum) {
        // TODO implement here
        return false;
    }

    /**
     * @param sujet 
     * @param joueur 
     * @return
     */
    public boolean supprimerSujet(SujetForum sujet, Joueur joueur) {
        // TODO implement here
        return false;
    }

    @Override
    public List<CommentaireForum> getCommentaireForumByJoueur(Integer idUtilisateur) {
        return daoCommentaireForum.findByJoueurIdUtilisateur(idUtilisateur);
    }

    @Override
    public List<SujetForum> getSujetForumByJoueur(Integer idUtilisateur) {
        return daoSujetForum.findByJoueurIdUtilisateur(idUtilisateur);
    }
}