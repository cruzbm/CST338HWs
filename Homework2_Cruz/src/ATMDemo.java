public class ATMDemo
{
    public static void main(String[] args)
    {
        ATM machine1 = new ATM(“OtterUnion”);
        ATM machine2 = new ATM(200, “BOA”, “Library”);
        
        System.out.println("===== Welcome to CSUMB ATM Machine =====");
        System.out.println(machine1);
        System.out.println(“”);        
        System.out.println(machine2);
        System.out.println("\n===== Equality Checking =====");
        System.out.println(machine1.equals(machine2));
        System.out.println(“”);

        machine1.setATM(100, “BIT110”);
        machine1.addFund(400.00);// In this method, we assume that an ATM machine
                           // administrator adds $400.00 more cash to the machine.  
        System.out.println(machine1);
        System.out.println(“”);

        machine1.displayMenu()
        machine1.withdrawal(“Alice”, 7777, 10.00); // In this method, we assume
                    // that a user, Alice, wants $10.00 withdrawal with PIN 7777.

        machine1.withdrawal(“NoAlice”, 1234, 10.00);
        machine1.withdrawal(“Alice”, 1234, 10000.00);
        machine1.withdrawal(“Alice”, 1234, 10.00);
        machine1.withdrawal(“Alice”, 1234, 2000.00);
        System.out.println("\n===== Machine Status =====");
        machine1.status();


        System.out.println(“”);
        machine1.deposit(“Alice”, 1234, 10.00); // In this method, we assume that 
                                  // a user, Alice, wants the cash deposit $10.00 
                                  // to the machine with PIN 1234.

        System.out.println("\n===== Machine Status =====");
        machine1.status();

        System.out.println(“”);
        machine1.transfer(“Alice”, 1234, 10.00, “Tom”, 2000); // In this method, 
                  // we assume that a user “Alice” wants to transfer $10.00 
                  // to “Tom”. 1234 and 2000 indicates their PINs.

        System.out.println("\n===== Machine Status =====");
        machine1.status();

        System.out.println("\n===== Thank you! =====");
    }
}
