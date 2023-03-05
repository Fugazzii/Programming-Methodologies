/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class misia1 extends SuperKarel {

    public void run() {
        for(int i = 0; i < 4; i++) {
            fillColumn(); // fill n size column
            returnDown(); // return to the first row
            move4Times(); // move to the next destination
        }
    }

    private void fillColumn() {
        turnLeft();
        safePut(); // put beeper on the first box
        while(frontIsClear()) {
            move();
            safePut();
        }
    }

    private void safePut() {
        if(noBeepersPresent()) {
            putBeeper();
        }
    } // we are supposed to have beepers only once, therefore let's check if the box already contains one or not

    private void returnDown() {
        turnAround();
        while(frontIsClear()) {
            move();
        }
        turnLeft();
    }


    private void move4Times() {
        if(frontIsClear()) {
            for(int i = 0; i < 4; i++) {
                move();
            }
        }
    }

    private void safeMove() {
        if(frontIsClear()) {
            move();
        }
    }
}
