package com.simplon;

/**
 * Created by alonso on 17/02/17.
 */
public enum Compass{
    N(0, 0, 1),
    E(90, 1, 0),
    S(180, 0, -1),
    W(270, -1, 0);

    private final int angle;
    private int moveX;
    private int moveY;

    Compass(int angle, int moveX, int moveY){
        this.angle = angle;
        this.moveX = moveX;
        this.moveY = moveY;
    }

    public String getCardinal(int angle){
       for (Compass c : values()){
           if (c.angle == angle){
              return c.name();
           }
        }
        return  null; // à voir
    }

    public int getAngle(String cardinal){return ((valueOf(cardinal).angle +360));}
    public int getMoveX(String cardinal) {return valueOf(cardinal).moveX;}
    public int getMoveY(String cardinal) {return valueOf(cardinal).moveY;}
}

