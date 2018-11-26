package fr.gaminglab.orchestrateur.controller.java;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.web.client.RestTemplate;

import fr.gaminglab.entity.boutique.Article;
import fr.gaminglab.entity.boutique.CategorieArticle;

public class CatalogueWebService {

	private static final String SLASH = "/";
	private static final String ARTICLE = "/article";
	private static final String CATEGORIE = "/categorie";
	private RestTemplate restTemplate;
	private String base_url = null;

	public CatalogueWebService() {
		restTemplate = new RestTemplate();
		try {
			Properties props = new Properties();
			InputStream is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("ws_java_reactor.properties");
			props.load(is);
			is.close();
			this.base_url = props.getProperty("ws_java_reactor_catalogue.base_url");
			System.out.println("CatalogueJavaController -> base_url=" + base_url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<CategorieArticle> getAllCategorieArticle() {
		CategorieArticle[] tabCategorieArticles = restTemplate.getForObject(base_url + CATEGORIE,
				CategorieArticle[].class);
		return Arrays.asList(tabCategorieArticles);
	}

	public CategorieArticle getCategorieArticleById(Integer idCategorieArticle) {
		return restTemplate.getForObject(base_url + CATEGORIE + SLASH + idCategorieArticle, CategorieArticle.class);
	}

	public List<Article> getAllArticleByCategorieArticle(Integer idCategorieArticle) {
		Article[] tabArticles = restTemplate.getForObject(base_url + CATEGORIE + SLASH + idCategorieArticle + ARTICLE,
				Article[].class);
		return Arrays.asList(tabArticles);
	}

	public Article getArticleById(Integer idArticle) {
		return restTemplate.getForObject(base_url + ARTICLE + SLASH + idArticle, Article.class);
	}

	public List<Article> getAllArticle() {
		Article[] tabArticles = restTemplate.getForObject(base_url + ARTICLE, Article[].class);
		return Arrays.asList(tabArticles);
	}

	public Article noterArticle(Integer idArticle, Article articleModifie) {
		restTemplate.put(base_url + ARTICLE + SLASH + idArticle, articleModifie);
		return articleModifie;
	}
}
