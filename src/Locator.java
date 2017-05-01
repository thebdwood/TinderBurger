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
	private Map<String, Place> placesMap = new HashMap<>(60);

	public Locator(){

	}

	/**
	 * Constructor for a Locator with a variable number of String args.
	 * These args should be the keywords to search locations for.
	 * For example, one might search for "burgers" and "tacos"
	 * @param args
	 */
	public Locator(String... args){
		for(String arg : args){
			places = client.getNearbyPlaces(35.2124253,-97.4219124, 6000, GooglePlaces.MAXIMUM_RESULTS,  Param.name("keyword").value(arg));
			for (Place place : places){
//				if (place.getDetails().getRating() > 4.0)			// disabled for considerable run-time improvement
					if (!placesMap.containsKey(place.getName()))
						placesMap.put(place.getName(), place);
			}
		}
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
		for(String arg : yes){
			places = client.getNearbyPlaces(35.2124253,-97.4219124, 6000, GooglePlaces.MAXIMUM_RESULTS,  Param.name("keyword").value(arg));
			for (Place place : places){
//				if (place.getDetails().getRating() > 4.0)			// disable for considerable run-time improvement
					if (!placesMap.containsKey(place.getName()))
						placesMap.put(place.getName(), place);
			}
		}
		for (String arg: no){
			places = client.getNearbyPlaces(35.2124253,-97.4219124, 6000, GooglePlaces.MAXIMUM_RESULTS,  Param.name("keyword").value(arg));
			for (Place place : places){
//				if (place.getDetails().getRating() > 4.0)			// disable for considerable run-time improvement
					if (!placesMap.containsKey(place.getName()))
						placesMap.remove(place.getName());
			}
		}
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
			for (Place place : places){
//				if (place.getDetails().getRating() > 4.0)			// disable for considerable run-time improvement
					if (!placesMap.containsKey(place.getName()))
						placesMap.put(place.getName(), place);
			}
		}

	}
	
	public Map<String, Place> getResults(){
		return placesMap;
	}

}
