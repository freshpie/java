package com.kt.push.util;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;


public class HttpClient {	
	public static String doGet(String url) throws Exception {
		// request
		Request request = Request.Get(url);
		request.connectTimeout(1000);
		request.socketTimeout(1000);
		request.addHeader("Content-Type", "text/html; charset=UTF-8");

		// response
		Response response = request.execute();

		// return
		return response.returnContent().asString();

	}
}
