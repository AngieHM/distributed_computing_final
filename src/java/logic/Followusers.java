/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Followers;
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
public class Followusers {
     @PersistenceContext(unitName = "pinterestTry1PU")
    private EntityManager em;

    public Followusers() {
    }

    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void savetoDataBase(Followers followers){
        getEntityManager().persist(followers);

    }
    
     public List<Followers> findByUser(int followingId) {
       return em.createNamedQuery("Followers.findByFollowingId")
                .setParameter("followingId", followingId)
                .getResultList();
    }
    
     public Followers findByIds(int followerId, int followingId) {
         
         try {
            Object rawUser = em.createNamedQuery("Followers.findByIds")
                    .setParameter("followerId", followerId)
                    .setParameter("followingId", followingId)
                    .getSingleResult();
            if(rawUser instanceof Followers) {
                Followers u = (Followers)rawUser;
                return u;
            }
        } catch(NoResultException e) {
            return null;
        }

        return null;
    }
     
     public void deleteFromDataBase(int followersId){
         Followers follow = em.find(Followers.class, followersId);
         em.remove(follow);

    }
   
}
