package fr.gaminglab.orchestrateur.controller.angular;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gaminglab.entity.boutique.Article;
import fr.gaminglab.entity.boutique.CategorieArticle;
import fr.gaminglab.orchestrateur.controller.java.CatalogueWebService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gaminglab/boutique")
public class CatalogueAngularController {

    public static final Logger logger = LoggerFactory.getLogger(CatalogueAngularController.class);

    private CatalogueWebService wsCatalogue = new CatalogueWebService();

    @GetMapping("/categorie")
    public List<CategorieArticle> getAllCategorieArticle(){

        return wsCatalogue.getAllCategorieArticle();
    }

    @GetMapping("/categorie/{idCategorieArticle}")
    public CategorieArticle getCategorieArticleById(@PathVariable Integer idCategorieArticle){
        return wsCatalogue.getCategorieArticleById(idCategorieArticle);
    }

    @GetMapping("/categorie/{idCategorieArticle}/article")
    public List<Article> getAllArticleByCategorieArticle (@PathVariable Integer idCategorieArticle){
        return wsCatalogue.getAllArticleByCategorieArticle(idCategorieArticle);
    }

    @GetMapping("/article/{idArticle}")
    public Article getArticleById(@PathVariable Integer idArticle){
        return wsCatalogue.getArticleById(idArticle);
        
    }

    @GetMapping("/article")
    public List<Article> getAllArticle(){
        return wsCatalogue.getAllArticle();
    }

    @PutMapping("/article/{idArticle}")
    public Article noterArticle(@PathVariable Integer idArticle ,@RequestBody Article articleModifie){
        return wsCatalogue.getArticleById(idArticle);
    }
}
