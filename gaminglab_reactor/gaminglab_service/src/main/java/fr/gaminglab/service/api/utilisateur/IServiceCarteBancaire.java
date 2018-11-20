package fr.gaminglab.service.api.utilisateur;


import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.entity.utilisateur.JoueurCarte;
import fr.gaminglab.entity.utilisateur.TypeCarte;

import java.util.List;

/**
 * 
 */
public interface IServiceCarteBancaire {


    public JoueurCarte ajouterJoueurCarte(JoueurCarte joueurCarte);


    public List<JoueurCarte> getAllCarteByJoueur(Integer idUtilisateur);


    public List<TypeCarte> getAllTypeCarte();


    public void supprimerJoueurCarte(Integer idJoueurCarte);

}