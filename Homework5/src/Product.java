
public class Product {
	private int productNum;
	private String name;
	private double unitPrice;
	
	public Product(int pNum, String pName, double pPrice) {
		this.productNum = pNum;
		this.name = pName;
		this.unitPrice = pPrice;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return unitPrice;
	}
	
	public boolean setPrice(double newPrice) {
		this.unitPrice = newPrice;
		return true;
	}
	
	public boolean setName(String newName) {
		this.name = newName;
		return true;
	}
}
