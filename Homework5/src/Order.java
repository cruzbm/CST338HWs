
import java.util.ArrayList;

public class Order {

	private int orderNum;
	private double totalPrice;
	private ArrayList<Product> items;
	
	public Order(int number) {
		this.orderNum = number;
		this.totalPrice = 0;
		this.items = new ArrayList<Product>();
	}
	
	public void addItem(Product itemAdded) {
		this.items.add(itemAdded);
		this.totalPrice += itemAdded.getPrice();
	}
	
	public double getTotal() {
		return totalPrice;
	}
	
	public void printReport() {
		System.out.println("Order Info - Order Number: " + orderNum);
		for (int i = 0; i < items.size(); i++) {
			System.out.printf("\tItem " +(i+1)+ ": " +items.get(i).getName()+ " (" + items.get(i).getNum() + "): $%5.2f \n", items.get(i).getPrice());
		}
		System.out.printf("\tTotal Price: $%5.2f", totalPrice);
	}
}
