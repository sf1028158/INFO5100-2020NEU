package assignment;

import java.util.Vector;

public class CheckOut {
	
	private Vector<DessertItem> items;
	private int cost;
	DessertShoppe shop = new DessertShoppe();
	public CheckOut(){
		this.items=new Vector<DessertItem>();
	}
	
	public int numberOfItems(){
		return items.size();
		
	}
	
	
	
    public void enterItem(DessertItem item){
	  items.add(item);

  }
    
    public void clear(){
    	
    	items.clear();
    	
    }
    
    public int totalCost(){
    	
    	int cost = 0;
		for (DessertItem item: items) {
			cost += item.getCost();
		}
		return cost;
    	
    }
    
    public int totalTax(){
    	return (int) (this.cost * new DessertShoppe().getTaxRate());

    }
    
    public java.lang.String toString(){
    	
    	String ss="";
    	ss=ss+"    "+shop.getStoreName()+"\n";
    	ss=ss+"     -------------------"+"\n";
    	ss+="                           "+"\n";
    	
    	double totalcost=0;
    	for(int i=0;i<items.size();i++){
    		
    	
    		totalcost+=(double)items.get(i).getCost()/100;
    		String itemName=items.get(i).getName();
    		
    		String  itemCost=shop.cents2dollarsAndCents(items.get(i).getCost());
    	   if (items.get(i) instanceof IceCream){
    		   String itemPrice=null;
    	   }else{
    		   String itemPrice=items.get(i).priceToString();
    	   ss=ss+itemPrice+"\n"+itemName+"     "+itemCost+"\n";
    	   }
    	   
    	
    	}
    	 
    	double tax=totalcost*shop.getTaxRate();
    	
    	ss=ss+"Tax"+"        ."+tax+"\n"+"Total Cost          "+tax;
    	
    	return ss;
    	   
    	   
    	   
    	   
    	   
    
    	
    	
    	
    	
    	
    	
    	
    }
	
	
}
