import se.walkercrou.places.Place;

public class Restaurant
{
	private String name;
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
	}
	
	public void incPriority(){
		++this.priority;
	}
	
	public void setPriority(int priority){
		this.priority = priority;
	}
	
	public double getPriority(){
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
