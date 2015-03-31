 import java.awt.*;
import java.util.*;
import java.applet.Applet;
import java.io.*;

/*
<applet code=CharGen width=600 height=600></applet>
*/
public class CharGen extends Applet
{
	public void paint(Graphics g)
	{

		//int a[][]=new int[13][9];
		int a[][]={
			{0,0,0,1,1,1,1,1,1},
			{0,0,1,1,1,1,1,0,0},
			{0,1,1,0,0,0,0,0,0},
			{0,1,0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0,0,0},
			{1,1,0,0,0,0,0,0,0},
			{0,1,0,0,0,0,0,0,0},
			{0,1,1,0,0,0,0,0,0},
			{0,0,1,1,1,1,1,0,0},
			{0,0,0,1,1,1,1,1,1},
	};
		
		int i,j;
		for(i=0;i<13;i++)
		{
			for(j=0;j<9;j++)
			{
				if(a[i][j]==1)
					g.drawString(".",200+j,200+i);
					g.drawOval(190,192,30,30);
			}
		}
	}
}
