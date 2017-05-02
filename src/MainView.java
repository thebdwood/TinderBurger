import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

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
public class MainView extends JFrame implements ActionListener
{
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
	private DefaultListModel<String> yesListModel;
	/*JScroll panes that display the relative list*/
	private JScrollPane noList;
	private JScrollPane maybeList;
	private JScrollPane yesList;
	private Model model;
	/*User options*/
	private JButton yesButton;
	private JButton noButton;
	private JButton maybeButton;
	private JButton resetButton;
	private JButton foodButton;
	private JButton helpButton;
	ImageIcon helpBtn = new ImageIcon("helpButton.png");
	ImageIcon foodBtnImg = new ImageIcon("foodButton.png");
	private JPanel leftHelpPanel;
	private JPanel displayPanel;
	private JPanel rightHelpPanel;
	private JButton remaining;

	
	public Color mainFrameBackground = Color.decode("#7FDBFF");
	public Color mainButtonBackground = Color.decode("#001f3f");

	private DefaultListModel<String> foodTypes;
	private JScrollPane foodsPane;
	private JLabel food;
	private double width;

	/**
	 * Constructor for MainView. Initializes the JScrollPanes and the DefaultListModels
	 */
	public MainView()
	{	
		
		noListModel = new DefaultListModel<>();
		noList = new JScrollPane(new JList<Restaurant>(noListModel));
		noList.setBackground(mainFrameBackground);
		noList.setForeground(mainButtonBackground);
		
		maybeListModel = new DefaultListModel<>();
		maybeList = new JScrollPane(new JList<Restaurant>(maybeListModel));
		maybeList.setBackground(mainFrameBackground);
		maybeList.setForeground(mainButtonBackground);
		
		yesListModel = new DefaultListModel<>();

		yesList = new JScrollPane(new JList<String>(yesListModel));
		yesList.setBackground(mainFrameBackground);
		yesList.setForeground(mainButtonBackground);

		yesList = new JScrollPane(new JList<String>(yesListModel));

		
		yesButton = new JButton(YES_LIST_TITLE);
		maybeButton = new JButton(MAYBE_LIST_TITLE);
		noButton = new JButton(NO_LIST_TITLE);
		
		resetButton = new JButton("Reset");
		foodButton = new JButton("");
		helpButton = new JButton("");
		helpButton.setIcon(helpBtn); 
		
		leftHelpPanel = new JPanel();
		leftHelpPanel.setBackground(mainFrameBackground);
		leftHelpPanel.setForeground(mainButtonBackground);
		rightHelpPanel = new JPanel();
		rightHelpPanel.setBackground(mainFrameBackground);
		rightHelpPanel.setForeground(mainButtonBackground);
		displayPanel = new JPanel();
		displayPanel.setBackground(mainFrameBackground);
		displayPanel.setForeground(mainButtonBackground);
	
		remaining = new JButton("Remaining: 0");
		
		foodTypes = new DefaultListModel<>();
		foodsPane = new JScrollPane(new JList<String>(foodTypes));
		
		food = new JLabel("", SwingConstants.CENTER);
		
		
	}
	/**
	 * Builds the view when called
	 */
	public void activateView()
	{
		/*Gets the Dimensions of the screen*/
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = Math.round(screenSize.getWidth());
		double height = Math.round(screenSize.getHeight());
		setSize((int) width, (int) height);
		setLayout(new GridBagLayout());
		/*A row for the JFrame*/
		JPanel rowPanel = new JPanel();
		rowPanel.setBackground(mainFrameBackground);
		rowPanel.setForeground(mainButtonBackground);
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

        leftHelpPanel.setBackground(mainFrameBackground);
        displayPanel.setBackground(mainFrameBackground);

        leftHelpPanel.setBackground(Color.BLUE);
        

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
        
        TitledBorder optionsListBorder = new TitledBorder(new LineBorder(Color.BLACK, 1));
		optionsListBorder.setTitle("Remaining Options");
		optionsListBorder.setTitleFont(new Font("Remaining Options", Font.BOLD, FONT_LIST_TITLE_SIZES));
		optionsListBorder.setTitleJustification(TitledBorder.CENTER);
		
		foodsPane.setBorder(optionsListBorder);
		
		int oldx  = counterConstraint.gridx;
        oldx++;
        counterConstraint = new GridBagConstraints();
        counterConstraint.gridy = -1;
        counterConstraint.gridx = oldx;
        counterConstraint.weighty = 1;
        counterConstraint.weightx = 1;
        counterConstraint.fill = GridBagConstraints.BOTH;
        rightHelpPanel.add(foodsPane, counterConstraint);
        
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        displayPanel.setLayout(new GridBagLayout());
       
        food.setFont(new Font("", Font.BOLD, new Double (width * .025).intValue())); 
        displayPanel.add(food, c);
        
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
        rowPanel.setBackground(mainFrameBackground);
		rowPanel.setForeground(mainButtonBackground);
        rowPanel.setLayout(new GridBagLayout());
        /*Constraints to organize last row of buttons*/
        c = new GridBagConstraints();
        c.anchor = GridBagConstraints.SOUTHWEST;
        c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 1;
        c.weighty = 1;
        /*Invisible button for organization*/
        JButton spacer = new JButton();
        spacer.setVisible(false);
        /*Add the reset button with invisible button and the food button*/
        rowPanel.add(resetButton, c);
        rowPanel.add(spacer, c);
		foodButton.setIcon(foodBtnImg);
		foodButton.setBackground(mainFrameBackground);
		foodButton.setOpaque(true);
		foodButton.setBorderPainted(false);
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
	
	private void updateRightList()
	{
		if (yesListModel.isEmpty())
		{
			
		}
		else
		{
			yesListModel.clear();
		}

		for (int i = 0; i < model.getYesList().size(); ++i)
		{
			yesListModel.addElement(model.getYesList().get(i).toString());
		}
		
		//remove and update
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
	
	public void setFoodTypes(DefaultListModel<Ethnicities> foods)
	{
      for (int i = 0; i < foods.size(); ++i)
      {
    	foodTypes.addElement(foods.getElementAt(i).toString());
      }
     
      food.setText(foods.get(0).toString());
	}
	
	public Ethnicities getCurrentEthnicity()
	{
		for (Ethnicities e : Ethnicities.values())
		{
			if (e.toString().equalsIgnoreCase(food.getText()))
			{
				return e;
			}
		}
		
		return null;
	}
	
	public void setModel(Model m)
	{
		model = m;
		model.addListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		updateRightList();
	}
	
}
