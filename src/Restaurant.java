import java.util.ArrayList;
import java.util.List;

import se.walkercrou.places.Place;

public class Restaurant
{
	private String name;
	private List<Ethnicities> foods;
	private List<String> keywords;
	private Place place;
	private double rating;
	private int priority;
	
	public Restaurant(){
	}
	
	public Restaurant(Place p){
		this(p, 0);
	}
	
	public Restaurant(Place p, int priority){
		this.name = p.getName();
		this.place = p;
		this.priority = priority;
		this.foods = new ArrayList<>(3);
		this.keywords = new ArrayList<>(3);
	}
	
	public void addKeyword(String keyword){
		this.keywords.add(keyword);
	}
	
	public void setKeywords(List<String> keywords){
		this.keywords = keywords;
	}
	
	public List<String> getKeywords(){
		return this.keywords;
	}
	
	public void incPriority(){
		++this.priority;
	}
	
	public void setPriority(int priority){
		this.priority = priority;
	}
	
	public int getPriority(){
		return this.priority;
	}
	
	public double getRating(){
		return this.rating;
	}
	
	public Place getPlace(){
		return this.place;
	}
	
	public String getName(){
		return this.name;
	}
	
	/**
	 * Returns the name of the Restaurant
	 */
	public String toString(){
		return this.name;
	}
}
