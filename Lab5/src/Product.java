
public class Product {
	
	private int productNum;
	private String name;
	private double unitPrice;
	
	public Product(int number, String pName, double price) {
		this.productNum = number;
		this.name = pName;
		this.unitPrice = price;
	}
	
	public String getInfo() {
		return (name + "(No. " + productNum + "): $" + unitPrice);
	}
}
