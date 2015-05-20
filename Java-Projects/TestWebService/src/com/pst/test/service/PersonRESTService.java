package com.pst.test.service;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.ws.BindingType;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

/**
 * Person Service - RESTful with JAX-WS
 */
@WebServiceProvider
@ServiceMode(Mode.MESSAGE)
@BindingType(HTTPBinding.HTTP_BINDING)
public class PersonRESTService implements Provider<Source> {

	@Resource
	WebServiceContext wsctx;
	
	@Override
	public Source invoke(Source request) {
		String verb = (String) wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_METHOD);
		String queryString = (String) wsctx.getMessageContext().get(MessageContext.QUERY_STRING);
		System.out.println(verb + " Request Recieved, " + queryString + " Is The Query String!");
		System.out.println("Was request present? " + request);
		return null;
	}

}
