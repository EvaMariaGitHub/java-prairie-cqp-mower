package com.simplon;

import java.awt.*;

/**
 * Created by alonso on 18/02/17.
 */
public class Position {
    private Point square;
    private String cardinal;

    public Position(Point square, String cardinal){
        this.square = square;
        this.cardinal = cardinal;
    }

    public Point getSquare(){
        return this.square;
    }

    public void  setSquare(Point square){
        this.square = square;
    }

    public String getCardinal(){return this.cardinal;}

    public void setCardinal(String newCardinal){this.cardinal = newCardinal;}

    @Override
    public String toString() {
        return  "(" +(int) square.getX()+ ","+(int) square.getY()+")" + cardinal;
    }
}
