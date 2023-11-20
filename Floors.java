import java.util.*;


// get rid of passenger class because its not even doing anything rn 
public class Floors{
	// need to somehow increment the floors 

	boolean direction = true; // true means up, false is down. need to implement this somehow 

	Passengers p = new Passengers(); 
// priority queues bc it removes in a specific order 
	Queue<Integer> up = new PriorityQueue<>();
	Queue<Integer> down = new PriorityQueue<>();

	

	int currFloor = 1; // current floor , subject to change 
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


	public int getCurrFloor(){
		return currFloor; // returns current floor number, helps with up or down queue; 
	}

	public void setNumFloors(int totalFloors){
		floors = totalFloors; 

	}

	public int getNumFloors(){
		return floors; // returns total number of floors 
	}


	public void generatePassenger(){
		passengers = p.passenger(); // passenger count is being set, will affect the queues 
		if (passengers > 0){
			load(); 
		}

	}
	public Queue<Integer> upQueue(){
		return up; // for the unload function in elevator class
	}

	public Queue<Integer> downQueue(){
		return down;
	}
	
	public boolean load(){
		Random r = new Random(); // for random floor 
		// cant be above 
		if (passengers > 0 && passengers <= capacity){
			int destination = r.nextInt(floors) + 1; // getting a number within the range of all the floors 
			if (destination > currFloor && destination <= floors){
				up.add(destination); 
			}
			else{
				down.add(destination);
			}
			direction = true; 

		}
		else if (passengers <= 0){
			generatePassenger();
			
		}
		else{
			e.elevatorSim(capacity);
			// need to start unloading, will call the move function in elevator class
			direction = false; // quit moving up, time to move down
			

		}
		return direction; 
	}

	
}