
//imports
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class OnlineStore {
	
	//Variables
	private String name;
	private HashMap<Integer, Product> products;
	private HashMap<Integer, Order> orders;
	
	public OnlineStore(String sName) {
		this.name = sName;
		this.products = new HashMap<Integer, Product>();
		this.orders = new HashMap<Integer, Order>();
	}
	
	boolean addProduct() {
		try {
			Scanner input = new Scanner(System.in);
			System.out.print("Product Number: ");
			int pNum = input.nextInt();
			if (products.get(pNum) != null) {
				System.out.println("Invalid input. Product " + pNum + " already exists.");
				return false;
			}
			System.out.print("Product Name: ");
			input = new Scanner(System.in);
			String pName = input.nextLine();
			System.out.print("Product Price: ");
			double pPrice = input.nextDouble();
			products.put(pNum, new Product(pNum, pName, pPrice));
			System.out.printf("Product Added -- " + pName + ", No: " + pNum + ", Price: $%5.2f \n", pPrice); 
			return true;
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid input. Try again..");
			addProduct();
			return false;
		}
	}
	
	boolean deleteProduct() {
		try {
			System.out.print("Enter Product to Delete: ");
			Scanner input = new Scanner(System.in);
			int pNum = input.nextInt();
			if (products.containsKey(pNum)){
				products.remove(pNum);
				System.out.println("Product " + pNum + " deleted.");
				return true;
			}
			else {
				System.out.println("Input error. Product number " + pNum + " does not exist.");
				return false;
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid input. Try again.");
			deleteProduct();
			return false;
		}
	}
	
	void productInfo() {
//		System.out.print("Enter product number (or just enter for all products: ");
//		Scanner input = new Scanner(System.in);
//		int pNum = input.nextInt();
//		if (pNum ) {
//			
//		}
	}
	
	boolean makeOrder() {
		return false;
	}
	
	boolean updateProduct() {
		System.out.print("Product Number to Update: ");
		Scanner input = new Scanner(System.in);
		int pNum = input.nextInt();
		System.out.println("If you do not want to change data, press the enter key.");
		String oName = products.get(pNum).getName();
		System.out.print("Product name (" + oName + "):");
		String newName = input.nextLine();
		if (newName != null) {
			products.get(pNum).setName(newName);
		}
		double oPrice = products.get(pNum).getPrice();
		System.out.printf("Product price ($%5.2): ", oPrice);
		double newPrice = input.nextDouble();
		return false;
	}
}
