package etc.reflect;

public class TempClass {

	public TempClass() {
		super();
		System.out.println("TempClass Init");
	}
	
	public void callMethod(String msg){
		System.out.println(msg);
	}
	public void callMethod2(){
		System.out.println("신기하게 호출되었다.");
	}
	public static void callMethod3(){
		System.out.println("스태틱 메소스가 호출되었다.");
	}
	private void callMethod4(){
		System.out.println("private 메소드가 호출되었다.");
	}
}
