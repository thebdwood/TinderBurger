import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
/**
 * The main view for the user interface. Allows drag and drop features and displays changes to user.
 * @author amorr
 * @author thebdwood
 * thebdwood: only graphic and color adjustment. Majority of code contribution from amorr.
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
	private JButton yesButton;
	private JButton noButton;
	private JButton maybeButton;
	private JButton resetButton;
	private JButton foodButton;
	private JButton helpButton;
	private JPanel leftHelpPanel;
	private JPanel displayPanel;
	private JPanel rightHelpPanel;
	private JButton remaining;
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
		
		yesButton = new JButton(YES_LIST_TITLE);
		maybeButton = new JButton(MAYBE_LIST_TITLE);
		noButton = new JButton(NO_LIST_TITLE);
		
		resetButton = new JButton("Reset");
		foodButton = new JButton("Find me food");
		helpButton = new JButton("Help");
		
		leftHelpPanel = new JPanel();
		rightHelpPanel = new JPanel();
		displayPanel = new JPanel();
	
		remaining = new JButton("Remaining: 0");
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
		setSize((int) width, (int) height);
		setLayout(new GridBagLayout());
		/*A row for the JFrame*/
		JPanel rowPanel = new JPanel();
		/*GridBag constraints to organize the rows of the frame*/
		GridBagConstraints rowConstraints = new GridBagConstraints();
		rowConstraints.insets = new Insets(4, 4, 4, 4);
		rowConstraints.gridx = 0;
		rowConstraints.weightx = 1;
		rowConstraints.weighty = 1;
        rowConstraints.gridy = 0;
        rowConstraints.fill = GridBagConstraints.BOTH;
        rowConstraints.anchor = GridBagConstraints.NORTH;
        /*Constraints for the panels that will hold the choices and help info*/
        GridBagConstraints panelConstraints = new GridBagConstraints();
        panelConstraints.fill = GridBagConstraints.BOTH;
        panelConstraints.weighty = 1;
        //TODO: temp colors. Delete when done
        leftHelpPanel.setBackground(Color.BLUE);
        displayPanel.setBackground(Color.CYAN);
        /*Set size of button, text, and gives appearance of label*/
        remaining.setFont(new Font("", Font.BOLD, new Double(width * .025).intValue()));
        remaining.setPreferredSize(new Dimension(new Double(width*.05).intValue(),new Double(height*.05).intValue()));
        remaining.setFocusable(false);
        remaining.setBorder(null);
        remaining.setEnabled(false);
        /*New GridBagLayout*/
        rightHelpPanel.setLayout(new GridBagLayout());
        /*Constraints for right help panel*/
        GridBagConstraints counterConstraint = new GridBagConstraints();
        counterConstraint.anchor = GridBagConstraints.NORTHWEST;
        counterConstraint.weightx = 1;
        counterConstraint.weighty = 1;
        counterConstraint.fill = GridBagConstraints.HORIZONTAL;
        /*Adds remaining to panel*/
        rightHelpPanel.add(remaining, counterConstraint);
        /*Creates a GridBagLayout for the first row panel*/
        rowPanel.setLayout(new GridBagLayout());
        /*Adds the panels for choices and help info*/
        rowPanel.add(leftHelpPanel, panelConstraints);
        rowPanel.add(displayPanel, panelConstraints);
        rowPanel.add(rightHelpPanel, panelConstraints);
        /*Sets the buttons titles*/
        noButton.setFont(new Font(NO_LIST_TITLE, Font.BOLD, new Double(width*.025).intValue()));
        maybeButton.setFont(new Font(MAYBE_LIST_TITLE, Font.BOLD, new Double(width*.025).intValue()));
        yesButton.setFont(new Font(YES_LIST_TITLE, Font.BOLD, new Double(width*.025).intValue()));
        /*Constraints to organize the no button*/
        GridBagConstraints optionButtonConstraints = new GridBagConstraints();
        optionButtonConstraints.fill = GridBagConstraints.BOTH;
        optionButtonConstraints.weightx = 1;
        optionButtonConstraints.gridx = 0;
        optionButtonConstraints.insets = new Insets(1,1,1,1);
        optionButtonConstraints.gridy = -1;
        /*Makes sure that the no button is the same size as the yes button. The yes button is the widest button based on the text we have on it*/
        optionButtonConstraints.ipadx = new Double(yesButton.getPreferredSize().getWidth()- noButton.getPreferredSize().getWidth()).intValue();  //fix hard coding if time allows
        /*Adds no button with constraints*/
        rowPanel.add(noButton, optionButtonConstraints);
        optionButtonConstraints.gridx ++;
        int currentx = optionButtonConstraints.gridx;
        /*Constraints for maybe button*/
        optionButtonConstraints = new GridBagConstraints();
        optionButtonConstraints.fill = GridBagConstraints.BOTH;
        optionButtonConstraints.weightx = 1;
        optionButtonConstraints.gridx = currentx;
        optionButtonConstraints.insets = new Insets(1,1,1,1);
        /*Ensures that maybe is the same width and height as other buttons*/
        optionButtonConstraints.ipadx = new Double(yesButton.getPreferredSize().getWidth()- maybeButton.getPreferredSize().getWidth()).intValue();  //fix hard coding if time allows
        optionButtonConstraints.ipady = new Double(noButton.getPreferredSize().getHeight()- maybeButton.getPreferredSize().getHeight()).intValue();  //fix hard coding if time allows
        /*Adds maybe button with given constraints*/
        rowPanel.add(maybeButton, optionButtonConstraints);
        optionButtonConstraints.gridx ++;
        currentx = optionButtonConstraints.gridx;
        /*Constraints for yes button*/
        optionButtonConstraints = new GridBagConstraints();
        optionButtonConstraints.fill = GridBagConstraints.BOTH;
        optionButtonConstraints.weightx = 1;
        optionButtonConstraints.gridx = currentx;
        optionButtonConstraints.insets = new Insets(1,1,1,1);
        /*Ensures button is the same height as the others*/
        optionButtonConstraints.ipady = new Double(noButton.getPreferredSize().getHeight()- yesButton.getPreferredSize().getHeight()).intValue();  //fix hard coding if time allows
        /*Adds the yes button with constraints*/
        rowPanel.add(yesButton, optionButtonConstraints);
        /*Adds rowPanel to the frame*/
        add(rowPanel, rowConstraints);
        rowConstraints.gridy++;
        /*New row panel needed for next row*/
        rowPanel = new JPanel();
        /*Constraints for the lists*/
        GridBagConstraints listConstraints = new GridBagConstraints();
        listConstraints.fill = GridBagConstraints.BOTH;
        listConstraints.weightx = 1;
        listConstraints.weighty = 1;
        /*Set row layout to GridBagLayout*/
        rowPanel.setLayout(new GridBagLayout());
        /*Create the lists borders*/
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
		/*Add lists to panel*/
		rowPanel.add(noList, listConstraints);
		rowPanel.add(maybeList, listConstraints);
		rowPanel.add(yesList, listConstraints);
		/*Adds row to the frame*/
        add(rowPanel, rowConstraints);
        rowConstraints.gridy++;
        /*New row needed*/
        rowPanel = new JPanel();
        /*Set row layout to GridBag*/
        rowPanel.setLayout(new GridBagLayout());
        /*Constraints to organize last row of buttons*/
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.SOUTHWEST;
        c.weightx = 1;
        c.weighty = 1;
        /*Invisible button for organization*/
        JButton spacer = new JButton();
        spacer.setVisible(false);
        /*Add the reset button with invisible button and the food button*/
        rowPanel.add(resetButton, c);
        rowPanel.add(spacer, c);
        rowPanel.add(foodButton, c);
        /*New constraints are needed to place help button in the correct spot*/
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.SOUTHWEST;
        rowPanel.add(helpButton, c);
        /*Adjusted constraints for the final row*/
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.SOUTH;
        c.gridy = rowConstraints.gridy;
        /*Adds the row with the updated constraints*/
        add(rowPanel, c);

		setVisible(true);
		setLocationRelativeTo(null);
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

	/**
	 * Add action listener for foodButton
	 * @param l
	 */
	public void addFoodButtonListener(ActionListener l)
	{
		foodButton.addActionListener(l);
	}
	/**
	 * Add action listener for yesButton
	 * @param l
	 */
	public void addYesButtonListener(ActionListener l)
	{
		yesButton.addActionListener(l);
	}
	/**
	 * Add action listener for noButton
	 * @param l
	 */
	public void addNoButtonListener(ActionListener l)
	{
		noButton.addActionListener(l);
	}
	/**
	 * Add action listener for maybeButton
	 * @param l
	 */
	public void addMaybeButtonListener(ActionListener l)
	{
		maybeButton.addActionListener(l);
	}
	/**
	 * Add action listener for resetButton
	 * @param l
	 */
	public void addResetButtonListener(ActionListener l)
	{
		resetButton.addActionListener(l);
	}
	/**
	 * Add action listener for helpButton
	 * @param l
	 */
	public void addHelpButtonListener(ActionListener l)
	{
		helpButton.addActionListener(l);
	}
}
