package com.pst.test.service;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXSource;
import javax.xml.ws.BindingType;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.sun.org.apache.xml.internal.resolver.readers.SAXParserHandler;

/**
 * Person Service - RESTful with JAX-WS
 */
@WebServiceProvider
@ServiceMode(Mode.PAYLOAD)
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
		if(request != null) {
			SAXSource saxSource = (SAXSource) request;
			try {			
				SAXParserHandler handler = new SAXParserHandler() {
					@Override
					public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes) throws SAXException {
						System.out.print("|" + paramString2 + "|");
					}
					@Override
					public void characters(char[] paramArrayOfChar,
							int paramInt1, int paramInt2) throws SAXException {
						System.out.print("|" + new String(paramArrayOfChar).substring(paramInt1, paramInt1+paramInt2) + "|");						
					}
					@Override					  
					public void endElement(String paramString1, String paramString2, String paramString3) throws SAXException {
						System.out.print("|" + paramString2 + "|");
					}
				};				
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				Result output = new SAXResult(handler);
				transformer.transform(saxSource, output);
				System.out.println("");
			} catch(Exception e) {
				e.printStackTrace();
				e.getCause().printStackTrace();
			}			
		}
		return null;
	}

}
