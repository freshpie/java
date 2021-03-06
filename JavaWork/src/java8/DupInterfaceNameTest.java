package java8;

public class DupInterfaceNameTest {

	public static void main(String[] args) {
		//InterfaceImpl impl = new InterfaceImpl();
		//impl.interfaceMethod();
		
		//DupInterfaceImpl dupImpl = new DupInterfaceImpl();
		//dupImpl.customMethod();
		
		DupInterfaceImpl3 dup2 = new DupInterfaceImpl3();
		dup2.interfaceMethod();
		
	}		
}

//default 메소드는 기본적으로 하위호환성을 위하여 사용된다.
//다중 인터페이스 구현시 기존 구현 메소드를 사용하길 원한다면 
//메소드 오버라이드 내용에 상위 인터페이스에서 default 키워드가 사용된 메소드를 호출해 준다...
class InterfaceImpl implements Interface1{
	@Override
	public void interfaceMethod() {
		System.out.println("Interface1 interfaceMethod");
	}
	@Override
	public void interfaceMethod1() {
		System.out.println("Interface1 interfaceMethod1");
	}
}

class DupInterfaceImpl implements Interface3, Interface4{
	//중복되는 인터페이스가 있으면 동일하게 처리(defalut 메소드 없음)
	@Override
	public void interfaceMethod4() {}

	@Override
	public void interfaceMethod() {}

	@Override
	public void interfaceMethod2() {}
	
	public void customMethod(){
		System.out.println("asdf");
	}
}

class DupInterfaceImpl2 implements Interface1, Interface2{
	//default 메소드가 구현하는 인터페이스에 중복으로 존재하면
	//둘중 하나를 오버라이드 해주어야 한다(모호함 제거)
	@Override
	public void interfaceMethod2() {
	}

	@Override
	public void interfaceMethod1() {
	}

	@Override
	public void interfaceMethod() {
		Interface1.super.interfaceMethod();
		System.out.println("DupInterfaceImpl2 interfaceMethod");
	}
	//OR
	/*@Override
	public void interfaceMethod() {
		Interface2.super.interfaceMethod();
	}*/

}
class DupInterfaceImpl3 implements Interface1, Interface3{
	//구현하는 인터페이스에 동일한 이름을 가진 메소드가 존재하고
	//어느것은 default 메소드 일때도 명시적으로 오버라이드 하여 모호함을 제거 해야 한다.
	@Override
	public void interfaceMethod2() {}

	@Override
	public void interfaceMethod1() {}

	//@Override
	//public void interfaceMethod() {
	//	System.out.println("DupInterfaceImpl3 interfaceMethod");
	//}
	//OR
	//@Override
	public void interfaceMethod() {
		Interface1.super.interfaceMethod();
		System.out.println("DupInterfaceImpl3 interfaceMethod");
	}
}