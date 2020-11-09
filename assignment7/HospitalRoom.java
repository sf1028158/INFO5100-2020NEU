package assignment;

public class HospitalRoom {
	
		   //TODO: implement your code here
		 private final Object lock1 = new Object();
		 private final Object lock2 = new Object();
		 
		 private  int docNum=0;
		 private  int patientNum=0;


	    @SuppressWarnings("unused")
		public boolean doctorEnter(Doctor d) throws InterruptedException {
	        synchronized(lock1){
	        	while(true){
	        		if(docNum==1){
	        			 System.out.println("Doctor "+d.name+"is waiting to Enter, number of doctor 1");
	                     lock1.wait();
	                     return false;
	        		}else{
	        			 System.out.println("Doctor "+d.name+" Entered, , number of doctor 1");
	        			 lock1.notify();
	        			 docNum++;
	        			 return true;
	        		}
	        	}
	        }
	 
	    }

	    public boolean doctorLeave(Doctor d) throws InterruptedException {
	        //TODO: implement your code here
	    	  synchronized(lock1){
	          	while(true){
	          		if(docNum==1){
	          			 System.out.println("Doctor "+d.name+"Left, number of doctor 0");
	                       lock1.notify();
	                       docNum--;
	                       return true;
	          		}
	          	}
	          }
	   
	    }

	    public boolean patientEnter(Patient p) throws InterruptedException {
	        //TODO: implement your code here
	    	 synchronized(lock2){
	         	while(true){
	         		if(patientNum==3){
	         			 System.out.println("Patient "+p.name+"is waiting to Enter, number of patients 3");
	                      lock2.wait();
	                      return false;
	         		}else{
	         			lock2.notify();
	         			patientNum++;   			
	         			 System.out.println("Patient "+p.name+" Entered, , number of patients "+patientNum);
	         			 return true;
	         			 
	         		}
	         	}
	         }
	    }

	    public boolean patientLeave(Patient p) throws InterruptedException {
	        //TODO: implement your code here
	    	synchronized(lock2){
	         	while(true){     		
	         			lock2.notify();
	         			patientNum--;   			
	         			 System.out.println("Patient "+p.name+" Left");
	         			 return true;
	         			 
	         		}
	         	}
	         }
	    }



	class Doctor {
	    public String name;
	    public Doctor(String name) {
	        this.name = name;
	    }
	}

	class Patient {
	    public String name;
	    public Patient(String name) {
	        this.name = name;
	    }
	}

	class Main2 {
	    public static void main(String[] args) {
	        HospitalRoom room = new HospitalRoom();
	        Doctor siva = new Doctor("siva");
	        Doctor john = new Doctor("john");
	        Patient p1 = new Patient("p1");
	        Patient p2 = new Patient("p2");
	        Patient p3= new Patient("p3");
	        Patient p4 = new Patient("p4");
	        Patient p5 = new Patient("p5");
	        Thread doctor1 = new Thread(() -> {
	            try {
	                while(!room.doctorEnter(siva)) {}
	                Thread.sleep(500);
	                while(!room.doctorLeave(siva)) {}

	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        });

	        Thread doctor2 = new Thread(() -> {
	            try {
	                while(!room.doctorEnter(john)) {}
	                Thread.sleep(500);
	                while(!room.doctorLeave(john)) {}
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        });

	        Thread patient1 = new Thread(() -> {
	            try {
	                    while(!room.patientEnter(p1)) {}
	                Thread.sleep(500);
	                    while(!room.patientLeave(p1)) {}
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        });

	        Thread patient2 = new Thread(() -> {
	            try {
	                while(!room.patientEnter(p2)) {};
	                Thread.sleep(500);
	                while(!room.patientLeave(p2)) {};
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        });

	        Thread patient3 = new Thread(() -> {
	            try {
	                while(!room.patientEnter(p3)) {};
	                Thread.sleep(500);
	                while(!room.patientLeave(p3)) {};
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        });

	        Thread patient4 = new Thread(() -> {
	            try {
	                while(!room.patientEnter(p4)) {};
	                Thread.sleep(500);
	                while(!room.patientLeave(p4)) {};
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        });

	        Thread patient5 = new Thread(() -> {
	            try {
	                while(!room.patientEnter(p5)) {};
	                Thread.sleep(500);
	                while(!room.patientLeave(p5)) {};
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        });

	        doctor1.start();
	        doctor2.start();
	        patient1.start();
	        patient2.start();
	        patient3.start();
	        patient4.start();
	        patient5.start();
	    }
	}
	


