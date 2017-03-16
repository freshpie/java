package etc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i=0; i<10; i++){
			executor.execute(new MyTask());
		}
		executor.shutdown();
		
		while(!executor.isTerminated()){
			
		}
		System.out.println("finish all thread");
	}

}
