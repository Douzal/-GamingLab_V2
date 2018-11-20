package fr.gaminglab.service.impl.utilisateur;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gaminglab.dao.api.utilisateur.IDaoAdresse;
import fr.gaminglab.dao.api.utilisateur.IDaoBadge;
import fr.gaminglab.dao.api.utilisateur.IDaoCivilite;
import fr.gaminglab.dao.api.utilisateur.IDaoJoueur;
import fr.gaminglab.dao.api.utilisateur.IDaoJoueurBadge;
import fr.gaminglab.dao.api.utilisateur.IDaoUtilisateur;
import fr.gaminglab.dao.api.utilisateur.IDaoVille;
import fr.gaminglab.dao.api.utilisateur.IDaoVilleCodePostal;
import fr.gaminglab.entity.utilisateur.Adresse;
import fr.gaminglab.entity.utilisateur.Civilite;
import fr.gaminglab.entity.utilisateur.CodePostal;
import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.entity.utilisateur.JoueurBadge;
import fr.gaminglab.entity.utilisateur.Utilisateur;
import fr.gaminglab.entity.utilisateur.Ville;
import fr.gaminglab.service.api.utilisateur.IServiceUtilisateur;

/**
 * 
 */
@Service
@Transactional
public class ServiceUtilisateur implements IServiceUtilisateur {

    /**
     * Default constructor
     */
    public ServiceUtilisateur() {
    }

    /**
     * 
     */
    @Autowired
    private IDaoJoueur daoJoueur;

    /**
     * 
     */
    @Autowired
    private IDaoVille daoVille;

    /**
     * 
     */
    @Autowired
    private IDaoBadge daoBadge;

    /**
     * 
     */
    @Autowired
    private IDaoAdresse daoAdresse;

    /**
     * 
     */
    @Autowired
    private IDaoCivilite daoCivilite;

    /**
     * 
     */
    @Autowired
    private IDaoJoueurBadge daoJoueurBadge;

    /**
     * 
     */
    @Autowired
    private IDaoUtilisateur daoUtilisateur;

    /**
     * 
     */
    @Autowired
    private IDaoVilleCodePostal daoVilleCodePostal;

    /**
     * @param pseudo 
     * @param password 
     * @return
     */
    public Utilisateur connexion(String pseudo, String password) {
        return daoUtilisateur.findByPseudoOrMailAndAndPassword(pseudo, pseudo, password);
    }

    @Override
    public List<Joueur> getAllJoueur() {

        return daoJoueur.findAll();
    }

    @Override
    public Optional<Joueur> getJoueurById(Integer idUtilisateur) {

        return daoJoueur.findById(idUtilisateur);
    }

    @Override
    public Optional<Civilite> getCiviliteById(Integer idCivilite) {

        return daoCivilite.findById(idCivilite);
    }

    @Override
    public List<Civilite> getAllCivilite() {

        return daoCivilite.findAll();
    }

    @Override
    public Joueur inscrire(Joueur joueur) {

        return daoJoueur.save(joueur);
    }

    @Override
    public boolean desinscrire(Joueur joueur) {
        // TODO implement here
        return false;
    }

    @Override
    public Joueur modifierJoueur(Joueur joueur) {
        return daoJoueur.save(joueur);
    }

    @Override
    public List<Joueur> getJoueurByPseudo(String pseudo) {

        return daoJoueur.findTop5ByPseudoStartingWith(pseudo);
    }

    @Override
    public List<Ville> getVilleByName(String libelle) {
        // TODO implement here
        return null;
    }

    @Override
    public List<Ville> getVilleByCodePostal(CodePostal cp) {
        // TODO implement here
        return null;
    }

    @Override
    public List<Adresse> getAdresseByJoueur(Integer idUtilisateur) {

        return daoAdresse.findByJoueurIdUtilisateur(idUtilisateur);
    }

    @Override
    public Adresse ajouterAdresse(Adresse adresse) {
        // TODO implement here
        return null;
    }

    @Override
    public boolean supprimerAdresse(Adresse adresse, Joueur joueur) {
        // TODO implement here
        return false;
    }

    @Override
    public List<JoueurBadge> getBadgeByJoueur(Integer idUtilisateur) {
        return daoJoueurBadge.findByJoueurIdUtilisateur(idUtilisateur);
    }

    @Override
    public JoueurBadge incrementeCompteurBadge(JoueurBadge joueurBadge) {
        // TODO implement here
        return null;
    }

    @Override
    public boolean existeMail(String mail) {

        return daoUtilisateur.existsByMail(mail);
    }

    @Override
    public boolean existePseudo(String pseudo) {

        return daoUtilisateur.existsByPseudo(pseudo);
    }

    public IDaoJoueur getDaoJoueur() {
		return daoJoueur;
	}

	public void setDaoJoueur(IDaoJoueur paramDaoJoueur) {
		daoJoueur = paramDaoJoueur;
	}

	public IDaoVille getDaoVille() {
		return daoVille;
	}

	public void setDaoVille(IDaoVille paramDaoVille) {
		daoVille = paramDaoVille;
	}

	public IDaoBadge getDaoBadge() {
		return daoBadge;
	}

	public void setDaoBadge(IDaoBadge paramDaoBadge) {
		daoBadge = paramDaoBadge;
	}

	public IDaoAdresse getDaoAdresse() {
		return daoAdresse;
	}

	public void setDaoAdresse(IDaoAdresse paramDaoAdresse) {
		daoAdresse = paramDaoAdresse;
	}

	public IDaoCivilite getDaoCivilite() {
		return daoCivilite;
	}

	public void setDaoCivilite(IDaoCivilite paramDaoCivilite) {
		daoCivilite = paramDaoCivilite;
	}

	public IDaoJoueurBadge getDaoJoueurBadge() {
		return daoJoueurBadge;
	}

	public void setDaoJoueurBadge(IDaoJoueurBadge paramDaoJoueurBadge) {
		daoJoueurBadge = paramDaoJoueurBadge;
	}

	public IDaoUtilisateur getDaoUtilisateur() {
		return daoUtilisateur;
	}

	public void setDaoUtilisateur(IDaoUtilisateur paramDaoUtilisateur) {
		daoUtilisateur = paramDaoUtilisateur;
	}

	public IDaoVilleCodePostal getDaoVilleCodePostal() {
		return daoVilleCodePostal;
	}

	public void setDaoVilleCodePostal(IDaoVilleCodePostal paramDaoVilleCodePostal) {
		daoVilleCodePostal = paramDaoVilleCodePostal;
	}
    
    

}