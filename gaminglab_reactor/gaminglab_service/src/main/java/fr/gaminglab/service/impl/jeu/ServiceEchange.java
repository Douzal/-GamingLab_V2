package fr.gaminglab.service.impl.jeu;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gaminglab.dao.api.jeu.IDaoCommentaireJeu;
import fr.gaminglab.entity.jeu.CommentaireJeu;
import fr.gaminglab.entity.jeu.Jeu;
import fr.gaminglab.service.api.jeu.IServiceEchange;

import javax.transaction.Transactional;

/**
 * 
 */
@Service
@Transactional
public class ServiceEchange implements IServiceEchange {

    /**
     * Default constructor
     */
    public ServiceEchange() {
    }

    /**
     * 
     */
    @Autowired
    private IDaoCommentaireJeu daoCommentaireJeu;

    /**
     * @param comJeu 
     * @return
     */
    public CommentaireJeu ajouterCommentaire(CommentaireJeu comJeu) {

        return daoCommentaireJeu.save(comJeu);
    }

    /**
     * @param idJeu
     * @return
     */
    public List<CommentaireJeu> getCommentaireByJeu(Integer idJeu) {

        return daoCommentaireJeu.findByJeuIdJeu(idJeu);
    }

    /**
     * @param idCommentaire
     * @return
     */
    public boolean supprimerCommentaire(Integer idCommentaire) {
        // TODO implement here
        return false;
    }

    @Override
    public List<CommentaireJeu> getCommentaireJeuByJoueur(Integer idUtilisateur) {

        return daoCommentaireJeu.findByJoueurIdUtilisateur(idUtilisateur);
    }

    @Override
    public Optional<CommentaireJeu> getCommentaireJeuById(Integer idCommentaireJeu) {

        return null;
    }

}