import java.util.*;

public class Elevators{

	Floors f = new Floors(); 
	Passengers pass = new Passengers(); 
// priority queue sorts in place basically 
	Queue<Integer> up = new PriorityQueue<>();
	Queue<Integer> down = new PriorityQueue<>();

	List<Integer> timeList = new ArrayList<>(); // to track time in duration 


	//List<Passenger> passenger; 
	//List<Floors> floors;  

	boolean elevatorDirection = true; // moving up 

	int capacity = f.getCap(); 
	int floorNum = f.getCurrFloor(); 
	int topFloor = f.getNumFloors(); // gets very last floor 


	int passengers = f.generatePassenger(); 

	int numElevators = 1; // at least one elevator, but that is subject to change 

	int duration;

	public void setDuration(int d){
		duration = d; 
	}

	public void setElevators(int elevators){
		numElevators = elevators; 
	}

	public boolean move(){
		if (elevatorDirection){
			floorNum++; 
			return true;
			// if direction is up, its true
		}else{
			floorNum--; 
			return false; 
		}
	}

// loading in passengers
	// was previosuly in floor function but i needed to move it 
	public void load(){
		Random r = new Random(); 
		if (passengers > 0 && passengers <= capacity){
			int destination = r.nextInt(topFloor) + 1; // getting a number within the range of all the floors 
			if (destination > floorNum && destination <= topFloor){
				up.add(destination); 
			}
			else{
				down.add(destination);
			}
			elevatorDirection = true; 
			

		}
		else if (passengers <= 0){
			f.generatePassenger();
			
		}
		else{
			elevatorDirection = false; // quit moving up, time to move down
			

		}
	}

	public void unload(boolean direction, int floorNum){
		while ((up.isEmpty() == false) && (down.isEmpty() == false)){
			if (floorNum == floorNum && direction == true){
				up.remove(floorNum); 
			}
			else if (floorNum == floorNum && direction == false) {
				down.remove(floorNum); 

			}
		}
	}

// button is true, create elevators
	// really need to fix elevator sim and the logic here 
	// need to make sure the 
	public void elevatorSim(boolean button){
		if (button){
			System.out.println(topFloor);
			System.out.println(floorNum);
			System.out.println(passengers);
			System.out.println(duration);
			for (int i = 0; i < duration; i++){
				f.generatePassenger(); // getting a passenger
				load();
				elevatorDirection = true; 
				move(); 
				if (i == f.getNumFloors()){
					elevatorDirection = false;
					move(); // turning that thing around
					unload(elevatorDirection, floorNum); 

				}
			}

		}
	}

}

