package fr.gaminglab.service.test;

import fr.gaminglab.application.DemoApplication;
import fr.gaminglab.entity.utilisateur.Joueur;
import fr.gaminglab.entity.utilisateur.JoueurCarte;
import fr.gaminglab.entity.utilisateur.TypeCarte;
import fr.gaminglab.entity.utilisateur.Utilisateur;
import fr.gaminglab.service.impl.utilisateur.ServiceCarteBancaire;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TestServiceCarteBancaire {

    @Autowired
    private ServiceCarteBancaire serviceCarteBancaire;

    @Test
    public void testGetCarteBancaireByUtilisateur(){
        //List<JoueurCarte> joueurCartes = serviceCarteBancaire.getAllCarteByJoueur(5);
        //Assert.assertTrue(joueurCartes != null);
        //for (JoueurCarte joueurCarte: joueurCartes) {
          //  System.out.println(joueurCarte.getNomTitulaire() +" " + joueurCarte.getNumeroCarte());
       // }

    }

    @Test
    public void ajouterCarteBancaire(){
        JoueurCarte joueurCarte = new JoueurCarte();
        joueurCarte.setCodeVerification("1232");
        joueurCarte.setDateExpiration(new Date());
        Joueur joueur = new Joueur();
        joueur.setIdUtilisateur(1);
        TypeCarte typeCarte = new TypeCarte();
        typeCarte.setIdTypeCarte(1);
        joueurCarte.setTypeCarte(typeCarte);
        joueurCarte.setJoueur(joueur);
        joueurCarte.setNomTitulaire("BLABLA");
        joueurCarte.setPrenomTitulaire("COUCOU");
        joueurCarte.setNumeroCarte("123456567");
        //Assert.assertTrue(serviceCarteBancaire.ajouterJoueurCarte(joueurCarte) != null);
    }

    @Test
    public void supprimerCarteBancaire(){

    }

}
