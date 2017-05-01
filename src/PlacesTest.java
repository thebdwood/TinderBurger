import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import se.walkercrou.places.*;


public class PlacesTest {
	private static final String API_KEY = "AIzaSyDjSIBUt0_d15vAulaS8eGHNdAOUaBY2k0";

	public PlacesTest (){
	}

	/**
	 * Example method with a variable number of String arguments.
	 * More information about varargs can be found at:
	 * http://docs.oracle.com/javase/1.5.0/docs/guide/language/varargs.html
	 * @param option, args
	 */
	private void foo(int option, String... args) {
		for (String arg : args) {
			System.out.println(arg);
		}
	}

	public static void main(String[] args){
		String[] yesList = {"burgers", "tacos"};
		String[] noList = {"noodles"};
		Locator l = new Locator(yesList,noList);
		Map<String,Place> placesMap = l.getResults();
		int i = 0;
		for (String s : placesMap.keySet()){
			System.out.println(++i + ": " + s);
		}
		
//		GooglePlaces client = new GooglePlaces(API_KEY);
//		List<Place> places = new ArrayList<>(new ArrayList<Place>(client.getNearbyPlaces(35.2124253,-97.4219124, 6000, GooglePlaces.MAXIMUM_RESULTS,  Param.name("keyword").value("tacos"))));
//		Map<String, Place> placesMap = new LinkedHashMap<>(places.size());
//		int i = 0;
//		for (Place place : places){
//				if (place.getDetails().getRating() > 4.0)
//					if (!placesMap.containsKey(place.getName()))
//						placesMap.put(place.getName(), place);
//		}
//		i = 0;
//		for (String s : placesMap.keySet()){
//			if (i < (placesMap.size() / 3 + 1))
//				System.out.println(++i + ": " + s);
//		}
//		
//		for (Place p : placesMap.values()){
//			
//		}
//		
//		for (Map.Entry<String, Place> entry : placesMap.entrySet()){
//			
//		}
//		// place.getDetails() takes additional time
//		System.out.println(places.size() + " results were found.");
//		System.out.println(places.get(0).getDetails().getRating());
//		
//		for (Place place : places) {
//			if (i < 20) {
//				if (place.getDetails(Param.name("rating")) != null)
//					if (place.getDetails().getRating() > 2.9){
//						System.out.println(place.getDetails().getRating());
//						System.out.println(++i + ": " + place.getName());
//					}
//			}
//		}
	}
}
