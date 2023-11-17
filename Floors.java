import java.util.*;


// get rid of passenger class because its not even doing anything rn 
public class Floors{

	Queue<Passengers> up = new Queue<>();
	Queue<Passengers> down = new Queue<>();

	int currFloor; // current floor 
	int floors; 
	int passengers; 

	public void setCurrFloor(int floor){
		currFloor = floor; 
	}

	int getCurrFloor(){
		reutrn currFloor; // returns current floor number, helps with up or down queue; 
	}

	public void setNumFloors(int totalFloors){
		floors = totalFloors; 
	}

	int getNumFloors(){
		return floors; // returns total number of floors 
	}


	public void generatePassenger(double passenger){
		double max = 1; 
		double min = 0; 
		
		Random r = new Random();
		if (r.nextDouble() < passenger){
			return; // need to fill in this blank 
		}
		else if (r.nextDouble() >= passenger && r.nextDouble() <= max){
			passenger += 1; 
			int nextFloor = r.nextInt(floors); // getting a new floor to go to 
			if (nextFloor > currFloor){
				up.enqueue(nextFloor); 

			}
			else{
				down.enqueue(nextFloor); 
			}

		}


	}
	public void load(){
		// with this you need to know if the elevator is going up or down
	}
	
}