
public class Driver 
{
	public static void main(String[] args)
	{

		Model model = new Model();
		WelcomeView welcome = new WelcomeView();
		LoadingView loading = new LoadingView();
		Controller controller = new Controller();
		MainView mv = new MainView();
		
		mv.setModel(model);
		controller.setModel(model);
		controller.setWelcomeView(welcome);
		controller.setLoadingView(loading);
		controller.activateWelcomeViews();
		controller.setMainView(mv);
		
		
		//mv.setFoodTypes(model.getChoices());
	}
}
