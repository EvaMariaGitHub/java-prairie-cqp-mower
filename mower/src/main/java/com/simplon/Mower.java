package com.simplon;

import java.awt.*;

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
        int newAngle = (COMPASS.getAngle(cardinal)+angle) % 360;
        position.setCardinal(COMPASS.getCardinal(newAngle));
        return position;
    }

    public Position forward() {
        Point newSquare = position.getSquare();
        newSquare.translate(COMPASS.getMoveX(position.getCardinal()), COMPASS.getMoveY(position.getCardinal()));
        if (notOut(newSquare)) position.setSquare(newSquare);
        return position;
    }

    private boolean notOut(Point square) {
        return (square.getX()+square.getY() >=0 && square.getX()<=max.getX() && square.getY()<=max.getY());
    }


}
