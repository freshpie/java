package etc;

public class CallStackTest {

	public static void main(String[] args) {
		initMethod("first Call", 0);

	}
	public static void initMethod(String name, int number){
		callMethod(name, number);
	}
	public static void callMethod(String name, int number){
		//?��?��?? 같이 2?��?�� ?���??��출의 ?���? ?��?��
		//종료 조건 ?��까�? 첫번�? ?���??��출을 계속?��?��..
		//?��출때 마다 �??��?��?�� 조건?�� ?��겨주?�� 종료조건?�� 주어 ?��출한?��.
		//종료 조건?�� 만족?���? ?��?�� ?��출�? 종료?���? ?��출한 ?��?��?�� ?��?�� ?���?�? ?��출한?��.
		//?��번째 ?���?�? 종료조건?���? 종료 ?���? ?��출한 ?��?��?�� 종료(반환) ?��?��.....
		if(number < 2){
			number++;
			System.out.println(name + " | " + number);
			callMethod("callMethod1_" + number, number);
			callMethod("callMethod2_"+ number, number);
		}
	}

}
