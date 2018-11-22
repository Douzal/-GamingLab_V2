package fr.gaminglab.forum.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gaminglab.forum.data.IDaoCategorieForum;
import fr.gaminglab.forum.data.IDaoCommentaireForum;
import fr.gaminglab.forum.data.IDaoJoueurCommentaireForum;
import fr.gaminglab.forum.data.IDaoJoueurSujet;
import fr.gaminglab.forum.data.IDaoSujetForum;
import fr.gaminglab.forum.entity.CategorieForum;
import fr.gaminglab.forum.entity.CommentaireForum;
import fr.gaminglab.forum.entity.JoueurCommentaireForum;
import fr.gaminglab.forum.entity.JoueurSujetForum;
import fr.gaminglab.forum.entity.SujetForum;

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
    public CommentaireForum ajouterCommentaire(CommentaireForum comForum, Integer idJoueur) {
        comForum.setIdJoueur(idJoueur);
    	return daoCommentaireForum.save(comForum);       
    }

    /**
     * @param sujet 
     * @param joueur 
     * @return
     */
    public SujetForum ajouterSujet(SujetForum sujet, Integer idJoueur) {
        sujet.setIdJoueurCreateur(idJoueur);
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
        return daoCommentaireForum.findBySujetForumTest(idSujetForum); 
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
        return daoSujetForum.findByIdJoueurCreateur(idJoueur);      	
      }
     
//      public List<SujetForum> getSujetByJeu(Jeu jeu) {
//    	  return null;     	
//      } 
     
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
    public CommentaireForum noteCommentaire(CommentaireForum comForum, Integer idJoueur) {
        JoueurCommentaireForum joueurCommentaireForum = new JoueurCommentaireForum();
        joueurCommentaireForum.setIdJoueur(idJoueur);
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
    public SujetForum noteSujet(SujetForum sujet, Integer idJoueur) {
        JoueurSujetForum joueurSujetForum = new JoueurSujetForum();
        joueurSujetForum.setIdJoueur(idJoueur);
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
    public boolean supprimerSujet(SujetForum sujet, Integer idJoueur) {
        //sujet.setJoueur(joueur);
    	//daoSujetForum.delete(sujet);
        return false;
    }   

    @Override
    public List<CommentaireForum> getCommentaireForumByJoueur(Integer idUtilisateur) {
        return daoCommentaireForum.findByIdJoueur(idUtilisateur);
    }

    @Override
    public List<SujetForum> getSujetForumByJoueur(Integer idUtilisateur) {
        return daoSujetForum.findByIdJoueurCreateur(idUtilisateur);
    }
    
    public List<SujetForum> getAllSujetForum() {    	
    	List<SujetForum> listes = daoSujetForum.findAll();       	
    	return (List<SujetForum>)listes.stream()    	
    	    	.sorted((p1, p2) -> (p1.getNote().compareTo(p2.getNote())))
    	    	.collect(Collectors.toList());    	
    }
}