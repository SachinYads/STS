package inheritance;

class BestAnimal{
	void vegfood() {
		System.out.println("here a veg food animal are present ");
	}
}



 class Animal extends BestAnimal{
    void eat() {
	 System.out.println("here we are eaten");
}

}
 class Dog extends Animal{
	 void food() {
		 System.out.println("here we are connect to each other");
	 }
 }
  
 
public class Test {

	public static void main(String[] args) {
    
		Dog d=new Dog();
		d.eat();
		d.food();
		d.vegfood();
		
	   Address add1=new Address("bengluru","krantka","india");
		Employee e1=new Employee(12,"raty",add1);
		Address add2=new Address("Lucknow","up","india");
		Employee e2=new Employee(13,"xcc",add2);
        e1.display();
        e2.display();
	}

}
