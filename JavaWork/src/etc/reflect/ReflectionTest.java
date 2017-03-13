package etc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import etc.annotation.MyAnnotation;
import etc.annotation.MyAnnotation2;

public class ReflectionTest {

	public static void main(String[] args) {
		try {
			//객체 생성
			Class class1 = Class.forName("etc.MyAnnotationTest");
			Object obj = class1.newInstance();
			Constructor c = class1.getConstructor(null); //String.class, Integer.Class...
			Object obj2 = c.newInstance(null);
			System.out.println(class1.getAnnotation(MyAnnotation.class));
			System.out.println(class1.getAnnotation(MyAnnotation2.class));
			System.out.println("-------------------------------------------");
			
			System.out.println(Class.forName("java.lang.String"));
			System.out.println(Class.forName("etc.reflect.TempClass"));
			System.out.println(Class.forName("etc.reflect.TempClass").getConstructor(null));
			
			TempClass temp = (TempClass)Class.forName("etc.reflect.TempClass").getConstructor(null).newInstance(null);
			temp.callMethod("호출 되다ㅎㅎ");
			
			Method[] mes = Class.forName("etc.reflect.TempClass").getDeclaredMethods();			
			for(Method m : mes){				
				System.out.println("method name : " + Modifier.toString(m.getModifiers()) + " " + m.getName());
			}
			
			TempClass temp2 = (TempClass)Class.forName("etc.reflect.TempClass").newInstance();
			temp2.callMethod("호출 되었다");
			Class.forName("etc.reflect.TempClass").getMethod("callMethod2").invoke(temp2);
			//Method method = Class.forName("etc.TempClass").getMethod("callMethod2");
			//method.invoke(temp2);
			
			Class.forName("etc.reflect.TempClass").getMethod("callMethod3").invoke(null);

			//Class.forName("etc.TempClass").getMethod("callMethod4");
			Method me = Class.forName("etc.reflect.TempClass").getDeclaredMethod("callMethod4");
			me.setAccessible(true);
			me.invoke(temp2);
			/* 
			--- INVOKE without setAccessible(true) ---
			java.lang.IllegalAccessException: Class etc.ReflectionTest can not access a member of class etc.TempClass with modifiers "private"
			at sun.reflect.Reflection.ensureMemberAccess(Unknown Source)
			at java.lang.reflect.AccessibleObject.slowCheckMemberAccess(Unknown Source)
			at java.lang.reflect.AccessibleObject.checkAccess(Unknown Source)
			at java.lang.reflect.Method.invoke(Unknown Source)
			at etc.ReflectionTest.main(ReflectionTest.java:42)
			*/
			
			/*
			--- using getMethod to 'private' modifier ---
			java.lang.NoSuchMethodException: etc.TempClass.callMethod4()
			at java.lang.Class.getMethod(Unknown Source)
			at etc.ReflectionTest.main(ReflectionTest.java:40)
			*/
			
			
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
