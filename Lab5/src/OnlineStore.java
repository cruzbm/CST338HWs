//LAB 5 -- BRANDON CRUZ

import java.util.HashMap;
import java.util.Scanner;

public class OnlineStore{

	private String name;
	private HashMap<Integer, Product> products;
	
	public OnlineStore(String newName) {
		this.name = newName;
		products = new HashMap<Integer, Product>();
	}
	
	public boolean addProduct() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Product Number: ");
		int pNum = keyboard.nextInt();
		System.out.print("Product Name: ");
		String pName = keyboard.next();
		System.out.print("Product Price: ");
		double pPrice = keyboard.nextDouble();
		if (products.containsKey(pNum)) {
    		System.out.println("Input error: Product " + pNum + " already exists.");
    		return false;
		}
    	else {
    		products.put(pNum, new Product(pNum, pName, pPrice));
    		System.out.printf("Product Added - " + pName + ", Num: " + pNum + ", Price: $%5.2f", pPrice);
    		return true;
    	}
	}
	
	public void productInfo() {
		int increment = 1;
		for(HashMap.Entry<Integer, Product> entry : products.entrySet()) {
			System.out.print(increment + ": ");
			System.out.println(entry.getValue().getInfo());
			increment++;
        }
	}
	
	public boolean deleteProduct() {
		System.out.println("Enter product number to delete: ");
		Scanner keyboard = new Scanner(System.in);
		int pNum = keyboard.nextInt();
		if (!products.containsKey(pNum)) {
			System.out.println("Input Error: No product " + pNum);
			return false;
		}
		else {
			products.remove(pNum);
			return true;
		}
	}
	
}