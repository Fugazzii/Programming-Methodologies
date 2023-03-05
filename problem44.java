import acm.graphics.GOval;
import acm.program.ConsoleProgram;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

public class problem44 extends GraphicsProgram {
    public GOval ball = new GOval(20, 20);

    @Override
    public void run() {
        addMouseListeners();
        moveBall();
    }

    @Override
    public void mouseClicked(MouseEvent mouse) {
        ball.setLocation(mouse.getX() - 10, mouse.getY() - 10);
        ball.setFilled(true);
        ball.setFillColor(Color.BLACK);
        add(ball);
    }

    public void moveBall() {
        while(ball.getY() + 20 <= getHeight()) {
            ball.move(0,3);
            pause(20);
        }
    }
}
