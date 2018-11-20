package fr.gaminglab.service.impl.utilisateur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gaminglab.dao.api.utilisateur.IDaoJoueurCarte;
import fr.gaminglab.dao.api.utilisateur.IDaoTypeCarte;
import fr.gaminglab.entity.utilisateur.JoueurCarte;
import fr.gaminglab.entity.utilisateur.TypeCarte;
import fr.gaminglab.service.api.utilisateur.IServiceCarteBancaire;

import javax.transaction.Transactional;

/**
 * 
 */
@Service
@Transactional
public class ServiceCarteBancaire implements IServiceCarteBancaire {

    /**
     * Default constructor
     */
    public ServiceCarteBancaire() {
    }

    /**
     * 
     */
    @Autowired
    private IDaoJoueurCarte daoJoueurCarte;

    /**
     * 
     */
    @Autowired
    private IDaoTypeCarte daoTypeCarte;

    /**
     * @param joueurCarte 
     * @return
     */
    public JoueurCarte ajouterJoueurCarte(JoueurCarte joueurCarte) {

        return daoJoueurCarte.save(joueurCarte);
    }

    /**
     * @param idUtilisateur
     * @return
     */
    public List<JoueurCarte> getAllCarteByJoueur(Integer idUtilisateur) {

        return daoJoueurCarte.findByJoueurIdUtilisateur(idUtilisateur);
    }

    /**
     * @return
     */
    public List<TypeCarte> getAllTypeCarte() {
        // TODO implement here
        return null;
    }

    /**
     * @param idJoueurCarte
     * @return
     */
    public void supprimerJoueurCarte(Integer idJoueurCarte) {

        daoJoueurCarte.deleteById(idJoueurCarte);
    }

}