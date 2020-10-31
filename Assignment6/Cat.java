package assignment6;

import java.util.Date;


public class Cat extends Pet implements Boardable {
	private String hairLength;
	private Date startDate;
	private Date endDate;
	public Cat(String name, String ownerName, String color, String hairLength){
		super(name,ownerName,color);
		this.hairLength=hairLength;
	}
	public String getHairLength(){
		return hairLength;
	}
	@Override
	public String toString(){
		String b="CAT:"+"\n"+super.toString()+"Hair:"+getHairLength();
		 return b;
	}
	

	@SuppressWarnings("deprecation")
	@Override
	public void setBoardStart(int month, int day, int year) {
     startDate = new Date(month,day,year);
	}
   

	@Override
	public void setBoardEnd(int month, int day, int year) {
		endDate = new Date(month,day,year);

	}

	@Override
	public boolean boarding(int month, int day, int year) {
		Date d=new Date(month,day,year);
		  if (startDate.compareTo(d) <= 0 && endDate.compareTo(d) >= 0){
			  return true;}
		  else{
			  return false;}
		  }
	
	}


