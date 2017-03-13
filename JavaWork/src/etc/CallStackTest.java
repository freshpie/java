package etc;

public class CallStackTest {

	public static void main(String[] args) {
		initMethod("first Call", 0);

	}
	public static void initMethod(String name, int number){
		callMethod(name, number);
	}
	public static void callMethod(String name, int number){
		//?•„?˜?? ê°™ì´ 2?—°?† ?¬ê·??˜¸ì¶œì˜ ?˜¸ì¶? ?ˆœ?„œ
		//ì¢…ë£Œ ì¡°ê±´ ? „ê¹Œì? ì²«ë²ˆì§? ?¬ê·??˜¸ì¶œì„ ê³„ì†?•œ?‹¤..
		//?˜¸ì¶œë•Œ ë§ˆë‹¤ ë³??™?•˜?Š” ì¡°ê±´?„ ?„˜ê²¨ì£¼?–´ ì¢…ë£Œì¡°ê±´?„ ì£¼ì–´ ?˜¸ì¶œí•œ?‹¤.
		//ì¢…ë£Œ ì¡°ê±´?´ ë§Œì¡±?•˜ë©? ?•´?‹¹ ?˜¸ì¶œì? ì¢…ë£Œ?˜ê³? ?˜¸ì¶œí•œ ?•¨?ˆ˜?˜ ?‹¤?Œ ?¬ê·?ë¥? ?˜¸ì¶œí•œ?‹¤.
		//?‘ë²ˆì§¸ ?¬ê·?ê°? ì¢…ë£Œì¡°ê±´?œ¼ë¡? ì¢…ë£Œ ?˜ë©? ?˜¸ì¶œí•œ ?•¨?ˆ˜?Š” ì¢…ë£Œ(ë°˜í™˜) ?œ?‹¤.....
		if(number < 2){
			number++;
			System.out.println(name + " | " + number);
			callMethod("callMethod1_" + number, number);
			callMethod("callMethod2_"+ number, number);
		}
	}

}
