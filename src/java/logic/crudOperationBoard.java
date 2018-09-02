/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Boards;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Angela
 */
@Stateless
public class crudOperationBoard {
        @PersistenceContext(unitName = "pinterestTry1PU")
    private EntityManager em;

    public crudOperationBoard() {
    }

    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void savetoDataBase(Boards board){
        getEntityManager().persist(board);

    }
    
         public void updateDataBase(Boards board){
        getEntityManager().merge(board);

    }
}
