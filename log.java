import acm.program.ConsoleProgram;

public class log extends ConsoleProgram {
    // log2(1024) = 10;

    public void run() {
        println(logarithm(2,9));
    }

    public int logarithm(int n, int m) {
        int x = n;
        int counter = 0;
        while(n <= m) {
            n *= x;
            counter++;
        }
        return counter;
    }
}
