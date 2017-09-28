/**
 * Title: Truck.java
 * Abstract: This class implements the Truck subclass of 
 *           the Vehicle class. Trucks can have a towing 
 *           capacity and a load capacity.
 * Author: XXXX
 * ID: XXXX
 * Date: XX/XX/XX
 */
public class Truck extends Vehicle
{
    private double loadCapacity;
    private int towingCapacity;
    
    public Truck()
    {
        super();
        this.loadCapacity = 0.0;
        this.towingCapacity = 0;
    }
    
    public Truck(String manu, int cyl, Person p) {
    		super(manu, cyl, p);
    }
    
    public Truck(String manu, int cyl, Person p, double loadCap, int towCap) {
    		super(manu, cyl, p);
    		this.loadCapacity = loadCap;
    		this.towingCapacity = towCap;
    }
    
   
    public double getLoadCap()
    {
        return loadCapacity;
    }
    
    public void setLoadCap(double theLoadCapacity)
    {
        this.loadCapacity = theLoadCapacity;
    }
    
    public int getTowingCap()
    {
        return towingCapacity;
    }
    
    public void setTowingCap(int theTowingCapacity)
    {
        this.towingCapacity = theTowingCapacity;
    }
    
    public String toString() {
    		return (super.toString() + ", " + this.loadCapacity + ", " + this.towingCapacity);
    }
    
    public boolean equals(Object object) {
    		if (this.toString().equals(object.toString())){
    			return true;
    		}
    		else {
    			return false;
    		}
    }
    
}
