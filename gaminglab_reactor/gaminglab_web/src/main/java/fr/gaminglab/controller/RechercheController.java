package fr.gaminglab.controller;


import fr.gaminglab.dto.Recherche;
import fr.gaminglab.service.api.boutique.IServiceCatalogue;
import fr.gaminglab.service.api.communication.IServiceForum;
import fr.gaminglab.service.api.jeu.IServiceJeu;
import fr.gaminglab.service.api.utilisateur.IServiceUtilisateur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gaminglab/recherche")
public class RechercheController {

    public static final Logger logger = LoggerFactory.getLogger(RechercheController.class);

    @Autowired
    private IServiceUtilisateur serviceUtilisateur;

    @Autowired
    private IServiceJeu serviceJeu;

    @Autowired
    private IServiceCatalogue serviceCatalogue;

    @Autowired
    private IServiceForum serviceForum;

    @GetMapping("/{motsCles}")
    Recherche recherche(@PathVariable String motsCles){
        Recherche recherche = new Recherche();
        recherche.setJoueurs(serviceUtilisateur.getJoueurByPseudo(motsCles));
        recherche.setJeux(serviceJeu.getJeuxByLibelle(motsCles));
        recherche.setArticles(serviceCatalogue.getArticleByLibelle(motsCles));
        recherche.setSujetForums(serviceForum.getSujetByLibelle(motsCles));
        return recherche;
    }
}
