/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Tracks;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import java.util.logging.Logger;

/**
 *
 * @author Angela
 */
@Stateless
public class crudTracks {
    
    @PersistenceContext(unitName = "pinterestTry1PU")
    private EntityManager em;

    public crudTracks() {
    }

    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void savetoDataBase(Tracks track){
        
        try{getEntityManager().persist(track);}
        
        catch (ConstraintViolationException e) {
       e.printStackTrace();
       
    }
    }
}
