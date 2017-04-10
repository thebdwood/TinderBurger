import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controller 
{
	private WelcomeView wv = new WelcomeView();
	
	public Controller()
	{
	
	}
	
	public void setWelcomeView(WelcomeView view)
	{
		this.wv = view;
		wv.addStartButtonListener(new StartButtonListener());
		wv.addWelcomeWindowListener(new WelcomeWindowListener());
	}
	
	public void activateViews()
	{
		wv.activateView();
	}
	
	private class StartButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			/*Closes the window*/
			wv.dispose();
		}
	}
	
	private class WelcomeWindowListener implements WindowListener
	{
		public WelcomeWindowListener()
		{
			
		}

		@Override
		public void windowActivated(WindowEvent arg0) 
		{	
			//Left empty 
		}

		@Override
		public void windowClosed(WindowEvent arg0)
		{
			/*Closes the program*/
			System.exit(0);
		}

		@Override
		public void windowClosing(WindowEvent arg0) 
		{
			//Left empty 
		}

		@Override
		public void windowDeactivated(WindowEvent arg0)
		{
			//Left empty 	
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) 
		{
			//Left empty 
		}

		@Override
		public void windowIconified(WindowEvent arg0) 
		{
			//Left empty 
		}

		@Override
		public void windowOpened(WindowEvent arg0)
		{
			//Left empty 
		}
	}
}
