package a.study.day5;

import java.util.ArrayList;
import java.util.List;

//@SuppressWarnings("unchecked")
public class Ex001 {
	public void a (){
		List<String> strings = new ArrayList<String>();
		
		//safe1(strings, new Integer(40));
		//safe2(strings, new Integer(40));
		//safe3(strings, new Integer(40));
		//safe4(strings, new Integer(40));
	}

	//private void safe1(List<Object> strings, Integer integer) { strings.add(integer); }
	//private void safe2(List<?> strings, Integer integer) { strings.add(integer); }
	//private void safe3(List<? extends String> strings, Integer integer) { strings.add(integer); }
	//private void safe4(List strings, Integer integer) { strings.add(integer); }
}
