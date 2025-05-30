package Activities;

public class TestCustomException {

    
    public static void exceptionTest(String input) throws CustomException {
        if (input == null) {
            throw new CustomException("Input string is null!");
        } else {
            System.out.println(input);
        }
    }

    
    public static void main(String[] args) {
        try {
            exceptionTest("Will print to console");
            exceptionTest(null); 
        } catch (CustomException e) {
            
            System.out.println("Caught CustomException: " + e.getMessage());
        }
    }
}
