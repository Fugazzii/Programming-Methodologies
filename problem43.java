import acm.graphics.GOval;
import acm.program.GraphicsProgram;

import java.awt.event.MouseEvent;

public class problem43 extends GraphicsProgram {
    public GOval circle;

    @Override
    public void run() {
        addMouseListeners();
        drawCircle(40, 40);
    }

    public void drawCircle(int x, int y) {
        circle = new GOval(x, y, 40, 40);
        circle.setFilled(true);
        add(circle);
    }

    @Override
    public void mouseDragged(MouseEvent mouse) {
        circle.setLocation(mouse.getX() - 20, mouse.getY() - 20);
    }
}
