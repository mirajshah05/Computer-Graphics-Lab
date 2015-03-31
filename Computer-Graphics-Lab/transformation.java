/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.io.*;
import java.util.*;



/**
 *
 * @author student
 */
public class transformation extends Applet {
    volatile int r;
    int x1=15;
        int x2=100;
        int y1=50;
        int y2=60;
        int z=1;
        int[][] a= {{x1,y1,z},{x2,y2,z},{0,0,1}};
        int ans[][]=new int[3][3];
        int tx=50;
        int ty=0;

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    @Override
    public void init() {
        try {
            // TODO start asynchronous download of heavy resources
            takeInput a = new takeInput();
            read();

        } catch (IOException ex) {
            
        }

    }


    @Override
    public void paint(Graphics g){
        
        
        
        
        //int b[][]={{1,0,0},{0,1,0},{tx,ty,1}};
        
        System.out.println(x1+" "+y1);

        g.drawLine(400+x1, 400+y1, 400+x2, 400+y2);
       /* for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    ans[i][j]+=a[i][k]*b[k][j];
                }
            }
        }*/
        rotate();
        g.setColor(Color.red);
        
        g.drawLine(400+ans[0][0], 400+ans[0][1], 400+ans[1][0], 400+ans[1][1]);
        

    }

    public void read()throws IOException{
        System.out.println("Enter x1 & y1");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        x1=Integer.parseInt(br.readLine());
        y1=Integer.parseInt(br.readLine());

        System.out.println("Enter x2 & y2");

        x2=Integer.parseInt(br.readLine());
        y2=Integer.parseInt(br.readLine());

        
    }

    public void translate(){


        int b[][]={{1,0,0},{0,1,0},{tx,ty,1}};




        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    ans[i][j]+=a[i][k]*b[k][j];
                }
            }
        }

    }

    public void rotate(){
        double ang=90;
        ang=ang*3.14/180;
        double rot[][]={{Math.cos(ang),-(Math.sin(ang)),0},{Math.sin(ang),Math.cos(ang),0},{0,0,1}};
        a[0][0]=x1;
        a[0][1]=y1;
        a[1][0]=x2;
        a[1][1]=y2;
        int ansr[][]=new int[3][3];
        tx=-x1;
        ty=-y1;
        translate();
        int tmpx1=x1;
        int tmpy1=y1;
        int tmpx2=x2;
        int tmpy2=y2;
        x1=ans[0][0];
        y1=ans[0][1];
        x2=ans[1][0];
        y2=ans[1][1];

        //clearing matrix
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                ans[i][j]=0;

            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    ans[i][j]+=a[i][k]*rot[k][j];
                }
            }
        }
        ans[0][0]+=tmpx1;
        ans[0][1]+=tmpy1;
        ans[1][0]+=tmpx1;
        ans[1][1]+=tmpy1;


    }

    

    // TODO overwrite start(), stop() and destroy() methods
}
class takeInput{
    

}
/*<applet code="transformation" height=1000 width=1000>
 </applet>
 */