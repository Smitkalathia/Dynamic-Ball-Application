/*Class for creating a GameOver screen
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

public class GameOver extends JFrame implements ActionListener {


JLabel one = new JLabel();//Game over text
JLabel Win = new JLabel();//win condition text
JLabel Loss = new JLabel();//lose condition text

/*creates a new screen which presents either the win condition or loss
 * pre: int WorL
 * post: none
 */

public GameOver(int WorL) {
super("Ball Game");
setSize(500,500);
setLayout(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);
IPanel background = new IPanel();//calls class IPanel to obtain and print the background
//Similar to class Instructions[
background.setLayout(null);
background.setBounds(0,0,500,500);
add(background);
JButton back = new JButton ("PLAYAGAIN");
back.setBounds(323,390,150,60);
back.setBackground(new Color(150,15,15));
back.setActionCommand("PLAYAGAIN");
back.addActionListener(this);
back.setVisible(true);
background.add(back);

one.setText("                      Game Over");
one.setBackground(new Color(15,15,15));
one.setForeground(new Color(240,240,240));
one.setFont(new Font("", Font.BOLD, 20));
one.setOpaque(true);
one.setBounds(0, 0, 500, 25);
background.add(one);
one.setVisible(true);


Win.setText("         Congratulations, You Win");
Win.setBackground(new Color(15,225,15));
Win.setForeground(new Color(240,240,240));
Win.setFont(new Font("", Font.BOLD, 20));
Win.setOpaque(true);
Win.setBounds(0, 150, 500, 25);
background.add(Win);
Win.setVisible(false);

Loss.setText("        Better Luck next Time, You Lose");
Loss.setBackground(new Color(215,25,15));
Loss.setForeground(new Color(240,240,240));
Loss.setFont(new Font("", Font.BOLD, 20));
Loss.setOpaque(true);
Loss.setBounds(0, 150, 500, 25);
background.add(Loss);
Loss.setVisible(false);
setVisible(true);
//end of similarity to class instructions]


if(WorL==1) {//depending on the circumstances from class GamePanel
Win.setVisible(true);//makes victory text visible
}
else if (WorL==2) {
Loss.setVisible(true);//makes loss text visible
}


}

/*performs actions when a button is pressed
 * pre:ActionEvent event
 * post: none
 */
public void actionPerformed(ActionEvent event) { 
String eventName = event.getActionCommand(); 
if( eventName.equals("PLAYAGAIN")) {
	setVisible(false);
	Game home = new Game();//calls class Game
}
}

}