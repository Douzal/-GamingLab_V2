package fr.gaminglab.entity.utilisateur;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * 
 */
@Entity
@Table(name = "Ville_CodePostal")
public class VilleCodePostal implements Serializable {

    /**
     * Default constructor
     */
    public VilleCodePostal() {
    }

    public VilleCodePostal(CodePostal codePostal, Ville ville) {
        this.codePostal = codePostal;
        this.ville = ville;
    }

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idVilleCodePostal;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idCodePostal", nullable = false)
    private CodePostal codePostal;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name="idVille", nullable = false)
    private Ville ville;

    /**
     *
     */
    @OneToMany(mappedBy="villeCodePostal")
    @JsonIgnore
    private Set<Adresse> adresses;

	public Integer getIdVilleCodePostal() {
		return idVilleCodePostal;
	}

	public void setIdVilleCodePostal(Integer paramIdVilleCodePostal) {
		idVilleCodePostal = paramIdVilleCodePostal;
	}

	public CodePostal getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(CodePostal paramCodePostal) {
		codePostal = paramCodePostal;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville paramVille) {
		ville = paramVille;
	}

    public Set<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(Set<Adresse> adresses) {
        this.adresses = adresses;
    }
}