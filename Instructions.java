/*Class presenting the user with the instructions
 * Smit Kalathia
 * Jan 22,22
 */
package SmitsCulminating;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Instructions extends JFrame implements ActionListener {


JLabel one = new JLabel();//Text number one (Mouse to control)
JLabel two = new JLabel();//Text number two (Eat smaller balls)
JLabel Three = new JLabel();//Text number Three (avoid Larger balls)
JLabel Four= new JLabel();//Text number four (eat all 10 balls to win)


/*creates a new panel with instructions and back button
 * pre:none
 * post:none
 */
public Instructions() {
super("Ball Game");
setSize(500,500);
setLayout(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);
IPanel background = new IPanel(); //implements the background image from IPanel into the instructions
background.setLayout(null);
background.setBounds(0,0,500,500);//boundary for image
add(background);
JButton back = new JButton ("BACK");//implements the back button
back.setBounds(323,390,150,60); //position of the button
back.setBackground(new Color(15,15,15));
back.setActionCommand("BACK");
back.addActionListener(this);//makes button available to actionlistener
back.setVisible(true);
background.add(back);

one.setText("Use the mouse to control the Black Ball ");
one.setBackground(new Color(115,115,115)); //background colour
one.setForeground(new Color(240,240,240));
one.setFont(new Font("", Font.BOLD, 20));
one.setOpaque(true);
one.setBounds(0, 0, 500, 25);
background.add(one);//adds text to panel
one.setVisible(true);

two.setText("Your objective is to eat the smaller balls");//text portrayed
two.setBackground(new Color(115,115,115));//background colour
two.setForeground(new Color(0,200,0));//text color
two.setFont(new Font("", Font.BOLD, 20));
two.setOpaque(true);
two.setBounds(0, 100, 500, 25);//positioning
background.add(two);
two.setVisible(true);

Three.setText("Make sure you avoid hitting Larger Balls");
Three.setBackground(new Color(115,115,115));
Three.setForeground(new Color(200,0,0));
Three.setFont(new Font("", Font.BOLD, 20));
Three.setOpaque(true);
Three.setBounds(0, 200, 500, 25);
background.add(Three);
Three.setVisible(true);

Four.setText("If you Eat all 10 balls You Win! Good Luck");
Four.setBackground(new Color(115,115,115));
Four.setForeground(new Color(240,240,240));
Four.setFont(new Font("", Font.BOLD, 20));
Four.setOpaque(true);
Four.setBounds(0, 300, 500, 25);
background.add(Four);
Four.setVisible(true);
setVisible(true);//makes screen visible
}
/*performs actions when a button is pressed
 * pre:ActionEvent event
 * post: none
 */
public void actionPerformed(ActionEvent event) {
String eventName = event.getActionCommand(); 
if( eventName.equals("BACK")) {//calls the method menu when back button is pressed
	setVisible(false);//makes previous instructions not visible
	Menu home = new Menu();//calls Menu method
}
}
}