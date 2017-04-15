package etc._1;

public class CallStackTest {

	public static void main(String[] args) {
		initMethod("first Call", 0);

	}
	public static void initMethod(String name, int number){
		callMethod(name, number);
	}
	public static void callMethod(String name, int number){
		//아래와 같이 2연속 재귀호출의 호출 순서
		//종료 조건 전까지 첫번째 재귀호출을 계속한다..
		//호출때 마다 변동하는 조건을 넘겨주어 종료조건을 주어 호출한다.
		//종료 조건이 만족하면 해당 호출은 종료되고 호출한 함수의 다음 재귀를 호출한다.
		//두번째 재귀가 종료조건으로 종료 되면 호출한 함수는 종료(반환) 된다.....
		if(number < 2){
			number++;
			System.out.println(name + " | " + number);
			callMethod("callMethod1_" + number, number);
			callMethod("callMethod2_"+ number, number);
		}
	}

}
