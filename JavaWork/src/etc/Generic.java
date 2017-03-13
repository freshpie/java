package etc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Generic {
	public static void main(String[] arg){
		MyClass<Integer, String, Long, String, List<String>> myClass = new MyClass<Integer, String, Long, String, List<String>>();
		System.out.println(myClass.getData());
		myClass.setData(123);
		myClass.setOperator("add");
		myClass.setData1(Long.MAX_VALUE);//9223372036854775807
		myClass.setData2("아무 문자열");
		List<String> arr = new ArrayList<String>();
		arr.add("1등");
		arr.add("수렴");
		myClass.setData3(arr);
		//myClass.setData3("String"); error
		
		System.out.println(myClass.getData());
		System.out.println(myClass.getOperator());
		System.out.println(myClass.getData1());
		System.out.println(myClass.getData2());
		System.out.println(myClass.getData3());
		
		
		//MyClass2<A extends String ,B extends Collections, C extends Integer>
		MyClass2<String, Vector<String>, Integer> myClass1 = new MyClass2<String, Vector<String>, Integer>();
		MyClass2<String, List<String>, Integer> myClass2 = new MyClass2<String, List<String>, Integer>();
		myClass2.setData1("아무 문자열");//9223372036854775807
		ArrayList<String> arr2= new ArrayList<String>();
		myClass2.setData2(arr2);
		
		System.out.println(myClass2.getData1());
		System.out.println(myClass2.getData2());
		
		//myClass2.setData3(9223372036854775807);
		//System.out.println(Integer.MAX_VALUE);//2147483647
		myClass2.setData3(2147483647-1);
		System.out.println("int max -1: "+ myClass2.getData3());
		myClass2.setData3(2147483647);
		System.out.println("int max   : "+ myClass2.getData3());
		myClass2.setData3(2147483647+1);
		System.out.println("int max +1: "+ myClass2.getData3());
		
		putData(arr);
		//putData2(124);
		putData2("어떤 문자열?");
		
		putData3(myClass2);
	}
	
	public static <T> void putData(T data){
		System.out.println(data);
	}
	public static <T extends String> void putData2(T data){
		System.out.println(data);
	}
	public static void putData3(MyClass2<?,?,?> data){
		System.out.println("--------putData3---------");
		System.out.println(data.getData1());
		System.out.println(data.getData2());
		System.out.println(data.getData3());
		//?의 경우 어떤 타입이 오는지 알 수 없을때 사용한다.
		//어떤 타입이 오는지 모르기 때문에 당연히 값 설정이 불가
		//System.out.println(data.setData3(123));
		System.out.println("-------------------------");
	}
}

class MyClass<E,T,A,B,C>{
	E data;
	T operator;
	A data1;
	B data2;
	C data3;
	
	public MyClass(){
		System.out.println("MyClass init");
		this.data = (E)"2222";
	}
	
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public T getOperator() {
		return operator;
	}
	public void setOperator(T operator) {
		this.operator = operator;
	}
	public A getData1() {
		return data1;
	}
	public void setData1(A data1) {
		this.data1 = data1;
	}
	public B getData2() {
		return data2;
	}
	public void setData2(B data2) {
		this.data2 = data2;
	}
	public C getData3() {
		return data3;
	}
	public void setData3(C data3) {
		this.data3 = data3;
	}
}

class MyClass2<A extends String ,B extends Collection, C extends Integer>{
	A data1;
	B data2;
	C data3;
	
	public A getData1() {
		return data1;
	}
	public void setData1(A data1) {
		this.data1 = data1;
	}
	public B getData2() {
		return data2;
	}
	public void setData2(B data2) {
		this.data2 = data2;
	}
	public C getData3() {
		return data3;
	}
	public void setData3(C data3) {
		this.data3 = data3;
	}
}
