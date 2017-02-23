package com.simplon;

/**
 * Created by alonso on 18/02/17.
 */
public class Mower {
    private static final int LEFT = -90;
    private static final int RIGHT = 90;
    private static Compass COMPASS = Compass.N;

    private Position position;
    private String sequence;
    private Point max;

    public Mower(Position depart, String sequence, Point max){
        this.position = depart;
        this.sequence = sequence;
        this.max = max;
    }

    public Position readSequence() {
        for (Character c : sequence.toCharArray()) {
            switch (c) {
                case 'L' : turn(LEFT); break;
                case 'R' : turn(RIGHT); break;
                case 'F' : forward(); break;
                default: break;
            }
        }
        return position;
    }

    public Position turn(int angle){
        String cardinal = position.getCardinal();
        int newDegree = ((COMPASS.getDegree(cardinal) + angle) % 360 + 360)%360;
        position.setCardinal(COMPASS.getName(newDegree));
        return position;
    }

    public Position forward() {
        Point newSquare = addPoint(position.getSquare(), COMPASS.getPoint(position.getCardinal()));
        if (newSquare.getX()+newSquare.getY()>0 && !maxPoint(newSquare, max).equals(newSquare)){
          position.setSquare(newSquare);
        }
        return position;
    }

    private Point addPoint(Point a, Point b){return Point.addPoint(a,b);}
    private Point maxPoint(Point a, Point b){return Point.maxPoint(a,b);}
}
