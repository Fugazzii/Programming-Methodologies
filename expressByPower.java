import acm.program.ConsoleProgram;

public class expressByPower extends ConsoleProgram {
    public void run() {
        boolean isIt = canBeExpressedByPowers(34);
        println(isIt);
    }

    public boolean canBeExpressedByPowers(int num) {
        if(Math.floor(Math.sqrt(num)) == Math.sqrt(num)) {
            return true;
        }

        int sum = 0;

        for(int i = 1; i * i < num; i++) {
            for(int j = i; j * j < num; j++) {
                if(sum == num) {
                    return true;
                }
                sum = i * i + j * j;
            }
        }
        return false;
    }
}
