package fr.gaminglab.entity.boutique;


import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * 
 */
@Entity
@Table
public class CategorieArticle implements Serializable {

    /**
     * Default constructor
     */
    public CategorieArticle() {
    }

    public CategorieArticle(String libelle, String imageCategorie) {
        this.libelle = libelle;
        this.imageCategorie = imageCategorie;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCategorieArticle;

    /**
     * 
     */
    @Column(nullable = false, length = 50)
    private String libelle;

    /**
     * 
     */
    @Column(length = 150)
    private String imageCategorie;

    /**
     * 
     */
    @OneToMany(mappedBy="categorieArticle")
	@JsonIgnore
    private Set<Article> articles;

	public Integer getIdCategorieArticle() {
		return idCategorieArticle;
	}

	public void setIdCategorieArticle(Integer paramIdCategorieArticle) {
		idCategorieArticle = paramIdCategorieArticle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String paramLibelle) {
		libelle = paramLibelle;
	}

	public String getImageCategorie() {
		return imageCategorie;
	}

	public void setImageCategorie(String paramImageCategorie) {
		imageCategorie = paramImageCategorie;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> paramArticles) {
		articles = paramArticles;
	}
    
    

}