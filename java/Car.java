package Activities;

public class Car {
	String Color;
	String Transmission;
	int Make;
	int Tyres;
	int Doors;
	
	Car () {
		Tyres = 4;
		Doors = 4;
		}
	public void displayCharacteristics() {
		System.out.println("The car color is: " + Color);
		System.out.println("The car transmission is: " + Transmission);
		System.out.println("Make: " + Make);
		System.out.println("Tyres: " + Tyres);
		System.out.println("Doors: " + Doors);
		
	}
	public void accelerate() {
		System.out.println("Car is moving forward");
		}
	public void brake() {
		System.out.println("Car has stopped");
		
	}

}
