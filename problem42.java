import acm.graphics.GLine;
import acm.program.GraphicsProgram;

import java.awt.event.MouseEvent;

public class problem42 extends GraphicsProgram {
    public static boolean isFixed = false;
    public static GLine line;

    public static int lastX = 0;
    public static int lastY = 0;

    @Override
    public void run() {
        addMouseListeners();
    }

    @Override
    public void mousePressed(MouseEvent mouse) {
        line = new GLine(lastX, lastY, mouse.getX(), mouse.getY());
        add(line);
    }

    @Override
    public void mouseDragged(MouseEvent mouse) {
        line.setEndPoint(mouse.getX(), mouse.getY());
    }

    @Override
    public void mouseReleased(MouseEvent mouse) {
        lastX = mouse.getX();
        lastY = mouse.getY();
    }
}
