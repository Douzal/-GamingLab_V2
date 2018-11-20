package fr.gaminglab.service.api.boutique;


import fr.gaminglab.entity.boutique.Article;
import fr.gaminglab.entity.boutique.Commande;
import fr.gaminglab.entity.boutique.LigneCommande;
import fr.gaminglab.entity.utilisateur.Adresse;
import fr.gaminglab.entity.utilisateur.Joueur;

import java.util.List;
import java.util.Optional;

/**
 * 
 */
public interface IServiceCommande {

    /**
     * @param cmd
     * @return
     */
    public Commande ajouterCommande(Commande cmd);

    /**
     * @param ligneCommande
     * @return
     */
    public LigneCommande ajouterLigneCommande(LigneCommande ligneCommande);

    /**
     * @param idUtilisateur
     * @return
     */
    public List<Commande> getAllCommandeByJoueur(Integer idUtilisateur);

    /**
     * @param idCommande
     * @return
     */
    public List<LigneCommande> getAllLigneByCommande(Integer idCommande);

    /**
     * @param idLigneCommande
     * @return
     */
    public Optional<LigneCommande> getLigneCommandeById(Integer idLigneCommande);

    /**
     * @param idCommande
     * @return
     */
    public Optional<Commande> getCommandeById(Integer idCommande);

    /**
     * @param cmd
     * @return
     */
    public Commande modifierCommande(Commande cmd);

    /**
     * @param idCommande
     */
    public void supprimerCommande(Integer idCommande);

    /**
     * @param lgnCmd
     * @return
     */
    public LigneCommande modifierLigneCommande(LigneCommande lgnCmd);

    /**
     * @param idLigneCommande
     * @return
     */
    public void supprimerLigneCommande(Integer idLigneCommande);



}