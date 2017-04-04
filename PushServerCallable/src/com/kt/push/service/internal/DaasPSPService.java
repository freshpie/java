package com.kt.push.service.internal;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ket.push.model.DaasPushListVO;
import com.kt.push.main.Main;
import com.kt.push.util.HttpClient;

public class DaasPSPService {
	private static final Logger logger = LoggerFactory.getLogger(HttpClient.class);
	
	private final static String DEV_URL = "http://" + Main.SERVER_IP + "/DAAS/Web/RemoteControl.aspx?PSP=DaasPSP&PSO=DaasSO&BO=GetDaasPushList&Channel=CC";

	/**
	 * PUSH를 발송 할 대상 리스트를 가져온다.
	 * @return : PUSH List
	 */
	public DaasPushListVO getPushList() {

		// 객체 선언
		//this.httpClient = new HttpClient();		// 서버와 통신
		String webRequestResult = null;			// 서버와의 통신 결과 저장 
		DaasPushListVO daasPushListVO = null;	// 리턴
		
		try {
			
			// PUSH 대상 데이터 조회
			webRequestResult = HttpClient.doGet(DEV_URL);

			// XML 본문에 특수기호를 포맷에 맞게 변환 해준다.
			webRequestResult = StringUtils.replaceEach(webRequestResult,
					new String[] { "&amp;", "&quot;", "&lt;", "&gt;" }, new String[] { "&", "\"", "<", ">" });			
			
			// START : XML -> OBJECT 			
			// XML -> OBJECT
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
					webRequestResult.toString().getBytes(Charset.forName("UTF-8")));
			
			// unmarshal을 위한 JAXBContext 생성
			JAXBContext jc = JAXBContext.newInstance(DaasPushListVO.class);
			
			// Unmarshaller 생성
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			
			// 리턴 객체 생성
			daasPushListVO = (DaasPushListVO) unmarshaller.unmarshal(byteArrayInputStream);
			// END : XML -> OBJECT 
			
		} catch (Exception e) {
			logger.error("An Exception was thrown at DaasPSPService.getPushList() ", e);
			//e.printStackTrace();
		}
		
		// 결과 객체
		return daasPushListVO;

	}

}
