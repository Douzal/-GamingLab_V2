package fr.gaminglab.dao.api.jeu;


import fr.gaminglab.entity.jeu.CategorieJeu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 */
@Repository
public interface IDaoCategorieJeu extends JpaRepository<CategorieJeu, Integer> {

}