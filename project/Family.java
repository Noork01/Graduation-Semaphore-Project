package project;

public class Family extends People implements Runnable {

	  private String name;
	  Thread thread;
	  private int seat;
	  Thread studentName;
	  int familySeatStart;

	  public Family(String num, Thread student) {
		this.studentName = student;
	    this.name =  num;
	    this.thread = new Thread(this, num);

	  }
	  
	  
	  public int getSeat() {
		  return seat;
	  }
	  

	  public void msg(String m) {
	  System.out.println("["+(System.currentTimeMillis()-time)+"] "+name+": "+m);
	  }

	  public void start() {
	    thread.start();
	  }

	  public void run() {
		  try {
			familySeatStart = (((numRows/3)+1)*rowCapacity);
			
			//students arrive by waiting for random time
			msg("arrive with "+studentName.getName());
			  Thread.sleep(10);
			
			//students sit in lower third rows// family sits in upper third
		    seat = currentSeatf + familySeatStart;
			currentSeatf++;
			if(seat>=numRows*rowCapacity) {//if seats are full
				msg(name+ "waits in wallway for ceremony to end");
				sitWaitCounter++;
				sitWait.acquire();
			}
			else {//sit in back seat
			msg(name+" sits in row "+ ((seat/rowCapacity)+1) + " seat "+((seat%rowCapacity)+1));
			}
			//wait for an interrupt by chairman
			sitWaitCounter++;
			sitWait.acquire();
			
			
			//Students complete form, busy wait, and wait for coordinator
			
			//last student lets the coordinator know to start
			
			//chairman speech and coordinator gets ready to hand out speeches
			
			//each row stands up in turn, gets diplomas and goes to the hallway for busy wait
			

			//ceremony ends and 
		  
			//chairman invites everyone to go to second floor for food
			mutex.acquire();
				  msg(name+" stands up excitedly and moves toward the exit");
			mutex.release();
				  Thread.currentThread().setPriority((Thread.currentThread().getPriority())-1);
				  Thread.sleep((long)(Math.random()*2000));
				  Thread.currentThread().setPriority((Thread.currentThread().getPriority())+1);

			//everyone rushes using priority()
			  
			
			//students let family go through doors first using yield()
			mutex.acquire();
			  msg("enter room");
			mutex.release();
			//random time for each student to talk to faculty and then leave
			  
			
			//family members join student and leave together
			  studentName.join();
			  msg("leaves with "+studentName.getName());
			
			//chairman and coordinator leave together
			  
			  }
			  catch (InterruptedException f) {
				  
			  }
		}
	
			
	  
	  
}