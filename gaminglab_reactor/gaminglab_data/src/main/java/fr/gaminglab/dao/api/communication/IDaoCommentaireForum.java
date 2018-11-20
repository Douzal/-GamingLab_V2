package fr.gaminglab.dao.api.communication;


import fr.gaminglab.entity.communication.CommentaireForum;
import fr.gaminglab.entity.communication.SujetForum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 */
@Repository
public interface IDaoCommentaireForum extends JpaRepository<CommentaireForum, Integer> {

    /**
     * @param sujet 
     * @return
     */
    public List<CommentaireForum> findBySujetForum(SujetForum sujet);

    public List<CommentaireForum> findByJoueurIdUtilisateur(Integer idUtilisateur);

}