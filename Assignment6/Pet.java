package assignment6;

public class Pet {
	private String pName;
	private String oName;
	private String color;
	protected int sex;
	public Pet(String name, String ownerName, String color){
		this.pName=name;
		this.oName=ownerName;
		this.color=color;	
	}
	public String getPetName(){
		return this.pName;
		
	}
	public String getOwnerName(){
		return this.oName;
	}
	public String getColor(){
		return this.color;
		
	}
	public void setSex(int sexid){
		this.sex=sexid;
	}
	public String getSex(){
		String s = null;
		if(sex==1){
		 s="Male";
		}else if(sex==2){
			s="Female";
		}else if(sex==3){
			s="Spayed";
		}else if(sex==4){
			s="Neutered";
		}
		return s;
	}
public String toString(){
	String a=getPetName()+" owned by "+getOwnerName()+"\n"+"Color: "+getColor()+"\n"+"Sex: "+getSex()+"\n";
	return a;
}
}
