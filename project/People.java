package project;
import java.util.concurrent.Semaphore;

public class People {
	  public static long time = System.currentTimeMillis();
	  static volatile int rowCapacity;
	  static volatile int numRows;
	  static volatile int currentSeat = 0;
	  static volatile int currentSeatf = 0;
	  static volatile Student[] seating;
	  static volatile int numStudents;
	  static volatile int counter1 = 0;//everyone seated
	  static volatile int counter2 = 0;//everyone has diploma
	  static volatile int counter3 = 0;//everyone leaves
	//  static volatile boolean coordinatorSignal = true;
	//  static volatile boolean chairmanSignal = true;
	  static volatile boolean nextRow = false;
	  
	  
	  //project 2
	  static Semaphore coordinatorSignal = new Semaphore(0,true);
	  static Semaphore sitWait = new Semaphore(0,true);
	  static volatile int sitWaitCounter = 0;
	  static Semaphore chairmanSignal = new Semaphore(0,true);
	  static Semaphore speechSignal = new Semaphore(0,true);
	  static Semaphore seated = new Semaphore(0,true);
	  static Semaphore podium = new Semaphore(0,true);
	  static Semaphore picture = new Semaphore(0,true);
	  static Semaphore leavePodium = new Semaphore(0,true);
	  static Semaphore nextStudent = new Semaphore(0,true);
	  static Semaphore nextStudentCoordinator = new Semaphore(1,true);
	  static Semaphore ask = new Semaphore(1,true);
	  static Semaphore leaving = new Semaphore(0,true);
	  static Semaphore leavingCoordinator = new Semaphore(0,true);
	  static Semaphore mutex = new Semaphore(1,true);

}
