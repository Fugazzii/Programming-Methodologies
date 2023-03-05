/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 *
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {
    public  static final int APPLICATION_WIDTH = 600;
    public  static final int APPLICATION_HEIGHT = 800;
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;
    private static final int PADDLE_WIDTH = 120;
    private static final int PADDLE_HEIGHT = 10;
    private static final int PADDLE_Y_OFFSET = 30;
    private static final int NBRICKS_PER_ROW = 5;
    private static final int NBRICK_ROWS = 4;
    private static final int BALL_RADIUS = 15;
    private static final int BRICK_SEP = 4;
    private static final int BRICK_WIDTH = (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;
    private static final int BRICK_HEIGHT = 8;
    private static final int BRICK_Y_OFFSET = 70;
    private static int BRICKS_COUNT = NBRICKS_PER_ROW * NBRICK_ROWS;
    private static int NTURNS = 3;

    private RandomGenerator rgen = new RandomGenerator();
    GRect Brick = new GRect(
            BRICK_WIDTH + BRICK_SEP,
            BRICK_HEIGHT + BRICK_SEP,
            BRICK_WIDTH,
            BRICK_HEIGHT
    );
    private static int vy = 10;
    private double vx = rgen.nextDouble(1.0,3.0);
    private GOval Ball = new GOval(HEIGHT / 2.0, WIDTH / 2.0, BALL_RADIUS * 2, BALL_RADIUS * 2);
    GRect paddle = new GRect(WIDTH / 2.0, HEIGHT - PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
    /** Runs the Breakout program. */
    public void run() {
        // Default properties
        this.setSize(WIDTH * 2, HEIGHT * 3 / 2);
        this.setBackground(Color.GRAY);
        drawBall();
        drawBricks();
        drawPaddle();
        addMouseListeners();

        // Game loop
        while(NTURNS != 0 && BRICKS_COUNT != 0) {
            moveBall();
            handleCollisions();
            pause(10);
        }

        // Handle Win / Lose
        if(NTURNS == 0) {
            GLabel alert = new GLabel("Game Over", WIDTH / 2.0, HEIGHT / 2.0);
            add(alert);
        } else {
            GLabel alert = new GLabel("YOU WON!", WIDTH / 2.0, HEIGHT / 2.0);
            add(alert);
        }
    }

    private void drawBall() {
        Ball.setFilled(true);
        Ball.setColor(Color.BLACK);
        Ball.setFillColor(Color.BLACK);
        add(Ball);
    }
    private void moveBall() {
        // Handle ball directions
        if(Ball.getX() + BALL_RADIUS * 2 >= WIDTH || Ball.getX() <= 0) {
            vx = -vx;
        }
        if(Ball.getY() >= HEIGHT - BALL_RADIUS * 2 || Ball.getY() <= 0) {
            vy = -vy;
        }
        Ball.move(vx, vy);
    }

    // Draw all bricks
    private void drawBricks() {
        for(int i = 0; i < NBRICK_ROWS; i++) {
            for(int j = 0; j < NBRICKS_PER_ROW; j++) {
                drawBrick(i, j);
            }
        }
    }

    // Draw single brick
    private void drawBrick(int i, int j) {
        Brick = new GRect(
                BRICK_WIDTH * j + BRICK_SEP * j,
                BRICK_HEIGHT * i + BRICK_SEP * i,
                BRICK_WIDTH,
                BRICK_HEIGHT
        );
        Brick.setFilled(true);

        // Give colors to bricks depended on their row
        if(i % 10 == 0 || i % 10 == 1) {
            Brick.setFillColor(Color.RED);
            Brick.setColor(Color.RED);
        } else if(i % 10 == 2 || i % 10 == 3) {
            Brick.setFillColor(Color.ORANGE);
            Brick.setColor(Color.ORANGE);
        } else if(i % 10 == 4 || i % 10 == 5) {
            Brick.setFillColor(Color.YELLOW);
            Brick.setColor(Color.YELLOW);
        } else if(i % 10 == 6 || i % 10 == 7) {
            Brick.setFillColor(Color.GREEN);
            Brick.setColor(Color.GREEN);
        } else {
            Brick.setFillColor(Color.CYAN);
            Brick.setColor(Color.CYAN);
        }
        add(Brick);
    }

    private void drawPaddle() {
        paddle.setFilled(true);
        paddle.setFillColor(Color.BLACK);
        paddle.setColor(Color.BLACK);
        add(paddle);
    }

    private void handleCollisions() {
        // Handle Paddle collision
        if(
            Ball.getX() >= paddle.getX() &&
            Ball.getX() <= paddle.getX() + PADDLE_WIDTH &&
            Ball.getY() + 2 * BRICK_HEIGHT >= paddle.getY())
        {
            vy = -vy;
            paddle.setFillColor(Color.RED);
        }

        // Handle loss
        else if(Ball.getY() + 2 * BRICK_HEIGHT >= paddle.getY() + PADDLE_HEIGHT) {
            NTURNS--;
            Ball.setLocation(WIDTH / 2.0, HEIGHT / 2.0);
            pause(3000);
        } else {
            paddle.setFillColor(Color.BLACK);
        }

        // Handle Brick Collisions

        // Top left
        GObject obj1 = getElementAt(Ball.getX(), Ball.getY());
        // Top Right
        GObject obj2 = getElementAt(Ball.getX() + BALL_RADIUS * 2, Ball.getY());
        // Bottom Right
        GObject obj3 = getElementAt(Ball.getX() + BALL_RADIUS * 2, Ball.getY() + BALL_RADIUS * 2);
        // Bottom left
        GObject obj4 = getElementAt(Ball.getX(), Ball.getY() + BALL_RADIUS * 2);

//        if(vy < 0) {
            if(obj1 != null && obj1 != paddle) {
                vy = -vy;
                remove(obj1);
                BRICKS_COUNT--;
            } else if(obj2 != null && obj2 != paddle) {
                vy = -vy;
                remove(obj2);
                BRICKS_COUNT--;
            } else if(obj3 != null && obj3 != paddle) {
                vy = -vy;
                remove(obj3);
                BRICKS_COUNT--;
            } else if(obj4 != null && obj4 != paddle) {
                vy = -vy;
                remove(obj4);
                BRICKS_COUNT--;
            }
//        }
    }

    // Listeners
    public void mouseMoved(MouseEvent mouse) {
        // Handle paddle movement
        if(mouse.getX() + PADDLE_WIDTH >= WIDTH) {
            paddle.setLocation(WIDTH - PADDLE_WIDTH, HEIGHT - PADDLE_Y_OFFSET);
        } else if(mouse.getX() <= 0) {
            paddle.setLocation(0, HEIGHT - PADDLE_Y_OFFSET);
        } else {
            paddle.setLocation(mouse.getX(), (double)HEIGHT - PADDLE_Y_OFFSET);
        }
    }
}