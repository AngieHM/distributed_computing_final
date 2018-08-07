/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Notifications;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Angela
 */
@Stateless
public class NotificationRepo {
    @PersistenceContext(unitName = "pinterestTry1PU")
    private EntityManager em;

    public NotificationRepo() {
    }

    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void savetoDataBase(Notifications notification){
        getEntityManager().persist(notification);

    }

     public List<Notifications> getByDate(Date date) {
       return em.createNamedQuery("Notifications.findByDate")
                 .setParameter("date", date)
                .getResultList();
    }
}
