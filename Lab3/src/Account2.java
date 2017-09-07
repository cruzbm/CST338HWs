public class Account2 
{
    private String name;
    private int number;
    private int type;
    private double balance;
    
    
    public Account2(String name, int number, int type, double balance)
    {
        this.name = name;
        this.number = number;
        this.type = type;
        this.balance = balance;
    }
            
    
    public boolean deposit(double fund)
    {
        if (fund < 0.0) 
        {
            System.out.println("Error: no negative amount to deposit.");
            return false;
        }
        else
        {
            balance += fund;
            return true;
        }
    }

    
    public boolean withdrawal(double fund)
    {
        if (fund > balance) 
        {
            System.out.println("Error: insufficient balance to withdraw.");
            return false;
        }
        else 
        {
            balance -= fund;
            return true;
        }
    }
    
    //added getter
    public int getNum() {
    	return this.number;
    }
    public String getName() {
    	return this.name;
    }
    public int getType() {
    	return this.type;
    }
    public double getBal() {
    	return this.balance;
    }
}