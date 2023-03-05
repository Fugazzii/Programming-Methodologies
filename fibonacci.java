import acm.program.ConsoleProgram;

public class fibonacci extends ConsoleProgram {
    public static final int SENTINEL = -1;
    public static int next = 0;

    public void run() {
        println(isFibonacci());
    }

    public boolean isFibonacci() {
        int n = readInt("Enter: ");
        while(n != 0) {
            n = readInt("Not a fibonacci, enter again: ");
        }

        int m = readInt("Enter: ");
        while(m != 1) {
            m = readInt("Not a fibonacci, enter again: ");
        }

        while(true) {
            next = readInt("Enter: ");

            // Breakpoint
            if(next == SENTINEL) {
                break;
            }

            if(n + m != next) {
                return false;
            } else {
                n = m;
                m = next;
            }
        }

        return true;
    }
    public void printFibonacci(int n) {
        int num1 = 1;
        int num2 = 1;
        int i = 2;
        while(i < n) {
            int temp = num1;
            num1 = num2;
            num2 += temp;
            i++;
        }
        println(num2);
    }
}
