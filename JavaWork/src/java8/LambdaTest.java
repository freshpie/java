package java8;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaTest {

	public static void main(String[] args) {
		String[] arr1 = new String[]{"asdf","qwe","qw","asdfe"};
		int[] arr = new int[]{4,1,5,2,1,1,7,8};
		//Arrays.sort(arr1, new CSort());
		//System.out.println(Arrays.toString(arr1));
		
		//Arrays.sort(arr1, (o1, o2)-> Integer.compare(o1.length(), o2.length()) );
		//System.out.println(Arrays.toString(arr1));
		
		//Arrays.sort(arr1, String::compareToIgnoreCase);
		//System.out.println(Arrays.toString(arr1));
		
		Arrays.sort(arr1, (s1, s2)-> s1.compareToIgnoreCase(s2));
		System.out.println(Arrays.toString(arr1));
		
		repeatMsg("Start Thread", 5);
			
	}
	static int count2 =0;
	public static void repeatMsg(String text, int count){
		count2 = count;
		Runnable r = ()->{
			while(count2 > 0){
				System.out.println(count2);
				count2--;
				System.out.println(text);
				Thread.yield();
			}
		};
		new Thread(r).start();
	}
	/*public static void repeatMsg2(String text, int count){
		Runnable r = ()->{
			while(count > 0){
				System.out.println(count2);
				count--;
				System.out.println(text);
				Thread.yield();
			}
		};
		new Thread(r).start();
	}*/
}

class CSort implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return Integer.compare(o1.length(), o2.length());
	}
	
}
