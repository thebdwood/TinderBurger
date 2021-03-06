import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.DefaultListModel;

public class Controller 
{
	private WelcomeView wv = new WelcomeView();
	private LoadingView lv = new LoadingView();
	private MainView mv = new MainView();
	private PlacesView pv = new PlacesView();

	private Model model;
	
	public Controller()
	{
		
	}
	
	public void setMainView(MainView mv)
	{
		this.mv = mv;
		mv.addFoodButtonListener(new FoodButtonListener());
		mv.addYesButtonListener(new YesButtonListener());
		mv.addNoButtonListener(new NoButtonListener());
		mv.addMaybeButtonListener(new MaybeButtonListener());
		
		
	}
	
	public void setModel(Model m)
	{
		model = m;
		//model.addListener(mv);
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
			mv.setFoodTypes(model.getChoices());
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
			lv.activateView();
			/* timer set to allow loading while LoadView is operational */
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			                
			                Enumeration<Ethnicities> yesses = model.getYesList().elements();
			                List<Ethnicities> yesList = new ArrayList<>(model.getYesList().size());
			                while (yesses.hasMoreElements()){
			                	yesList.add(yesses.nextElement());
			                }
			                String[] yesQuery = new String[yesList.size()];
			                for (int i = 0; i < yesList.size(); ++i){
			                	yesQuery[i] = yesList.get(i).toString();
			                }
			                Locator l = new Locator(yesQuery);
			                for (Restaurant r : l.getResults().values()){
			                	model.addToResultsList(r.toString() + " is a 100% match to your criteria.");
			                }
			                pv.setListModel(model.getResults());
			            	pv.activatePlacesView();
			            	mv.setVisible(false);
			            	lv.dispose();
			            }
			        }, 
			        5000 
			);

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
			/* THIS IS WHERE A CANCEL LOADING SHOULD CALL APPROPRIATE METHODS */
			//mv.activateView();
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
	
	private class YesButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			
			model.addToYesList(mv.getCurrentEthnicity());
		}
		
	}
	
	private class NoButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			
			model.addToNoList(mv.getCurrentEthnicity());
		}
		
	}
	
	private class MaybeButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			
			model.addToMaybeList(mv.getCurrentEthnicity());
		}
		
	}
}
