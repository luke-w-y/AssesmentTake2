package oopAssesment;

import java.util.ArrayList;

public class Pizza extends MenuItem {

	private int size;
	private ArrayList<Topping> ExtraToppings;

	// constructors

	public Pizza() {
		// TODO Auto-generated constructor stub
		super("Plain Pizza");

		setSize(8);
		super.setPrice(getSize());

	}

	public Pizza(int size) {
		super("Plain Pizza");
		setSize(size);

		this.size = getSize();
		super.setPrice(pizzaPrice(getSize()));

	}

	public Pizza(int size, ArrayList<Topping> ExtraToppings) {
		super("Custom Pizza");
		ExtraToppings.trimToSize();
		this.ExtraToppings = ExtraToppings;
		setSize(size);

		this.size = getSize();
		super.setPrice(pizzaPrice(size, ExtraToppings));

	}

	// methods

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		if (size > 16) {
			this.size = 16;

		} else if (size < 8) {

			this.size = 8;
		} else {
			this.size = size;
		}

		super.setPrice((double) this.size);
	}

	public ArrayList<Topping> getExtraToppings() {
		return ExtraToppings;
	}

	public void setExtraToppings(ArrayList<Topping> extraToppings) {

		extraToppings.trimToSize();
		ExtraToppings = extraToppings;
	}

	public void addTopping(Topping topping) {

		if (ExtraToppings == null) {
			ArrayList<Topping> toppings = new ArrayList<Topping>();
			toppings.add(topping);
			setName("Custom Pizza");
			this.ExtraToppings = toppings;
			setPrice(pizzaPrice(size, ExtraToppings));
		} else {

			if (doubleToppingCheck(ExtraToppings, topping) == true) {
				this.ExtraToppings.add(topping);
				setPrice(pizzaPrice(size, ExtraToppings));
			}

		}

	}

	public boolean doubleToppingCheck(ArrayList<Topping> Toppings, Topping newTop) {

		for (Topping topping : Toppings) {
			if (topping.equals(newTop)) {
				return false;
			}
		}
		return true;
	}

	private double pizzaPrice(int size, ArrayList<Topping> ExtraToppings) {

		setSize(size);
		return (double) getSize() + (0.5 * ((double) ExtraToppings.size()));
	}

	private double pizzaPrice(int size) {

		setSize(size);
		return (double) getSize();
	}

	@Override
	public void printDetails() {
		// TODO Auto-generated method stub
		pizzaDetail();
	}

	private void pizzaDetail() {

		System.out.printf("%s \t  (%d) £%.2f %n", getName(), getSize(), getPrice());
		if (getName().equalsIgnoreCase("Custom Pizza")) {
			System.out.printf("WITH TOPPINGS: %n");
			for (Topping topping : ExtraToppings) {
				System.out.println(topping);
			}
		}

		System.out.println();
	}

	public boolean isVegetarian() {

		if (ExtraToppings == null) {
			return true;
		} else {

			for (Topping topping : ExtraToppings) {
				if (topping.equals(Topping.BEEF) || topping.equals(Topping.CHICKEN) || topping.equals(Topping.HAM)
						|| topping.equals(Topping.PEPPERONI)) {
					return false;
				}
			}
		}
		return true;
	}

}
