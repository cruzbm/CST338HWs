/**
 * Title:  Person.java
 * Abstract: This class maintains a Persion's name information.                                   
 * Author: XXXX
 * ID: XXXX
 * Date: XX/XX/XX
 */

public class Person 
{
    private String name;

    public Person()
    {
        this.name = "UNKNOWN NAME"; 
    }

    public Person (Person person)
    {
        this.name = person.name;
    }
         

    public Person (String theName)
    {
       if (theName == null)
       {
             System.out.println("Fatal error.");
             System.exit(0);
       }
       this.name = theName;
    }

    public String getName ( )
    {
       return name;
    }

    public void setName (String theName)
    {
        this.name = theName;
    }

    public String toString ( ) ///////////////////////
    {
    		return this.name;
    }

    public boolean equals (Object other) ///////////////////////
    {
        if (this.name.equals(other.toString())) {
        		return true;
        }
        else {
        		return false;
        }
    }

}
