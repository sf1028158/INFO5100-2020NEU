package assignment;

import javax.swing.Spring;

public abstract class DessertItem extends java.lang.Object {
	protected String name;
	public DessertItem(){
	}
	
	
	public DessertItem(String name){
		
		this.name = name;
		
	}
	public  String getName(){
		return this.name;
	
	}
	public abstract int getCost();
	public String priceToString(){
	
		return null;
	}

}
