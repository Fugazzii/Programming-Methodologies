import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.*;

public class pyramid extends GraphicsProgram {
    // as long as we have the same brick size, we can use constant variables
    static final int BRICK_WIDTH = 30, BRICK_HEIGHT = 12, BRICKS_IN_BASE = 14;
    Color[] colors = new Color[2];
    // constructor
    public pyramid() {
        this.colors[0] = Color.BLUE;
        this.colors[1] = Color.YELLOW;
    }

    public void run() {
        for(int i = 0; i < BRICKS_IN_BASE; i++) { // loop for columns
            for(int j = BRICKS_IN_BASE; j > i; j--) { // loop for rows
                addBrick(calcXCoordinate(i, j), calcYCoordinate(i));
            }
        }
    }

    // function to add bricks
    private void addBrick(int x, int y) {
        GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        brick.setFilled(true);
        brick.setColor(this.colors[0]);
        brick.setFillColor(this.colors[x % 2]);
        add(brick);
    }

    // function to handle x coordinate calculation
    private int calcXCoordinate(int i, int j) {
        return BRICK_WIDTH * j - (BRICK_WIDTH / 2) * i + getWidth() / (BRICK_WIDTH * BRICKS_IN_BASE);
    }

    // function to handle y coordinate calculation
    private int calcYCoordinate(int i) {
        return getHeight() - BRICK_HEIGHT * i;
    }
}
