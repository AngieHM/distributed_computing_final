/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Boards;
import entity.Tracks;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Angela
 */
@Stateless
public class TrackRepository {
    @PersistenceContext(unitName = "pinterestTry1PU")
    private EntityManager em;
    
    public List<Tracks> getAll() {
       return em.createNamedQuery("Tracks.findAll")
                .getResultList();
    }
    
    public List<Tracks> findByBoard(Boards board) {
       return em.createNamedQuery("Tracks.findByBoard")
                .setParameter("board", board)
                .getResultList();
    }
}
