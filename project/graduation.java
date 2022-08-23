package project;

public class graduation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("["+(System.currentTimeMillis()-System.currentTimeMillis())+"] "+": Program Start");
		
		int numStudent = 13;
		int rowCapacity = 4;
		int numRows = 11;
		
		//create and start coordinator and children	
		Chairman chairman = new Chairman(numStudent);
		Coordinator coordinator = new Coordinator(numRows, rowCapacity);
		coordinator.start();
		chairman.start();
		
		
		//create and starts student threads which in turn create and start family threads
		for (int i = 1; i <= numStudent; i++) {
		      Student student = new Student(Integer.toString(i));
		      student.start();
		    }
		

	}

}
