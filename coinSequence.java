import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class coinSequence extends ConsoleProgram{
    RandomGenerator rand = RandomGenerator.getInstance();
    public static final int EXPERIMENT_COUNT = 100;
    public void run() {
        println(makeSimulations());
    }

    public double makeSimulations() {
        int sum = 0;
        for(int i = 0; i < EXPERIMENT_COUNT; i++) {
            sum += getCoinSequence(10);
        }
        return (double) sum / EXPERIMENT_COUNT;
    }

    public int getCoinSequence(int n) {
        int counter = 0;
        while(n != 0) {
            if(flipCoin()) {
                n /= 2;
            } else {
                n--;
            }
            counter++;
        }
        return counter;
    }

    public boolean flipCoin() {
        boolean coin = rand.nextBoolean();
        return coin;
    }
}
