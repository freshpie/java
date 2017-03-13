package etc.annotation;

@MyAnnotation(id = "2", name = "MyAnnotationTest", num = 1)
public class MyAnnotationTest {
	
	
	@MyAnnotation(id = "1", name = "1", num = 1)
	String a;
	//@MyAnnotation2    //annotation target 설정에 따라 필드에서는 에러
	String b;
	
	@MyAnnotation(id = "1", name = "1", num = 1)
	public void myMethod(){	}
	
	public static void main(String[] arg){
		System.out.println("MyAnnotationTest에 설정된 annotation은 ? "+ MyAnnotationTest.class.getAnnotation(MyAnnotation.class));
		System.out.println("MyAnnotationTest에 설정된 annotation은 ? "+ MyAnnotationTest.class.getAnnotation(MyAnnotation2.class));
		
		System.out.println("MyAnnotationTest는 Annotation 인가 ? " + MyAnnotationTest.class.isAnnotation());
		System.out.println("MyAnnotation는 Annotation 인가 ? " + MyAnnotation.class.isAnnotation());
		System.out.println("MyAnnotation2는 Annotation 인가 ? " + MyAnnotation2.class.isAnnotation());
		
		System.out.println("MyAnnotationTest는 MyAnnotation 으로 표현된다 : " + MyAnnotationTest.class.isAnnotationPresent(MyAnnotation.class));
		System.out.println("MyAnnotationTest는 MyAnnotation2 로 표현된다 : " + MyAnnotationTest.class.isAnnotationPresent(MyAnnotation2.class));
		
		System.out.println("-------------------------------------------");
		
		printClassInfo(MyAnnotationTest.class);
	}
	public static void printClassInfo(Class<?> clazz){
		MyAnnotation ann = clazz.getAnnotation(MyAnnotation.class);
		
		System.out.println(ann.date());
		System.out.println(ann.id());
		System.out.println(ann.name());
		System.out.println(ann.num());
		
	}
}

