package exception;

public class FinallyBlock {

	public static void main(String[] args) {
	//When an exception does not occur
//		try {
//			int data=25/5;
//			System.out.println(data);
//		}catch(NullPointerException  e) {
//			System.out.println("NullPointerException ");
//			
//			
//		}finally {
//			System.out.println("Nothing print");
//		}
//		System.out.println("rest of the code");
		
  // When exception does occur
		try {
			int data=25/0;
			System.out.println(data);
		}catch(NullPointerException e) {
			System.out.println("NullPointerException");
		}finally {
			System.out.println("Nothing print");

		}
		System.out.println("rest of the code");

	}
		

}
