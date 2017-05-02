import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PlacesView extends JFrame{	
	private JFrame baseFrame;
	private JPanel backBtnPanel;
	private JPanel placesPanel;
	private JButton backBtn;
	private JScrollPane placesPane;
	private DefaultListModel<String> placesModel;
	private JList placesList;

	public PlacesView(){
		this(new DefaultListModel<String>());
	}
	
	public PlacesView(DefaultListModel<String> lm){
		this.setTitle("Restaurants");
		//used for filling the scroll pane for testing
		placesModel = lm;
		placesList = new JList<String>(placesModel);
		backBtnPanel = new JPanel();
		placesPanel = new JPanel();
		backBtn = new JButton("Back");
	}
	
	public void setListModel(DefaultListModel<String> lm){
		this.placesModel = lm;
	}

	public void activatePlacesView(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = Math.round(screenSize.getWidth());
		double height = Math.round(screenSize.getHeight());
		JLabel title = new JLabel("Recommendations");
		title.setFont(new Font("", Font.BOLD, 30));
		backBtn.setToolTipText("Back to selection screen");
		
		placesList.setFixedCellHeight(56);
		placesList.setCellRenderer(new BigFontListCellRenderer());
		
		placesPane = new JScrollPane(placesList);
//		TitledBorder optionsListBorder = new TitledBorder(new LineBorder(Color.BLACK, 1));
//		optionsListBorder.setTitle("Recommendations");
//		optionsListBorder.setTitleFont(new Font("", Font.BOLD, 24));
//		optionsListBorder.setTitleJustification(TitledBorder.CENTER);
//		placesPane.setBorder(optionsListBorder);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(10,19,10,0);
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		//gbc.anchor = gbc.NORTHWEST;
		add(backBtn, gbc);
		
		gbc.insets = new Insets(10,0,10,10);
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = gbc.CENTER;
		add(title, gbc);
		
		gbc.insets = new Insets(0,19,20,0);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = gbc.BOTH;
		add(placesPane, gbc);
		
		//used for filling the scroll pane for testing
		int i = 0;
		while (++i < 20){
			placesModel.addElement(i + ": TSESSADSsdghdfgfgkghjl");
		}

		setSize((int) width, (int) height);
		add(backBtnPanel);
		add(placesPanel);
		setVisible(true);
	}
	
	public class BigFontListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            setFont(new Font("Verdana", Font.PLAIN, 20));
            setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.BLACK));
            return this;
        }

    }
}
