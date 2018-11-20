package fr.gaminglab.service.api.jeu;


import fr.gaminglab.entity.jeu.*;
import fr.gaminglab.entity.utilisateur.Joueur;

import java.util.List;
import java.util.Optional;

/**
 * 
 */
public interface IServiceJeu {

    /**
     * @param jeu
     * @return
     */
    public Jeu ajouterJeu(Jeu jeu);

    /**
     * @param joueurJeu
     * @return
     */
    public JoueurJeu ajouterJoueurJeu(JoueurJeu joueurJeu);

    /**
     * @return
     */
    public List<Jeu> getAllJeux();

    /**
     * @param
     * @return
     */
    public List<CategorieJeu> getAllCategorieJeux();

    /**
     * @param
     * @return
     */
    public List<Tag> getAllTag();

    /**
     * @param id
     * @return
     */
    public Optional<Tag> getTagById(Integer id);

    /**
     * @param libelle
     * @return
     */
    public List<Tag> getTagByLibelle(String libelle);

    /**
     * @param id 
     * @return
     */
    public Optional<Jeu> getJeuById(Integer id);

    /**
     * @param id
     * @return
     */
    public Optional<CategorieJeu> getCategorieJeuById(Integer id);

    /**
     * @param id
     * @return
     */
    public List<Jeu> getJeuxByCategorie(Integer id);

    /**
     * @param libelle 
     * @return
     */
    public List<Jeu> getJeuxByLibelle(String libelle);

    /**
     * @return
     */
    public List<Jeu> getMeilleurJeux();

    /**
     * @param idJeu
     * @return
     */
    public List<JoueurJeu> getMeilleurJoueurByJeu(Integer idJeu);

    /**
     * @param idJeu
     * @param idUtilisateur
     * @return
     */
    public JoueurJeu getJoueurJeuByJeuAndJoueur(Integer idJeu, Integer idUtilisateur);

    /**
     * @param idJoueurJeu
     * @return
     */
    public Optional<JoueurJeu> getJoueurJeuById(Integer idJoueurJeu);

    /**
     * @param jeu 
     * @return
     */
    public Jeu modifierJeu(Jeu jeu);

    /**
     * @param idUtilisateur
     * @return
     */
    public List<JoueurJeu> getJoueurJeuByJoueur(Integer idUtilisateur);

    /**
     * @param joueurJeu 
     * @return
     */
    public JoueurJeu modifierJoueurJeu(JoueurJeu joueurJeu);

    /**
     * @param idTag
     * @return
     */
    public List<Jeu> getJeuxByTag(Integer idTag);

    /**
     * @param idUtilisateur
     * @return
     */
    public List<Jeu> getJeuxByJoueur(Integer idUtilisateur);

}