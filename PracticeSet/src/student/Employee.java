package student;

public class Employee extends Person {
	private float salary;

	public Employee(String n, int a, String add,float s) {
		super(n, a, add);
		this.salary=s;
		
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
		

}
