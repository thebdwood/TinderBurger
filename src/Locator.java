import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import se.walkercrou.places.GooglePlaces;
import se.walkercrou.places.Param;
import se.walkercrou.places.Place;

public class Locator {
	private static final String API_KEY = "AIzaSyDjSIBUt0_d15vAulaS8eGHNdAOUaBY2k0";
	private static final GooglePlaces client = new GooglePlaces(API_KEY);
	private List<Place> places = new ArrayList<>(60);
	private Map<String, Restaurant> placesMap = new HashMap<>(60);

	public Locator(){

	}

	/**
	 * Constructor for a Locator with a variable number of String args.
	 * These args should be the keywords to search locations for.
	 * They may also be passed as an array of Strings.
	 * For example, one might search for "burgers" and "tacos"
	 * @param args
	 */
	public Locator(String... args){
		this(args,new String[] {""});
	}

	/**
	 * Constructor for a Locator taking two String arrays: yes and no,
	 * which should represent the types of food corresponding to those selections.
	 * These args should be the keywords used for searching locations.
	 * For example, the "yes" array might be {"burgers", "tacos"}
	 * while the "no" array might be {"noodles"}
	 * @param yes	String array of food type keywords
	 * @param no	String array of food type keywords
	 */
	public Locator(String[] yes, String[] no){
		this(yes, new String[]{""}, no);
	}

	/**
	 * Constructor for a Locator taking three String arrays: yes, maybe and no,
	 * which should represent the types of food corresponding to those selections.
	 * These args should be the keywords used for searching locations.
	 * For example, the "yes" array might be {"burgers", "tacos"}
	 * while the "no" array might be {"noodles"}
	 * @param yes	String array of food type keywords
	 * @param maybe	String array of food type keywords
	 * @param no	String array of food type keywords
	 */
	public Locator(String[] yes, String[] maybe, String[] no){
		for(String arg : yes){
			places = client.getNearbyPlaces(35.2124253,-97.4219124, 6000, GooglePlaces.MAXIMUM_RESULTS,  Param.name("keyword").value(arg));
			
			for (int i = 0; i < (places.size()/3) + 1; ++i){
				if (!placesMap.containsKey(places.get(i).getName())){
					placesMap.put(places.get(i).getName(), new Restaurant(places.get(i)));
					placesMap.get(places.get(i).getName()).addKeyword(arg);
				}
			}
		
		}
		
		for (String arg: maybe){
			places = client.getNearbyPlaces(35.2124253,-97.4219124, 6000, GooglePlaces.MAXIMUM_RESULTS,  Param.name("keyword").value(arg));
			for (int i = 0; i < (places.size()/3) + 1; ++i){
				if (!placesMap.containsKey(places.get(i).getName())){
					placesMap.put(places.get(i).getName(), new Restaurant(places.get(i)));
					placesMap.get(places.get(i).getName()).addKeyword(arg);
				}
			}
		}
		
		for (String arg: no){
			places = client.getNearbyPlaces(35.2124253,-97.4219124, 6000, GooglePlaces.MAXIMUM_RESULTS,  Param.name("keyword").value(arg));
			for (Place place : places){
				if (placesMap.containsKey(place.getName()))
					placesMap.remove(place.getName());
			}
		}
	}

	public Map<String, Restaurant> getResults(){
		return placesMap;
	}

}