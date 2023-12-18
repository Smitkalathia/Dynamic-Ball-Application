
/*Class for menu screen of the game
 * Smit Kalathia
 * Jan 22,22
 */
package SmitsCulminating;
 

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JFrame implements ActionListener {
	JLabel one = new JLabel();//Text number one
	JLabel two = new JLabel();//Text number two
	/*Creates the new layout of the menu screen including the help button, text,instructions button and play button
	 * pre:none
	 * post: none
	 */
	public Menu() {
    	super("Welcome To Ball Game");
    	setSize(500,500);
    	setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    	IPanel background = new IPanel();//call IPanel to obtain image
    	background.setLayout(null);
        background.setBounds(0,0,500,500);//set position of image and range
    	add(background);
    	JButton Help = new JButton ("HELP");//help button
        Help.setBounds(150,400,200,60);
        Help.setBackground (new Color(115,115,115));//background of the help button
        Help.setActionCommand("HELP");
        Help.addActionListener(this);
        Help.setVisible(true);
    	background.add(Help);	//adds help button to the panel
    	one.setText("                   Welcome To Ball Game ");
    	one.setBackground(new Color(0,0,0));
    	one.setForeground(new Color(240,240,240));
    	one.setFont(new Font("", Font.BOLD, 20));
    	one.setOpaque(true);
    	one.setBounds(0, 0, 500, 50);
    	background.add(one);
    	one.setVisible(true);
    	two.setText("       Click PLAY to Start the Game or Click INSTRUCTIONS for the Rules");
    	two.setBackground(new Color(15,15,15));
    	two.setForeground(new Color(240,240,240));
    	two.setFont(new Font("", Font.BOLD, 12));
    	two.setOpaque(true);
    	two.setBounds(0, 50, 500, 50);
    	background.add(two);
    	two.setVisible(false);
    	JButton play = new JButton ("PLAY");
        play.setBounds(25,300,200,60);
        play.setBackground (new Color(250,0,0));
        play.setActionCommand("PLAY");
        play.addActionListener(this);
        play.setVisible(true);
    	background.add(play);	
    	JButton I = new JButton ("INSTRUCTIONS");
        I.setBounds(275,300,200,60);
        I.setBackground (new Color(240,240,240));
        I.setActionCommand("INSTRUCTIONS");
        I.addActionListener(this);
        I.setVisible(true);
      	background.add(I);
    	setVisible(true);//sets entire panel as visible

	}
	/*calls Menu
	 * pre:String[] arguments
	 * post: none
	 */
	public static void main(String[] arguments) {
    	Menu frame = new Menu();
    	
	}


	/*performs actions when a button is pressed
	 * pre:ActionEvent event
	 * post: none
	 */
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand(); 
		if(eventName.equals("INSTRUCTIONS")) {
			setVisible(false);//sets previous panel to invisible
			Instructions game = new Instructions();//calls class Instructions
		}
		if(eventName.equals("PLAY")) {
			setVisible(false);
			Game game = new Game();//calls class Game
		}
		if(eventName.equals("HELP")) {
			
			two.setVisible(true);//makes the helping text appear to guide the user to make a choice
			
		}
	}
}