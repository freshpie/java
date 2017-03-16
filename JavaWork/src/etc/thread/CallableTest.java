package etc.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {
	public static void main(String[] arg){
		//Thread 설정
		ExecutorService executor = Executors.newFixedThreadPool(2);
		List<CallableTask> jobList = new ArrayList<CallableTask>();
		
		for(int i=0; i<6; i++){
			String data = String.valueOf(i);
			//Thread 적용
			jobList.add( new CallableTask(data) );
		}
		
		try {
			System.out.println("starting....");
			List<Future<String>> futureList = executor.invokeAll(jobList);	//모든 thread가 처리 될때까지 기다린다..
			
			System.out.println("All thread finish....");
			
			for(Future<String> future : futureList ) {
				String futureResult = future.get();
				System.out.println("result : "+ futureResult);
			}
			executor.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
