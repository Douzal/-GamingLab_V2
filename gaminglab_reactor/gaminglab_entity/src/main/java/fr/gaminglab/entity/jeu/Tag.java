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
public class Tag implements Serializable {

    /**
     * Default constructor
     */
    public Tag() {
    }

    public Tag(String libelle) {
        this.libelle = libelle;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idTag;

    /**
     * 
     */
    @Column(nullable = false, length = 255)
    private String libelle;

    /**
     * 
     */
    @OneToMany(mappedBy="tag")
	@JsonIgnore
    private Set<JeuTag> jeuxTag;

	public Integer getIdTag() {
		return idTag;
	}

	public void setIdTag(Integer paramIdTag) {
		idTag = paramIdTag;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String paramLibelle) {
		libelle = paramLibelle;
	}

	public Set<JeuTag> getJeuxTag() {
		return jeuxTag;
	}

	public void setJeuxTag(Set<JeuTag> paramJeuxTag) {
		jeuxTag = paramJeuxTag;
	}
    
    

}