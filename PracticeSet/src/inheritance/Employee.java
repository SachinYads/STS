package inheritance;

public class Employee {
	int id;
	String name;
	Address address;
	public Employee(int id,String name,Address address) {
		this.address=address;
		this.id=id;
		this.name=name;
		
			}
	
	void display() {
		System.out.println("id="+id+"  "+"Employee Name="+name);
		System.out.println("city="+address.city+" "+"state="+address.state+" "+"country="+address.country);
	}

}
