import java.util.*;


// get rid of passenger class because its not even doing anything rn 
public class Floors{
	// need to somehow increment the floors 

	boolean direction = true; // true means up, false is down. need to implement this somehow 

	Passengers p = new Passengers(); 
	
	int startFloor = 1; // but always needs to have more than 1 

	int currFloor; // current floor 
	int floors; // total number of floors 
	int passengers; 
	int destination; // gets a randomly generated floor 

	int capacity; 

	public void setCap(int cap){
		capacity = cap; 
	}

	public int getCap(){
		return capacity; 
	}

	public void setCurrFloor(int floor){
		currFloor = floor; 
	}

	public int getCurrFloor(){
		return currFloor; // returns current floor number, helps with up or down queue; 
	}

	public void setNumFloors(int totalFloors){
		floors = totalFloors; 
	}

	public int getNumFloors(){
		return floors; // returns total number of floors 
	}


	public int generatePassenger(){
		passengers = p.passenger(); // passenger count is being set, will affect the queues 
		
		return passengers; 
		//load(); 
		//System.out.println(passengers);

	}
}