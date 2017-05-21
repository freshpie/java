package a.study.day6.concurrentprogramming;

import java.text.NumberFormat;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Ex001 {
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				//리턴할 수 없다...
			}
		};
		Thread t1 = new Thread(r1);
		
		
		
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		String won = currencyFormat.format(Double.parseDouble("234274582734"));
		System.out.println(won);
		
		
		ExecutorService exec = Executors.newCachedThreadPool();
		Future<String> result = exec.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				TimeUnit.SECONDS.sleep(1);
				
				Thread t2 = new Thread(() -> {
					while(true){
						System.out.println("t2 running....");
					}
				});
				//t2.start();
				return "end";
			}
		});
		
		
//		while(true){
//			System.out.println(result.isDone());
//			TimeUnit.MILLISECONDS.sleep(100);
//		}
		
//		System.out.println(result.get());
		exec.shutdown();
		
		Thread t3 = new Thread(() -> {
			try {
				Thread t3_1 = new Thread(() -> {
					try {
						while(true){
							System.out.println("t3_1 running...");
							TimeUnit.SECONDS.sleep(2);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				t3_1.setDaemon(true);
				t3_1.start();
				while(true){
					System.out.println("t3 running...");
					TimeUnit.SECONDS.sleep(2);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t3.setDaemon(true);
		t3.start();
		
		System.out.println("프로그램 종료 ");
	}
}
