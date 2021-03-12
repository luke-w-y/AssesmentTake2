/**
 * 
 */
package oopAssesment;

/**
 * @author lwyer
 *
 */
public class MenuItem implements IDetail {

	private String name;
	private double price;
	
	
	
	public MenuItem() {
		
	}
	
	public MenuItem(String name) {
		setName(name);
		this.name=getName();
	}

	
	public MenuItem(String name, double price) {
		
		setName(name);
		setPrice(price);
		this.price=getPrice();
		this.name=getName();
		
		
	}
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		
		if (name.charAt(0)==' '||name==""||name==null||isAlpha(name)==false) {
			this.name="INVALID NAME";
		} else {
		this.name = name;
		}
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		if (price<0) {
			this.price=0;
		} else {
		this.price = price;
	}
	}
	
	
	
	public boolean isAlpha(String name){
		char[] chars =name.toCharArray();
		
		for (char c : chars) {
			if(!Character.isLetter(c)&&c!=' ') {
				return false;
		}
			
		}
		return true;
		
	}
	
	
	@Override
	public void printDetails() {
		// TODO Auto-generated method stub
		
		System.out.printf("%s \t\t       £%.2f %n",getName(),getPrice());

	}
	

	




	

}
