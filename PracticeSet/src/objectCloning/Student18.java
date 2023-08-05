package objectCloning;

 class Student18 {
	 
	private String name,city;
	private int id;
	public Student18(String name, String city, int id) {
		super();
		this.name = name;
		this.city = city;
		this.id = id;
	}
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		}  
	public static void main(String args[]){  				
		
		try{  
		Student18 s1=new Student18("amit","jaunpur",12);  
		  
		Student18 s2=(Student18)s1.clone();  
		  
		System.out.println(s1.name+" "+s1.id+" "+s1.city);  
		System.out.println(s2.id+" "+s2.name+" "+s2.city);  
		  
		}catch(CloneNotSupportedException c){}  
		  
		}  	
	

}
