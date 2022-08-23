package project;

public class Coordinator extends People implements Runnable {

	  private String num;
	  private Thread thread;

	  public Coordinator(int row, int rowcap) {
	    this.num = "Coordinator";
	    this.thread = new Thread(this, num);
	    numRows = row;
	    rowCapacity = rowcap;
	    seating = new Student[numStudents+1];

	  }
	  
	  public void msg(String m) {
	  System.out.println("["+(System.currentTimeMillis()-time)+"] "+Thread.currentThread().getName()+": "+m);
	  }
	  

	  public void start() {
	    thread.start();
	  }

	  public void run() {
		  try {
				msg("waits for students to arrive and be seated");
				//students arrive by waiting for random time
				
				//students sit in lower third rows
				

				
				//Students complete form, busy wait, and wait for coordinator
				
				//last student lets the coordinator know to start
					coordinatorSignal.acquire();
				//chairman finishes speech
					chairmanSignal.release();
					speechSignal.acquire();
				//chairman speech and coordinator gets ready to hand out speeches
					for(int i = 0; i < (numStudents); i++) {//signal each row to stand
						
						nextStudentCoordinator.acquire();
						//nextRow = true;
						msg("asks next Student to stand");
							if(seating[i] != null) {
							seated.release();
							nextStudent.release();
						}
					}
				
				//each row stands up in turn, gets diplomas and goes to the hallway for busy wait
				
			  
				//ceremony ends and chairman and coordinator wait
				leavingCoordinator.acquire(numStudents);
		  		msg("leaves");
		  
		  }
			  catch (InterruptedException e) {
				  
				  
			}
		}
				
		  
		  
	}