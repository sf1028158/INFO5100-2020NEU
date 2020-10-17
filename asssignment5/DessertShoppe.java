package assignment;

public class DessertShoppe {
	private String storeName = "M & M Dessert Shoppe";
	private double taxRate = 0.065;
	private int maxSize = 30;
	private int width  = 30;
	
	public String cents2dollarsAndCents(int cent){
		return String.valueOf(cent/100.0);
	
	}
	public String getStoreName() {
		return storeName;
	}
	
	public double getTaxRate() {
		return taxRate;
	}
	public int getMaxSize() {
		return maxSize;
	}
	
	
	
	
	
	
	
	
	

}
