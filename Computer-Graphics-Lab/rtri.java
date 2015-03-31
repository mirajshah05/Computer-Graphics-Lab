import java.io.*;
import java.awt.*;
import java.applet.*;
public class rtri extends Applet{
	public void paint(Graphics g)
	{
		int theta=90;
		float cost=0,sint=0;
		cost=(float)Math.cos(theta);
		sint=(float)Math.sin(theta);

		float t[][]={{cost,sint,0},{-sint,cost,0},{0,0,1}};
		float p[][]={{0,0,1},{0,100,1},{50,100,1}};
		float f[][]=new float[3][3];
		int x1=(int)p[0][0];
		int x2=(int)p[1][0];
		int y1=(int)p[0][1];
		int y2=(int)p[1][1];
		g.drawLine(x1+300,y1+300,x2+300,y2+300);
		//g.drawLine(p[1][0],p[1][1],p[2][0],p[2][1]);
		//g.drawLine(p[0][0],p[0][1],p[2][0],p[2][1]);
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				for(int k=0;k<3;k++)
				{
					f[i][j]=f[i][j]+(p[i][k]*t[k][j]);
				}
			}
		}
		//g.drawLine(100,100,200,200);
		
		x1=(int)f[0][0];
		x2=(int)f[1][0];
		y1=(int)f[0][1];
		y2=(int)f[1][1];
		g.drawString(","+y1 ,100,100);
		g.drawLine(x1+300,y1+300,x2+300,y2+300);
		//g.drawLine((int)f[1][0],(int)f[1][1],(int)f[2][0],(int)f[2][1]);
		//g.drawLine((int)f[0][0],(int)f[0][1],(int)f[2][0],(int)f[2][1]);				
	}
	public void init()
	{
	}
}
/*<applet code="rtri" height=600 width=500>
</applet>*/
		
