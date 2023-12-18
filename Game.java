/*Class for creating a new frame for the game
 * Smit Kalathia
 * Jan 22,22
 */
package SmitsCulminating;
import java.awt.*;
import javax.swing.*;

public class Game extends JFrame {
/*creates a new frame for the actual game
 * pre: none
 * post: none
 */
    public Game() { 
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.setSize(500, 500);
        GamePanel gamePanel = new GamePanel(); //Calls Class GamePanel
        frame.add(gamePanel); //adds class gamepanel to the frame 
        frame.setVisible(true);
        
       }
    
}
       
   
  