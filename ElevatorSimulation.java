import java.util.*;
import java.io.*; 

// global vars
// String dataStrcuture = "linked" // could change to array

// int floors = 32; // default
// double passengers = 0.03 // default
// int elevators = 1; // default 
// int elevatorCap = 10; // default capacity 
// int duration = 500; // default 
// int maxElevator = 2; // this is personal and easier to handle 

public class ElevatorSimulation{
	public static void main (String[] args) throws Exception{
		/* button that is set to true, until capacity is reached. elevator goes to every 
		floor even if there are no passengers 
		once capacity is reached, we need to unload the passengers and then 
		go to the floors to keep looking for more people 
		*/


		boolean button = true; // means button is pressed, set to false when people want to get off 

		// setting up the properties 
		// these all contain the default properties
		FileReader defaults = new FileReader("defaultProperties.properties");

		 Properties p = new Properties(); 
		 Floors f = new Floors(); 
		 Passengers pr = new Passengers(); 

// if args is null 
		 if (args.length == 0){
		 	p.load(defaults);
		 	int floors = Integer.parseInt(p.getProperty("floors"));
		 	double passengers = Double.parseDouble(p.getProperty("passengers"));
		 	
		 	String dataStructure = p.getProperty("structure"); // somehow need to incorporate different strucutre types 
		 	int elevators = Integer.parseInt(p.getProperty("elevators"));
		 	int elevatorCap = Integer.parseInt(p.getProperty("elevatorCapacity"));
		 	int duration = Integer.parseInt(p.getProperty("duration")); 

		 	pr.setPassengerProb(passengers);
		 	System.out.println(pr.passenger());
		 	f.generatePassenger(); 


		 }
		 else{
		 	try (FileReader props = new FileReader(args[0])){
			 	p.load(props);
			 	int floors = Integer.parseInt(p.getProperty("floors"));
			 	double passengers = Double.parseDouble(p.getProperty("passengers"));
			 	String dataStructure = p.getProperty("structure");
			 	int elevators = Integer.parseInt(p.getProperty("elevators"));
			 	int elevatorCap = Integer.parseInt(p.getProperty("elevatorCapacity"));
			 	int duration = Integer.parseInt(p.getProperty("duration")); 
			 	
		 	}
		 	catch (IOException e){
		 		e.printStackTrace();
		 	}
		 	
		 	
		 }


		 


	}
}
