package Activities;


public class Activity7 {
    public static void main(String[] args) {
        Bicycle myBike = new Bicycle(5, 10);

        System.out.println(myBike.bicycleDesc());
        myBike.speedUp(15);
        myBike.applyBrake(5);
        myBike.speedUp(100); 
    }
}
