import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class WelcomeView extends JFrame
{
	JPanel glass;
	JButton startButton;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WelcomeView()
	{
		glass = new JPanel();
		startButton = new JButton("Click Here Start");
	}
	
	public void activateView()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = Math.round(screenSize.getWidth());
		double height = Math.round(screenSize.getHeight());
		/*JPanel to hold the start button*/
		JPanel buttons = new JPanel();
		/*Sets the startButton's size to the width of the frame and 20 percent of the height of the frame*/
		startButton.setPreferredSize(new Dimension((int) width, (int) (height * .20)));
		/*Add to panel*/
		buttons.add(startButton);
		/*Set the size of the frame to the screen size*/
		setSize((int) width, (int) height);
		/*Creates a layout of row 1 and 0 columns for the startButton*/
		buttons.setLayout(new GridLayout(1, 0));
		/*Sets an empty border for the buttons JPanel. This is to add padding. 5% padding on both sides for width and 10% for height*/
		buttons.setBorder(new EmptyBorder(0, (int) (width * .05), (int) (height * .1), (int) (width * .05)));
		/*Moves the JPanel to the bottom*/
		add(buttons, BorderLayout.SOUTH);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}
	
	public void addStartButtonListener(ActionListener l)
	{
		startButton.addActionListener(l);
	}
	
	public void addWelcomeWindowListener(WindowListener l)
	{
		this.addWindowListener(l);
	}
}
