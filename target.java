import acm.graphics.GRect;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.program.GraphicsProgram;
import java.awt.*;

public class target extends GraphicsProgram {
    static final double WIDTH = 150, HEIGHT = 40;

    public void run() {
        // Save frequent values
        double  centerX = getWidth() / 2.0,
                centerY = getHeight() / 2.0,
                lowerY = getHeight() / (3.0 / 2.0);

        double  lineX1 = centerX + WIDTH / 2,
                lineY2 = centerY + HEIGHT;

        // Rectangles / texts
        rect(centerX, centerY, "Program");
        rect(centerX - WIDTH * 2, lowerY, "GraphicsProgram");
        rect(centerX, lowerY, "ConsoleProgram");
        rect(centerX + WIDTH * 2, lowerY, "DialogProgram");

        // Lines
        line(lineX1, lineY2, centerX + WIDTH / 2, lowerY);
        line(lineX1, lineY2, centerX - WIDTH * 1.5, lowerY);
        line(lineX1, lineY2, centerX + WIDTH * 2.5, lowerY);
    }

    // Draw rectangle with text
    private void rect(double x, double y, String text) {
        GLabel test = new GLabel(text, x, y); // pseudo text class to get access width of the
        GRect r = new GRect(x, y, WIDTH, HEIGHT);
        GLabel txt = new GLabel(text, x + WIDTH / 2 - test.getWidth() / 2, y + HEIGHT / 2 + test.getHeight() / 2);

        add(r);
        add(txt);
    }

    // draw line
    private void line(double x1, double y1, double x2, double y2) {
        GLine newLine = new GLine(x1, y1, x2, y2);
        add(newLine);
    }
}
