public class Driver 
{
	//main does main stuff
	public static void main(String[] args)
	{
		WelcomeView welcome = new WelcomeView();
		Controller controller = new Controller();
		controller.setWelcomeView(welcome);
		controller.activateViews();
	}
}
