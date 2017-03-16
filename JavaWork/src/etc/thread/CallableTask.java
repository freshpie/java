package etc.thread;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {
	
	String data;
		
	public CallableTask(String data) {
		this.data = data;
	}
	
	@Override
	public String call(){
		System.out.println(this.data + " start!!");
		String result = "Called!!! with : " + this.data;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return result;	
	}
}
