public class Driver 
{

	public static void main(String[] args)
	{
		WelcomeView welcome = new WelcomeView();
		LoadingView loading = new LoadingView();
		Controller controller = new Controller();
		controller.setWelcomeView(welcome);
		controller.setLoadingView(loading);
		controller.activateWelcomeViews();
		controller.activateLoadViews();
	}
}
