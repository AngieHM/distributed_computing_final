/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Categories;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Angela
 */
@Stateless
public class CRUDOperationCat {
    
      
     @PersistenceContext(unitName = "pinterestTry1PU")
    private EntityManager em;

    public CRUDOperationCat() {
    }

    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void savetoDataBase(Categories categories){
        getEntityManager().persist(categories);

    }
    
}
