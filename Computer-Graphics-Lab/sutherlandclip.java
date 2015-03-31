//package cg;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author PRIYANK
 */
public class sutherlandclip extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    int x1=110,y1=260,x2=600,y2=400;
    int regcode[]=new int[4];
    int tempcode[]=new int[4];
    double xwmin=200,xwmax=600,ywmin=250,ywmax=650;
        
    @Override
    public void init() {
        // TODO start asynchronous download of heavy resources
    }
    // TODO overwrite start(), stop() and destroy() methods
    
    @Override
    public void paint(Graphics g){
    
        int vis;
        regioncode(x1,y1);
        try{
        System.arraycopy(regcode, 0, tempcode, 0, 4);
        }
        catch(NullPointerException e){
        }
         System.out.println(tempcode[0]+""+tempcode[1]+""+tempcode[2]+""+tempcode[3]);
        
        g.drawLine(x1,y1,x2,y2);
        g.drawRect(xwmin, ywmin, 400, 400);
        regioncode(x2,y2);
        vis=visibilty();
        System.out.println(vis);
        System.out.println(regcode[0]+""+regcode[1]+""+regcode[2]+""+regcode[3]);
        if(vis==0)
            System.out.println("Not visible");
        else if(vis==1)
        {
            g.setColor(Color.red);
            g.drawLine(x1,y1,x2,y2);
        }
        else{
            clip();
        }
        
    }
    void regioncode(int ptx,int pty){
        //int code[]=new int[4];
        if(pty<250)
            regcode[0]=1; //top
        else
            regcode[0]=0;
        
        if(pty>650)
            regcode[1]=1;//bottom
        else
            regcode[1]=0;
        
        if(ptx<200)
            regcode[3]=1;//left
        else
            regcode[3]=0;
        
        if(ptx>600)
            regcode[2]=1;//right
        else
            regcode[2]=0;
                
    }
    
    int visibilty(){
        //return 0 for invisible
        //return 1 for fully visible
        //return 2 for partially visible
        int flag=0;
        for(int i=0;i<4;i++)
        {
            if(regcode[i]!=0||tempcode[i]!=0)                
                flag=2;
        }
        if(flag==0)
            return 1;
        else{
            //check partial visible
            for(int i=0;i<4;i++)
            {
                if(regcode[i]==tempcode[i]&&tempcode[i]!=0)
                    return 0;//not visible
            }
           
           return 2; 
        }
        
    }
    
    void clip(){
        int x,y;
        int flag=0;
        double m;
        m=(y2-y1)/(x2-x1);
         for(int i=0;i<4;i++){
             if(regcode[i]!=0||tempcode[i]!=0){
                 flag=1;
                 break;
             }                 
         }
         if(flag==1){
             //Clip x1 y1
             if(tempcode[3]==1){
                 x1=xwmin;
                 y1=int(m*(xwmin-(double)x1)+y1);//left
             }
             else if(tempcode[2]==1){
                 x1=xwmax;
                 y1=int(m*(xwmax-(double)x1)+y1);//right
             }
             else if(tempcode[0]==1){
                 y1=ywmin;
                 x1=int(x1+(1/m)*(ywmin-(double)y1));//top
             }
             else if(tempcode[1]=1){
                 y1=ywmax;
                 x1=int(x1+(1/m)*(ywmax-(double)y1));
             }
         }
    
    
    }
}
/*<applet code="sutherlandclip" height=900 width=900>
</applet>
*/