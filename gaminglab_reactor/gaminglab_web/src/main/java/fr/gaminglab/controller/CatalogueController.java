package fr.gaminglab.controller;

import fr.gaminglab.entity.boutique.Article;
import fr.gaminglab.entity.boutique.CategorieArticle;
import fr.gaminglab.entity.boutique.ImageArticle;
import fr.gaminglab.entity.utilisateur.Utilisateur;
import fr.gaminglab.service.api.boutique.IServiceCatalogue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gaminglab/boutique")
public class CatalogueController {

    public static final Logger logger = LoggerFactory.getLogger(CatalogueController.class);

    @Autowired
    private IServiceCatalogue serviceCatalogue;

    @GetMapping("/categorie")
    public List<CategorieArticle> getAllCategorieArticle(){

        return serviceCatalogue.getAllCategorieArticle();
    }

    @GetMapping("/categorie/{idCategorieArticle}")
    public CategorieArticle getCategorieArticleById(@PathVariable Integer idCategorieArticle){
        Optional<CategorieArticle> categorieArticle = serviceCatalogue.getCategorieArticleById(idCategorieArticle);
        if(categorieArticle.isPresent()){
            return categorieArticle.get();
        } else {
            return null;
        }
    }

    @GetMapping("/categorie/{idCategorieArticle}/article")
    public List<Article> getAllArticleByCategorieArticle (@PathVariable Integer idCategorieArticle){

        return serviceCatalogue.getArticleByCategorie(idCategorieArticle);
    }

    @GetMapping("/article/{idArticle}")
    public Article getArticleById(@PathVariable Integer idArticle){
        Optional<Article> article = serviceCatalogue.getArticleById(idArticle);
        if(article.isPresent()){
            return article.get();
        } else {
            return null;
        }
    }

    @GetMapping("/article")
    public List<Article> getAllArticle(){

        return serviceCatalogue.getAllArticle();
    }

    @PutMapping("/article/{idArticle}")
    public Article noterArticle(@PathVariable Integer idArticle ,@RequestBody Article articleModifie){
        Optional<Article> article = serviceCatalogue.getArticleById(idArticle);
        if( article.isPresent()){
            article.get().setCredit(articleModifie.getCredit());
            article.get().setCategorieArticle(articleModifie.getCategorieArticle());
            article.get().setImageArticle(articleModifie.getImageArticle());
            article.get().setPrix(articleModifie.getPrix());
            article.get().setNotesArticle(articleModifie.getNotesArticle());
            article.get().setImagesArticle(articleModifie.getImagesArticle());
            return serviceCatalogue.modifierArticle(article.get());
        }
        else {
            return null;
        }
    }
}
