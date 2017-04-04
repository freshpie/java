package com.kt.push.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kt.push.controller.MainController;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static String API_KEY = "";
	public static String APNS_SSL_CERTIFICATE = "";
	public static String APNS_SSL_CERTIFICATE_PWD = "";
	public static boolean IS_PRODUCTION = true;
	public static long RUN_INTERVAL = 10000;
	public static String SERVER_IP = "";
	
	public static void main(String[] args){
		logger.info("=========Init Push Batch===============");
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("config.properties");
			prop.load(input);
			input.close();
			
			File f = new File("logconfig.xml");
		    if (!f.isFile()) {
		    	throw new FileNotFoundException("logconfig.xml");
		    }f=null;

			logger.info("-----configuration-----");
			API_KEY = prop.getProperty("API_KEY");
			APNS_SSL_CERTIFICATE = prop.getProperty("APNS_SSL_CERTIFICATE");
			APNS_SSL_CERTIFICATE_PWD = prop.getProperty("APNS_SSL_CERTIFICATE_PWD");
			IS_PRODUCTION = Boolean.parseBoolean(prop.getProperty("IS_PRODUCTION"));
			RUN_INTERVAL = Long.parseLong(prop.getProperty("RUN_INTERVAL"));
			SERVER_IP = prop.getProperty("SERVER_IP");
			logger.info("--API_KEY : "+ API_KEY);
			logger.info("--APNS_SSL_CERTIFICATE : "+ APNS_SSL_CERTIFICATE);
			logger.info("--APNS_SSL_CERTIFICATE_PWD : "+ APNS_SSL_CERTIFICATE_PWD);
			logger.info("--IS_PRODUCTION : "+ IS_PRODUCTION);
			logger.info("--RUN_INTERVAL : "+ RUN_INTERVAL);
			logger.info("--SERVER_IP : "+ SERVER_IP);
			logger.info("------------------------");
			
			final MainController mainController = new MainController();
			Timer timer = new Timer();
			TimerTask timerTask = new TimerTask() {
				@Override
				public void run() {
					mainController.run();
				}
			};
			// 5초마다 mainController 호출
			logger.info("=========Run Push Batch===============");
			timer.schedule(timerTask, 0, RUN_INTERVAL);
			
			// 한번 mainController 호출
			//timer.schedule(timerTask, 0);
			
		} catch (FileNotFoundException fne){
			if("logconfig.xml".equals(fne.getMessage())){
				logger.error("'"+fne.getMessage()+"' is not found.");
			}else{
				logger.error("'config.properties' is not found.");
			}
			//fne.printStackTrace();
		} catch (SecurityException se){
			logger.error("can not read 'config.properties'.");
			//se.printStackTrace();
		} catch (IOException ex) {
			logger.error("An IOException was thrown at main() ", ex); 
			//ex.printStackTrace();
		} catch (Exception e){
			logger.error("An Exception was thrown at main()  ", e); 
			//e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error("An IOException was thrown at thrown input.close() ", e); 
					//e.printStackTrace();
				}
			}
		}
	}
}
