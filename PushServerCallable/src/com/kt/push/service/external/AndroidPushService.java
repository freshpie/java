package com.kt.push.service.external;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.ket.push.model.DaasPushVO;
import com.kt.push.main.Main;

public class AndroidPushService extends PushService implements Callable<Map<String,String>> {
	private static final Logger logger = LoggerFactory.getLogger(AndroidPushService.class);
	
	Message message;
	Sender sender;
	DaasPushVO daasPushVO;
	
	public AndroidPushService(DaasPushVO daasPushVO, Sender sender, Message message) {
		this.message = message;
		this.sender = sender;
		this.daasPushVO = daasPushVO;
	}

	@Override
	public Map<String,String> call(){
		Result result = null;
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			result = sender.send(message, daasPushVO.getTOKEN(), 3);
			
			resultMap.put("result", String.valueOf(result.getMessageId()));
			resultMap.put("uid", String.valueOf(daasPushVO.getUID()));
			if(result.getMessageId() != null){
				resultMap.put("status", Main.SUCCESS_CODE);
				resultMap.put("message", "PUSH Success");
				resultMap.put("device", "Android");
			}else{
				resultMap.put("status", Main.FAIL_CODE);
				resultMap.put("message", "Fail");
				
				if(result.getErrorCodeName() != null){
					resultMap.put("errorCode", result.getErrorCodeName());
					resultMap.put("message", result.getErrorCodeName());
				}
			}
			resultMap.put("device", "Android");
			
		} catch (Exception e) {
			resultMap.put("uid", String.valueOf(daasPushVO.getUID()));
			resultMap.put("status", Main.FAIL_CODE);
			resultMap.put("message", e.getClass().getName()+"|"+e.getMessage());
			logger.error("An Exception was thrown at AndroidPushService.call() ", e);
			//e.printStackTrace();
		}
		return resultMap;
	}
}
