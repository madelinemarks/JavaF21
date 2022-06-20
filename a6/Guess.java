import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Guess
{
    public static void main(String args[])  // main function
    {
        guess play = new guess();   // creates new window
        play.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        play.setSize(250,300);  // set size
        play.setVisible(true);  // set to visible
    }

    private static class guess extends JFrame
    {
        private static Random r = new Random(); // random number generator to get number to guess

        private int number; // number chosen by application
        private int guess;  // user input

        private boolean firstGuess; // is it the first guess or not

        private int currentDistance;    // distance between new guess and number
        private int previousDistance; // distance between last guess and number

        private JTextField input; // user input field

        private JTextArea line1; // first prompt to user
        private JTextArea line2; // second prompt to user
        private JTextArea line3; // third prompt to user
        private JTextArea higherOrLower; // displays message of game status

        private JButton newGame; // creates new game
        private Color background; // background color of application
        
        public guess()
        {
            super("Guess the Number");  // title of JFrame

            number = getNumber(); 
            firstGuess = true; // new game means firstGuess is true on invokation of constructor
            currentDistance = 0;
            previousDistance = 0;

            input = new JTextField(10); // initialize input field w size
            input.addActionListener(new getInput());    // add functionality to get user input from field

            line1 = new JTextArea("I have a number between 1 and 1000.\n"); // init messages
            line2 = new JTextArea("Can you guess my number?\n");
            line3 = new JTextArea("Please enter your first guess: ");  
            higherOrLower = new JTextArea(" ");

            // formatting
            line1.setEditable(false); line1.setLineWrap(false); line1.setOpaque(false); // formatting
            line2.setEditable(false); line2.setLineWrap(false); line2.setOpaque(false);
            line3.setEditable(false); line3.setLineWrap(false); line3.setOpaque(false);
            higherOrLower.setEditable(false); higherOrLower.setLineWrap(false); higherOrLower.setOpaque(false);

            background = Color.WHITE;   // set background
            newGame = new JButton("New Game");  // create New game button
            newGame.setVisible(false);  // new game button isnt displayed until a game is completed

            newGame.addActionListener(  // implement new game functionality, i.e. this is executed when user selects "New Game"
                new ActionListener()    // new Action Listener object
                {   // define constructor
                    public void actionPerformed(ActionEvent e)  // e = click New Button
                    {
                        newGame.setVisible(false);

                        number = getNumber();     // reinit number values
                        currentDistance = 0;
                        previousDistance = 0;
                        firstGuess = true;  // new game means first guess

                        input.setText("");  // clear input field
                        input.setEnabled(true);     // reenble input field
                        input.setEditable(true);

                        higherOrLower.setText("");  // clear higher or lower message
                        line3.setText("Please enter your first guess: ");    // update prompt

                        background = Color.WHITE;
                        repaint();      // paint GUI
                    } 
                }
            );
            setLayout(new FlowLayout());    // set flow layout
            add(line1,BorderLayout.CENTER); add(line2,BorderLayout.CENTER); add(line3,BorderLayout.CENTER); 
            add(input); add(higherOrLower,BorderLayout.CENTER);  add(newGame);   // add GUI
        } 

        public void paint (Graphics g)
        {
            super.paint(g);
            getContentPane().setBackground(background); // set background color
        }

        public int getNumber()
        {
            number = r.nextInt(1000);   // number between 1 and 1000
            number++;   // increment bc range is [0, 999]
            return number;
        }

        public void warmOrCold()    // function to determine if the player is warmer or colder
        {
            if (currentDistance < previousDistance) // if player is warmer
            { background = new Color(179,6,0); }    // change background 
            else if (currentDistance > previousDistance)    // if player is colder
            { background = new Color(55,96,227); }  // change background
            else
            { background = Color.WHITE; }   // if guess is same distance as previous guess, change background to white
        }
        
        public void getResult(int g)
        {
            currentDistance = 0; // init distance
            if (firstGuess) // case for first guess 
            {
                firstGuess = false; // after this is executed it is no longer the first guess
                previousDistance = Math.abs(g-number);  // init distance between guess and number

                // do not change color of background on first guess
                if (g > number )
                { 
                    higherOrLower.setText("Too High.");
                    line3.setText("Guess again: "); // update prompt
                }
                else if (g < number)
                { 
                    higherOrLower.setText("Too Low.");
                    line3.setText("Guess again: "); // update prompt
                }
                else    // in the rare chance that a user guesses correctly on the first try
                {
                    higherOrLower.setText("Correct!");
                    background = new Color(41,175,52);  // set color to green :p

                    input.setEditable(false);   // prevent user from editing and grey out input field
                    input.setEnabled(false);

                    line3.setText("The number is: "); // update prompt
                    newGame.setVisible(true);   // new game button only displays after game is completed
                }
            }
            else
            {
                currentDistance = Math.abs(g-number);

                if (g > number) // if the guess is greater than the number to guess
                {
                    higherOrLower.setText("Too High.");     // prompt
                    warmOrCold();   // determine if guess is warmer or colder
                    previousDistance = currentDistance; // current becomes previous after appropriate display changes
                }
                else if (g < number)    // if the guess is less than the number to guess
                {
                    higherOrLower.setText("Too Low.");  // prompt
                    warmOrCold();   // determine if guess is warmer or colder
                    previousDistance = currentDistance; // current becomes previous after appropriate display changes
                }
                else    // if not higher or lower, guess is correct
                {
                    higherOrLower.setText("Correct!");
                    background = new Color(41,175,52);  // set color to green :p

                    input.setEditable(false);   // prevent user from editing and grey out input field
                    input.setEnabled(false);

                    line3.setText("The number is: "); // update prompt
                    newGame.setVisible(true);   // new game button only displays after game is completed
                }
            repaint();    // set background color appropriately, repaints window w/ new color
            } 
        }

        class getInput implements ActionListener    // class to get input from text field
        {
            public void actionPerformed(ActionEvent e)  // action handler, in which action is entering in text field
            {   
                guess = Integer.parseInt(input.getText());  // parse input field and convert to int, set guess
                getResult(guess);   // executes code to get result of guess
            } 
        }
    } 
}
