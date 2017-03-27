package com.webservice;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "com.webservice.HelloWebService")
public class HelloWebServiceImpl implements HelloWebService{

	@Override
	public String getUserInfo(String name) {
		String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
				+ "<soap:Body>"
				+ "<ns1:sumResponse xmlns:ns1=\"http://superbiz.org/wsdl\">"
				+ "<return>10</retu"
				+ "</ns1:sumRespons"
				+ " </soap:Body>"
				+ "</soap:Envelope>";
		
		return result;
	}

}