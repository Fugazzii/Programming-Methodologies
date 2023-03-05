import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.*;

import java.awt.*;


public class misia2 extends GraphicsProgram {
    public void run() {
        // World
        GRect body = new GRect(0, 0, getWidth(), getHeight());
        body.setFilled(true);
        body.setColor(Color.BLACK);
        body.setFillColor(Color.BLACK);
        add(body);

        // Robot Head
        double worldW = getWidth(), worldH = getHeight(), robotW = 250, robotH = 250;
        GRect robot = new GRect((worldW / 2) - (robotW / 2), (worldH / 2) - (robotH / 2), robotW, robotH);
        robot.setFilled(true);
        robot.setColor(Color.WHITE);
        robot.setFillColor(Color.WHITE);
        add(robot);

        // Eyes
        GOval leftEye = new GOval(
                (worldW / 2) - (robotW / 4),
                (worldH / 2) - (robotH / 4),
                40,
                40
        );
        GOval rightEye = new GOval(
                (worldW / 2) + (robotW / 4) - 40,
                (worldH / 2) - (robotH / 4),
                40,
                40
        );
        leftEye.setFilled(true);
        leftEye.setColor(Color.RED);
        leftEye.setFillColor(Color.RED);
        add(leftEye);

        rightEye.setFilled(true);
        rightEye.setColor(Color.RED);
        rightEye.setFillColor(Color.RED);
        add(rightEye);

        // Nose
        GLine nose = new GLine(worldW / 2, worldH / 2, worldW / 2, worldH / 2 + 40);
        add(nose);

        // Mouth
        GRect mouth = new GRect(worldW / 2 - 40, worldH / 2 + 60, 80, 40);
        mouth.setFilled(true);
        mouth.setColor(Color.YELLOW);
        mouth.setFillColor(Color.YELLOW);
        add(mouth);
    }
}