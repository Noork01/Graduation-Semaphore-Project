package project;

public class Chairman extends People implements Runnable {

	  private String num;
	  private Thread thread;

	  public Chairman(int studentnum) {
	    this.num = "Chairman";
	    this.thread = new Thread(this, num);
	    numStudents = studentnum;
	  }
	  
	  public void msg(String m) {
	  System.out.println("["+(System.currentTimeMillis()-time)+"] "+Thread.currentThread().getName()+": "+m);
	  }
	  

	  public void start() {
	    thread.start();
	  }
	  
//	  public void interruptAll(){
//		  for(int i = 0; i < (numRows/3)+1; i++) {
//				for(int j = 0; j < rowCapacity;j++) {
//					if(seating[i][j] != null) {
//					seating[i][j].interruptAll();
//					}
//				}
//		  }
//	  }

	  public void run() {
		  try {
				
				msg("waits for students to arrive and be seated");
				//students arrive by waiting for random time
				
				//students sit in lower third rows
				

				
				//Students complete form, busy wait, and wait for coordinator
				
				//last student lets the coordinator know to start
				chairmanSignal.acquire();
				msg("gives long speech");//chairman speech
				Thread.sleep((long)(Math.random()*10000));
				msg("tells coordinator hes ready to hand out diplomas");//siganl coordinator
				speechSignal.release(numStudents +1);
				
				//chairman and coordinator gets ready to hand out diplomas
				for(int i = 0; i < numStudents; i++) {

						//if(seating[i] != null) {
						
						
						msg("asks for student to come up");
						podium.release();
						Thread.sleep(40);
						msg(num+" gives diploma");
						picture.release();
						Thread.sleep(40);
						msg(num+" congratulates student");
						leavePodium.release();
						counter2++;
						nextStudent.acquire();
						//nextRow = false;
						if(counter2 == numStudents) {
							Thread.sleep(50);
							msg("invite everyone for some refreshments and snacks on the second floor");
							sitWait.release(numStudents*4);
						}
					//	}
						
						
					
				}
				leaving.acquire(numStudents);
		  		msg("leaves");
			  
				
			  }
				//ceremony ends and 

				//chairman invites everyone to go to second floor for food

				//everyone rushes using priority()
				  
				
				//students let family go through doors first using yield()
				  
				
				//random time for each student to talk to faculty and then leave
				  
				
				//family members join student and leave together
				 
				
				//chairman and coordinator leave together
					//ceremony ends and chairman and coordinator wait
			  		
				  catch (InterruptedException f) {
					  
				  }
			
		}
				
		  
		  
	}