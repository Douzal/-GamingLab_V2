package fr.gaminglab.entity.utilisateur;


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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idSuspension", scope = Motif.class)
public class Motif implements Serializable {

    /**
     * Default constructor
     */
    public Motif() {
    }

    public Motif(String libelle, String contenu) {
        this.libelle = libelle;
        this.contenu = contenu;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idSuspension;

    /**
     * 
     */
    @Column(nullable = false, length = 50)
    private String libelle;

    /**
     * 
     */
    @Column(nullable = false)
    private String contenu;

    /**
     * 
     */
    @OneToMany(mappedBy="motif")
	@JsonIgnore
    private Set<DemandeSuspension> demandesSuspension;

	public Integer getIdSuspension() {
		return idSuspension;
	}

	public void setIdSuspension(Integer paramIdSuspension) {
		idSuspension = paramIdSuspension;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String paramLibelle) {
		libelle = paramLibelle;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String paramContenu) {
		contenu = paramContenu;
	}

	public Set<DemandeSuspension> getDemandesSuspension() {
		return demandesSuspension;
	}

	public void setDemandesSuspension(Set<DemandeSuspension> paramDemandesSuspension) {
		demandesSuspension = paramDemandesSuspension;
	}
    
    

}