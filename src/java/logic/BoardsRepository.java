/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Boards;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Angela
 */
@Stateless
public class BoardsRepository {
        @PersistenceContext(unitName = "pinterestTry1PU")
        private EntityManager em;
    
        public Boards getAllBoards() {
        try {
            Object rawBoard = em.createNamedQuery("Boards.findAll")
                    .getSingleResult();
            if(rawBoard instanceof Boards) {
                Boards u = (Boards)rawBoard;
                return u;
            }
        } catch(NoResultException e) {
            return null;
        }

        return null;
    }
        
    
}
