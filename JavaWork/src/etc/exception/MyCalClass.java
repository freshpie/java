package etc.exception;

public class MyCalClass {
	public static int add(int a, int b) throws MyException{
		if(a<0 || b<0){
			throw new MyException("음수임;");
		}
		
		return (a+b);
	}
	
	
	public static void main(String[] arg){
		try {
			int v = add(10, -5);
			System.out.println(v);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
