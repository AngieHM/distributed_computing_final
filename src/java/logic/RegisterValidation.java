/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Angela
 */
@Stateless
public class RegisterValidation {
            @PersistenceContext(unitName = "pinterestTry1PU")
            private EntityManager em;
            public Users findByFirstname(String name) {
        try {
            Object rawUser = em.createNamedQuery("Users.findByFirstname")
                    .setParameter("firstname", name)
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
