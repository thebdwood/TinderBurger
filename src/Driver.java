
public class Driver 
{
	public static void main(String[] args)
	{
		WelcomeView welcome = new WelcomeView();
		LoadingView loading = new LoadingView();
		Controller controller = new Controller();
		MainView mv = new MainView();
		controller.setWelcomeView(welcome);
		controller.setLoadingView(loading);
		controller.activateWelcomeViews();
		controller.setMainView(mv);
		
	}
}
