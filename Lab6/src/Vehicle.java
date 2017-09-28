/**
 * Title: Vehicle.java
 * Abstract: The Vehicle class stores manufacturer, cylinder,
 *           and owner information.
 * Author: XXXX
 * ID: XXXX
 * Date: XX/XX/XX
 */
public class Vehicle
{
    private String manufacturer;
    private int cylinders;
    private Person owner;
    
    
    public Vehicle()
    {
        this.manufacturer = "Unknown";
        this.cylinders = 0;
        this.owner = null;
    }
    
    public Vehicle(String theManufacturer, int theCylinders, Person theOwner)
    {
        this.manufacturer = theManufacturer;
        this.cylinders = theCylinders;
        this.owner = theOwner;
    }
    
    //COPY CONSTRUCTOR
    public Vehicle(Vehicle v) {
    		this.manufacturer = v.manufacturer;
    		this.cylinders = v.cylinders;
    		this.owner = v.owner;
    }
    
    public String getManufacturer()
    {
        return manufacturer;
    }
    
    public void setManufacturer(String theManufacturer)
    {
        this.manufacturer = theManufacturer;
    }
    
    public int getCylinders()
    {
        return cylinders;
    }
    
    public void setCylinders(int theCylinders)
    {
        this.cylinders = theCylinders;
    }
    
    public Person getOwner()
    {
        return owner;
    }
    
    public void setOwner(Person theOwner)
    {
        this.owner = theOwner;
    }
    
    public String toString() {
    		return (this.manufacturer + ", " + this.cylinders + ", " + this.manufacturer);
    }
}