/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Player;

/**
 *
 * @author pxmlw126com
 */
@Stateless
public class PlayerBean {
     @PersistenceContext private EntityManager em;
     public Player get(String username){
        return em.find(Player.class, username);
     }
     public void insert(Player p){
         em.persist(p);
     }
}
