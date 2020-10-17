package assignment;

public class Cookie extends DessertItem {
	private int number;
	private int pricePerDozen;
	
	public Cookie(String name, int number, int pricePerDozen) {
		super(name);
		this.number = number;
		this.pricePerDozen = pricePerDozen;
		
	}
	
	public double getPricePerDozen(){
		
	return (double)this.pricePerDozen/100;
	}
	
	@Override
	public String priceToString(){
		String s="";
		s=s+this.number+" @ "+this.getPricePerDozen()+" /dz.";
		return s;
		
		
	}
	

	@Override
	public int getCost() {
		double c =  (double) pricePerDozen/12 * number;
		int cost = (int) Math.round(c);
		return cost;
	}

}
