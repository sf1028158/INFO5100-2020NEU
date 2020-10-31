package assignment6;
import java.util.*;
public class Mreview extends java.lang.Object implements java.lang.Comparable<Mreview>{
	 // instance variables
	  private String title;   // title of the movie
	  private ArrayList<Integer> ratings; // list of ratings stored in a Store object

	  // methods
	  
	  public Mreview(){
		  this.title="";
		  this.ratings=new ArrayList<>();
				
	  }
	  public Mreview(String ttl){
		  this.title=ttl;
		  this.ratings=new ArrayList<>();
		  
	  }
	  public Mreview(String ttl, int firstRating){
		  this.title=ttl;
		  this.ratings=new ArrayList<>(1);
		  ratings.add(firstRating);
		  
	  }

	  public void addRating(int r){
		  ratings.add(r);
  
	  }
	  public double aveRating(){
		  int i=ratings.size();
		  int total=0;
		  for(int j=0;j<i;j++){
			  total+=ratings.get(j);		  
		  }
		  return total/i;	  
	  }
	  @Override
	  public int compareTo(Mreview obj){
		  
		  return title.compareTo(obj.title);
		  
	  }
	  public boolean equals(java.lang.Object obj){
		  
		  return title.equals(((Mreview)obj).title);
 
	  }
	  public String getTitle(){
		  
		  return this.title;
	
	  }
	  public int numRatings(){
		  return ratings.size();
		  
	  }
	  @Override
	  public String toString(){
		  String a=this.getTitle();
		  String b=String.valueOf(this.aveRating());
		  int c=ratings.size();
		  String s=this.getTitle()+" , average "+b+" out of "+c+" ratings";
		  return s;
	
	  }
	  public static void main(String args[]){
		  Mreview a=new Mreview("Tatanic");
		  a.addRating(1);
		  a.addRating(5);
		  a.addRating(8);
	      double c=a.aveRating();
		  System.out.println(a.toString());
		
	  }

}
