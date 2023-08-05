package student;

public class Student {
	private String name;
	private int roll;
	private int id;
	static String college="ITS";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + ", id=" + id + "]";
	}
	public Student(String n, int r, int i) {
		super();
		name = n;
		roll = r;
		id = i;
	}
	public Student()
	{
		
	}
	public Student(Student s) {
		name=s.name;
		roll=s.roll;
		id=s.id;
		System.out.println(s);
		
	}
	public void display() {
		System.out.println(name+" "+roll+" "+id+"   "+college);
	}
	public static void change() {
		college="BBDTC";
	}
	public static  int cube(int x) {
		return x*x*x;
	}

}
