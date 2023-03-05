import acm.program.ConsoleProgram;

public class base extends ConsoleProgram {
    public void run() {
        // Test cases
        println(toKthBaseSum(8, 2)); // -> 1
        println(toKthBaseSum(10, 5)); // -> 2
        println(toKthBaseSum(6, 8)); // -> 6
    }

    public int toKthBaseSum(int decimal, int k) {
        // Check for k
        int sum = 0;
        if(k < 2 || k > 9) {
            println("Enter k between: 2-9");
            return -1;
        }

        while(decimal > 0) {
            sum += decimal % k;
            decimal /= k;
        }

        return sum;
    }

}
