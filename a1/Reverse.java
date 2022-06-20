import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {

        long longinteger = 0;                // initialize string to empty
        Scanner scnr = new Scanner(System.in);  // new scanner object for input
        boolean cont = true;

        
        while (cont) {
            System.out.print("Please enter a long integer (0 to quit): ");
            longinteger = scnr.nextLong();

            if (longinteger == 0) {
                System.out.println("Goodbye!");
                System.exit(0);         // exit program
            }
            else {
            if (longinteger < 10)
                System.out.println("The number reversed is: "+longinteger);
            else {
                String temp = String.valueOf(longinteger);
                char[] toArray = temp.toCharArray();
                String reverse = "";
                for (int i = temp.length(); i > 0; i--)
                {
                    reverse = reverse + toArray[i-1];
                }
                long reversed = Long.parseLong(reverse);
                System.out.println("The number reversed is: "+reversed);
            }
        }
            System.out.println();
        }
    }
}
