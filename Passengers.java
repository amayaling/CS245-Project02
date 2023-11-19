import java.util.*; 

public class Passengers{

	boolean direction = true; // true = up, false = down
	int passengerCount = 0; 

	double passenger = 0; 



	public void setPassengerProb(double passengerProb){
		passenger = passengerProb; 

	}

	public double getPassengerProb(){
		return passenger; 
	}

	public int passenger(){
		// returns a person/floor number that we put in a queue 
	
		Random r = new Random(); // generating a random double in between the max
		// nextDouble gives a number between 0 & 1 anyway  
		double rand = r.nextDouble(); 
		//System.out.println(rand);
		if (rand <= passenger){
			passengerCount += 1; // need to get the floor number or something
			// passenger count goes up because its in the expected range 
			//return passengerCount; // passes into the floor class to help with generating a random floor and then adding to the queue 
		}
		
		return passengerCount; // if its higher, return 0




	}
}