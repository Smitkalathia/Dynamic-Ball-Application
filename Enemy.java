/*Class for creating Enemy Balls 
 * Smit Kalathia
 * Jan 22,22
 */
package SmitsCulminating;
import java.awt.*;

import java.awt.geom.*;

public class Enemy 
{   float x, y;           // coordinates of ball rectangle
float xo,yo;		//initial x and y positions
float vx, vy;         // coordinates of velocity vector
Color colour;         // ball colour
float d;     		//diameter of the ball
Ellipse2D.Float circle;//initializing the circle 

//set the values of each variable
//pre: int x,y,vx,vy,d, Color colour
//post:none
Enemy(int x, int y, int vx, int vy, int d, Color colour) 
{ this.x=x; this.y=y; this.d=d; xo=x;yo=y;
this.setColour(colour);
this.setVelocity(vx,vy);
this.setPosition(vx, vy); 
circle = new Ellipse2D.Float(x,y,d,d);
}

//set the colour of the balls
//pre: none
//post: none
public void setColour (Color colour)
{ this.colour=colour; }

//set the velocity vectors
//pre: Color colour
//post: none
public void setVelocity (int vx, int vy)
{ this.vx=vx; this.vy=vy; }
//creates and shows ball based on positions
//pre; Graphics g
//post: none
public void show (Graphics g) 
{ ((Graphics2D)g).setPaint(colour);
circle.setFrame(x,y,d,d);
((Graphics2D)g).fill(circle); xo=x; yo=y;
}
/*sets the position of the balls
 * pre: float x, y
 * post: none
 */
public void setPosition(float x, float y)//sets the position of the balls
{ this.x=x; this.y=y; }
/*makes sure that the balls stay inbounds by bouncing off the border
 * pre: int a,b,xh,yh
 * post: none
 */
public void move(int a,int b, int xh,int yh){ 
	if(vy>0){
		if (y+d+vy-yh-b>0){//y value + size + new y vector - 500 (border) - 0 > 0
			y=yh+b-d;//y = 500+ 0 - size
			vy=-vy;//head in the opposite y direction
		} 
		else y+=vy;
	}
	else{
		if(y+vy<=b){
			y=b; 
			vy=-vy;
		} 
		else y+=vy; 
	}
	if(vx>0){
		if (x+d+vx-xh-a>0){
			x=xh+a-d;
			vx=-vx;//head in the opposite x direction
		} else x+=vx;
	}
	else{
		if(x+vx<=a){
			x=a;
			vx=-vx;
		} 
		else x+=vx;
	}
}

}