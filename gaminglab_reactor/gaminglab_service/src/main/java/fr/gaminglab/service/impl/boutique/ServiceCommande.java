package fr.gaminglab.service.impl.boutique;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gaminglab.dao.api.boutique.IDaoArticle;
import fr.gaminglab.dao.api.boutique.IDaoCommande;
import fr.gaminglab.dao.api.boutique.IDaoEtatCommande;
import fr.gaminglab.dao.api.boutique.IDaoLigneCommande;
import fr.gaminglab.entity.boutique.Article;
import fr.gaminglab.entity.boutique.Commande;
import fr.gaminglab.entity.boutique.LigneCommande;
import fr.gaminglab.entity.utilisateur.Adresse;
import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.service.api.boutique.IServiceCommande;

import javax.transaction.Transactional;

/**
 * 
 */
@Service
@Transactional
public class ServiceCommande implements IServiceCommande {

    /**
     * Default constructor
     */
    public ServiceCommande() {
    }

    /**
     * 
     */
    @Autowired
    private IDaoEtatCommande daoEtatCommande;

    /**
     * 
     */
    @Autowired
    private IDaoCommande daoCommande;

    /**
     * 
     */
    @Autowired
    private IDaoLigneCommande daoLigneCommande;

    /**
     * 
     */
    @Autowired
    private IDaoArticle daoArticle;

    /**
     * @param cmd
     * @return
     */
    public Commande ajouterCommande(Commande cmd) {

        return daoCommande.save(cmd);
    }

    /**
     * @param ligneCommande
     * @return
     */
    public LigneCommande ajouterLigneCommande(LigneCommande ligneCommande) {

        return daoLigneCommande.save(ligneCommande);
    }


    /**
     * @param idUtilisateur
     * @return
     */
    public List<Commande> getAllCommandeByJoueur(Integer idUtilisateur) {

        return daoCommande.findByJoueurIdUtilisateurOrderByDateEnregistrementDesc(idUtilisateur);
    }

    /**
     * @param idCommande
     * @return
     */
    public List<LigneCommande> getAllLigneByCommande(Integer idCommande) {

        return daoLigneCommande.findByCommandeIdCommande(idCommande);
    }

    @Override
    public Optional<LigneCommande> getLigneCommandeById(Integer idLigneCommande) {

        return daoLigneCommande.findById(idLigneCommande);
    }

    /**
     * @param idCommande
     * @return
     */
    public Optional<Commande> getCommandeById(Integer idCommande) {

        return daoCommande.findById(idCommande);
    }

    /**
     * @param cmd 
     * @return
     */
    public Commande modifierCommande(Commande cmd) {

        return daoCommande.save(cmd);
    }

    @Override
    public void supprimerCommande(Integer idCommande) {

        daoCommande.deleteById(idCommande);
    }

    /**
     * @param lgnCmd 
     * @return
     */
    public LigneCommande modifierLigneCommande(LigneCommande lgnCmd) {

        return daoLigneCommande.save(lgnCmd);
    }

    /**
     * @param idLigneCommande
     */
    public void supprimerLigneCommande(Integer idLigneCommande) {

        daoLigneCommande.deleteById(idLigneCommande);
    }

}