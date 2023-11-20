import java.util.*;
import java.io.*; 


public class ElevatorSimulation{
	public static void main (String[] args) throws Exception{
		/* button that is set to true, until capacity is reached. elevator goes to every 
		floor even if there are no passengers 
		once capacity is reached, we need to unload the passengers and then 
		go to the floors to keep looking for more people 
		*/


		// setting up the properties 
		// these all contain the default properties
		FileReader defaults = new FileReader("defaultProperties.properties");
// creating the objects 
		Properties p = new Properties(); 
		Floors floor = new Floors(); 
		Passengers pass = new Passengers(); 
		Elevators e = new Elevators(); 

// if args is null 
		if (args.length == 0){
			try{
				p.load(defaults);
			 	int floors = Integer.parseInt(p.getProperty("floors"));
			 	double passengers = Double.parseDouble(p.getProperty("passengers"));
			 	
			 	String dataStructure = p.getProperty("structures"); // somehow need to incorporate different strucutre types 
			 	//dataStructure.toLowerCase();
			 	int elevators = Integer.parseInt(p.getProperty("elevators"));
			 	int elevatorCap = Integer.parseInt(p.getProperty("elevatorCapacity"));
			 	int duration = Integer.parseInt(p.getProperty("duration")); 

			 	floor.setNumFloors(floors);
			 	e.setTopFloor(floors);

			 	
			 	e.setDS(dataStructure);

			 	e.setDuration(duration); 
			 	e.setElevators(elevators); 
			 	floor.setCap(elevatorCap); 
			 	e.setCap(elevatorCap);
			 	e.elevatorSim(); 
			 	
			 	e.printResults();
			 } 
			 catch (IOException err){
			 	err.printStackTrace();
			 }

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
// invoking all of the methods 
			 	floor.setNumFloors(floors);
			 	e.setTopFloor(floors);

			 	
			 	e.setDS(dataStructure);

			 	e.setDuration(duration); 
			 	e.setElevators(elevators); 
			 	floor.setCap(elevatorCap); 
			 	e.setCap(elevatorCap);
			 	e.elevatorSim(); 
			 	
			 	e.printResults();
		 	}
		 	catch (IOException err){
		 		err.printStackTrace();
		 	}
		 	
		 	
		 }


		 


	}
}
