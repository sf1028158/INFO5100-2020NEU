package assignment;

import java.util.Random;

public class SumValue {
	 /*generate array of random numbers*/
	 static void generateRandomArray(int[] arr){
		 for (int i = 0; i < arr.length; i ++) {
				Random arrayItem = new Random();
				arr[i] = (short) arrayItem.nextInt(101);
				
				}
		 
	 }
	 
 /*get sum of an array using 4 threads*/
	 static long sum(int[] arr){
		int[] b=arr;
		int n=arr.length/4;
		summOfThreads t1= new summOfThreads(b, 0, n);
		summOfThreads t2= new summOfThreads(b, n, n*2);
		summOfThreads t3= new summOfThreads(b, n*2, n*3);
		summOfThreads t4= new summOfThreads(b, n*3, arr.length);
		 t1.start();
		 t2.start();
		 t3.start();
		 t4.start();
		 try {
			t1.join();
			 t2.join();
			 t3.join();
			 t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 
	 return t1.total+t2.total+t3.total+t4.total;
	 
	 }
	 
	 
	 public static class summOfThreads extends Thread{
		 int[] arr;
		 int i,j;
		 int total=0;
		 summOfThreads(int[] arr,int i,int j){
			 this.arr=arr;	 
			 this.i=i;
			 this.j=j;
		 }
		 public int sumTotal(int i, int j){
			 for(int a=i;a<j;a++){
				total+=arr[a];	
			 }
			 return total;
			
		 }
		 public void run(){
			 
			 total= sumTotal(i,j);
		 }
		 
	 }

	 public static void main(String[] args){	 
	 int[] arr = new int[4000000];
	 generateRandomArray(arr);
	 long sum = sum(arr);
	 System.out.println("Sum: " + sum);
	 
	 }
}
