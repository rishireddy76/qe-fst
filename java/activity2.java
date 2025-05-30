package Activities;

public class activity2 {
	public static void main(String[] args) {
		int[] n = {10, 77, 10, 54, -11, 10};
		int sumOfTens = 0;
		for (int i : n)  {
            if (i == 10) {
                sumOfTens = sumOfTens +  i;
            }
        }
        boolean isSum30 = (sumOfTens == 30);
        
        
        System.out.println("Sum of all 10's in the array: " + sumOfTens);
        System.out.println("Is the sum of all 10's equal to 30: " + isSum30);

	}
	

}
