
//imports
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Map.Entry;

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
	
	void productInfo() { //NOT READING 'ENTER' KEY FOR ALL PRODUCTS
		System.out.print("Enter product number (or just enter for all products): ");
		Scanner input = new Scanner(System.in);
		String checkNull = input.nextLine();
		if (!checkNull.equals("")) {
			int pNum = Integer.parseInt(checkNull);
			if (products.containsKey(pNum)) {
				System.out.printf("No. " + pNum + ": " + products.get(pNum).getName() + ", $%5.2f", products.get(pNum).getPrice());
			}	
		}
		else {
			for (Integer prod: products.keySet()) {
				Product p = products.get(prod);
				System.out.printf(p.toString() + "%5.2f \n", p.getPrice());
			}
		}
		
	}
	
	public boolean makeOrder() {
		Scanner input = new Scanner(System.in);
		System.out.print("Order Number: ");
		int ordNum = input.nextInt();
		if (orders.containsKey(ordNum)) {
			System.out.println("Error: Order " + ordNum + " already exists.");
			return false;
		}
		orders.put(ordNum, new Order(ordNum));
		
		boolean flag = false;
		while (flag == false) {
			System.out.print("Type Product Number (0 to finish): ");
			input = new Scanner(System.in);
			int newItem = input.nextInt();
			if (newItem == 0) {
				flag = true;
			}
			else {
				
				if (!products.containsKey(newItem)) {
					System.out.println("Error: Product " + newItem + " does not exist.");
				}
				else {
					orders.get(ordNum).addItem(products.get(newItem));
				}
			}
		}

		//Print total Order
		orders.get(ordNum).printReport();
		return false;
		
	}
	
	boolean updateProduct() {
		
		System.out.print("Product Number to Update: ");
		Scanner input = new Scanner(System.in);
		int pNum = input.nextInt();
		if (!products.containsKey(pNum)) {
			System.out.println("Input Error: Product " + pNum + " doesn't exist.");
			return false;
		}
		System.out.println("If you do not want to change data, press the enter key.");
		String oName = products.get(pNum).getName();
		System.out.print("Product name (" + oName + "):");
		input = new Scanner(System.in);
		String newName = input.nextLine();
		if (newName != null) {
			products.get(pNum).setName(newName);
		}
		double oPrice = products.get(pNum).getPrice();
		System.out.printf("Product price ($%5.2f): ", oPrice);
		input = new Scanner(System.in);
		String checkNull = input.nextLine();
		if (!checkNull.equals("")) {
			double newPrice = Double.parseDouble(checkNull);
			System.out.println(newPrice);
			products.get(pNum).setPrice(newPrice);
		}
		
		System.out.printf("Product Updated - " + products.get(pNum).getName() + ", No: " + pNum + ", Price: $%5.2f", products.get(pNum).getPrice());
		
		return true;
		
	}
}
