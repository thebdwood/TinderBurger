import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.*;
public class Model 
{
	private DefaultListModel<Ethnicities> choices;
	private DefaultListModel<Ethnicities> yesList;
	private ArrayList<ActionListener> listeners;
	
	public Model()
	{
		choices = new DefaultListModel<>();
		yesList = new DefaultListModel<>();
		listeners = new ArrayList<>();
	}
	
	public DefaultListModel<Ethnicities> getChoices()
	{
		createChoices();
		return choices;
	}
	
	private void createChoices()
	{
		ArrayList<Ethnicities> temp = new ArrayList<Ethnicities>();
		for (Ethnicities e : Ethnicities.values())
		{
			temp.add(e);
		}
		
		Collections.sort(temp, (p1, p2) -> p1.toString().compareTo(p2.toString()));
		
		for (Ethnicities e : temp)
		{
			choices.addElement(e);
		}
	}
	
	public void addToYesList(Ethnicities e)
	{
		yesList.addElement(e);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Add to yeslist"));
	}
	
	public void addListener(ActionListener l) 
	{
		listeners.add(l);
	}
	
	private void processEvent(ActionEvent e)
	{
		for (ActionListener l : listeners)
		{
			l.actionPerformed(e);
		}
	}
	
	public DefaultListModel<Ethnicities> getYesList()
	{
		return yesList;
	}
}
