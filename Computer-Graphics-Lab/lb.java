import java.io.*;
import java.applet.*;
import java.awt.*;
import java.util.*;

public class lb extends Applet
{
	public void paint(Graphics g)
	{
	int x1=100,y1=100,x2=600,y2=300;
	int xmin=150,ymin=150,xmax=250,ymax=250;
	int i,j,k;
	//float q1,q2,q3,q4,p1,p2,p3,p4;
	float dx=x2-x1;
	float dy=y2-y1;
	float a,b,c,d;
	
	float p[]=new float[4];
	float q[]=new float[4];
	float dpq[]=new float[4];
	q[0]=x1-xmin;
	q[1]=xmax-x1;
	q[2]=y1-ymin;
	q[3]=ymax-y1;
	
	p[0]=-dx;
	p[1]=dx;
	p[2]=-dy;
	p[3]=dy;
	
	for(i=0;i<4;i++)
	{
		dpq[i]=(q[i]/p[i]);
	}
	
	
	boolean flag;
	float t1,t2;
	if(dpq[0]>dpq[2])
	t1=dpq[0];
	else
	t1=dpq[2];
	
	if(dpq[1]>dpq[3])
	t2=dpq[3];
	else
	t2=dpq[1];
	System.out.println(t1);
	System.out.println(t2);
	int xx1=(int)(x1+(t1*dx));	
	int yy1=(int)(y1+(t1*dy));
	int xx2=(int)(x1+(t2*dx));
	int yy2=(int)(y1+(t2*dy));
	
	System.out.println(xx1);
	System.out.println(yy1);
	System.out.println(xx2);
	System.out.println(yy2);
	g.drawRect(150,150,250,250);
	g.drawLine(x1,y1,x2,y2);
	g.setColor(Color.red);
	g.drawLine(xx1,yy1,xx2,yy2);

}
}
/*
<applet code='lb.class' height=700 width=700>
</applet>
*/