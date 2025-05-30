package Activities;
import java.util.Date;
import java.util.List;

public class Activity6 {
	 public static void main(String[] args) throws InterruptedException {
	     
	        plane plane = new plane(10);
	        
	        plane.onboard("Rishi");
	        plane.onboard("Deepthi");
	        plane.onboard("Prabhas");
	        
	        System.out.println("Plane took off at: " + plane.takeOff());
	        
	        System.out.println("People on the plane: " + plane.getPassengers());
	        
	        Thread.sleep(5000);
	        
	        plane.land();
	        
	        System.out.println("Plane landed at: " + plane.getLastTimeLanded());
	        System.out.println("People on the plane after landing: " + plane.getPassengers());
	    }
	}
	