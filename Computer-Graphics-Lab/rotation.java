/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cg;

import java.applet.Applet;
import java.awt.Graphics;

public class rotation extends Applet {
int ans[][]=new int[3][3];
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    @Override
    public void init() {
        // TODO start asynchronous download of heavy resources
    }
    
    @Override
    public void paint(Graphics g){
        int tx=70,ty=0;
        g.drawString("Translation",400,50);
        g.drawLine(50,50,100,100);
        //g.drawLine(x1, y1, x2, y2);
        double x1=50,y1=50,x2=100,y2=100;
        double a[][]={{x1,y1,1},{x2,y2,1},{3,3,1}};
       
        double b[][]={{1,0,0},{0,1,0},{-x1,-y1,1}};
        
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                for(int k=0;k<3;k++)
                {
                    ans[i][j]+=a[i][k]*b[k][j];
                }
                
            }
        }
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++){
                
            }
            
        }
        double r[][]={{0,1,0},{-1,0,0},{0,0,1}};
        write1();
        
        g.drawLine(ans[0][0], ans[0][1], ans[1][0], ans[1][1]);
        
        
        
    }
    // TODO overwrite start(), stop() and destroy() methods
    void write1()
    {
        
                System.out.println(ans[0][0]+" "+ans[0][1]+" "+ans[1][0]+" "+ans[1][1]);
                
           
    }
}
/*<applet code="transformation" width=1200 height=1000>
 </applet>
 */