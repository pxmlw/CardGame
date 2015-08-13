/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author pxmlw126com
 */
@ApplicationScoped
public class GameRoom {
    private ArrayList GameList=new ArrayList();
    /**
     * @return the GameList
     */
    public ArrayList getGameList() {
        return GameList;
    }
    public void addgame(Game game){
       GameList.add(game);
}
    public void deletegame(Game game){
        GameList.remove(game);
    }
    public Game getgame(int gameid){
        Game g=(Game)GameList.get(gameid-1);
        return g;
    }
}
