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

    public static Point maxPoint(Point a, Point b) {
        if ((a.getX() > b.getX()) || (a.getY() > b.getY()))
            return a;
        return b;
    }

    public int getX() {return x;}

    public int getY() {return y;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        if (x != point.x) {
            return false;
        }
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

}
