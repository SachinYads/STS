package string;

public class Testimmutablestring {

	public static void main(String[] args) {
//		String s="sachin";
//		 s= s.concat("Tendulakar");
//		System.out.println(s);
//		String s1="sachin";
//		String s2="SACHIN";
//		String s3=new String("sachin");
//		String s4="Ratan";
//		
//		System.out.println(s1.equals(s2));
//		System.out.println(s1.equalsIgnoreCase(s2));
//		System.out.println(s1==s3);
//		System.out.println(s1.compareTo(s));
//		StringBuilder s1 = new StringBuilder("Hello");    //String 1  
//		   StringBuilder s2 = new StringBuilder(" World");    //String 2  
//	        StringBuilder s = s1.append(s2);   //String 3 to store the result  
//	            System.out.println(s);  //Displays
		
		String s1=new String("Hello");
		String s2=new String("World");
		String s3=String.join(" ", s1,s2);
		System.out.println(s3.toString());
		System.out.println(s1.substring(2));

	}

}
