import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;
import java.awt.event.MouseEvent;

public class circles extends GraphicsProgram {
    RandomGenerator rand = RandomGenerator.getInstance();
    public final int CIRCLE_D = 40;
    public final int CIRCLE_NUM = 40;
    public final int DELAY = 2000;
    public int clicksCount = 0;

    public void run() {
        game();
    }

    public void game() {
        draw();
    }

    GObject c1;
    GObject c;
    public void draw() {
        for(int i = 0; i < CIRCLE_NUM; i++) {
            GOval c1  = new GOval(
                    rand.nextInt(0, getWidth()) - CIRCLE_D,
                    rand.nextInt(0, getHeight()) - CIRCLE_D,
                    CIRCLE_D,
                    CIRCLE_D);
            GOval c  = new GOval(
                    rand.nextInt(0, getWidth()) - CIRCLE_D,
                    rand.nextInt(0, getHeight()) - CIRCLE_D,
                    CIRCLE_D,
                    CIRCLE_D);
            c.setFilled(true);
            c1.setFilled(true);
            Color col = rand.nextColor();
            c1.setFillColor(col);

            add(c);
            add(c1);
            pause(DELAY);
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouse) {
        if(getElementAt(mouse.getX(), mouse.getY()) == null) {
            clicksCount = 0;
        } else {
            clicksCount++;
            if(clicksCount == 1) {
                c = getElementAt(mouse.getX(), mouse.getY());
            } else if(clicksCount == 2) {
                c1 = getElementAt(mouse.getX(), mouse.getY());
                if(getElementAt(mouse.getX(), mouse.getY()).getColor() != c1.getColor()){
					c1 = null;
				}
                else if(c != null && c1 != null && c1.getColor() == c.getColor()) {
                    remove(c);
                    remove(c1);
                }
            }
        }
    }
}
