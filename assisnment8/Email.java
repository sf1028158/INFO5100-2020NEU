package emailapp;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Email {
	
    private String firstName,lastName,department;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = "aeycompany.com";
    private String password;
    private String alteEmailAdd;
    private String emailAddress;

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
    	this.firstName=firstName;
    	this.lastName=lastName;
    	 
    	
    }

    public String showInfo(){
    
    	 SetDepartment();
    	 this.emailAddress=generateEmailAddress();
    	 this.password=randomPassword(defaultPasswordLength);
    	 String S2="DISPLAY NAME: "+getName()+"\n"+"DEPARTMENT:"+department+"\n"
    	 
    			 +"COMPANY EMAIL:"+emailAddress+"\n"+"PASSWORD:"+password+"\n"
    			 +"MAILBOX CAPACITY:"+mailboxCapacity+"mb";
    			
    			 return S2;
    }
    
    
    // Ask for the department
    private String SetDepartment() {
    	System.out.println("New Worker: "+getName()+".Department Codes:\n"
    	
    	 +"1 for Sales\n"+"2 for Development\n"+"3 for Accounting\n"+"0 for none\n"
    	 +"Enter department code:");
    	 
		Scanner i=new Scanner(System.in);
    	
    	int s=i.nextInt();
    	 if(s==1){
    		 this.department="sal";
    	 }
    	 else if(s==2){
    		 this.department="dev";
    	 }else if(s==3){
    		 this.department="acc";
    	 }else if(s==0){
    		 this.department=" ";
    	 }
    	
    
    	 i.close();
    	
		return this.department;
		}

    // Generate a random password
    private String randomPassword(int length) {
    	   String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
    	    Random random = new Random();
    	    StringBuffer sb = new StringBuffer();
    	    for (int i = 0; i < length; i++) {
    	        int number = random.nextInt(str.length());
    	        sb.append(str.charAt(number));
    	    }
    	    this.password=sb.toString();
    	    return password;
    	   

    	
    }

    private void setPassword(String s){
    	
    	this.password=s;
    }
    private void setMailCap(int j){
    	this.mailboxCapacity=j;
    }
    private void setAlteEmail(String a){
    	this.alteEmailAdd=a;
    }
    
    public String generateEmailAddress(){
    	 if (department.equals("")) {
             this.emailAddress = firstName + "." + lastName + "@" + companySuffix;
         } else {
             this.emailAddress = firstName + "." + lastName + "@" + department + "." + companySuffix;
         }
    	
    	return emailAddress;
    }
    
    
    
    public String getName() {
        return firstName + " " + lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getMailboxCapacity() {
        return mailboxCapacity + "mb";
    }
}





