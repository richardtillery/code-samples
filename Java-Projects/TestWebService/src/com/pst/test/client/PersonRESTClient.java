package com.pst.test.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.ws.Endpoint;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.PostMethod;

import com.pst.test.service.PersonRESTService;

/**
 * Example for using curl commands to communicate with service instead:
 * $ curl -X POST --data test=value\&test2=value2 --max-time 5 --url http://localhost:8182/personservice
 * $ curl -X POST --data "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><test>Blabby blab</test></soap:Body></soap:Envelope>" --max-time 5 --url http://localhost:8182/personservice
 *
 */
public class PersonRESTClient {

	public static void main(String[] args) throws InterruptedException, IOException {
		Endpoint endpoint = null;
		HttpConnection hconn = null;
		try {
			endpoint = Endpoint.publish("http://localhost:8182/personservice", new PersonRESTService());
			//useApacheCommonsInstead(endpoint, hconn);
			URL url = new URL("http://localhost:8182/personservice");// + "?testParam=testValue");
			HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
			urlc.setRequestMethod("POST");
			urlc.setDoInput(true);
			urlc.setDoOutput(true);
			DataOutputStream dos = new DataOutputStream(urlc.getOutputStream());
			dos.write("testParam=testValue".getBytes());
			dos.flush();
			dos.close();
			System.out.println("Response = [" + urlc.getResponseCode() + "]");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(endpoint != null)
				endpoint.stop();
			if(hconn != null) 
				hconn.close();
		}
	}
	
	private void useApacheCommonsInstead(Endpoint endpoint, HttpConnection hconn) throws NullPointerException, IOException {
		URI uri = new URI("http://localhost:8182/personservice", false);
		HostConfiguration hc = new HostConfiguration();
		hc.setHost(uri);			
		
		PostMethod postMethod = new PostMethod(uri.getURI());
		NameValuePair[] data = {
		          new NameValuePair("user", "blah"),
		          new NameValuePair("password", "blaaah")
		};
		postMethod.setRequestBody(data);
		postMethod.setContentChunked(true);
		postMethod.setParameter("param", "paramValue");
		postMethod.setQueryString(data);
		postMethod.setRequestHeader(new Header("Rich", "Value"));
		hconn = new HttpConnection(hc);
		hconn.open();
		int returnCode = postMethod.execute(new HttpState(), hconn);
		System.out.println("Response = [" + returnCode + "]");
	}

}
