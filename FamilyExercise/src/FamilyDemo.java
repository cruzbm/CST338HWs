public class FamilyDemo 
{
    public static void main(String[] args)
    {
        Family smith = new Family();
    
        smith.addMember("Smith", 45);
        smith.addMember("Alice", 41);
        smith.addMember("Tom", 15);
        smith.printAllMembers();
        
        return;
    }
}
