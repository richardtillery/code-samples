package com.pst.test.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author tilleryr
 *
 */
@WebService(targetNamespace = "http://service.test.pst.com/", portName = "SpecificPersonSOAPMessageGeneratorPort", serviceName = "SpecificPersonSOAPMessageGeneratorService")
public class SpecificPersonSOAPMessageGenerator {

	@WebMethod
	public String fetchSpecificPersonMessage(@WebParam(name="personName", mode=WebParam.Mode.IN) String personName) {
		return "Hello " + personName;
	}

}
