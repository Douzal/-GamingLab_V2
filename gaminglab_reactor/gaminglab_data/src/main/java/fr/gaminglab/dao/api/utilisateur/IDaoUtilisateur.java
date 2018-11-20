package fr.gaminglab.dao.api.utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gaminglab.entity.utilisateur.Utilisateur;

/**
 * 
 */
@Repository
public interface IDaoUtilisateur extends JpaRepository<Utilisateur, Integer> {

    /**
     * @param pseudo
     * @return
     */
    public boolean existsByPseudo(String pseudo);

    /**
     * @param mail 
     * @return
     */
    public boolean existsByMail(String mail);

    /**
     * @param
     * @return
     */
    public Utilisateur findByPseudoOrMailAndAndPassword(String pseudo, String mail, String password);

}