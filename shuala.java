import stanford.karel.*;

public class shuala extends SuperKarel {
    public void run() {
        while(beepersPresent()) {
            moveToLastBeeper();
            pickBeeper();
            goToOrigin();
            turnRight();
            while(beepersPresent()) {
                move();
            }
            putBeeper();
            turnAround();
            goToOrigin();
            turnLeft();
        }
    }

    private void moveToLastBeeper() {
        while(beepersPresent()) {
            move();
        }
        turnAround();
        move();
    }

    private void goToOrigin() {
        while(frontIsClear()) {
            move();
        }
    }
}
