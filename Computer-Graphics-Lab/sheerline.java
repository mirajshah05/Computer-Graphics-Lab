import java.io.*;
import java.awt.*;
import java.applet.*;
public class sheerline extends Applet{
	public void paint(Graphics g)
	{
		int theta;
		int t[][]={{1,0,0},{1,1,0},{0,0,1}};
		int p[][]={{50,50,1},{50,100,1},{100,100,1},{100,50,1}};
		int f[][]=new int[4][4];
		g.drawLine(p[0][0],p[0][1],p[1][0],p[1][1]);
		g.drawLine(p[1][0],p[1][1],p[2][0],p[2][1]);
		g.drawLine(p[0][0],p[0][1],p[3][0],p[3][1]);
		g.drawLine(p[2][0],p[2][1],p[3][0],p[3][1]);

		for(int i=0;i<4;i++)
		{
			for(int j=0;j<3;j++)
			{
				for(int k=0;k<3;k++)
				{
					f[i][j]=f[i][j]+(t[k][j]*p[i][k]);
				}
			}
		}
		
		g.drawLine(f[0][0],f[0][1],f[1][0],f[1][1]);
		g.drawLine(f[1][0],f[1][1],f[2][0],f[2][1]);
		g.drawLine(f[0][0],f[0][1],f[3][0],f[3][1]);
		g.drawLine(f[2][0],f[2][1],f[3][0],f[3][1]);				
	}
	public void init()
	{
	}
}
/*<applet code="sheerline" height=600 width=500>
</applet>*/
		
