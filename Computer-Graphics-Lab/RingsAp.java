import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class RingsAp extends Applet
{
public void paint (Graphics g)
{
//Draw the First Circle and make it blue
 g.setColor(Color.blue);
g.drawOval (1,0,40,40);

//Draw the Second Circle and make it yellow
 g.setColor(Color.yellow);
g.drawOval (21,20,40,40);

//Draw the Third Circle and make it black
 g.setColor(Color.black);
g.drawOval (41,0,40,40);

//Draw the Fourth Circle and make it green
 g.setColor(Color.green);
g.drawOval (61,20,40,40);

//Draw the Fifth Circle and make it red
 g.setColor(Color.red);
g.drawOval (81,0,40,40);
}
}