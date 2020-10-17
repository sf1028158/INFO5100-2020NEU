package assignment;

public class Sundae extends IceCream {
	private float toppingPrice;
	private String sundaeName;
	public Sundae(String iceCreamName, int cost, float toppingPrice,String sundaeName){
		super(iceCreamName, cost);
		this.toppingPrice = toppingPrice;
		this.sundaeName= sundaeName;
	}
	
	
public int getCost() {
		
		double p = super.getCost() + toppingPrice;
		int cost = (int) Math.round(p);
		return cost;
		
	}

@Override
public String getName(){
String itemName= sundaeName+"with\n"+super.name;
return itemName;
	
}

@Override
public String priceToString(){
	String s="";
	s=s+(double)this.getCost()/100;
	return s;
	
}
}