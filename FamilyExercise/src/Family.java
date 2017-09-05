public class Family 
{
    private Person[] members;
    private int numOfMembers;
    
    public Family ()
    {    
        members = new Person[30];
        numOfMembers = 0;  
    }
    

    // Develop this method...
    public void addMember(String name, int age)
    {    
    	members[numOfMembers] = new Person();
    	members[numOfMembers].setPerson(name, age);
    	numOfMembers++;
    }
    
    // Develop this method... 
    public void printAllMembers() 
    {            
    	for (int i = 0; i < numOfMembers; i++) {
    		members[i].printPerson();
    	}
    }
}