import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class shuala2 extends ConsoleProgram {
    public static int d;

    public void run (){
        int n = readInt("Enter: ");
        if(n == -1) {
            // Error
        }

        int m = readInt("Enter: ");
        if(m == -1) {
            // Error
        }

        d = m - n;

        boolean status = true;
        while(true) {
            n = readInt("Enter new value for n: ");
            if(n == -1) {
                break;
            }
            if(n - m != d) {
                status = false;
            }
            m = n;
        }
        println(status);
    }
}
