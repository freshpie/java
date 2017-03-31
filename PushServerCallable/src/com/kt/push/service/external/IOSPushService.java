package com.kt.push.service.external;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import com.ket.push.model.DaasPushVO;

import javapns.Push;
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
		String APNS_SSL_CERTIFICATE = "src/cert/HomehubManager_dev.p12";
		String APNS_SSL_CERTIFICATE_PWD = "newolleh";
		Map<String, String> resultMap = new HashMap<String, String>();
		
		try {
			// payload, 인증서파일.p12, 인증서비빌번호, true/false, 디바이스 토큰값
			// true : 실서버 gateway.push.apple.com
			// false : 개발서버 gateway.sandbox.push.apple.com
			PushedNotifications notice = 
					Push.payload(payload, APNS_SSL_CERTIFICATE, APNS_SSL_CERTIFICATE_PWD, true, daasPushVO.getTOKEN());

			resultMap.put("uid", String.valueOf(daasPushVO.getUID()));
			resultMap.put("result", String.valueOf(notice.get(0).isSuccessful()));
			if(notice.get(0).isSuccessful()){
				resultMap.put("status", "2");
				resultMap.put("message", "PUSH Success");
			}else{
				ResponsePacket errorResponse = notice.get(0).getResponse();
				/*if (errorResponse != null) {
					if (errorResponse.getStatus() == 8) {
						String invalidToken = notice.get(0).getDevice().getToken();
					}
				}*/
				resultMap.put("status", "5");
				resultMap.put("message", "Fail");
				if(errorResponse != null){
					resultMap.put("responseMessage", errorResponse.getMessage());
					resultMap.put("responseStatus", String.valueOf(errorResponse.getStatus()));
				}
			}
			
			resultMap.put("device", "IOS");
			
			System.out.println(resultMap.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultMap;
	}
}
