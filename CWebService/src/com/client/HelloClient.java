package com.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.webservice.HelloWebService;


public class HelloClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:9999/ws/hello?wsdl");

        //1st argument service URI, refer to wsdl document above
		//2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://webservice.com/", "HelloWebServiceImplService");
        Service service = Service.create(url, qname);
        HelloWebService hello = service.getPort(HelloWebService.class);
        System.out.println(hello.getUserInfo("mkyong"));
    }
}
