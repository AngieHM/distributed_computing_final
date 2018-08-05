/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Logins;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Angela
 */
@Stateless
public class CrudOperationLogins {
          
     @PersistenceContext(unitName = "pinterestTry1PU")
    private EntityManager em;

    public CrudOperationLogins() {
    }

    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void savetoDataBase(Logins login){
        getEntityManager().persist(login);

    }
}
