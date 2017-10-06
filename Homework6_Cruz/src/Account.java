

public class Account {

    private String acctSSN;
    private int acctNumber;
    private int acctType;
    private double acctBalance;

    public Account(String ssn, int num, int type, double balance){
        this.acctSSN = ssn;
        this.acctNumber = num;
        this.acctType = type;
        this.acctBalance = balance;
    }

}
