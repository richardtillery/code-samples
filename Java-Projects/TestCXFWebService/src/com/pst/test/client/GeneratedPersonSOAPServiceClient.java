/**
 * 
 */
package com.pst.test.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


/**
 * Tests the GeneratedPersonSOAPService - that service must be installed to Tomcat
 */
public class GeneratedPersonSOAPServiceClient {

	public static void main(String[] args) throws InterruptedException, IOException {

		URL url = new URL("http://localhost:8082/TestCXFWebService/services/specificpersonsoapmessagegenerator");
		HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
		urlc.setRequestProperty("SOAPAction", "");
		urlc.setDoOutput(true);
		DataOutputStream dos = new DataOutputStream(urlc.getOutputStream());
		dos.write(
				new String("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " + 
		                                    " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " + 
                                            " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " + 
		                                    " xmlns:tns=\"http://service.test.pst.com/\" >" + 
                                            " <soapenv:Body> " + 
		                                    "  <tns:fetchSpecificPersonMessage>" + 
                                            "    <personName>Richard</personName>" + 
		                                    "  </tns:fetchSpecificPersonMessage>" + 
                                            "</soapenv:Body></soapenv:Envelope>").getBytes());
		dos.flush();
		dos.close();
		//System.out.println("Response = [" + IOUtils.toString(urlc.getInputStream()) + "]");
		//stupid scanner trick
		System.out.println("Response = [" + new Scanner(urlc.getInputStream()).useDelimiter("\\A").next() + "]");

/*		URL url = new URL("http://localhost:8082/TestCXFWebService/services/PersonService");
		HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
		urlc.setRequestProperty("SOAPAction", "");
		urlc.setDoOutput(true);
		DataOutputStream dos = new DataOutputStream(urlc.getOutputStream());
		dos.write("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Body><fetchPerson xmlns=\"http://service.test.pst.com/\"/></soapenv:Body></soapenv:Envelope>".getBytes());
		dos.flush();
		dos.close();
		//System.out.println("Response = [" + IOUtils.toString(urlc.getInputStream()) + "]");
		//stupid scanner trick
		System.out.println("Response = [" + new Scanner(urlc.getInputStream()).useDelimiter("\\A").next() + "]");
*/	}

}
