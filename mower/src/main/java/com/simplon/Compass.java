package com.simplon;

/**
 * Created by alonso on 17/02/17.
 */
public enum Compass{
    N(0, new Point(0, 1)),
    E(90, new Point(1, 0)),
    S(180, new Point(0, -1)),
    W(270, new Point(-1, 0));

    private final int degree;
    private Point point;

    Compass(int degree, Point point){
        this.degree = degree;
        this.point = point;
     }

    public String getName(int degree){
       for (Compass c : values()){
           if (c.degree == degree){
              return c.name();
           }
        }
        return  null; // à voir
    }

    public int getDegree(String cardinal){return ((valueOf(cardinal).degree+360));}

    public Point getPoint(String cardinal) {return valueOf(cardinal).point;}

}

