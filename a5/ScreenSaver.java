import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;

public class ScreenSaver
{
    // execute application
    public static void main( String args[] )
    {
        // create frame
        JFrame frame = new JFrame("ScreenSaver");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        screensaver panel = new screensaver();  // creating new panel object
        frame.add(panel);       // put screensaver panel in jframe
        frame.setSize(800,600); // set starting size of jframe
        frame.setVisible(true); // display jframe to user
   } 
}


class screensaver extends JPanel implements ActionListener
{
   private int delay = 1000;	
   protected Timer timer;
   
   private int random1, random2;
   private int vDiameter, hDiameter;

   public screensaver()     // constructor
   {
      timer = new Timer(delay,this);      // timer object
      timer.start();
   }

   // function to draw/color triangles
   public void paintComponent(Graphics g)
   {
	   super.paintComponent(g);       // calling superclass' paint component
	   Random random = new Random();    // random number obj.
	   Graphics2D g2d = (Graphics2D) g;     
	   
	   
	   for (int i = 0 ; i <= 49; i++)
	   {
		   g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
		   g2d.setStroke(new BasicStroke(random.nextInt(10)+1)); 	
		   random1 = (random.nextInt(getHeight()));		
		   random2 = (random.nextInt(getWidth()));	
		   vDiameter = random.nextInt(getHeight()-random1);	
		   hDiameter = random.nextInt(getWidth()random2);	
		   g.drawOval(random2,random1,hDiameter,vDiameter);
	   } 
   }

}