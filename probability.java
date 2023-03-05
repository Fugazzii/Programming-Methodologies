import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class probability extends ConsoleProgram {
    RandomGenerator rg = RandomGenerator.getInstance();

    public void run() {
        ruletka();
    }

    private void ruletka() {
        int MONEY = 1000;
        while(MONEY != 0) {
            int randNum = rg.nextInt(0,36);
            int userNum = readInt("Enter num: ");
            while(true) {
                if(userNum <= 36 && userNum >= 0) {
                    break;
                }
                userNum = readInt("Enter valid: ");
            }

            int bet = readInt("Bet: ");
            while(true) {
                if(bet > 0 && bet <= MONEY) {
                    break;
                }
                bet = readInt("Insufficient money, enter again: ");
            }

            if(userNum == randNum) {
                MONEY *= 2;
                println("You won, your money: " + MONEY);
            } else {
                MONEY -= bet;
                println("You lose, your money: " + MONEY);
            }
            println("Ruletkaze movida: " + randNum);
        }
        println("GAKOTRDII BOZOOOOOOOOOOOOOOOOO");
    }

    private void amocana1() {
        int userNum = readInt("Enter from 0 to 36: ");
        while(userNum <= 0 || userNum > 36) {
            userNum = readInt("Again: ");
        }
        int randNum = rg.nextInt(36);
        if (randNum == userNum) {
            println("Moige dzma");
        } else {
            println("Looooooooseeeeeeeer");
        }
        println(randNum);
    }
}
