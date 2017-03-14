package etc.inConstructorCallOverridableMethod;

import java.util.Date;

public final class Sub extends Super {
	private final Date date;
	
	Sub(){
		System.out.println("Sub 생성자 호출");
		date = new Date();
		overrideMe();
	}
	
	@Override
	public void overrideMe(){
		date.getTime(); //NullPointerException 예외 발생!!!
		System.out.println("Sub에서 override되었음 : " + date);
	}
	
	public static void main (String[] arg){
		Sub sub = new Sub();
		
		/*  --- 결과 ---
		Super 생성자 호출
		Sub에서 override되었음 : null
		Sub 생성자 호출
		Sub에서 override되었음 : Tue Mar 14 15:15:52 KST 2017
		
		단순히 Sub의 생성자가 호출 될때 암묵적으로 부모(Super)의 생성자가 호출되는 구조에서
		Super의 생성자가 호출 되고 그 생성자가 호출하는 메소드를 수행하고 
		Sub의 생성자를 호출하고 Sub가 override한 메소드를 수행 할 것 같지만...
		
		override된 메소드의 스냅샷은 override된 후의 스냅샷을 가진다 override대상의 원형 메소드는 무시됨
		때문에 Super의 생성자에서 호출하고 있는 메소드는 이미 override가 된 메소드만을 바라보게 되어
		실행시에 원형 메소드가 수행되지 않고 override된 메소드가 수행된다...
		
		--만약 override된 메소드에서 부모클래스에 존재하지 않는 객체를 사용하고 있다면
		부모클래스의 생성자에서 override된 메소드가 호출 될때 해당 객체는 null 이므로
		NullPointerException 예외가 발생하게 된다.
		
		*/
	}
}
