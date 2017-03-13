package etc.Array;

import java.util.Arrays;
import java.util.List;

public class ArrayTest {

	public static void main(String[] args) {
		setStrings("a", "b", "c");
		setStrings2(new String[]{"1", "2", "3"});
		
		System.out.println("--------------------------");
		String[] arr1 = {"a","b","c"};
		String[] arr2 = {"d","e","f"};
		String[] arr3 = {"g","h","i"};
		List<String[]> list1 = Arrays.asList(arr1, arr2, arr3);
		for(String[] i : list1){
			for(String j : i){
				System.out.println(j);
			}
		}
		
		System.out.println("--------------------------");
		String str1 = "t";
		String str2 = "v";
		String str3 = "n";
		List<String> list2 = Arrays.asList(str1, str2, str3);
		for(String i : list2){
			System.out.println(i);
		}
	}
	
	public static void setStrings(String... strings){	//가변 입력 처리
		int length = strings.length;
		for(int i=0;i<length;i++){
			System.out.println(strings[i]);
		}
	}
	public static void setStrings2(String[] strings){
		int length = strings.length;
		for(int i=0;i<length;i++){
			System.out.println(strings[i]);
		}
	}
}
