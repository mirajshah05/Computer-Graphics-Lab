import java.awt.*;
import java.applet.*;
import java.io.*;
public class midpt_circle extends Applet{
  int r=20;
    @Override
public void paint (Graphics g){

Circl c=new Circl();
try{
readr();
}
catch(Exception e){}
c.drawcircle1(r,g);

}

public class Circl{
void drawcircle1(int r,Graphics g){
double p;
int i,x,y;
x=0;
y=r;
p=1.25-r;
do{
g.drawString(".",200+x,200+y);
g.drawString(".",200+y,200+x);
g.drawString(".",200+x,200-y);
g.drawString(".",200+y,200-x);
g.drawString(".",200-x,200-y);
g.drawString(".",200-x,200+y);
g.drawString(".",200-y,200+x);
g.drawString(".",200-y,200-x);

if(p<0){
x++;
p=p+2*x+1;
}
else{
x++;
y--;
p=p+2*(x-y)+1;
}

}
while(x<y);
}
}

void readr()throws IOException{
    System.out.println("Enter the radius");
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    r=Integer.parseInt(br.readLine());
            
}

}
/*<applet code="midpt_circle" width=400 height=500>
</applet>*/