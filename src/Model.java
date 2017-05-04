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
	private DefaultListModel<Ethnicities> noList;
	private DefaultListModel<Ethnicities> maybeList;
	private DefaultListModel<String> results;
	private ArrayList<ActionListener> listeners;
	
	public Model()
	{
		choices = new DefaultListModel<>();
		yesList = new DefaultListModel<>();
		noList = new DefaultListModel<>();
		maybeList = new DefaultListModel<>();
		results = new DefaultListModel<>();
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
	
	public void addToNoList(Ethnicities e)
	{
		noList.addElement(e);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Add to nolist"));
	}
	
	public void addToMaybeList(Ethnicities e)
	{
		maybeList.addElement(e);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Add to maybelist"));
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
	
	public DefaultListModel<Ethnicities> getNoList()
	{
		return noList;
	}
	
	public DefaultListModel<Ethnicities> getMaybeList()
	{
		return maybeList;
	}
	
	public void setResultsList(DefaultListModel<String> lm){
		this.results = lm;
	}
	
	public void addToResultsList(String string){
		this.results.addElement(string);
	}
	
	public DefaultListModel<String> getResults(){
		return this.results;
	}
}
