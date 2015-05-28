package com.pst.test.client;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.ws.Endpoint;

import com.pst.test.service.PersonSOAPService;

public class PersonSOAPClient {

	public static void main(String[] args) {
		Endpoint endpoint = null;
		try {
			endpoint = Endpoint.publish("http://localhost:8182/personservice", new PersonSOAPService());
			//Thread.sleep(1000 * 60);

			URL url = new URL("http://localhost:8182/personservice");
			HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
			urlc.setRequestProperty("Content-Type", "application/soap+xml");
			urlc.setRequestProperty("SOAPAction", "http://localhost:8184/personservice");
			urlc.setDoOutput(true);
			DataOutputStream dos = new DataOutputStream(urlc.getOutputStream());
			dos.write("<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><test>Blabby blab</test></soap:Body></soap:Envelope>".getBytes());
			dos.flush();
			dos.close();
			System.out.println("Response = [" + urlc.getResponseCode() + "]");
			Thread.sleep(1000 * 30);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(endpoint != null)
				endpoint.stop();						
		}		
	}

}
