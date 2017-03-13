package etc;

public class Recursive {

	public static void main(String[] args) {
		int input = 4;
		
		System.out.println(fact(input));
	}

	public static int fact(int n) {
		if (n <= 1){
			System.out.println(n);
			return n;
		}else{
			System.out.println(n);
			return fact(n-1) * n;
		}
	}

}
