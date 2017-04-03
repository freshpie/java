package com.kt.push.service.external;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.ket.push.model.DaasPushVO;

public class AndroidPushService extends PushService implements Callable<Object> {
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
			result = sender.sendNoRetry(message, daasPushVO.getTOKEN());
			
			resultMap.put("result", String.valueOf(result.getMessageId()));
			resultMap.put("uid", String.valueOf(daasPushVO.getUID()));
			if(result.getMessageId() != null){
				resultMap.put("status", String.valueOf(2));
				resultMap.put("message", "PUSH Success");
				resultMap.put("device", "Android");
			}else{
				if(result.getErrorCodeName() != null){
					resultMap.put("status", String.valueOf(9));
					resultMap.put("errorCode", result.getErrorCodeName());
					resultMap.put("message", result.getErrorCodeName());
				}
			}
			resultMap.put("device", "Android");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultMap;
	}
}
