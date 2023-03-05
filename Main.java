/*
 * File: FindRange.java
 * --------------------
 * This program is a stub for the FindRange problem, which finds the
 * smallest and largest values in a list of integers.
 */

import acm.program.*;

public class Main extends ConsoleProgram {

    private int usj(int num1, int num2) {
        for(int i = Math.max(num1, num2); i <= num1 * num2; i += Math.max(num1, num2)) {
            if(i % num1 == 0 && i % num2 == 0) {
                return i;
            }
        }
        return -1;
    }

    public void run() {
        // Test cases
        println(usj(7, 15)); // 7 * 15
        println(usj(2, 7));  // 14
        println(usj(9, 13)); // 9 * 13
        println(usj(20, 60));// 60
        println(usj(12, 24));// 24
    }
}
