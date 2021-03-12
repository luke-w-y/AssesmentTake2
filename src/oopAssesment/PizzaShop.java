/**
 * 
 */
package oopAssesment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author lwyer
 *
 */
public class PizzaShop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
printReceipt(readInOrder("OrderList-1-BasicOnly.csv"));
printReceipt(readInOrder("OrderList-2-PizzasOnly.csv"));
printReceipt(readInOrder("OrderList-3-Full.csv"));
	
		
		findVeggies(readInOrder("OrderList-1-BasicOnly.csv"));
		findVeggies(readInOrder("OrderList-2-PizzasOnly.csv"));
		findVeggies(readInOrder("OrderList-3-Full.csv"));
		
	}

	public static void printReceipt(ArrayList<MenuItem> menuItems) {

		double total = 0;

		System.out.printf("--------------%nOrder Details%n--------------%n");

		for (MenuItem menuItem : menuItems) {

			menuItem.printDetails();
			System.out.println("---------------------------------");
			total += menuItem.getPrice();

		}

		System.out.printf("--------------%nTotal Cost: %.2f %n--------------%n", total);

	}

	public static void findVeggies(ArrayList<MenuItem> menuItems) {
		System.out.println("Findding Veggie Pizzas....");

		int veggieCount;
		veggieCount = 0;

		ArrayList<Pizza> pizzas = new ArrayList();

		for (MenuItem menuItem : menuItems) {

			if (menuItem.getName().equalsIgnoreCase("Plain Pizza")
					|| menuItem.getName().equalsIgnoreCase("Custom Pizza")) {
				pizzas.add((Pizza) menuItem);
			}

		}

		for (Pizza pizza : pizzas) {
			if (pizza.isVegetarian() == true) {
				veggieCount++;
				System.out.printf("Veggie %d)%n", veggieCount);
				pizza.printDetails();
			}
		}

		System.out.println("Number of Veggie Pizzas: " + veggieCount);

	}

	public static ArrayList<MenuItem> readInOrder(String fileName) {

		int aListCount;
		aListCount = 0;
		ArrayList<MenuItem> order = new ArrayList<MenuItem>();

		try {
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line;

			line = br.readLine();
			line=br.readLine();
			

			while (line != null) {

				
				String[] fields = line.split(",");


				
				
				if (fields[0].equalsIgnoreCase("Pizza")) {

					Pizza p1 = new Pizza();
					for (int i = 1; i < fields.length; i++) {
						if (i == 1) {
							p1.setSize(Integer.parseInt(fields[1]));
						} else {
							p1.addTopping(Topping.valueOf(fields[i]));
						}

					}
					order.add(p1);
					aListCount++;
				
				} else {
					
					MenuItem m1 = new MenuItem(fields[0],Double.parseDouble(fields[1]));
						
					

					order.add(m1);
			
					aListCount++;
				
				}

				line=br.readLine();
			}
			
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

}
