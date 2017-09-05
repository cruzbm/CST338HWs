public class Person 
{
    private String name;
    private int age;
    
    public void setPerson(String name, int age) 
    {  
        this.name = name;
        this.age = age;
    }
    
    public void printPerson() 
    {  
        System.out.println ("Name: " + this.name);
        System.out.println ("Age: " + this.age);
    }
    
}