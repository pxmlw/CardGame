package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author pxmlw126com
 */

public class Game {
    static int count = 0;
    private int gameID;
    private String creater;
    private ArrayList playerlist;
    public Game(String creater) {
        this.creater=creater;
        count++;
        this.gameID = count; 
//        int id = 0;
//        for (int i = 1; i < 4; i++) {
//            for (int j = 1; j < 4; j++) {
//                for (int x = 1; x < 4; x++) {
//                    for (int y = 1; y < 4; y++) {
//                        id++;
//                        Card a=new Card(id, i, j, x, y);
//                    }
//                }
//            }
//        }
//        Collections.shuffle(this.deck);
//        for(int i=0;i<12;i++)
//             {
//                 this.display.add(this.deck.get(i));
//                 this.deck.remove(i);
//             }
//    }

//    public int getGameID() {
//        return gameID;
//    }
//
//    public void setGameID(int gameID) {
//        this.gameID = gameID;
//    }
//
//    public List<Card> getDeck() {
//        return deck;
//    }
//
//    public void setDeck(List<Card> deck) {
//         this.deck=deck;
//    }
//
//    public List<Card> getDisplay() {
//        return display;
//    }
//
//    public void setDisplay(List<Card> display) {
//        this.display = display;
//    }
//
//    /**
//     * @return the playerlist
//     */
//    public List<Player> getPlayerlist() {
//        return playerlist;
//    }
//
//    /**
//     * @param playerlist the playerlist to set
//     */
//    public void setPlayerlist(List<Player> playerlist) {
//        this.playerlist = playerlist;
//    }
    }
    /**
     *
     * @return
     */
    public JsonObject toJson() {
        return (Json.createObjectBuilder()
                .add("gameid", getGameID())
                .add("Creater", getCreater())
                .build());
    }

    /**
     * @return the creater
     */
//    public Player getCreater() {
//        return creater;
//    }
//
//    /**
//     * @param creater the creater to set
//     */
//    public void setCreater(Player creater) {
//        this.creater = creater;
//    }
//    


    /**
     * @return the playerlist
     */
    public List<String> getPlayerlist() {
        return playerlist;
    }

    /**
     * @param playerlist the playerlist to set
     */
    public void setPlayerlist(ArrayList playerlist) {
        this.playerlist = playerlist;
    }

    /**
     * @return the gameID
     */
    public int getGameID() {
        return gameID;
    }

    /**
     * @return the creater
     */
    public String getCreater() {
        return creater;
    }

    /**
     * @param creater the creater to set
     */
    public void setCreater(String creater) {
        this.creater = creater;
    }
}
