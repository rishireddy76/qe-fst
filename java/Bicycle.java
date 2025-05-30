package Activities;

public class Bicycle implements BicycleParts, BicycleOperations {
    private int gears;
    private int currentSpeed;

    public Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }

    
    public void applyBrake(int decrement) {
        currentSpeed -= decrement;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println("Speed after brake: " + currentSpeed);
    }

   
    public void speedUp(int increment) {
        currentSpeed += increment;
        if (currentSpeed > maxSpeed) currentSpeed = maxSpeed;
        System.out.println("Speed after acceleration: " + currentSpeed);
    }

    public String bicycleDesc() {
        return "No of gears are: " + gears + "\nSpeed of bicycle is: " + maxSpeed;
    }
}
