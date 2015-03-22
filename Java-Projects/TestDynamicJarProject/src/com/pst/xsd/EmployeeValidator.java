package com.pst.xsd;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class EmployeeValidator {

	/**
	 * run this to validate employee xml!
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		Source schemaFile = new StreamSource(new File("resources/Employee.xsd"));
		Source xmlFile = new StreamSource(new File("resources/Employee.xml"));
		SchemaFactory schemaFactory = SchemaFactory
		    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(schemaFile);
		Validator validator = schema.newValidator();
		try {
		  validator.validate(xmlFile);
		  System.out.println(xmlFile.getSystemId() + " is valid");
		} catch (SAXException e) {
		  System.out.println(xmlFile.getSystemId() + " is NOT valid");
		  System.out.println("Reason: " + e.getLocalizedMessage());
		}
	}

}
