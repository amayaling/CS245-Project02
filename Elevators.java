import java.util.*;

public class Elevators{

	Floors floors = new Floors(); 

	Queue<Passenger> passQ = new LinkedList<>(); 


	boolean direction; // true = up, down = false
	int floor = floors.getCurrFloor(); // start floor/current floor 
	int capacity; 
	int duration; // num of ticks. needs to decrement 
	String ds; // data structure 

	int elevators = 1; // subject to change 

	if (floor == floors.getNumFloors()){
		direction = false; 
	}

	public void setElevators(int numElevators){
		elevators = numElevators
	}
	public void setDuration(int d){
		duration = d; 
	}

	public void setDataStructure(String structure){
		ds = structure; 

	}

	public void move(boolean upDown){
		if (upDown == true){
			floor++; 
		}
		else{
			floor--;
		}
	}

	publicvoid addPassenger(){
		// adding to the Q.. hmm .. when I unload ill dequeue 
		Passenger passenger = new Passenger(); 
		passQ.add(passenger.passenger());
	}

	if (ds.toLowerCase(contains("array"))){
		List<Integer> list = new ArrayList<>(); 
	}




}

public class RunElevator{

}