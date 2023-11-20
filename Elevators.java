import java.util.*;

public class Elevators{

	Floors f = new Floors(); 
	Passengers pass = new Passengers(); 

	List<Integer> timeList;  // to track time in duration 
	

	boolean moveUp = true; // moving up 

	
	int currFloor = 1; // start floor 
	int topFloor;  // gets very last floor 
	int capacity; 

	String dataStructure;


	int numElevators = 1; // at least one elevator, but that is subject to change 

	int duration;


	public void setDuration(int d){
		duration = d; 
	}
// getting the very top floor
	public void setTopFloor(int fl){
		topFloor = fl;
	}

	public int getTopFloor(){
		return topFloor;
	}

	public void setCap(int cap){
		capacity = cap;
	}

	public void setDS(String structure){
		// changes the data structure 
		if (structure.contains("array")){
			timeList = new ArrayList<>(); 
		}
		else{
			timeList = new LinkedList<>(); 
		}
	}
	
// couldnt figure out the multiple elevators 
	 public void setElevators(int elevators){
	 	numElevators = elevators; 
	 }

// moves the elevator up or down
	public void move(){
		if (moveUp){
			currFloor++; 
			// if direction is up, its true
		}else if (!moveUp) {
			currFloor--; 
			
		}
	}

	public void unload(boolean direction, int floorNum){
		while ((f.upQueue().isEmpty() == false) && (f.downQueue().isEmpty() == false)){
			if (currFloor == floorNum && f.load() == true){
				f.upQueue().remove(floorNum); 
			}
			else if (currFloor == floorNum && f.load() == false) {
				f.downQueue().remove(floorNum); 


			}
		}
	}

// button is true, create elevators
	// really need to fix elevator sim and the logic here 
	// need to make sure the 
	public void elevatorSim() {
    for (int i = 0; i < duration; i++) {
        f.generatePassenger();
        f.load();
        timeList.add(duration);
        if (moveUp) {
            move();
            if (currFloor == topFloor) {
                moveUp = false;
                unload(moveUp, currFloor);
                timeList.add(i);
            }
        } else if (!f.load()){
        	moveUp = false; 
        	move();
        }
        else {
            move();
            if (currFloor == 1) {
                moveUp = true;
                unload(moveUp, currFloor);
                timeList.add(i);
            }
        }
    }
}


	public void printResults(){
		// prints results of the elevator simulation 
		int maxTemp = timeList.get(0);
		for (int k = 1 ; k < timeList.size(); k++){
			if (timeList.get(k) > maxTemp){
				maxTemp = timeList.get(k);
			}
		}
		System.out.println("Longest time: " + maxTemp); 

		int minTemp = timeList.get(0);
		for (int j = 1; j < timeList.size(); j++){
			if (timeList.get(j) < minTemp){
				minTemp = timeList.get(j);
			}
		}
		System.out.println("Shortest time: " + minTemp); 

		int sum = 0;
		for (int h = 0; h < timeList.size(); h++){
			sum += timeList.get(h);
		}
		System.out.println("Average time: " + sum/timeList.size());

		
	}

}

