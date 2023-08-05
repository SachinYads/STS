package exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestThrow1 {
	
	public static void validate(int age) {
		if(age<18) {
			throw new ArithmeticException("Person is under age");
		}else {
			System.out.println("Person is valid for voting");
		}
	}
	public static void method() throws FileNotFoundException{
		FileReader file = new FileReader("C:\\Users\\Anurati\\Desktop\\abc.txt");  
        BufferedReader fileInput = new BufferedReader(file);  
  
      
        throw new FileNotFoundException();  
      
		
	}
	
	
	

	public static void main(String[] args) {
		//validate(13);
		try {
			method();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
