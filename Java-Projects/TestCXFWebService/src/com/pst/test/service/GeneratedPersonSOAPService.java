/**
 * 
 */
package com.pst.test.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * SOAP service from which wsdl will be generated
 */
@WebService
public class GeneratedPersonSOAPService {

	@WebMethod
	public String fetchPerson() {
		return "Person Name";
	}
	
}
