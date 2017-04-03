package com.kt.push.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.json.JSONException;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Sender;
import com.ket.push.model.DaasPushListVO;
import com.ket.push.model.DaasPushVO;
import com.kt.push.main.Main;
import com.kt.push.service.external.AndroidPushService;
import com.kt.push.service.external.IOSPushService;
import com.kt.push.service.external.PushService;
import com.kt.push.service.internal.DaasPSPService;
import com.kt.push.util.HttpClient;

import javapns.notification.PushNotificationPayload;

public class MainController {
	public void run() {
		try {
			System.out.print("[" + new Date() + "] run.. ");
			// PUSH 발송 대상 조회
			DaasPSPService daasPSPService = new DaasPSPService();
			DaasPushListVO daasPushListVO = daasPSPService.getPushList();
			System.out.println("target count : "+ daasPushListVO.getPUSHLIST().size());
			
			
			Message message = null;
			Sender sender = null;
			String apiKey = Main.API_KEY;//"AIzaSyAB80eAU0zEVBCXrPeBMhIlOYqnH5Kmm78";
			String alert = "";
			String msg = "";
			String uid = "";
			int badge = 0;
			String group = "";

			ExecutorService executor = Executors.newFixedThreadPool(10);
			List<PushService> jobList = new ArrayList<PushService>();
			
			PushNotificationPayload payload = null;
			
			for (DaasPushVO daasPushVO : daasPushListVO.getPUSHLIST()) {
				group = daasPushVO.getCLASS1();
				uid = String.valueOf(daasPushVO.getUID());
				
				if ("FREE".equals(group)) {
					alert = "K-Talk 자유게시판" + "|" + group + "|" + daasPushVO.getCLASS2();
					msg = daasPushVO.getTITLE();
                } else if ("NOTI".equals(group)) {
                    alert = "K-Talk 공지사항" + "|" + group + "|" + daasPushVO.getCLASS2();
                    msg = daasPushVO.getTITLE();
                } else if ("VOC".equals(group)) {
                	alert = "K-Talk 기술지원요청" + "|" + group + "|" + daasPushVO.getCLASS2();
                    msg = daasPushVO.getTITLE();
                } else if ("BAND".equals(group)) {
                	alert = "K-Talk BAND" + "|" + group + "|" +daasPushVO.getCLASS2();
                    msg = daasPushVO.getTITLE();
                } else if ("LOGIN".equals(group)) {
                	alert = "K-Talk 가입" + "|"+ group + "|" + "0";
                    msg = daasPushVO.getTITLE();
                }
				
				if ("AD".equals(daasPushVO.getDEVICE_TYPE())) {
					sender = new Sender(apiKey);
					message = new Message.Builder()
							.addData("alert", msg)
							.addData("badge", String.valueOf(badge))
							.addData("url", alert)
							.addData("pushid", uid)
							.build();
					
					jobList.add( new AndroidPushService(daasPushVO, sender, message) );
					
				} else if ("IP".equals(daasPushVO.getDEVICE_TYPE())) {
					try {
						payload = PushNotificationPayload.complex();
						payload.addAlert(msg);
						payload.addBadge(badge);
						payload.addCustomDictionary("url", alert);
						payload.addCustomDictionary("pushid", uid);
						//System.out.println(payload);
						/*rawJson = "{\"aps\":"
								+ "{\"alert\":\"" + msg + "\","
								+ "\"badge\":" + badge + "}"
							+ ",\"url\":\"" + alert + "\""
							+ ",\"pushid\":\"" + uid + "\"}";
						System.out.println(rawJson);
						payload = PushNotificationPayload.fromJSON(rawJson);*/
						
						jobList.add( new IOSPushService(daasPushVO, payload) );
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			}
			
			List<Future<Map<String,String>>> futureList = executor.invokeAll((Collection)jobList);

			for(Future<Map<String,String>> future : futureList ) {
				Map<String, String> resultMap = null;
				try {
					resultMap = (Map<String,String>)future.get();
				} catch (ExecutionException e) {
					e.printStackTrace();
				} finally {
					if(resultMap != null){
						savePushResult(resultMap);
					}
				}
			}
			executor.shutdown();
			
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	private void savePushResult(Map<String, String> r) {
		//System.out.println("device : "+ r.get("device") + ", UID : " + r.get("uid") + ", status :  "+ r.get("status") + ", result :  "+ r.get("result"));
		try {
			String callUrl = "http://" + Main.SERVER_IP + "/DAAS/Web/RemoteControl.aspx?PSP=DaasPSP&PSO=DaasSO&BO=SetDaasPushReport&UID="+r.get("uid") +"&MESSAGE="+URLEncoder.encode((String)r.get("message"), "UTF-8") +"&STATUS="+r.get("status") +"&Channel=CC";
			//System.out.println(httpClient.doGet(callUrl));
			HttpClient.doGet(callUrl);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
