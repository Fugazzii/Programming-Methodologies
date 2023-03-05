import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class geometricProgression extends ConsoleProgram {
    public static int b1;
    public static int bNext;
    public static int bn;
    public static float q;
    public static final int SENTINEL = -1;
    public static boolean isProgression = true;

    public void run() {
        isGeometricProgression();
    }

    public void isGeometricProgression() {
        b1 = readInt("Enter: ");
        while(b1 == SENTINEL) {
            b1 = readInt("Enter again: ");
        }
        bNext = readInt("Enter: ");
        while(bNext == SENTINEL) {
            bNext = readInt("Enter again: ");
        }

        q = ((float)bNext / b1);
        while(true) {
            bn = readInt("Enter: ");
            if(bn == SENTINEL) {
                break;
            }

            if((float)bn / bNext != q) {
                isProgression = false;
            }
            bNext = bn;
        }
        println(handleMessages(isProgression));
    }

    public String handleMessages(boolean isSuccess) {
        if(isSuccess) {
            return "It is geometric progression";
        } else {
            return "It is not geometric progression";
        }
    }
}
