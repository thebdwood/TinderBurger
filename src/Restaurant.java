import se.walkercrou.places.Place;

public class Restaurant
{
	private String name;
	private Place place;
	private double rating;
	private double priority;
	
	public Restaurant()
	{
		
	}
	
	public Restaurant(Place p){
		this(p, 0.0);
	}
	
	public Restaurant(Place p, double priority){
		this.name = p.getName();
		this.priority = priority;
		this.place = p;
	}
}
