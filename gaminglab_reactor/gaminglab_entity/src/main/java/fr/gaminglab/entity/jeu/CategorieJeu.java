package fr.gaminglab.entity.jeu;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table
public class CategorieJeu implements Serializable {

    /**
     * Default constructor
     */
    public CategorieJeu() {
    }

    public CategorieJeu(String libelle, String imageCategorieJeu) {
        this.libelle = libelle;
        this.imageCategorieJeu = imageCategorieJeu;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCategorieJeu;

    /**
     * 
     */
    @Column(nullable = false, length = 50)
    private String libelle;

    /**
     * 
     */
    @Column(length = 150)
    private String imageCategorieJeu;

    /**
     * 
     */
    @OneToMany(mappedBy="categorieJeu")
	@JsonIgnore
    private Set<Jeu> jeux;

	public Integer getIdCategorieJeu() {
		return idCategorieJeu;
	}

	public void setIdCategorieJeu(Integer paramIdCategorieJeu) {
		idCategorieJeu = paramIdCategorieJeu;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String paramLibelle) {
		libelle = paramLibelle;
	}

	public String getImageCategorieJeu() {
		return imageCategorieJeu;
	}

	public void setImageCategorieJeu(String paramImageCategorieJeu) {
		imageCategorieJeu = paramImageCategorieJeu;
	}

	public Set<Jeu> getJeux() {
		return jeux;
	}

	public void setJeux(Set<Jeu> paramJeux) {
		jeux = paramJeux;
	}

    
}