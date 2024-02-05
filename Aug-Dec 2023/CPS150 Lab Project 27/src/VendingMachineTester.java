public class VendingMachineTester
{
   public static void main(String[] args)
   {
      VendingMachine machine1 = new VendingMachine(); // machine 1 initially has 0 cans
      machine1.fillUp(10); // Fill up with ten (10) cans
      machine1.insertToken();
      machine1.insertToken();
      System.out.print("Token count: ");
      System.out.println(machine1.getTokenCount());
      System.out.println("Expected: 2 tokens");
      System.out.print("Can count: ");
      System.out.println(machine1.getCanCount());
      System.out.println("Expected: 8 cans");

      VendingMachine machine2 = new VendingMachine(); // machine 2 initially has 0 cans
      machine2.fillUp(15); // Add 15 cans to the machine
      machine2.insertToken();
      machine2.insertToken();
      machine2.insertToken();
      System.out.print("Token count: ");
      System.out.println(machine2.getTokenCount());
      System.out.println("Expected: 3 tokens");
      System.out.print("Can count: ");
      System.out.println(machine2.getCanCount());
      System.out.println("Expected: 12 cans");
   }
}