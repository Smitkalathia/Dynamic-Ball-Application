/*Class for gamepanel
 * Smit Kalathia
 * Jan 22,22
 */
package SmitsCulminating;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.awt.Image;
import javax.swing.ImageIcon;
public class GamePanel extends JPanel implements Runnable, MouseMotionListener{
	Image background;//
	ImageIcon getBackground;//Temporary variable for obtaining the background

	int ah,bh,xh,yh;   // parameters of the rectangle frame
	Color[] ColorAr={Color.red,Color.blue,Color.pink,Color.green,Color.yellow,Color.magenta,Color.orange,Color.gray,Color.cyan}; //array to randomize the color of the balls
	public ArrayList<Enemy> dots = new ArrayList<Enemy>(10);//initializing the arraylist for the enemy balls
	UserBall MainBall; //initializing the black ball array
	int quantity=10; //quantity of the enemy balls
	//X and Y positions of the mouse
	int mouseX = 0;
	int mouseY = 0;
	//X and Y distance for the mainball
	static int xDis = 0;
	static int yDis = 0;

	/* Preparation for the game (background,mousemotionlistener,doublebuffering,thread)
	 * Pre: None
	 * Post: None
	 */
	public GamePanel(){
		super();
		getBackground = new ImageIcon("Background.png");
		background = getBackground.getImage();
		background = background.getScaledInstance(500,  500,  Image.SCALE_DEFAULT);
		addMouseMotionListener(this);
		setDoubleBuffered(true);
		create(); //calls method create
		Thread runner = new Thread(this);
		runner.start();

	}
	/*Painting the background, border of the map aswell as the main ball
	 * pre: Graphics gg
	 * post: none
	 */
	public void paint(Graphics gg) { 
		Graphics2D g = (Graphics2D)gg;
		g.drawImage(background,  0,  0,  this);//implements the background image
		g.setPaint(Color.black);
		g.drawRect(ah,bh,xh,yh);//paints the border of the game
		for(int i=0; i<dots.size(); i++){ dots.get(i).show(g); }
		MainBall.paint(g);//fills the main ball
	}

	/*Method for creating the enemy balls and the mainball
	 * pre: none
	 * post: none
	 */
	public void create(){

		ah=0; bh=0; xh=500; yh=500; //border coordinates

		MainBall = new UserBall(250,250,20,Color.BLACK);//creating the main ball 
		for(int i=0; i<5; i++) {// creating small size and speed balls
			dots.add( new Enemy(150,160,(int)(Math.random()*10)-1,(int)(Math.random()*10)-1,
					(int)(Math.random()*6)+17,ColorAr[(int)(Math.random()*8)]));   
		}
		for(int i=0; i<3; i++) {//creating medium size and speed balls
			dots.add( new Enemy(160,170,(int)(Math.random()*8)-2,(int)(Math.random()*8)-2,
					(int)(Math.random()*3)+22,ColorAr[(int)(Math.random()*8)]));
		}
		for(int i=0; i<2; i++) {//creating large sized and speed balls
			dots.add( new Enemy(170,180,(int)(Math.random()*5)-3,(int)(Math.random()*5)-3,
					(int)(Math.random()*3)+25,ColorAr[(int)(Math.random()*8)]));

		}


	}
	/*method for movement and colision of the enemy and mainball (based on mouse movement)
	 * pre: none
	 * post: none
	 */
	public void run() { 


		while(dots.size()>0){//while more than one enemy ball left
			for(int i=0; i<dots.size(); i++) {
				dots.get(i).move(ah,bh,xh,yh); //movement for all the enemy balls so they bounce off the walls

			}
			int directionX = mouseX - MainBall.x; //get the direction the mainball has to head in 
			int directionY = mouseY - MainBall.y;//gets the direction the mainball has to head in
			double distance = Math.sqrt(directionX * directionX + directionY * directionY);//gets the hypotenuse of the direction that the main ball is heading towards 
			if((distance >= 3)){ //distance of the mouse from the last position is greater than or equal to 3 
				//x and y coordinate of the mainball
				MainBall.x += (int)(directionX*MainBall.speed/distance);
				MainBall.y += (int)(directionY*MainBall.speed/distance);
			}

			for(int i=0; i<dots.size(); i++) {//COLLISION DETECTION
				float distanceBetweenCircles = (float)Math.sqrt ((dots.get(i).x - MainBall.x) * (dots.get(i).x - MainBall.x) + (dots.get(i).y - MainBall.y) * (dots.get(i).y - MainBall.y));//solves for the hypotenuse between the mainball and the enemy balls
				if(distanceBetweenCircles < MainBall.size/2 + dots.get(i).d/2 && MainBall.size>=dots.get(i).d){  //distance is less than radius of ball and enemy and ball size is greater than enemy
					dots.remove(i);//removes the enemy ball

					MainBall.size+=1;//increase size of main ball
				}
				else if (distanceBetweenCircles < MainBall.size/2 + dots.get(i).d/2 && MainBall.size<dots.get(i).d){//main ball is smaller than the enemy
					dots.removeAll(dots);//removes the enemy balls to end the while loop

				}


			}
			repaint(); 
			requestFocusInWindow();
			wait(45);    //delay;
		}


		if(MainBall.size==30) {	//win condition

			int WinorLoss=1;//win
			MainBall.size=20;
			setVisible(false);//reset the screen
			GameOver Win = new GameOver(WinorLoss);//call the gameover method
		}
		else if(MainBall.size<30){//Loss condition
			int WinorLoss=2;//loss
			MainBall.size=20;
			setVisible(false);//reset the screen
			GameOver Loss = new GameOver(WinorLoss);//call the gameover method

		}}
	/*creates a delay in the game to make the game run smooth
	 * Pre: int ms
	 * post:none
	 */
	public static void wait(int ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}
	/*obtains the users mouse movement
	 * pre: MouseEvent arg0
	 */
	public void mouseMoved(MouseEvent arg0) {
		mouseX = arg0.getX();
		mouseY = arg0.getY();
	}
	@Override
	/* Method needed to run the game
	 * pre: MouseEvent e
	 */
	public void mouseDragged(MouseEvent e) {

	}



}  