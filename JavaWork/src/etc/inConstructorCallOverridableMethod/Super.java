package etc.inConstructorCallOverridableMethod;

public class Super {
	//생성자에서 오버라이드 가능한 메소드를 호출 하는 경우 예제
	public Super(){
		System.out.println("Super 생성자 호출");
		overrideMe();
	}
	public void overrideMe(){
		System.out.println("Super의 overrideMe 호출");
	}
}
