package inheritance;

class Bank{
	int getrateofintreset() {
		return 0;
	}
}
class SBI extends Bank{
	int getrateofintreset() {
		return 8;
	}
}
class ICC extends Bank{
	int getrateofintreset() {
		return 7;
	}
}
class AXIS extends Bank{  
int getRateOfInterest(){return 9;}  
}  

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Bank b=new SBI();
    System .out.println("SBI rate of intrest="+ b.getrateofintreset());
    
	}

}
