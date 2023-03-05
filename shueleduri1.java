    import acm.graphics.*;
    import acm.program.*;
    import acm.util.*;

    import java.applet.*;
    import java.awt.*;
    import java.awt.event.*;

public class shueleduri1 extends GraphicsProgram {
    public static final int BOX_SIZE = 40;
    public static int mouseX = 0;
    public static int SCORE = 0;
    public static GLabel score = new GLabel(SCORE + "");

    @Override
    public void run() {
        addMouseListeners();
        drawSquare();
        drawScore("0");
    }

    public void drawSquare() {
        GRect square = new GRect(
                getWidth () / 2.0 - BOX_SIZE / 2.0,
                getHeight() / 2.0 - BOX_SIZE / 2.0,
                BOX_SIZE,
                BOX_SIZE);
        add(square);
    }

    public void drawScore(String s) {
        score.setLabel(s);
        score.setLocation(getWidth () / 2.0 - score.getWidth() / 2, getHeight () / 2.0 + score.getHeight() / 2);
        add(score);
    }

    public void updateScore(int newScore) {
        remove(score);
        drawScore(newScore + "");
    }

    @Override
    public void mousePressed(MouseEvent mouse) {
        mouseX = mouse.getX();
    }

    @Override
    public void mouseReleased(MouseEvent mouse) {
        if(mouse.getX() > mouseX && SCORE < 9) {
            SCORE++;
        } else if(mouse.getX() < mouseX && SCORE > 1) {
            SCORE--;
        }
        updateScore(SCORE);
    }
}