package com.kt.push.service.external;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import com.ket.push.model.DaasPushVO;
import com.kt.push.main.Main;

import javapns.Push;
import javapns.devices.exceptions.InvalidDeviceTokenFormatException;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotifications;
import javapns.notification.ResponsePacket;

public class IOSPushService extends PushService implements Callable<Object> {
	DaasPushVO daasPushVO;
	PushNotificationPayload payload;
	
	public IOSPushService(DaasPushVO daasPushVO, PushNotificationPayload payload) {
		this.daasPushVO = daasPushVO;
		this.payload = payload;
	}

	@Override
	public Map<String, String> call(){
		String APNS_SSL_CERTIFICATE = Main.APNS_SSL_CERTIFICATE;//"src/cert/HomehubManager_dev.p12";
		String APNS_SSL_CERTIFICATE_PWD = Main.APNS_SSL_CERTIFICATE_PWD;//"newolleh";
		boolean isProduction = Main.IS_PRODUCTION; 
		
		Map<String, String> resultMap = new HashMap<String, String>();
		
		try {
			// payload, 인증서파일.p12, 인증서비빌번호, true/false, 디바이스 토큰값
			// true : 실서버 gateway.push.apple.com
			// false : 개발서버 gateway.sandbox.push.apple.com
			PushedNotifications notice = 
					Push.payload(payload, APNS_SSL_CERTIFICATE, APNS_SSL_CERTIFICATE_PWD, isProduction, daasPushVO.getTOKEN());

			resultMap.put("uid", String.valueOf(daasPushVO.getUID()));
			resultMap.put("result", String.valueOf(notice.get(0).isSuccessful()));
			if(notice.get(0).isSuccessful()){
				resultMap.put("status", "2");
				resultMap.put("message", "PUSH Success");
			}else{
				resultMap.put("status", "9");
				resultMap.put("message", "Fail");
				
				resultMap.put("message", notice.get(0).getException().getMessage());
				
				try {
					throw notice.get(0).getException();
				}catch (InvalidDeviceTokenFormatException ie){
					resultMap.put("message", "Invalid Token");
				}catch (Exception e){
					resultMap.put("message", notice.get(0).getException().getClass().getName() +"|" + notice.get(0).getException().getMessage());
				}
				
				ResponsePacket errorResponse = notice.get(0).getResponse();
				if (errorResponse != null) {
					resultMap.put("message", errorResponse.getMessage());
					if (errorResponse.getStatus() == 8) {
						String invalidToken = notice.get(0).getDevice().getToken();
						if(invalidToken != null){
							resultMap.put("message", "Invalid Token");
						}
					}
					//resultMap.put("responseMessage", errorResponse.getMessage());
					//resultMap.put("responseStatus", String.valueOf(errorResponse.getStatus()));
				}
			}
			resultMap.put("device", "IOS");
			//System.out.println(resultMap.toString());
			
		} catch (Exception e) {
			resultMap.put("uid", String.valueOf(daasPushVO.getUID()));
			resultMap.put("status", "5");
			resultMap.put("message", e.getClass().getName()+"|"+e.getMessage());
			e.printStackTrace();
		}
		return resultMap;
	}
}
