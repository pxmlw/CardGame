/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author pxmlw126com
 */
@ApplicationScoped
public class CombineClass {
    private HashMap <Game,SetGame> cm1=new HashMap<Game,SetGame>();
    public void add(Game g,SetGame s){
        cm1.put(g, s);
    }
    public SetGame get(Game g){
        return cm1.get(g);  
    }

    /**
     * @return the cm
     */
    public HashMap <Game,SetGame> getCm() {
        return cm1;
    }

    /**
     * @param cm the cm to set
     */
    public void setCm(HashMap <Game,SetGame> cm) {
        this.cm1 = cm;
    }
}
