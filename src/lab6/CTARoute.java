package lab6;

import lab5.*; //used CTAStation from previous lab
import java.util.ArrayList;

public class CTARoute {

	private String name;
	private ArrayList<CTAStation> stops;
	
	//constructors
	public CTARoute() { //default
		name = "default";
		stops = new ArrayList<CTAStation>();
	}
	public CTARoute(String name) {
		this.name = name;
		stops = new ArrayList<CTAStation>();
	}
	
	//getters
	public String getName() {
		return name;
	}
	public ArrayList<CTAStation> getStops() {
		return stops;
	}
	
	public String toString() {
		String list = "";
		for (CTAStation station: stops) {
			list += station.toString() + "\n";
			list += "---------------------------------------------------\n";
		}
		return list;
	}
	
	//list methods of stops ArrayList
	public void addStation(CTAStation adding) {
		stops.add(adding);
	}
	public void removeStation(CTAStation removing) {
		stops.remove(removing);
	}
	public void insertStation(int indx, CTAStation adding) {
		stops.add(indx,  adding);
	}
	public void sort(String lineColor) {
		int count = 0;
		while (count < stops.size()-1) {
			int sortVal = -1, sortVal2 = -1;
			switch(lineColor) {
			case "green":
				sortVal = stops.get(count).getGreenIdx();
				sortVal2 = stops.get(count+1).getGreenIdx();
				break;
			case "red":
				System.out.println("yes");
				sortVal = stops.get(count).getRedIdx();
				sortVal2 = stops.get(count+1).getRedIdx();
				break;
			}
			if (sortVal > sortVal2) {
				
				for (int i = stops.size()-1; i >= 0; i--) {
					switch(lineColor) {
					case "green":
						sortVal2 = stops.get(i).getGreenIdx();
						break;
					case "red":
						sortVal2 = stops.get(i).getRedIdx();
						break;
					}
					if (sortVal > sortVal2) {
						stops.add(i, stops.remove(count));
						count = 0;
						break;
					}
				}
			} else {
				count += 1;
			}
		}
	}
	public CTAStation lookupStation(String looking) { //returns first instance of CTAStation matching the inputed name parameter
		CTAStation match = null;
		for (CTAStation station: stops) {
			if (station.getName().toLowerCase().equals(looking.toLowerCase())) {
				match = station;
				break;
			}
		}
		return match; //null is checked before this method is called
			
	}
	public CTAStation nearestStation(double lat, double lon) { //returns nearest distance to location parameter in stops arraylist
		CTAStation nearest = stops.get(0);
		for (int i = 1; i < stops.size(); i++) {
			if (stops.get(i).calcDistance(lat, lon) < nearest.calcDistance(lat, lon)) { //not sure what the threshold for nearby distance is
				nearest = stops.get(i);
			}
		}
		return nearest;
	}
	public CTAStation nearestStation(GeoLocation loc) { //same as above method with different parameters
		CTAStation nearest = stops.get(0);
		for (int i = 1; i < stops.size(); i++) {
			if (stops.get(i).calcDistance(loc) < nearest.calcDistance(loc)) { //not sure what the threshold for nearby distance is
				nearest = stops.get(i);
			}
		}
		return nearest;
	}

}
