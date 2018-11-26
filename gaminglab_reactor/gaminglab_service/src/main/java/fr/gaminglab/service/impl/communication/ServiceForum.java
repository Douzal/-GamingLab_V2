package fr.gaminglab.service.impl.communication;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gaminglab.dao.api.communication.IDaoCategorieForum;
import fr.gaminglab.dao.api.communication.IDaoCommentaireForum;
import fr.gaminglab.dao.api.communication.IDaoJoueurCommentaireForum;
import fr.gaminglab.dao.api.communication.IDaoJoueurSujet;
import fr.gaminglab.dao.api.communication.IDaoSujetForum;
import fr.gaminglab.entity.communication.CategorieForum;
import fr.gaminglab.entity.communication.CommentaireForum;
import fr.gaminglab.entity.communication.JoueurCommentaireForum;
import fr.gaminglab.entity.communication.JoueurSujetForum;
import fr.gaminglab.entity.communication.SujetForum;
import fr.gaminglab.entity.jeu.Jeu;
import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.service.api.communication.IServiceForum;

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
        comForum.setJoueur(joueur);
    	return daoCommentaireForum.save(comForum);       
    }

    /**
     * @param sujet 
     * @param joueur 
     * @return
     */
    public SujetForum ajouterSujet(SujetForum sujet, Joueur joueur) {
        //sujet.setJoueur(joueur);
    	return daoSujetForum.save(sujet);        
    }

    /**
     * @return
     */
    public List<CategorieForum> getAllCategorieForum() {
        return daoCategorieForum.findAll(); 
    }

    /**
     * @param sujet 
     * @return
     */
    public List<CommentaireForum> getAllCommentaireBySujet(SujetForum sujet) {
        return daoCommentaireForum.findBySujetForum(sujet); 
    }
    //coucou
    public List<CommentaireForum> getAllCommentaireBySujetTest(Integer idSujetForum) {
        return new ArrayList(); 
    }
    /**
     * @param cat 
     * @return
     */
    public List<SujetForum> getAllSujetByCategorie(CategorieForum cat) {
        return daoSujetForum.findByCategorieForum(cat); 
    }

    /**
     * @param jeu 
     * @return
     */
     public List<SujetForum> getSujetByJoueur(Integer idJoueur) {
        return null;      	
      }
     
      public List<SujetForum> getSujetByJeu(Jeu jeu) {
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
        daoCommentaireForum.delete(comForum);
        return false;
    }

    /**
     * @param sujet 
     * @param joueur 
     * @return
     */
    public boolean supprimerSujet(SujetForum sujet, Joueur joueur) {
        //sujet.setJoueur(joueur);
    	//daoSujetForum.delete(sujet);
        return false;
    }   

    @Override
    public List<CommentaireForum> getCommentaireForumByJoueur(Integer idUtilisateur) {
        return daoCommentaireForum.findByJoueurIdUtilisateur(idUtilisateur);
    }

    @Override
    public List<SujetForum> getSujetForumByJoueur(Integer idUtilisateur) {
        return null;
    }
    
    @Override
    public List<SujetForum> getAllSujetForum() {    	
    	List<SujetForum> listes = daoSujetForum.findAll();       	
    	return (List<SujetForum>)listes.stream()    	
    	    	.sorted((p1, p2) -> (p1.getNote().compareTo(p2.getNote())))
    	    	.collect(Collectors.toList());    	
    }
    @Override
    public List<JoueurSujetForum> getJoueurSujetForumByIdJoueurSujet(Integer idUtilisateur, Integer idSujet){
    	//sup List<JoueurSujetForum> liste = daoJoueurSujet.findByJoueurAndSujetForum(idUtilisateur, idSujet);
    	return daoJoueurSujet.findByJoueurAndSujetForum(idUtilisateur, idSujet);
    }
    
//    @Override
//    public void ajouterJoueurSujetForm() {
//    	
//    }
    
    
}