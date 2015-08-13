package model;


import java.math.BigDecimal;
import java.text.MessageFormat;
import javax.json.Json;
import javax.json.JsonObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pxmlw126com
 */
public class Card {
    private int number ;
    private int color ;
    private int symbor;
    private int shading;
    private int id;
    public Card(int number,int color,int symbor,int shading,int count)
    {
        this.number=number;
        this.color=color;
        this.symbor=symbor;
        this.shading=shading;
        this.id=count;
        
    }
    

    /**
     * @return the shape
     */
   
    


    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the color
     */
    public int getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(int color) {
        this.color = color;
    }

    /**
     * @return the symbor
     */
    public int getSymbor() {
        return symbor;
    }

    /**
     * @param symbor the symbor to set
     */
    public void setSymbor(int symbor) {
        this.symbor = symbor;
    }

    /**
     * @return the shading
     */
    public int getShading() {
        return shading;
    }

    /**
     * @param shading the shading to set
     */
    public void setShading(int shading) {
        this.shading = shading;
    }
}
