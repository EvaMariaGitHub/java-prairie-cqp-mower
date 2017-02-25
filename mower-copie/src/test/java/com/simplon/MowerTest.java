package com.simplon;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;


public class MowerTest {
    Point max = new Point(5,5);

    @Test
    public void leftBySequence()  {
        //set
        Mower mower = new Mower(new Position(new Point(1,2),"N"),"LL",max);
        //test
            Position result = mower.readSequence();
        //assert
            assertTrue((result.getCardinal()).equals("S"));
            assertTrue(result.getSquare().getX() == 1);
            assertTrue(result.getSquare().getY() == 2);
    }

    @Test
    public void rightBySequence()  {
        //set
        Mower mower = new Mower(new Position(new Point(1,2),"N"),"RRR",max);
        //test
        Position result = mower.readSequence();
        //assert
        assertTrue((result.getCardinal()).equals("W"));
        assertTrue(result.getSquare().getX() == 1);
        assertTrue(result.getSquare().getY() == 2);
    }

    @Test
    public void leftByTurn()  {
        //set
        Mower mower = new Mower(new Position(new Point(1,2),"S"),"",max);
        //test
        Position result = mower.turn(Mower.LEFT);
        //assert
        assertTrue((result.getCardinal()).equals("E"));
        assertTrue(result.getSquare().getX() == 1);
        assertTrue(result.getSquare().getY() == 2);
    }

    @Test
    public void rightByTurn()  {
        //set
        Mower mower = new Mower(new Position(new Point(1,2),"S"),"RRR",max);
        //test
        Position result = mower.turn(Mower.RIGHT);
        //assert
        assertTrue((result.getCardinal()).equals("W"));
        assertTrue(result.getSquare().getX() == 1);
        assertTrue(result.getSquare().getY() == 2);
    }



    @Test
    public void forwardBySequence() {
        //set
        Mower mower = new Mower(new Position(new Point(1,2),"S"),"F",max);
        //test
        Position result = mower.readSequence();
        //assert
        assertTrue((result.getCardinal()).equals("S"));
        assertTrue(result.getSquare().getX() == 1);
        assertTrue(result.getSquare().getY() == 1);


    }

    @Test
    public void forward()  {
        //set
        Mower mower = new Mower(new Position(new Point(1,2),"S"),"", max);
        //test
        Position result = mower.forward();
        //assert
        assertTrue((result.getCardinal()).equals("S"));
        assertTrue(result.getSquare().getX() == 1);
        assertTrue(result.getSquare().getY() == 1);

    }

    @Test
    public void forwardOutOfGrid()  {
        //set
        Mower mower = new Mower(new Position(new Point(5,5),"N"),"", max);
        //test
        Position result = mower.forward();
        //assert
        assertTrue((result.getCardinal()).equals("N"));
        assertTrue(result.getSquare().getX() == 5);
        assertTrue(result.getSquare().getY() == 5);
    }

}