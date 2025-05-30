package Activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        
        ArrayList<String> myList = new ArrayList<String>();
        
        
        myList.add("Rishi");
        myList.add("Deepthi");
        myList.add("Sailu");
        myList.add("Karthik");
        myList.add("Abhiram");
        
        
        System.out.println("All names in the list:");
        for(String name : myList) {
            System.out.println(name);
        }
        
        
        String thirdName = myList.get(2);
        System.out.println("\nThird name in the list: " + thirdName);
        
        
        String searchName = "Abhiram";
        boolean containsName = myList.contains(searchName);
        System.out.println("\nDoes the list contain '" + searchName + "'? " + containsName);
        
        
        System.out.println("\nNumber of names in the list: " + myList.size());
        
        
        String nameToRemove = "Rishi";
        myList.remove(nameToRemove);
        System.out.println("\nAfter removing '" + nameToRemove + "', number of names: " + myList.size());
    }
}