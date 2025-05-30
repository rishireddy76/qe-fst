package Activities;

public class MountainBike extends Bicycle {
     int seatHeight;

    public MountainBike(int gears, int currentSpeed, int seatHeight) {
        super(gears, currentSpeed); 
        this.seatHeight = seatHeight;
    }

    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    
   
    public String bicycleDesc() {
        return super.bicycleDesc() + "\nSeat height is " + seatHeight;
    }
}
