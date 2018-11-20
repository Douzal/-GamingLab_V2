package fr.gaminglab.service.api.utilisateur;


import fr.gaminglab.entity.utilisateur.*;

import java.util.List;
import java.util.Optional;

/**
 * 
 */
public interface IServiceUtilisateur {


    public Utilisateur connexion(String pseudo, String password);


    public List<Joueur> getAllJoueur();


    public Optional<Joueur> getJoueurById(Integer id);


    public Optional<Civilite> getCiviliteById(Integer id);


    public List<Civilite> getAllCivilite();


    public Joueur inscrire(Joueur joueur);


    public boolean desinscrire(Joueur joueur);


    public Joueur modifierJoueur(Joueur joueur);


    public List<Joueur> getJoueurByPseudo(String pseudo);


    public List<Ville> getVilleByName(String libelle);


    public List<Ville> getVilleByCodePostal(CodePostal cp);


    public List<Adresse> getAdresseByJoueur(Integer idUtilisateur);


    public Adresse ajouterAdresse(Adresse adresse);


    public boolean supprimerAdresse(Adresse adresse, Joueur joueur);


    public List<JoueurBadge> getBadgeByJoueur(Integer idUtilisateur);


    public JoueurBadge incrementeCompteurBadge(JoueurBadge joueurBadge);

    public boolean existeMail(String mail);

    public boolean existePseudo(String pseudo);

}