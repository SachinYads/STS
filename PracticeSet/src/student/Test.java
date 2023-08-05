package student;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static  void main(String[]args) {
	 Student data1 =new Student("sachin",12,2333);
	 Student data2=new Student("rishu",12,2334);
	 Student data3=new Student("shivam",234,11);
	 Student data4=new Student();
	 Student data5=new Student(data3);
	 Student.change();
	 data1.display();
	 data2.display();
	 data3.display();
	 data4.display();
	 data5.display();
	 List<Student>data=new ArrayList<>();
	 data.add(data3);
	 data.add(data1);
	 data.add(data2);
	 data.add(data3);
	 data.add(data4);
	 data.add(data5);
	 System.out.println(data);
    int result=Student.cube(5);
     System.out.println(result);
     
     
    Employee emp=new Employee("sachin",34,"kanpur",340000);
     System.out.println("Name: "+emp.getName()+" Salary: "+emp.getSalary()+" Age: "+emp.getAge()+" Address: "+emp.getAddress()); 
     
     Adder add1=new Adder();
     System.out.println(Adder.add(2,3));
     System.out.println(Adder.add(2,3,4));
      add1.sum(20, 20);
	}
	}
