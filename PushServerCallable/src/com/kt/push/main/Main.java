package com.kt.push.main;

import java.util.Timer;
import java.util.TimerTask;

import com.kt.push.controller.MainController;

public class Main {
	public static void main(String[] args){
		System.out.println("=========Init Push Batch===============");
		try {
			final MainController mainController = new MainController();
			Timer timer = new Timer();
			TimerTask timerTask = new TimerTask() {
				
				@Override
				public void run() {
					System.out.println("=========Run Push Batch===============");
					mainController.run();
				}
			};
			
			// 5초마다 mainController 호출
			//timer.schedule(timerTask, 0, 5000);
			
			// 한번 mainController 호출
			timer.schedule(timerTask, 0);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
