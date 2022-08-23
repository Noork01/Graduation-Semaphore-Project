package project;
import java.util.concurrent.atomic.AtomicBoolean;

public class Student extends People implements Runnable {
	
	
	  private Family[] family;
	  private String num;
	  private Thread thread;
	  private int seat;
	  int numFamily = (int) Math.floor(Math.random() * 3);
	//  boolean seated;
	  boolean uncalled = true;
	  
	  
	  public Student(String num) {
		    this.num = "student" + num;
		    this.thread = new Thread(this, "student" + num);
	  }
	  

	  public void msg(String m) {
	  System.out.println("["+(System.currentTimeMillis()-time)+"] "+Thread.currentThread().getName()+": "+m);
	  }
	  
	  public String getName() {
		  return num;
	  }
//	  public void stand() {
//		  seated = false;
//	  }
	  
	  public int getSeat() {
		  return seat;
	  }
	    
	  public void start() {
		    thread.start();
	  }
	  
	  public void interruptAll() {
		  for (int i = 0; i < numFamily; i++) {
			  family[i].thread.interrupt();
		  }
		  this.thread.interrupt();
	  }
		
	  public void run() {
		  try {
			// Creates an array for family threads
			    family = new Family[numFamily];

			 // Creates the family threads
			    for (int i = 0; i < numFamily; i++) {
			    	family[i] = new Family(num+"family"+(Integer.toString(i+1)),this.thread);
			    }
			
			//students arrive by waiting for random time and start family threads
			Thread.sleep((long)(Math.random()*10000));
			  msg(num+" arrives with their family");
			  for (int i= 0; i < numFamily; i++) {
			      family[i].start();
			    }
			  Thread.sleep(10);
			
//			//students sit in lower third rows
			  seat = currentSeat;
			  currentSeat++;
			 // seated = true;
			  seating[seat] = this;//put students in array for coordinator to call from
			  msg(num+" sits in row "+ ((seat/rowCapacity)+1) + " seat "+((seat%rowCapacity)+1));
			  Thread.sleep(10);
			
			//family wait for an interrupt by chairman
			
//			//Students complete form, busy wait, and wait for coordinator
			  Thread.sleep(10);
			  msg(num+" completes form and waits");
			  counter1++; 
			  Thread.sleep(10);
			  
			//last student lets the coordinator know to start
			  if(counter1 == numStudents) {
				  Thread.sleep(20);
				  msg(num+" tells the Chairman and Coordinator everyone is ready");
				  coordinatorSignal.release();
			  }
			  else {
				  sitWaitCounter++;
				  speechSignal.acquire();
			  }
			
			//chairman speech and coordinator gets ready to hand out speeches
			
//			//coordinator each row stands up in turn, and gets called by chairman
			  seated.acquire();
			  
			  
			  msg(num+" from row "+((seat/rowCapacity)+1) + " seat "+((seat%rowCapacity))+" stands up");
			  
			  podium.acquire();
			  Thread.sleep(30);
			  msg(num+" moves to the podium where the chairman stands");
			  picture.acquire();
			  
			//receives diploma
			  msg(num+" takes a picture with the chairman");
			  Thread.sleep(40);
			  leavePodium.acquire();
			  msg(num+" leaves the podium and goes to the hallway to wait");
			 // Thread.sleep(10);
			  nextStudentCoordinator.release();

			  sitWait.acquire();
			  
		  
			//ceremony ends and 

			//chairman invites everyone to go to second floor for food
				

			//everyone rushes using priority()
			  mutex.acquire();
			  msg(num+" stands up excitedly and moves toward the exit");
			  mutex.release();
			  Thread.currentThread().setPriority((Thread.currentThread().getPriority())-1);
			  Thread.sleep((long)(Math.random()*2000));
			  Thread.currentThread().setPriority((Thread.currentThread().getPriority())+1);
			
			//students let family go through doors first using yield()
			//  msg(num+" reaches auditorium door and politely lets family go first");
			//  Thread.yield();
			//  Thread.yield();
			  mutex.acquire();
			  msg("enter room");
			  mutex.release();
			
			//random time for each student to talk to faculty and then leave
			  msg(num+" eats and talks to faculty");
			  Thread.sleep((long)(Math.random()*5000));
			
			//family members join student and leave together
			  msg(num+" leaves with their family");
			  counter3++;
			  leavingCoordinator.release();
			  leaving.release();
			
			//chairman and coordinator leave together
			  
			  }
			  catch (InterruptedException f) {
				  
			  }
		
	}
			
	  
	  
}
