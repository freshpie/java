package com.kt.push.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import com.kt.push.controller.MainController;

public class Main {
	public static String API_KEY;
	public static String APNS_SSL_CERTIFICATE;
	public static String APNS_SSL_CERTIFICATE_PWD;
	public static boolean IS_PRODUCTION;
	
	public static void main(String[] args){
		System.out.println("=========Init Push Batch===============");
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("config.properties");
			prop.load(input);
			input.close();

			System.out.println("-----configuration-----");
			API_KEY = prop.getProperty("API_KEY");
			APNS_SSL_CERTIFICATE = prop.getProperty("APNS_SSL_CERTIFICATE");
			APNS_SSL_CERTIFICATE_PWD = prop.getProperty("APNS_SSL_CERTIFICATE_PWD");
			IS_PRODUCTION = Boolean.parseBoolean(prop.getProperty("IS_PRODUCTION"));
			System.out.println("--API_KEY : "+ API_KEY);
			System.out.println("--APNS_SSL_CERTIFICATE : "+ APNS_SSL_CERTIFICATE);
			System.out.println("--APNS_SSL_CERTIFICATE_PWD : "+ APNS_SSL_CERTIFICATE_PWD);
			System.out.println("--IS_PRODUCTION : "+ IS_PRODUCTION);
			System.out.println("------------------------");
			
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
			
		} catch (FileNotFoundException fne){
			System.out.println("'config.properties' is not found.");
		} catch (SecurityException se){
			System.out.println("can not read 'config.properties'.");
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
