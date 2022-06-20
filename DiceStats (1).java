import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class DiceStats {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        Random randomNumbers = new Random();
        
        System.out.print("How many dice will constitute one roll? ");
        int diceRolled = scnr.nextInt();
        System.out.print("How many rolls? ");
        int numRolls = scnr.nextInt();

        int possibleSums = diceRolled*6;
        int[] frequency = new int[possibleSums];   // array of frequency counters

        for (int i = 1; i <= numRolls; i++) {
            ++frequency[1 + randomNumbers.nextInt(possibleSums-1)];
        }
        
        System.out.println("Sum     # of times     Percentage");
        for (int sum = diceRolled; sum <= possibleSums; sum++)
        {
            double freq = frequency[sum-1];
            double  pct = ((freq/numRolls)*100);
            System.out.println(sum + "            " + frequency[sum-1] + "          " + String.format("%1.2f", pct)+"%");
        }


    }
}
