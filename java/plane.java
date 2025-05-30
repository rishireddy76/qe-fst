package Activities;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class plane {
	private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOff;
    private Date lastTimeLanded; 
    

public plane(int maxPassengers) {
    this.maxPassengers = maxPassengers;
    this.passengers = new ArrayList<>();

}
public boolean onboard(String passengerName) {
    if (passengers.size() < maxPassengers) {
        passengers.add(passengerName);
        System.out.println(passengerName + " onboarded.");
        return true;
    } else {
        System.out.println("Plane is full. Cannot onboard " + passengerName);
        return false;
    }
}

public Date takeOff() {
    this.lastTimeTookOff = new Date(); 
    System.out.println("Plane took off at: " + lastTimeTookOff);
    return lastTimeTookOff;
}
public Date land() {
    this.lastTimeLanded = new Date(); 
    this.passengers.clear(); 
    System.out.println("Plane landed at: " + lastTimeLanded);
    System.out.println("Passengers disembarked.");
    return lastTimeLanded;
}

public Date getLastTimeLanded() {
    return lastTimeLanded;
}
public List<String> getPassengers() {
    return new ArrayList<>(passengers); 
}
public Date getLastTimeTookOff() {
    return lastTimeTookOff;
}
public int getMaxPassengers() {
    return maxPassengers;
}
}
