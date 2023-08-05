package abstraction;

interface circles{
	void print();
	
}


public class A6 implements circles {
    public void print(){
    	System.out.println("here is a circle");
    }
	public static void main(String[] args) {
      A6 obj=new A6();
      obj.print();
      Drawable d=new Rectangle();//In real scenario, object is provided by method e.g. getDrawable()  
      d.draw();
	
	}

}
interface Drawable{  
void draw();  
}  
//Implementation: by second user  
class Rectangle implements Drawable{  
public void draw(){System.out.println("drawing rectangle");}  
}  
class Circle implements Drawable{  
public void draw(){System.out.println("drawing circle");}  
}  
//Using interface: by third user  
