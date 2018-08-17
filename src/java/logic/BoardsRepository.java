/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Boards;
import entity.Followed;
import entity.Users;
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
        
     public List<Followed> getFollowed(Users userid) {
       return em.createNamedQuery("Followed.findByUser")
                .setParameter("userid", userid)
                .getResultList();
    }
     
     public List<Boards> findByUser(Users userid) {
       return em.createNamedQuery("Boards.findByUser")
                .setParameter("userid", userid)
                .getResultList();
    }
     
    public Boards getById(int boardId) {
        try {
            Object rawBoard = em.createNamedQuery("Boards.findByBoardId")
                    .setParameter("boardId", boardId)
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
    
      public void deleteFollow(int followedId) {
        try {
            Object rawBoard = em.createNamedQuery("Followed.deleteFollow")
                    .setParameter("followedId", followedId);

        } 
        catch(NoResultException e) {

        }
    }
      
    public List<Boards> getAll() {
       return em.createNamedQuery("Boards.findAll")
                .getResultList();
    }
    public List<Boards> getByCategory(String category) {
       return em.createNamedQuery("Boards.findByCategory")
                .setParameter("category", category)
                .getResultList();
    }
    
     public void deleteFromDataBase(int boardId){
         Boards board = em.find(Boards.class, boardId);
         em.remove(board);

    }
}
