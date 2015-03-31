/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.Graphics;

/**
 *
 * @author Miraj
 */
public class ddacircle extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    @Override
    public void paint(Graphics g) {
        // TODO start asynchronous download of heavy resources
        double r=50;
        double x=r,y=0;
        double e;
        int n=-1;
        Thread t=null;
        do{
         n++;   
        e=Math.pow(2, n);
        }
        while(e<r);
        e=1/e;
        do{
            x=x+(e*y);
            y=y-(e*x);
            g.drawString(".",200+(int)x,200+(int)y);
            try{
            t.sleep(50);
            }
            catch(Exception e1){}
        }
        while((y-r)<e||(-x)>e);
    }
    // TODO overwrite start(), stop() and destroy() methods
}
/*<applet code="ddacircle" width=800 height=800>
</applet>*/
