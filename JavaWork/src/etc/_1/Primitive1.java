package etc._1;

import java.util.ArrayList;
import java.util.List;

public class Primitive1 {
	public static void main(String[] agrs){
		List<String> strings = new ArrayList<String>();
		
		unsafeAdd(strings, new Integer(54));
		//safeAdd(strings, new Integer(54));
		String s= strings.get(0);
		System.out.println(s);
	}
	//원천타입을 그대로 사용하는 것은 unsafe하다는 걸 보여주는 극단적인 예
	private static void safeAdd(List<String> strings, Object o) {
		strings.add(String.valueOf((int)o));
	}
	private static void unsafeAdd(List strings, Object o) {
		strings.add(o);
	}
}
