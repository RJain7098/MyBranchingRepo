import java.util.*; 
/**
   A program that demonstrates the LinkedList class
*/
public class ListDemo
{
   public static void main(String[] args)
   {
      //this well test the implementation of the contains method to make sure it works 
      LinkedList test = new LinkedList(); 
      test.addFirst("hello");
      test.addFirst("goodbye"); 
      test.addFirst("nah"); 
      ListIterator yikes = test.listIterator(); 
      System.out.println(test.contains("hello")); 
      
   }
}
