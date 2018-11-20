package fr.gaminglab.service.impl.jeu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.gaminglab.entity.jeu.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gaminglab.dao.api.jeu.IDaoCategorieJeu;
import fr.gaminglab.dao.api.jeu.IDaoJeu;
import fr.gaminglab.dao.api.jeu.IDaoJoueurJeu;
import fr.gaminglab.dao.api.jeu.IDaoTag;
import fr.gaminglab.service.api.jeu.IServiceJeu;

import javax.transaction.Transactional;

/**
 * 
 */
@Service
@Transactional
public class ServiceJeu implements IServiceJeu {

    /**
     * Default constructor
     */
    public ServiceJeu() {
    }


    /**
     * 
     */
    @Autowired
    private IDaoCategorieJeu daoCategorieJeu;

    /**
     * 
     */
    @Autowired
    private IDaoTag daoTag;

    /**
     * 
     */
    @Autowired
    private IDaoJeu daoJeu;

    /**
     * 
     */
    @Autowired
    private IDaoJoueurJeu daoJoueurJeu;

    private Path rootLocation;

    @Override
    public Jeu ajouterJeu(Jeu jeu) {
        jeu.setDateAjout(new Date());
        return daoJeu.save(jeu);
    }

    @Override
    public JoueurJeu ajouterJoueurJeu(JoueurJeu joueurJeu) {

        return daoJoueurJeu.save(joueurJeu);
    }

    @Override
    public List<Jeu> getAllJeux() {
        List<Jeu> jeux = daoJeu.findAll();
        return jeux.stream().sorted(Comparator.comparing(Jeu::getDateAjout).reversed()).collect(Collectors.toList());
    }

    @Override
    public List<CategorieJeu> getAllCategorieJeux() {

        return daoCategorieJeu.findAll();
    }

    @Override
    public List<Tag> getAllTag() {

        return daoTag.findAll();
    }

    @Override
    public Optional<Tag> getTagById(Integer idTag) {

        return daoTag.findById(idTag);
    }

    @Override
    public List<Tag> getTagByLibelle(String libelle) {

        return daoTag.findTop5ByLibelleStartingWith(libelle);
    }

    @Override
    public Optional<Jeu> getJeuById(Integer idJeu) {

        return daoJeu.findById(idJeu);
    }

    @Override
    public Optional<CategorieJeu> getCategorieJeuById(Integer idCategorieJeu) {

        return daoCategorieJeu.findById(idCategorieJeu);
    }

    @Override
    public List<Jeu> getJeuxByCategorie(Integer idCategorieJeu) {

        return daoJeu.findByCategorieJeuIdCategorieJeu(idCategorieJeu);
    }

    @Override
    public List<Jeu> getJeuxByLibelle(String libelle) {

        return daoJeu.findTop5ByLibelleStartingWith(libelle);
    }

    @Override
    public List<Jeu> getMeilleurJeux() {
        // TODO implement here
        return null;
    }

    @Override
    public List<JoueurJeu> getMeilleurJoueurByJeu(Integer idJeu) {

        return daoJoueurJeu.findByJeuIdJeuOrderByTempsJeu(idJeu);
    }

    @Override
    public JoueurJeu getJoueurJeuByJeuAndJoueur(Integer idJeu, Integer idUtilisateur) {

        return daoJoueurJeu.findByJeuIdJeuAndJoueurIdUtilisateur(idJeu, idUtilisateur);
    }

    @Override
    public Optional<JoueurJeu> getJoueurJeuById(Integer idJoueurJeu) {

        return daoJoueurJeu.findById(idJoueurJeu);
    }

    @Override
    public Jeu modifierJeu(Jeu jeu) {

        return daoJeu.save(jeu);
    }

    @Override
    public List<JoueurJeu> getJoueurJeuByJoueur(Integer idUtilisateur) {

        return daoJoueurJeu.findByJoueurIdUtilisateurOrderByDateJouerDesc(idUtilisateur);
    }

    @Override
    public JoueurJeu modifierJoueurJeu(JoueurJeu joueurJeu) {

        return daoJoueurJeu.save(joueurJeu);
    }

    @Override
    public List<Jeu> getJeuxByTag(Integer idTag) {

        return null;
    }

    @Override
    public List<Jeu> getJeuxByJoueur(Integer idUtilisateur) {

        return daoJeu.findByJoueurIdUtilisateur(idUtilisateur);
    }

}