package com.pst.test.service;

import javax.annotation.Resource;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingType;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.soap.SOAPBinding; 

/**
 * 
 * JAX-WS service, send in the SOAP
 *
 */
@WebServiceProvider
@ServiceMode(Mode.MESSAGE)
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class PersonSOAPService implements Provider<SOAPMessage> {

	@Resource
	WebServiceContext wsctx;
	
	@Override
	public SOAPMessage invoke(SOAPMessage request) {
		try {
			System.out.println("Request Is: " + request.getSOAPBody().getFirstChild().getNodeName() + "|" + request.getSOAPBody().getFirstChild().getTextContent());
		} catch (SOAPException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
}