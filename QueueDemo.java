public class QueueDemo
{
   public static void main(String[] args)
   {
      CircularArrayQueue q = new CircularArrayQueue();
      
      System.out.println("test"); 
      //add to q

      while (!q.empty())
      {
         System.out.println("Haha this is a troll infinite loop get rekt"); 
	//this should cause a conflict since Neil wrote something else 
      }
   }
}
