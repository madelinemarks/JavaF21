import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.geom.GeneralPath;

public class Triangles
{
    // execute application
	public static void main(String[] args)
	{
          // create frame
		  JFrame frame = new JFrame("Triangle");      // jframe object for display
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      triangle panel = new triangle(); // creating new panel object
	      frame.add(panel);         // put triangle panel in jframe
	      frame.setSize(500,500);  // set starting size of jframe
	      frame.setVisible(true); // display jframe to user
	}
}
class triangle extends JPanel
{
    int height, width;      // variables for width and height
    int s1, s2, s3;
    int sd1, sd2, sd3;
	
    // function to draw/color triangles
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);    // calling superclass' paint component
	    Random random = new Random();  // random number obj.
	
	    height = getHeight();      
	    width = getWidth();
	
	    for (int i = 0; i <= 5; i++)     // iterate 5 times to draw 5 triangles
        {
		    Graphics2D g2d = (Graphics2D) g;
		    GeneralPath triangle = new GeneralPath();   // create general path object
		
		    sd1 = random.nextInt(height);
		    s1 = random.nextInt(width);     
		    sd2 = random.nextInt(height);
		    s2 = random.nextInt(width);
		    sd3 = random.nextInt(height);
		    s3 = random.nextInt(width);
		
		    triangle.moveTo(s1, sd1);       // start drawing
		    triangle.lineTo(s2, sd2);       // draw first two lines
		    triangle.lineTo(s3, sd3);       // connect two lines
		
		    triangle.closePath();
		
		    g2d.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));      // get random color
		    g2d.fill(triangle);     // fill triangle w random color
	    }
    }
}