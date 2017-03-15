package java8;

interface Showable{
	void show();
	interface Message{
		void msg();
	}
}
class NestedInterface1 implements Showable.Message{
	public void msg(){
		System.out.println("Hello nested interface");
	}
}

public class NestedClassTest {
	//중첩 class 종류
	//1. non-static inner class
	//2. static inner class
	//3. anonymous class
	//4. local class
	public static void main(String[] args) {
		System.out.println("Nested interface Test!!");
		Showable.Message message = new NestedInterface1(); //upcasting...
		message.msg();
		System.out.println("--------------------------------------");
		
		method2();
		
		System.out.println("publicStaticInnerClass.staticMethod();");
		NestedClassTest.PublicStaticInnerClass.staticMethod();
		//PublicStaticInnerClass.staticMethod();
		System.out.println("--------------------------------------");
		
		System.out.println("publicStaticInnerClass.method();");
		PublicStaticInnerClass publicStaticInnerClass = new PublicStaticInnerClass();
		//NestedClassTest.PublicStaticInnerClass publicStaticInnerClass2 = new NestedClassTest.PublicStaticInnerClass();
		publicStaticInnerClass.method();
		System.out.println("--------------------------------------");
		
		System.out.println("privateStaticInnerClass.method();");
		PrivateStaticInnerClass privateStaticInnerClass = new PrivateStaticInnerClass();
		privateStaticInnerClass.method();
		System.out.println("--------------------------------------");
		
		/*Multiple markers at this line
		- The method PublicNonStaticInnerClass() is undefined for the type NestedClassTest
		- No enclosing instance of type NestedClassTest is accessible. 
			Must qualify the allocation with an enclosing instance of type NestedClassTest 
			(e.g. x.new A()where x is an instance of NestedClassTest).*/
		NestedClassTest nestedClassTest = new NestedClassTest();
		System.out.println("publicNonStaticInnerClass.method();");
		NestedClassTest.PublicNonStaticInnerClass publicNonStaticInnerClass = nestedClassTest.new PublicNonStaticInnerClass();
		publicNonStaticInnerClass.method();
		System.out.println("--------------------------------------");
		
		System.out.println("privateNonStaticInnerClass.method();");
		NestedClassTest.PrivateNonStaticInnerClass privateNonStaticInnerClass = nestedClassTest.new PrivateNonStaticInnerClass();
		privateNonStaticInnerClass.method();
		System.out.println("--------------------------------------");
	}
	public void method3() {
		PublicNonStaticInnerClass publicNonStaticInnerClass = new PublicNonStaticInnerClass();
		publicNonStaticInnerClass.method();
		
		PrivateNonStaticInnerClass privateNonStaticInnerClass = new PrivateNonStaticInnerClass();
		privateNonStaticInnerClass.method();
	}
	
	public void method1() {
		String localValue = "localValue";

		class LocalClass{
			//메소드 내부에서만 존재
			public void method(){
				System.out.println(publicStaticFiled);
				System.out.println(privateStaticFiled);
				System.out.println(publicNonStaticFiled);
				System.out.println(privateNonStaticFiled);
				
				//자바 1.7까지는 localClass가 지역변수에 접근 불가능 하였지만
				//1.8부터는 접근가능 하도록 변경되었다.
				System.out.println(localValue);
			}
		}
		System.out.println("localClass.method();");
		LocalClass localClass = new LocalClass();
		localClass.method();
		System.out.println("--------------------------------------");
	}
	public static void method2() {
		System.out.println("method2");
		class LocalClass{
			//메소드 내부에서만 존재
			public void method(){
				System.out.println(publicStaticFiled);
				System.out.println(privateStaticFiled);
				//System.out.println(publicNonStaticFiled);
				//System.out.println(privateNonStaticFiled);
			}
		}
		System.out.println("localClass.method();");
		LocalClass localClass = new LocalClass();
		localClass.method();
		System.out.println("--------------------------------------");
	}
	
	public static String publicStaticFiled = "publicStaticFiled";
	private static String privateStaticFiled = "privateStaticFiled";
	public String publicNonStaticFiled = "publicNonStaticFiled";
	private String privateNonStaticFiled = "privateNonStaticFiled";
	
	public static class PublicStaticInnerClass {
		public static String a1;
		private static String b1;
		public String c1;
		private String d1;
		
		public void method(){
			System.out.println(publicStaticFiled);
			System.out.println(privateStaticFiled);
			//System.out.println(publicNonStaticFiled);
			//System.out.println(privateNonStaticFiled);
		}
		public static void staticMethod(){
			System.out.println(publicStaticFiled);
			System.out.println(privateStaticFiled);
			//System.out.println(publicNonStaticFiled);
			//System.out.println(privateNonStaticFiled);
		}
	}
	private static class PrivateStaticInnerClass {
		public static String a2;
		private static String b2;
		public String c2;
		private String d2;
		
		public void method(){
			System.out.println(publicStaticFiled);
			System.out.println(privateStaticFiled);
			//System.out.println(publicNonStaticFiled);
			//System.out.println(privateNonStaticFiled);	
		}
	}
	public class PublicNonStaticInnerClass {
		//public static String a3;
		//private static String b3;
		public String c3;
		private String d3;
		
		public void method(){
			System.out.println(publicStaticFiled);
			System.out.println(privateStaticFiled);
			System.out.println(publicNonStaticFiled);
			System.out.println(privateNonStaticFiled);
		}
	}
	private class PrivateNonStaticInnerClass {
		//public static String a4;
		//private static String b4;
		public String c4;
		private String d4;
		
		public void method(){			
			System.out.println(publicStaticFiled);
			System.out.println(privateStaticFiled);
			System.out.println(publicNonStaticFiled);
			System.out.println(privateNonStaticFiled);
		}
	}
}
