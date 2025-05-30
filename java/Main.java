package Activities;

public class Main {
	public static void main(String[] args) {
        
        String title = "The Great Gatsby";
        MyBook newNovel = new MyBook();
        newNovel.setTitle(title);
        System.out.println("The title is: " + newNovel.getTitle());
    }
}


