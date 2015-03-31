import java.io.*;
import java.awt.*;
import java.applet.*;
public class tline extends Applet{
	public void paint(Graphics g)
	{
		int theta;
		int t[][]={{1,0,0},{0,1,0},{50,50,1}};
		int p[][]={{50,50,1},{100,50,1},{200,200,1}};
		int f[][]=new int[3][3];
		g.drawLine(p[0][0],p[0][1],p[1][0],p[1][1]);
		g.drawLine(p[1][0],p[1][1],p[2][0],p[2][1]);
		g.drawLine(p[0][0],p[0][1],p[2][0],p[2][1]);
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
		
		g.drawLine(f[0][0],f[0][1],f[1][0],f[1][1]);
		g.drawLine(f[1][0],f[1][1],f[2][0],f[2][1]);
		g.drawLine(f[0][0],f[0][1],f[2][0],f[2][1]);				
	}
	public void init()
	{
	}
}
/*<applet code="tline" height=600 width=500>
</applet>*/
		
