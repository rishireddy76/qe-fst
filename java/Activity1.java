package Activities;

public class Activity1 {
	public static void main(String[] args) {
	Car carName = new Car();
	carName.Make = 2014;
    carName.Color = "Black";
    carName.Transmission = "Manual";
    
    
    carName.displayCharacteristics();
    carName.accelerate();
    carName.brake();

    }
}
