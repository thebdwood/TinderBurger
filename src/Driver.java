public class Driver 
{
	public static void main(String[] args)
	{
		//Fight me
		WelcomeView welcome = new WelcomeView();
		Controller controller = new Controller();
		controller.setWelcomeView(welcome);
		controller.activateViews();
	}
}
