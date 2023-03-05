import acm.program.ConsoleProgram;

public class problem16 extends ConsoleProgram {
    public void run() {
        printProgression(10, 2, 2);
    }

    public void printProgression(int n, int b, int q) {
        for(int i = 0; i < n; i++) {
            println(b);
            b *= q;
        }
    }
}
