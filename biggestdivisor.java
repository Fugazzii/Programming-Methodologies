import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class biggestdivisor extends ConsoleProgram{
    public void run() {
        println(getBiggestDivisor(24));
    }

    public int getBiggestDivisor(int n) {
        for(int i = n - 1; i > 1; i--) {
            if(n % i == 0 && isPrime(i)) {
                return i;
            }
        }
        return n;
    }

    public boolean isPrime(int num) {
        for(int i = 2; i < num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
