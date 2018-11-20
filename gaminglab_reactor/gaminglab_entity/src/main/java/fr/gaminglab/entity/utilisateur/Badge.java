package fr.gaminglab.entity.utilisateur;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Type;

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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idBadge", scope = Badge.class)
public class Badge implements Serializable {

    /**
     * Default constructor
     */
    public Badge() {
    }

	public Badge(String libelle, String description, Integer compteurMax, String imageBadge) {
		this.libelle = libelle;
		this.description = description;
		this.compteurMax = compteurMax;
		this.imageBadge = imageBadge;
	}

	/**
     * 
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idBadge;

    /**
     * 
     */
    @Column(nullable = false, length = 150)
    private String libelle;

	/**
	 *
	 */
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.TextType")
	private String description;

    /**
     * 
     */
    @Column(nullable = false)
    private Integer compteurMax;

    /**
     * 
     */
    @Column(length = 150)
    private String imageBadge;

    /**
     * 
     */
    @OneToMany(mappedBy="badge")
	@JsonIgnore
    private Set<JoueurBadge> joueursBadge;

	public Integer getIdBadge() {
		return idBadge;
	}

	public void setIdBadge(Integer paramIdBadge) {
		idBadge = paramIdBadge;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String paramLibelle) {
		libelle = paramLibelle;
	}

	public Integer getCompteurMax() {
		return compteurMax;
	}

	public void setCompteurMax(Integer paramCompteurMax) {
		compteurMax = paramCompteurMax;
	}

	public String getImageBadge() {
		return imageBadge;
	}

	public void setImageBadge(String paramImageBadge) {
		imageBadge = paramImageBadge;
	}

	public Set<JoueurBadge> getJoueursBadge() {
		return joueursBadge;
	}

	public void setJoueursBadge(Set<JoueurBadge> paramJoueursBadge) {
		joueursBadge = paramJoueursBadge;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}