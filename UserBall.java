/*Stores and refreshes/paints the UserBall
 *Smit kalathia
 * Jan 22,22
 */
package SmitsCulminating;
import java.awt.Color;
import java.awt.Graphics2D;

public class UserBall{
    public int x;//x coordinates of the main ball
    public int y;//y coordinates of the main ball
    public int speed;//velocity of the main ball
    public int size;//size (diameter) of the mainball
    public Color color;
    /*initializes the variables/components of the ball
     * Pre: int x,y,size Color c
     * post: none
     */
    UserBall(int x, int y, int size, Color c){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = c;
        this.speed = 6;
    }
    /*paints the mainball the color of choice
     * Pre: Graphics2D g
     * Post: none
     */
    public void paint(Graphics2D g){
        g.setColor(color);
        g.fillOval(x - size/2, y - size/2, size, size);
    }
}