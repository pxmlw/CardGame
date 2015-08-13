package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.json.JsonObject;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pradeepganesan
 */

public class SetGame {

    private int id;
    private HashMap<Integer, Card> cardMap = new HashMap<>();
    private ArrayList<Card> Deck;
    private ArrayList<Card> table;
    
   
    public SetGame(){
            Deck=new ArrayList<Card>();
            table=new ArrayList<Card>(); 
     }
    public ArrayList<Card> createShuffledDeck() {
        int count = 0;
        ArrayList<Card> cards = new ArrayList<Card>(81);
        for (int number = 0; number < 3; number++) {
            for (int color = 0; color < 3; color++) {
                for (int symbol = 0; symbol < 3; symbol++) {
                    for (int shading = 0; shading < 3; shading++) {
                        count++;
                        Card cardsObj = new Card(number, color,symbol,shading, count);
                        cards.add(cardsObj);
                        getCardMap().put(count, cardsObj);
                    }
                }
            }
        }
        Collections.shuffle(cards);
        
        return cards;
    }
    
    /*class Card implements Comparable {
     private int number;
     private int symbol;
     private int shading;
     private int colour;
     private float sortOrder;

     public Card(int nu, int sy, int sh, int co) {
     number = nu;
     symbol = sy;
     shading = sh;
     colour = co;
     sortOrder = random.nextFloat(); // used when shuffling the deck
     }

     private Card(int number, int symbol, int shading, int colour, int count) {
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }
     public int compareTo(Object other) {
     if (this.sortOrder == ((Card) other).sortOrder)
     return 0;
     else if ((this.sortOrder) > ((Card) other).sortOrder)
     return 1;
     else
     return -1;
     }

     public String toString() {
     return number + ":" + symbol + ":" + shading + ":" + colour; // + " - " + sortOrder;
     }
     }*/

    public ArrayList<Card> moveCards(ArrayList<Card> from, ArrayList<Card> to, int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            if (from.isEmpty()) {
                break;
            }
            to.add(from.remove(from.size() - 1));
        }
        return to;
    }

    /**
     * @return the cardMap
     */
    public HashMap<Integer, Card> getCardMap() {
        return cardMap;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the Deck
     */
    public ArrayList<Card> getDeck() {
        return Deck;
    }

    /**
     * @param Deck the Deck to set
     */
    public void setDeck(ArrayList<Card> Deck) {
        this.Deck = Deck;
    }

    /**
     * @return the table
     */
    public ArrayList<Card> getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(ArrayList<Card> table) {
        this.table = table;
    }
   
}
