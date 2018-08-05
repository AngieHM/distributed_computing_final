/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Followed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Angela
 */
@Stateless
public class CrudFollowed {
    @PersistenceContext(unitName = "pinterestTry1PU")
    private EntityManager em;

    public CrudFollowed() {
    }

    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void savetoDataBase(Followed follow){
        getEntityManager().persist(follow);

    }
}
