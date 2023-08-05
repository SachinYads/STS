package inheritance;

class Operations{
	int square(int n) {
		return n*n;
	}
}
class Circle{
	double pi=3.14;
	Operations operations;
	
	double area(int radius) {
		Operations op=new Operations();
		double Area=op.square(radius);
		return pi*Area;
		
	}
}





public class AggregationTest {
	
	public static void main(String[]args) {
		
		Circle c=new Circle();
		double ar=c.area(5);
		System.out.println(ar);
		
	}

}
