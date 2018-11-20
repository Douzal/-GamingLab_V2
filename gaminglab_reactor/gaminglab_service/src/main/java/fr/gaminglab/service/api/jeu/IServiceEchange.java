package fr.gaminglab.service.api.jeu;


import fr.gaminglab.entity.jeu.CommentaireJeu;
import fr.gaminglab.entity.jeu.Jeu;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * 
 */
public interface IServiceEchange {

    /**
     * @param comJeu 
     * @return
     */
    public CommentaireJeu ajouterCommentaire(CommentaireJeu comJeu);

    /**
     * @param idJeu
     * @return
     */
    public List<CommentaireJeu> getCommentaireByJeu(Integer idJeu);

    /**
     * @param idCommentaireJeu
     * @return
     */
    public Optional<CommentaireJeu> getCommentaireJeuById(Integer idCommentaireJeu);

    /**
     * @param idCommentaire
     * @return
     */
    public boolean supprimerCommentaire(Integer idCommentaire);

    /**
     * @param idUtilisateur
     * @return
     */
    public List<CommentaireJeu> getCommentaireJeuByJoueur(Integer idUtilisateur);

}