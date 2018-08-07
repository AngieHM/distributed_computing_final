/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Logins;
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
public class UserRepository {
    
        @PersistenceContext(unitName = "pinterestTry1PU")
        private EntityManager em;
    
        public Users getByUsernameAndEmail(String username, String email) {
        try {
            Object rawUser = em.createNamedQuery("Users.findByUsernameAndEmail")
                    .setParameter("username", username)
                    .setParameter("email", email)
                    .getSingleResult();
            if(rawUser instanceof Users) {
                Users u = (Users)rawUser;
                return u;
            }
        } catch(NoResultException e) {
            return null;
        }

        return null;
    }
    
        public List<Logins> findByUser(Users userId) {
       return em.createNamedQuery("Logins.findByUser")
                .setParameter("userId", userId)
                .getResultList();
    }
    
    public List<Users> findAll() {
   return em.createNamedQuery("Users.findAll")
            .getResultList();
    }
    
    public Users getById(int id) {
        try {
            Object rawUser = em.createNamedQuery("Users.findById")
                    .setParameter("id", id)
                    .getSingleResult();
            if(rawUser instanceof Users) {
                Users u = (Users)rawUser;
                return u;
            }
        } catch(NoResultException e) {
            return null;
        }

        return null;
    }
}
