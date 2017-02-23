package com.simplon;

/**
 * Created by alonso on 23/02/17.
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static Point addPoint(Point a, Point b){
       return new Point(a.getX() + b.getX(), a.getY()+b.getY());
    }

    public int getX() {return x;}

    public int getY() {return y;}
}
