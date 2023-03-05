import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class coinFlip extends ConsoleProgram {
    public static int MONEY = 20;
    RandomGenerator rgen = RandomGenerator.getInstance();
    public void run() {
        int testCount = 0;
        while(testCount != 100 && MONEY > 0) {
            MONEY -= 2;
            int flipped = rgen.nextInt(0,1);
            if(flipped == 1) {
                MONEY += 3;
            }
            testCount++;
        }
        println(testCount);
        println(MONEY);
    }
}
