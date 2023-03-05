import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.StringTokenizer;

public class greencircle extends GraphicsProgram {
    private boolean Clicked = false;
    private final static int CIRCLE_D = 40;
    private final static int DELAY = 50;
    private GObject obj;
    RandomGenerator rand = RandomGenerator.getInstance();
    Color[] colors = { Color.RED, Color.BLUE, Color.YELLOW, Color.BLACK, Color.GREEN };

    @Override
    public void run() {
        addMouseListeners();
        while(true){
            if(Clicked){
                startAnimation(obj);
            }
            pause(10);
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouse) {
        obj = getElementAt(mouse.getX(), mouse.getY());
        if(obj == null) {
            GOval circle = new GOval(CIRCLE_D, CIRCLE_D);
            circle.setFilled(true);
            circle.setColor(rand.nextColor());
            add(circle, mouse.getX() - CIRCLE_D / 2.0, mouse.getY() - CIRCLE_D / 2.0);
        } else {
            Clicked = true;
        }
    }

    private void startAnimation(GObject obj) {
        int counter = 0;
        while(counter < colors.length) {
            obj.setColor(colors[counter]);
            counter++;
            pause(DELAY);
        }
        Clicked = false;
    }
}