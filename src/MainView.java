import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class MainView extends JFrame
{
	JList<Restaurant> leftList;
	public MainView()
	{
		leftList = new JList<Restaurant>();
	}
	
	public void activateView()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = Math.round(screenSize.getWidth());
		double height = Math.round(screenSize.getHeight());
		/*Set the size of the frame to the screen size*/
		setSize((int) width, (int) height);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
}
