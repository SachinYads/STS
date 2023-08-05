package student;

public class Person {
	private String name;
	private int age;
	private String address;
	
	public Person(String n,int a,String add) {
		 this.name=n;
		 this.age=a;
		 this.address=add;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
