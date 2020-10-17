package assignment;

public class Candy extends DessertItem {
	private double weight;
	private int pricePerPoundInCent;
	public Candy(String name,double weight,int p){
		super(name);
		this.weight = weight;
		this.pricePerPoundInCent = p;
		
		
	}

		
		public double getPricePerPoundsInDollar(){
			
			return (double)this.pricePerPoundInCent/100;
			}
		
		
		@Override
	   public String priceToString(){
				String s="";
				s=s+this.weight+" lbs. @ "+this.getPricePerPoundsInDollar()+" /lb.";
				return s;
				
				
			}

	@Override
	public int getCost() {
		
		double c = weight * pricePerPoundInCent;
		int cost= (int)Math.round(c);
		return cost;
			
	}

}
