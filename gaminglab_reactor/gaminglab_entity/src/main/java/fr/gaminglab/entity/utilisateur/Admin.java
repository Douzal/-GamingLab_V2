package fr.gaminglab.entity.utilisateur;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idUtilisateur", scope = Utilisateur.class)
public class Admin extends Utilisateur implements Serializable {

    /**
     * Default constructor
     */
    public Admin() {
    }

    public Admin(String nom, String prenom, String mail, String pseudo, String password, Date dateInscription, Date dateDesinscription, Civilite civilite) {
        super(nom, prenom, mail, pseudo, password, dateInscription, dateDesinscription, civilite);
    }

    /**
     * 
     */
    @OneToMany(mappedBy="admin")
    @JsonIgnore
    private Set<DemandeSuspension> demandesSuspension;

    public Set<DemandeSuspension> getDemandesSuspension() {
        return demandesSuspension;
    }

    public void setDemandesSuspension(Set<DemandeSuspension> demandesSuspension) {
        this.demandesSuspension = demandesSuspension;
    }
}