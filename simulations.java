import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class simulations extends ConsoleProgram {
    RandomGenerator rgen = RandomGenerator.getInstance();
    public void run() {
        double result = makeSimulations(1000);
        println(result);
    }

    public double makeSimulations(int n) {
        // n -> გატესტვის რაოდენობა
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += simulation();
        }
        return (double) sum / n;
    }

    // გერბამდე აგდებების რაოდენობა
    public int simulation() {
        int attempt = 0;
        while(true) {
            boolean head = rgen.nextBoolean();
            attempt++;
            if(head) {
                break;
            }
        }
        return attempt;
    }
}
