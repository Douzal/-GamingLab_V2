package fr.gaminglab.entity.communication;

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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idCategorie", scope = CategorieForum.class)
public class CategorieForum implements Serializable {

    /**
     * Default constructor
     */
    public CategorieForum() {
    }

    public CategorieForum(String libelle) {
        this.libelle = libelle;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCategorie;

    /**
     * 
     */
    @Column(nullable = false, length = 50)
    private String libelle;

    /**
     * 
     */
    @OneToMany(mappedBy="categorieForum")
	@JsonIgnore
    private Set<SujetForum> sujetsForum;

	public Integer getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Integer paramIdCategorie) {
		idCategorie = paramIdCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String paramLibelle) {
		libelle = paramLibelle;
	}

	public Set<SujetForum> getSujetsForum() {
		return sujetsForum;
	}

	public void setSujetsForum(Set<SujetForum> paramSujetsForum) {
		sujetsForum = paramSujetsForum;
	}
    
    

}