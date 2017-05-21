package a.study.day5;

//@Deprecated
//@SuppressWarnings({})
public class Ex003 {
	public static void main(String[] arg){
		class A{
			@Day5Annotation
			public void method(){
				System.out.println("call method");
			}
		}
		
		A a = new A();
		a.method();
		
	}
}
