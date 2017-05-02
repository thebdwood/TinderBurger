import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.concurrent.TimeUnit;

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
	JButton loadButton = new JButton("");
	ImageIcon loadingGif = getLoadingGif();
	ImageIcon loadingBtnImg = new ImageIcon("cancelButton.png");
	JLabel loadingText = new JLabel("Loading . . .");
	private int loadingWidth = 200;
	private int loadingHeight = 200;
	public Color loadFrameBackground = Color.decode("#7FDBFF");
	private static final long serialVersionUID = 1L;

	public LoadingView()
	{
		/*Set background color*/
		this.getContentPane().setBackground(loadFrameBackground);
	}
	
	public void activateView()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = Math.round(screenSize.getWidth()/2);
		double height = Math.round(screenSize.getHeight()/2);
		/*JPanel to hold the load button*/
		JPanel buttons = new JPanel();
		loadButton.setIcon(loadingBtnImg);
		/*Sets the loadButton's size to the width of the frame and 20 percent of the height of the frame*/
		loadButton.setPreferredSize(new Dimension((int) width, (int) (height * .2)));
		loadButton.setBackground(loadFrameBackground);
		loadButton.setOpaque(true);
		loadButton.setBorderPainted(false);
		/*Add to panel*/
		buttons.add(loadButton);
		/*Set the size of the gif frame to the screen size*/
		setSize((int) width, (int) height);
		/*Creates a layout of row 1 and 0 columns for the startButton*/
		buttons.setLayout(new GridLayout(1, 0));
		/*Sets an empty border for the buttons JPanel. This is to add padding. 5% padding on both sides for width and 10% for height*/
		buttons.setBorder(new EmptyBorder(0, (int) (width * .05), (int) (height * .1), (int) (width * .05)));
		/*Sets the background color to the background frame color*/
		buttons.setBackground(loadFrameBackground);
		/*Moves the JPanel to the bottom*/
		add(buttons, BorderLayout.SOUTH);
		/*Set the font and size of loading string*/
		loadingText.setFont(new Font("Serif", Font.BOLD, 55));
		/*Aligns the loading string to center of page*/
		loadingText.setHorizontalAlignment(JLabel.CENTER);
		/*Move the JLabel to the top*/
		add(loadingText, BorderLayout.NORTH);
		/*Resizes the gif to fit onto the window*/
		loadingGif.setImage(loadingGif.getImage().getScaledInstance(
				loadingWidth, loadingHeight, Image.SCALE_DEFAULT));
		/*Add the loading gif to center of the panel*/
		add(new JLabel(loadingGif, JLabel.CENTER));
		setLocationRelativeTo(null);
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
	
	/**
	 * This method will randomly select a gif to use for the loading screen
	 * Decided to hardcode the if statements due to a low number of possibilities
	 * Revisit this method if more gifs are added to the program
	 */
	private ImageIcon getLoadingGif() {
		int randomNum = (int)(Math.random() * 10) % 6; //mod by 6 for easy if statements
		if (randomNum == 1)
		{
			return loadingGif = new ImageIcon("turtleSmile.gif");
		}
		else if (randomNum == 2) 
		{
			return loadingGif = new ImageIcon("burgerBounce.gif");
		}
		else if (randomNum == 3) 
		{
			return loadingGif = new ImageIcon("burgerBuild.gif");
		}
		else if (randomNum == 4) 
		{
			return loadingGif = new ImageIcon("fingerCanabalism.gif");
		}
		else if (randomNum == 5) 
		{
			return loadingGif = new ImageIcon("thinkingManPhone.gif");
		}
		else if (randomNum == 6) 
		{
			return loadingGif = new ImageIcon("toastFlip.gif");
		}
		else
		{
			return loadingGif = new ImageIcon("loading.gif");
		}
	}
}

