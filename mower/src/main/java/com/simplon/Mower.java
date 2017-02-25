package com.simplon;

import java.awt.*;

/**
 * Created by alonso on 18/02/17.
 */
public class Mower {
    protected static final int LEFT = -90;
    protected static final int RIGHT = 90;
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
        position.setCardinal(COMPASS.getNewcardinal(position.getCardinal(), angle));
        return position;
    }

    public Position forward() {
        Point newSquare = (Point) position.getSquare().clone(); //sinon on modifie la position ...
        newSquare.translate(COMPASS.getMoveX(position.getCardinal()), COMPASS.getMoveY(position.getCardinal()));
        if (notOut(newSquare)) position.setSquare(newSquare);
        return position;
    }

    private boolean notOut(Point square) {
        return (square.getX()+square.getY() >=0 && square.getX()<=max.getX() && square.getY()<=max.getY());
    }


}
