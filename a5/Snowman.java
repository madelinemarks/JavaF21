import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Snowman
{
    // execute application
    public static void main(String[] args)
	{
        // create frame
		JFrame frame = new JFrame("Snowman");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    snowman panel = new snowman();  // creating new panel object
	    frame.add(panel);       // put snowman panel in jframe
	    frame.setSize(600,400); // set starting size of jframe
	    frame.setVisible(true); // display jframe to user
	}
}
class snowman extends JPanel
{
	private int height, bDiameter, mDiameter, hDiameter, eDiameter;
	private int bCenter, mCenter, hCenter;
	private int theCenter;
	
    // function to draw snowman 
    public void paintComponent(Graphics g)
    {
	 super.paintComponent(g); 					// call superclass's paintComponent 
	 Random random = new Random(); 				// get random number generator
	
	 height = (getHeight()*3)/4; // height takes up 3/4 of panel
	 bDiameter = height/2;
	
   	 if(bDiameter > getWidth())		// set bottom diameter (largest, base the rest of diameters on this #)		
	   { bDiameter = getWidth(); }
	
     
	 hDiameter = (bDiameter/3);          // calculate diameter for head, middle, and eyes
	 mDiameter = ((bDiameter*2)/3);    
	 eDiameter = hDiameter/10;
	 theCenter = getWidth()/2;
	
     hCenter = mCenter-(mDiameter/2)-(hDiameter/2);          // calculate body, middle, and head centers
     mCenter = bCenter-(bDiameter/2)-(mDiameter/2);
	 bCenter = getHeight()-(bDiameter/2)-(getHeight()/8);  

     // drawing head
	 g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));       // get random color
	 g.drawOval(theCenter-(hDiameter/2),hCenter-(hDiameter/2),hDiameter,hDiameter);

     // drawing body/middle
	 g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));    // get random color
	 g.drawOval(theCenter-(mDiameter/2),mCenter-(mDiameter/2),mDiameter,mDiameter);

	 // drawing bottom
 	 g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));    // get random color
	 g.drawOval(theCenter-(bDiameter/2),bCenter-(bDiameter/2),bDiameter,bDiameter); 

	 // drawing eyes
     g.setColor(new Color(0,0,0));      // no color for eyes
	 g.fillOval((theCenter-(hDiameter/4)),(hCenter-(hDiameter/4)),eDiameter,eDiameter); // subtract from x coordinate for left eye
	 g.fillOval((theCenter+(hDiameter/4)-eDiameter),(hCenter-(hDiameter/4)),eDiameter,eDiameter);   // add to x coordinate for right eye
	
     // drawing arms
	 g.drawLine(theCenter-(mDiameter/4),mCenter-(mDiameter/4),theCenter-(mDiameter/4)-(mDiameter/2),
                    mCenter-(mDiameter/4)-(mDiameter/3));   // subtract from x coordinates for left arm
	 g.drawLine(theCenter+(mDiameter/4),mCenter-(mDiameter/4),theCenter+(mDiameter/4)+(mDiameter/2),
                    mCenter-(mDiameter/4)-(mDiameter/3));   // add to x coordinates for right arm
   }
}