import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.*;

public class chess extends GraphicsProgram {
    public void run() {
        final double WIDTH = getWidth(), HEIGHT = getHeight();
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                GRect box = new GRect(i * (WIDTH / 10) + 1, j * (HEIGHT / 10) + 1, WIDTH / 10, HEIGHT / 10);
                add(box);
            }
        }
    }
}
