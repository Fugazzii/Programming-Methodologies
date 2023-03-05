import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.event.MouseEvent;

public class ovalorsquare extends GraphicsProgram {
    public static boolean isOval = true;
    public static int diameter = 40;
    public static int size = 30;
    public static int lastX = 0;

    @Override
    public void run() {
        addMouseListeners();
    }

    @Override
    public void mouseClicked(MouseEvent mouse) {
        if(isOval) {
            GOval circle = new GOval(diameter, diameter);
            circle.setLocation(mouse.getX() - diameter / 2.0, mouse.getY() - diameter / 2.0);
            add(circle);
        } else {
            GRect rect = new GRect(size, size);
            rect.setLocation(mouse.getX() - size / 2.0, mouse.getY() - size / 2.0);
            add(rect);
        }
    }

    @Override
    public void mousePressed(MouseEvent mouse) {
        lastX = mouse.getX();
    }

    @Override
    public void mouseReleased(MouseEvent mouse) {
        if(lastX < mouse.getX()) {
            isOval = true;
        } else if(lastX > mouse.getX()){
            isOval = false;
        }
    }
}
