/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author student
 */
public class lbarsky extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        // TODO start asynchronous download of heavy resources
    }
    @Override
    public void paint(Graphics g){
       int x1=10,y1=10;
       int x2=60,y2=30;
       int xwmin=15,ywmin=15;
       int xwmax=25,ywmax=25;
       int dx,dy;
       int q[]=new int[5];
       //int p1,p2,p3,p4;
       int p[]=new int[5];
       g.drawRect((15*10), (15*10), (25*10), (25*10));
       g.drawLine((x1*10),(y1*10),(x2*10),(y2*10));
       dx=(x2-x1);
       dy=(y2-y1);
       q[1]=x1-xwmin;
       q[2]=xwmax-x1;
       q[3]=y1-ywmin;
       q[4]=ywmax-y1;
       
       
       p[1]=-dx;
       p[2]=dx;
       p[3]=-dy;
       p[4]=dy;
       //System.out.println(q[1]);
       double r[]=new double[5];
       r[1]=(double)q[1]/p[1];
       r[2]=(double)q[2]/p[2];
       r[3]=(double)q[3]/p[3];
       r[4]=(double)q[4]/p[4];
       System.out.println(" r="+r[1]);
       
       int max[] = new int[5],min[]=new int[5];
       int k=1,j=1;
       //max=(p[1]<0)?max:min;
       for(int i=1;i<5;i++){
           if(q[i]<0){
               max[k]=i;               
               k++;
           }
           else{
               min[j++]=i;
           }
           
       }
       double mx=0,mn=500;
       int temp;
       for(int i=1;i<k;i++){
           temp=max[i];
           System.out.println(" temp="+temp);
           if(mx<r[temp]){
               mx=r[temp];
           }
       }
       temp=0;
       for(int i=1;i<j;i++){
           temp=min[i];
           System.out.println(" temp="+temp);
           if(mn>r[temp]){
               mn=r[temp];
           }
       }
      System.out.println(mn);
        
      int xx1,xx2,yy1,yy2;
      xx1=(int)((x1+(mx*dx))*10);
      yy1=(int)((y1+(mx*dy))*10);
      xx2=(int)((x1+(mn*dx))*10);
      yy2=(int)((y1+(mn*dy))*10);
      System.out.println("xx1= "+xx1+" yy1="+yy1+"xx2="+xx2+"yy2="+yy2);

      g.setColor(Color.red);
      g.drawLine(xx1,yy1,xx2,yy2); 
       
       
       
        
        
    }
    // TODO overwrite start(), stop() and destroy() methods
}
/*<applet code="lbarsky" height=800 width=800>
 </applet>*/
