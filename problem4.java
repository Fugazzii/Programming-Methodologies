import acm.program.ConsoleProgram;

import java.util.StringTokenizer;

public class problem4 extends ConsoleProgram {
    public final int SENTINEL = -1;
    public static int next = 0;

    public void run() {
        int test = nthFibonacci(4);
        println(test);
    }



    public int nthFibonacci(int n) {
        int f1 = 0;
        int f2 = 1;
        int next = -1;

        int counter = 2;
        while(counter != n) {
            next = f1 + f2;
            f1 = f2;
            f2 = next;
            counter++;
        }

        return next;
    }
}
