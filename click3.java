import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.event.MouseEvent;

public class click3 extends GraphicsProgram {
    private final static int CIRCLE_D = 40;
    private final static int CIRCLE_NUM = 50;
    private final static int DELAY = 2000;
    private static int clicksCount;
    private static GObject currentObj;
    RandomGenerator rand = RandomGenerator.getInstance();

    public void run() {
        addMouseListeners();
        int i = 0;
        while(true) {
            if(clicksCount == 3) {
                remove(currentObj);
            }
            if(i < CIRCLE_NUM) {
                drawCircle();
            }
            pause(DELAY);
            i++;
        }
    }

    public void drawCircle() {
        double x = rand.nextDouble(0.0, getWidth());
        double y = rand.nextDouble(0.0, getHeight());
        GOval circle = new GOval(x, y, CIRCLE_D, CIRCLE_D);
        circle.setFilled(true);
        circle.setFillColor(rand.nextColor());
        add(circle);
    }

    public void mouseClicked(MouseEvent mouse) {
        if(getElementAt(mouse.getX(), mouse.getY()) == null) {
            clicksCount = 0;
        } else {
            if(currentObj != getElementAt(mouse.getX(), mouse.getY())) {
                currentObj = getElementAt(mouse.getX(), mouse.getY());
                clicksCount = 1;
            } else {
                clicksCount++;
            }
        }
    }
}
