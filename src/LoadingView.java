import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author thebdwood
 * This class is going to be the loading view. 
 * Thebdwood will take point on this page.
 * 
 */

public class LoadingView extends JFrame
{
	JPanel glass = new JPanel();
	JButton loadButton = new JButton("Click here to stop loading");
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoadingView()
	{
		
	}
	
	public void activateView()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = Math.round(screenSize.getWidth()/2);
		double height = Math.round(screenSize.getHeight()/2);
		/*JPanel to hold the start button*/
		JPanel buttons = new JPanel();
		/*Sets the startButton's size to the width of the frame and 20 percent of the height of the frame*/
		loadButton.setPreferredSize(new Dimension((int) width, (int) (height * .20)));
		/*Add to panel*/
		buttons.add(loadButton);
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
	
	public void addLoadButtonListener(ActionListener l)
	{
		loadButton.addActionListener(l);
	}
	
	public void addLoadingWindowListener(WindowListener l)
	{
		this.addWindowListener(l);
	}
}

