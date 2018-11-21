package fr.gaminglab.orchestrateur.controller.angular;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gaminglab.entity.jeu.CategorieJeu;
import fr.gaminglab.entity.jeu.CommentaireJeu;
import fr.gaminglab.entity.jeu.Jeu;
import fr.gaminglab.entity.jeu.JoueurJeu;
import fr.gaminglab.entity.jeu.Tag;
import fr.gaminglab.orchestrateur.controller.java.JeuWebService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gaminglab/game")
public class JeuAngularController {

    private JeuWebService wsJeu = new JeuWebService();

    @GetMapping("/categorie")
    public List<CategorieJeu> getAllCategorieJeu(){
        return wsJeu.getAllCategorieJeu();
    }

    @GetMapping("/categorie/{idCategorieJeu}")
    public CategorieJeu getCategorieJeuById(@PathVariable Integer idCategorieJeu){
        return wsJeu.getCategorieJeuById(idCategorieJeu);
    }

    @GetMapping("/jeu")
    public List<Jeu> getAllJeux(){
        return wsJeu.getAllJeux();
    }

    @GetMapping("/jeu/{idJeu}")
    public Jeu getJeuById(@PathVariable Integer idJeu){
        return wsJeu.getJeuById(idJeu);
    }

    @GetMapping("/categorie/{idCategorieJeu}/jeu")
    public List<Jeu> getAllJeuxByCategorie(@PathVariable Integer idCategorieJeu){
        return wsJeu.getAllJeuxByCategorie(idCategorieJeu);
    }

    @GetMapping("/tag")
    public List<Tag> getAllTag(){
        return wsJeu.getAllTag();
    }

    @PostMapping("/ajoutJeu")
    public Jeu ajouterJeu(@RequestBody Jeu jeu){
        return wsJeu.ajouterJeu(jeu);
    }

    @PutMapping("/jeu/{idJeu}")
    public void modifierJeu(@PathVariable Integer idJeu,@RequestBody Jeu jeuModifie){
        wsJeu.modifierJeu(idJeu,jeuModifie);
    }

    @GetMapping("/jeu/{idJeu}/commentaire")
    public List<CommentaireJeu> getAllCommentaireJeuByJeu(@PathVariable Integer idJeu){
        return wsJeu.getAllCommentaireJeuByJeu(idJeu);
    }

    @GetMapping("/jeu/{idJeu}/joueur")
    public List<JoueurJeu> getMeilleurJoueurByJeu(@PathVariable Integer idJeu){
        return wsJeu.getMeilleurJoueurByJeu(idJeu);
    }

    @GetMapping("/jeu/{idJeu}/joueur/{idUtilisateur}")
    public JoueurJeu getJoueurJeuByJeuAndJoueur(@PathVariable Integer idJeu, @PathVariable Integer idUtilisateur){
        return wsJeu.getJoueurJeuByJeuAndJoueur(idJeu, idUtilisateur);
    }

    @PostMapping("/joueurJeu")
    public JoueurJeu ajouterJoueurJeu(@RequestBody JoueurJeu joueurJeu){

        return wsJeu.ajouterJoueurJeu(joueurJeu);
    }

    @PostMapping("/commentaireJeu")
    public CommentaireJeu ajouterCommentaireJeu(@RequestBody CommentaireJeu commentaireJeu){
        return wsJeu.ajouterCommentaireJeu(commentaireJeu);
    }

    @PutMapping("/joueurJeu/{idJoueurJeu}")
    public JoueurJeu modifierJoueurJeu(@PathVariable Integer idJoueurJeu,@RequestBody JoueurJeu joueurJeuModifie){
        return wsJeu.modifierJoueurJeu(idJoueurJeu, joueurJeuModifie);
    }
}
