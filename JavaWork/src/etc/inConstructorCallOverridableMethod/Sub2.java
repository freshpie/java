package etc.inConstructorCallOverridableMethod;

import java.util.Date;

public class Sub2 extends Super {
	public Date date;
	
	public Sub2(){
		System.out.println("Sub2 생성자 호출");
		date = new Date();
		overrideMe();
	}
	
	@Override
	public void overrideMe(){
		System.out.println("Sub2에서 override되었음 : " + date);
	}
	
	public static void main (String[] arg){
		Sub2 sub = new Sub2();
	}
}
