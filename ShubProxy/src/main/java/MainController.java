package main.java;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/shubProxy", method=RequestMethod.POST)
	public String shubProxy(@RequestBody Map<String, String> json) throws Exception {
    	String xmlData = json.get("xml");
    	String url = json.get("url");
    	
    	logger.info("=============Requset==================");
    	logger.info("EndPointUrl : " + url);
    	logger.info("RequestSOAPMessage : " + xmlData);
    	
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory.createConnection();

		//String url = "https://cus.tbapi.kt.com:443/SubscriptionInfoRetrieval/SubscriptionInfoRetrievalManager";
		MessageFactory factory = MessageFactory.newInstance();
	    SOAPMessage message = factory.createMessage(new MimeHeaders(), new ByteArrayInputStream(xmlData.toString().getBytes()));
		SOAPMessage soapResponse = soapConnection.call(message, url);
	    
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		soapResponse.writeTo(out);
		String strMsg = new String(out.toByteArray());
		soapConnection.close();
		
		logger.info("=============Response==================");
    	logger.info("ResponseSOAPMessage: " + strMsg);
		
        return strMsg;
	}
	
	@RequestMapping("/callsdp")
    public @ResponseBody String callsdp() throws Exception {
    	// Create SOAP Connection
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory.createConnection();

		// Send SOAP Message to SOAP Server
		String url;
		url = "https://cus.tbapi.kt.com:443/SubscriptionInfoRetrieval/SubscriptionInfoRetrievalManager";
		SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);

		// print SOAP Response
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		soapResponse.writeTo(out);
		String strMsg = new String(out.toByteArray());
		soapConnection.close();
		
		System.out.println("Response SOAP Message: " + strMsg);
		
        return strMsg;
    }
    
    private SOAPMessage createSOAPRequest() throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		String serverURI = "https://cus.tbapi.kt.com/";
		String oasURI = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		//System.out.println(envelope.toString());
		envelope.addNamespaceDeclaration("sdp", serverURI);
		envelope.addNamespaceDeclaration("oass", oasURI);

		/*
		 * <?xml version="1.0" encoding="UTF-8"?> <SOAP-ENV:Envelope
		 * xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
		 * xmlns:oas="https://cus.tbapi.kt.com/"
		 * xmlns:sdp="https://cus.tbapi.kt.com/"> <SOAP-ENV:Header>
		 * <oas:Security> <oas:UsernameToken>
		 * <oas:Username>AII7760064711HRPAYM</oas:Username>
		 * <oas:Password>TBK7760064711HOPSBN</oas:Password> </oas:UsernameToken>
		 * </oas:Security> </SOAP-ENV:Header> <SOAP-ENV:Body>
		 * <sdp:getSpecificSubscpnInfoRequest>
		 * <sdp:User_Name>alwayschen</sdp:User_Name>
		 * <sdp:Credt_Type_Cd>01</sdp:Credt_Type_Cd>
		 * </sdp:getSpecificSubscpnInfoRequest> </SOAP-ENV:Body>
		 * </SOAP-ENV:Envelope>
		 */

		// SOAP Header
		SOAPHeader soapHeader = envelope.getHeader();
		SOAPElement hSecurity = soapHeader.addChildElement("Security", "oass");
		SOAPElement hUsernameToken = hSecurity.addChildElement("UsernameToken", "oass");

		// Username
		SOAPElement hUserName = hUsernameToken.addChildElement("Username", "oass");
		hUserName.addTextNode("AII7760064711HRPAYM");

		// Password
		SOAPElement hPassword = hUsernameToken.addChildElement("Password", "oass");
		hPassword.addTextNode("TBK7760064711HOPSBN");

		// SOAP Body
		SOAPBody soapBody = envelope.getBody();
		SOAPElement bGetSpecificSubscpnInfoRequest = soapBody.addChildElement("getSpecificSubscpnInfoRequest", "sdp");

		// User_Name
		SOAPElement bUserName = bGetSpecificSubscpnInfoRequest.addChildElement("User_Name", "sdp");
		bUserName.addTextNode("alwayschen");

		// Credt_Type_Cd
		SOAPElement bCredtTypeCd = bGetSpecificSubscpnInfoRequest.addChildElement("Credt_Type_Cd", "sdp");
		bCredtTypeCd.addTextNode("01");

		// MimeHeaders headers = soapMessage.getMimeHeaders();
		// headers.addHeader("SOAPAction", serverURI + "VerifyEmail");

		soapMessage.saveChanges();

		/* Print the request message */
		System.out.print("Request SOAP Message:");
		soapMessage.writeTo(System.out);
		System.out.println();

		return soapMessage;
	}
}



