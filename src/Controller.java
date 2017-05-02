import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controller 
{
	private WelcomeView wv = new WelcomeView();
	private LoadingView lv = new LoadingView();
	private MainView mv = new MainView();

	public Controller()
	{
	
	}
	
	public void setMainView(MainView mv)
	{
		this.mv = mv;
		mv.addFoodButtonListener(new FoodButtonListener());
		
	}
	
	public void setWelcomeView(WelcomeView view)
	{
		this.wv = view;
		wv.addStartButtonListener(new StartButtonListener());
		wv.addWelcomeWindowListener(new WelcomeWindowListener());
	}
	
	public void activateWelcomeViews()
	{
		wv.activateView();
	}
	
	private class StartButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			/*Closes the window*/
			mv.activateView();
			wv.dispose();
		}
	}
	
	private class FoodButtonListener implements ActionListener
	{
		public FoodButtonListener()
		{
			
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			mv.setVisible(false);
			lv.activateView();
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
			//System.exit(0);
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
	
	
	 /**
	  * Loading View methods
	  * @author thebdwood
	  */
	public void setLoadingView(LoadingView view)
	{
		this.lv = view;
		lv.addLoadButtonListener(new LoadButtonListener());
		lv.addLoadingWindowListener(new LoadingWindowListener());
	}
	
	public void activateLoadViews()
	{
		lv.activateView();
	}
	
	private class LoadButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			/*Closes the window*/
			lv.dispose();
		}
	}
	
	private class LoadingWindowListener implements WindowListener
	{
		public LoadingWindowListener()
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
			//System.exit(0);
			/*THIS IS WHERE A CANCEL LOADING SHOULD CALL APPROPRIATE METHODS */
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
