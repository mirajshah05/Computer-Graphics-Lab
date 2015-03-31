import java.applet.*;
import java.awt.*;

public class BallApplet extends Applet implements Runnable
{

int x_pos = 10;
int y_pos = 100;
int radius = 20; 
int length =400;

    public void init() { }

    public void start() 
	{
						
	Thread th = new Thread (this);	// define a new thread
	th.start ();			// start this thread
 		
	 }


    public void run () 
	{
	
							
	Thread.currentThread().setPriority(Thread.MIN_PRIORITY);	// lower ThreadPriority

	while (true && x_pos<length)							// run a long while (true) this means in our case "always"
{

    
    	repaint();			// repaint the applet	

    try
    {
        // Stop thread for 20 milliseconds
        Thread.sleep (10);
    }
    catch (InterruptedException ex)
    {
        // do nothing
    }

    // set ThreadPriority to maximum value
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
 	x_pos++;
} 
	
	 }

    public void paint (Graphics g) 
	{
	int i=1,x=10,y=100;

	while(i<length)
	{
	g.setColor(Color.black);
	g.drawString(".",x,y);
	x += 1;
	++i;
	}
	g.setColor (Color.red);		// set color
	g.fillOval (x_pos - radius, y_pos - radius, 2 * radius, 2 * radius); 	// paint a filled colored circle

	 }

} 