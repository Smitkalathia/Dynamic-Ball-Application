/*Obtaining and utilizing the image from folder.
 * Smit Kalathia
 * Jan 22,22
 */
package SmitsCulminating;
import java.awt.*;
import javax.swing.*;
public class IPanel extends JPanel  {
	Image  Background;//background image
	/*Obtains, scales and sets the background to the image
	 * Pre: none
	 * post:none
	 */
	public IPanel() {
    	super();
    	Toolkit kit = Toolkit.getDefaultToolkit();
    		Background = kit.getImage("Menu.png");//set background to the image named Menu.png
    		Background.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH ) ; //scales the image
    
	}
	/*draws the background onto the panel
	 * pre: Graphics comp
	 * post:none
	 */
	public void paintComponent(Graphics comp) {
    	 Graphics2D comp2D = (Graphics2D) comp;
    	 comp2D.drawImage(Background, 0, 0, this);
    	 }}

