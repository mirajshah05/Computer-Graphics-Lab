 import java.awt.*;
import java.util.*;
import java.applet.Applet;
import java.io.*;


public class BezierCurve extends Applet
{
	TextField Ax,Ay,Bx,By,Cx,Cy,Dx,Dy;
	Label l1,l2,l3,l4,l5,l6,l7,l8;
	float ax=0,ay=0,bx=0,by=0,cx=0,cy=0,dx=0,dy=0;

	TextField Ex,Ey,Fx,Fy,Gx,Gy,Hx,Hy;
	Label l9,l10,l11,l12,l13,l14,l15,l16;
	float ex=0,ey=0,fx=0,fy=0,gx=0,gy=0,hx=0,hy=0;
	Graphics g1;
	
	public void init()
	{
		Ax=new TextField("100",3);
		Ay=new TextField("400",3);
		Bx=new TextField("200",3);
		By=new TextField("300",3);
		Cx=new TextField("400",3);
		Cy=new TextField("300",3);
		Dx=new TextField("700",3);
		Dy=new TextField("450",3);
		Ex=new TextField("100",3);
		Ey=new TextField("400",3);
		Fx=new TextField("200",3);
		Fy=new TextField("500",3);
		Gx=new TextField("400",3);
		Gy=new TextField("500",3);
		Hx=new TextField("700",3);
		Hy=new TextField("350",3);
		l1=new Label("Ax");
		add(l1); add(Ax);
		l2=new Label("Ay");
		add(l2); add(Ay);
		l3=new Label("Bx");
		add(l3); add(Bx);
		l4=new Label("By");
		add(l4); add(By);
		l5=new Label("Cx");
		add(l5); add(Cx);
		l6=new Label("Cy");
		add(l6); add(Cy);
		l7=new Label("Dx");
		add(l7); add(Dx);
		l8=new Label("Dy");
		add(l8); add(Dy);
		l9=new Label("Ex");
		add(l9); add(Ex);
		l10=new Label("Ey");
		add(l10); add(Ey);
		l11=new Label("Fx");
		add(l11); add(Fx);
		l12=new Label("Fy");
		add(l12); add(Fy);
		l13=new Label("Gx");
		add(l13); add(Gx);
		l14=new Label("Gy");
		add(l14); add(Gy);
		l15=new Label("Hx");
		add(l15); add(Hx);
		l16=new Label("Hy");
		add(l16); add(Hy);
	}
	public void paint(Graphics g)
	{
		ax=Float.parseFloat(Ax.getText());
		ay=Float.parseFloat(Ay.getText());
		bx=Float.parseFloat(Bx.getText());
		by=Float.parseFloat(By.getText());
		cx=Float.parseFloat(Cx.getText());
		cy=Float.parseFloat(Cy.getText());
		dx=Float.parseFloat(Dx.getText());
		dy=Float.parseFloat(Dy.getText());
		ex=Float.parseFloat(Ex.getText());
		ey=Float.parseFloat(Ey.getText());
		fx=Float.parseFloat(Fx.getText());
		fy=Float.parseFloat(Fy.getText());
		gx=Float.parseFloat(Gx.getText());
		gy=Float.parseFloat(Gy.getText());
		hx=Float.parseFloat(Hx.getText());
		hy=Float.parseFloat(Hy.getText());
		//g.drawString(ax+" "+ay+" "+bx+" "+by+" "+cx+" "+cy+" "+dx+" "+dy,200,200);
		//g.drawString(ex+" "+ey+" "+fx+" "+fy+" "+gx+" "+gy+" "+hx+" "+hy,200,200);
		g.setColor(Color.WHITE);
		g.drawLine((int)ax,(int)ay,(int)bx,(int)by);
		g.drawLine((int)bx,(int)by,(int)cx,(int)cy);
		g.drawLine((int)cx,(int)cy,(int)dx,(int)dy);
		g.drawLine((int)ex,(int)ey,(int)fx,(int)fy);
		g.drawLine((int)fx,(int)fy,(int)gx,(int)gy);
		g.drawLine((int)gx,(int)gy,(int)hx,(int)hy);
		bezier(bx,by,cx,cy,dx,dy,8,g);
		bezier2(fx,fy,gx,gy,hx,hy,8,g);
		g.drawOval(200,370,15,15);
		g.drawLine(700,350,700,450);
	}
		
	public boolean action(Event event, Object object)
	{
		repaint();
		return true;
	}
	public void plotLine(float x, float y, Graphics g)
	{
		g.setColor(Color.BLACK);
		g.drawLine((int)ax,(int)ay,(int)x,(int)y);
		ax=x;
		ay=y;
	}
		
		
	public void plotLine1(float x, float y, Graphics g)
	{
		g.setColor(Color.BLACK);
		g.drawLine((int)ex,(int)ey,(int)x,(int)y);
		ex=x;
		ey=y;
	}
	
	public void bezier2(float xf, float yf, float xg, float yg, float xh, float yh, int n, Graphics g)
	{
		float xef,yef,xfg,yfg,xgh,ygh;
		float xefg,yefg,xfgh,yfgh;
		float xefgh,yefgh;
		if(n==0)
		{
			plotLine1(xf,yf,g);
			plotLine1(xg,yg,g);
			plotLine1(xh,yh,g);
		}
		else
		{
			xef=(ex+xf)/2.0f;
			yef=(ey+yf)/2.0f;
			xfg=(xf+xg)/2.0f;
			yfg=(yf+yg)/2.0f;
			xgh=(xg+xh)/2.0f;
			ygh=(yg+yh)/2.0f;
			xefg=(xef+xfg)/2.0f;
			yefg=(yef+yfg)/2.0f;
			xfgh=(xfg+xgh)/2.0f;
			yfgh=(yfg+ygh)/2.0f;
			xefgh=(xefg+xfgh)/2.0f;
			yefgh=(yefg+yfgh)/2.0f;
			n--;
			bezier2(xef,yef,xefg,yefg,xefgh,yefgh,n,g);
			bezier2(xfgh,yfgh,xgh,ygh,xh,yh,n,g);
		}
	}
	
	public void bezier(float xb, float yb, float xc, float yc, float xd, float yd, int n, Graphics g)
	{
		float xab,yab,xbc,ybc,xcd,ycd;
		float xabc,yabc,xbcd,ybcd;
		float xabcd,yabcd;
		if(n==0)
		{
			plotLine(xb,yb,g);
			plotLine(xc,yc,g);
			plotLine(xd,yd,g);
		}
		else
		{
			xab=(ax+xb)/2.0f;
			yab=(ay+yb)/2.0f;
			xbc=(xb+xc)/2.0f;
			ybc=(yb+yc)/2.0f;
			xcd=(xc+xd)/2.0f;
			ycd=(yc+yd)/2.0f;
			xabc=(xab+xbc)/2.0f;
			yabc=(yab+ybc)/2.0f;
			xbcd=(xbc+xcd)/2.0f;
			ybcd=(ybc+ycd)/2.0f;
			xabcd=(xabc+xbcd)/2.0f;
			yabcd=(yabc+ybcd)/2.0f;
			n--;
			bezier(xab,yab,xabc,yabc,xabcd,yabcd,n,g);
			bezier(xbcd,ybcd,xcd,ycd,xd,yd,n,g);
		}
	}
}
