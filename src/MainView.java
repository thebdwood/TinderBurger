import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * The main view for the user interface. Allows drag and drop features and displays changes to user.
 * @author amorr
 *
 */
public class MainView extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constant to change the title of the no list
	 */
	final String NO_LIST_TITLE = "No thanks";
	/**
	 * Constant to change the title of the maybe list
	 */
	final String MAYBE_LIST_TITLE = "Maybe";
	/**
	 * Constant to change the title of the yes list
	 */
	final String YES_LIST_TITLE = "Sounds good";
	/**
	 * Constant to change the size of the all three list titles
	 */
	final int FONT_LIST_TITLE_SIZES = 25;
	/*Lists that hold the information to be displayed*/
	private DefaultListModel<Restaurant> noListModel;
	private DefaultListModel<Restaurant> maybeListModel;
	private DefaultListModel<Restaurant> yesListModel;
	/*JScroll panes that display the relative list*/
	private JScrollPane noList;
	private JScrollPane maybeList;
	private JScrollPane yesList;
	/*User options*/
	private JButton resetButton;
	private JButton foodButton;
	private JButton helpButton;
	/**
	 * Constructor for MainView. Initializes the JScrollPanes and the DefaultListModels
	 */
	public MainView()
	{
		noListModel = new DefaultListModel<>();
		noList = new JScrollPane(new JList<Restaurant>(noListModel));
		
		maybeListModel = new DefaultListModel<>();
		maybeList = new JScrollPane(new JList<Restaurant>(maybeListModel));
		
		yesListModel = new DefaultListModel<>();
		yesList = new JScrollPane(new JList<Restaurant>(yesListModel));
		
		resetButton = new JButton("Reset");
		foodButton = new JButton("Find me food");
		helpButton = new JButton("Help");
		
	}
	/**
	 * Builds the view when called
	 */
	public void activateView()
	{
		/*Gets the Dimensions of the screen*/
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = Math.round(screenSize.getWidth());
		double height = Math.round(screenSize.getHeight());
		
		/*Panel to hold buttons*/
		JPanel buttonPanel = new JPanel();
		/*Layout for buttonPanel*/
		GridLayout buttonPanelLayout = new GridLayout(1,3);
		buttonPanelLayout.setHgap(10);
		/*Add buttons*/
		//buttonPanel.add(resetButton);
		buttonPanel.add(helpButton);
//		buttonPanel.add(helpButton);
		/*Panel that holds the lists*/
		JPanel listsPanel = new JPanel();
		/*Layout for the listsPanel*/
		GridLayout listsPanelLayout = new GridLayout(2, 3);
		listsPanelLayout.setHgap(10);
		/*Sets the listsPanel's layout*/
		listsPanel.setLayout(listsPanelLayout);
		/*Creates padding around the JPanel*/
		listsPanel.setBorder(new EmptyBorder(0, (int) (width * .05), (int) (height * .05), (int) (width * .05)));
		listsPanel.setPreferredSize(new Dimension((int) (width * .40), (int) (height*.40)));
		
		TitledBorder noListTitleBorder = new TitledBorder(new LineBorder(Color.BLACK, 1));
		noListTitleBorder.setTitle(NO_LIST_TITLE);
		noListTitleBorder.setTitleFont(new Font(NO_LIST_TITLE, Font.BOLD, FONT_LIST_TITLE_SIZES));
		noListTitleBorder.setTitleJustification(TitledBorder.CENTER);
		
		noList.setBorder(noListTitleBorder);
		
		TitledBorder maybeListTitleBorder = new TitledBorder(new LineBorder(Color.BLACK, 1));
		maybeListTitleBorder.setTitle(MAYBE_LIST_TITLE);
		maybeListTitleBorder.setTitleFont(new Font(MAYBE_LIST_TITLE, Font.BOLD, FONT_LIST_TITLE_SIZES));
		maybeListTitleBorder.setTitleJustification(TitledBorder.CENTER);
		
		maybeList.setBorder(maybeListTitleBorder);
		
		TitledBorder yesListTitleBorder = new TitledBorder(new LineBorder(Color.BLACK, 1));
		yesListTitleBorder.setTitle(YES_LIST_TITLE);
		yesListTitleBorder.setTitleFont(new Font(YES_LIST_TITLE, Font.BOLD, FONT_LIST_TITLE_SIZES));
		yesListTitleBorder.setTitleJustification(TitledBorder.CENTER);
		
		yesList.setBorder(yesListTitleBorder);
		
		listsPanel.add(noList);
		listsPanel.add(maybeList);
		listsPanel.add(yesList);
		listsPanel.add(new JPanel().add(resetButton));
		listsPanel.add(new JPanel().add(foodButton));
		listsPanel.add(buttonPanel);
		
		setSize((int) width, (int) height);
		add(listsPanel, BorderLayout.SOUTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	}
	/**
	 * Updates noListModel list to display changes
	 * @param list
	 */
	private void editLeftList(ArrayList<Restaurant> list)
	{
		noListModel.clear();
		for (Restaurant r : list)
		{
			noListModel.addElement(r);
		}
	}
	
	public void addFoodButtonListener(ActionListener l)
	{
		foodButton.addActionListener(l);
	}
}
