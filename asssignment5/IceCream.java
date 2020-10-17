package assignment;

public class IceCream extends DessertItem {
	private double price;
	public IceCream(){
		
	}
	public IceCream(String name, int cost) {
		super(name);
		this.price = cost;
	}

	@Override
	public String priceToString(){
		String s="";
		s=s+(double)this.getCost()/100;
		return s;
		
	}
	
	
	
	@Override
	public int getCost() {
		double p = price;
		int cost = (int) Math.round(p);
		return cost;
	}

}
