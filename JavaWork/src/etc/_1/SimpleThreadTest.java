package etc._1;

public class SimpleThreadTest implements Runnable{

	public static void main(String[] args) {
		//NewClass newClass = new NewClass();
		//System.out.println(newClass.getClass().getName());
		Thread t = new Thread(new SimpleThreadTest());
		t.start();
		
	}

	@Override
	public void run() {
		System.out.println("run");
	}

}
