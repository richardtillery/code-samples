package com.pst.controller;

import java.util.Random;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pst.service.BankService;

/**
 * JAXB Safety check!
 */
@Controller
@RequestMapping("/jaxb-thread")
public class JAXBThreadSafetyController {

	private final static String EXAM_RESPONSE_XSD_2_0 = "/schemas/Employee-2.0.xsd";
	private final static String EXAM_RESPONSE_XSD_1_0 = "/schemas/Employee-1.0.xsd";

	private final static String DOCUMENT_XML = "/test/Employee.xml";

	private BankService service;

	/**
	 * @return the service
	 */
	public BankService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	@Bean
	@Scope(value = "request")
	@Autowired
	public void setService(BankService service) {
		this.service = service;
	}

	//private SchemaFactory schemaFactory = null; 
			//SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	/** SchemaFactory for fetching schemas to validate CUI XML, not thread-safe so use ThreadLocal **/
	private ThreadLocal<SchemaFactory> schemaFactory = new ThreadLocal<SchemaFactory>() {
		@Override
		protected SchemaFactory initialValue() {
			SchemaFactory factory = null;
			try {
				factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
				factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, false);
			} catch (Exception e) {
				System.out.println("CUIServiceImpl - fatal error while creating SchemaFactory");
			}
			return factory;
		}
	};

	@RequestMapping(value={"/safe"}, method={RequestMethod.GET})
	public ModelAndView safetyCheck() throws Exception {
		ModelAndView modelAndView = new ModelAndView("sanity");
		
        Random rg = new Random();
        int binaryNum = rg.nextInt(2);
        
        String xsd = EXAM_RESPONSE_XSD_1_0;
        boolean shouldBeValid = false;
        if(binaryNum == 0) {
        	xsd = EXAM_RESPONSE_XSD_2_0;
            System.out.println(Thread.currentThread().getId() + "|Should be valid");
            shouldBeValid = true;
        } else {
            System.out.println(Thread.currentThread().getId() + "|Should be invalid");                	
            shouldBeValid = false;
        }
        
		boolean valid = validateDocument(DOCUMENT_XML, xsd);
		
		if(shouldBeValid != valid) {
			throw new RuntimeException("Thread Safety Check failure!!! " + Thread.currentThread().getId());
		}
		return modelAndView;
	}

	@RequestMapping(value={"/tx"}, method={RequestMethod.GET})
	public ModelAndView transactionCheck() throws Exception {
		ModelAndView modelAndView = new ModelAndView("sanity");		
		this.getService().doTransaction();		
		return modelAndView;
	}

	/**
	 * @return SchemaFactory
	 */
/*	private SchemaFactory getSchemaFactory() throws Exception {			
		if(schemaFactory == null) {
			schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
			System.out.println(Thread.currentThread().getId() + "|SchemaFactory|" + schemaFactory.hashCode() + "just fetched the schema factory");
			schemaFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, false);			
			System.out.println(Thread.currentThread().getId() + "|SchemaFactory|" + schemaFactory.hashCode() + "just set the secure processing on the schema factory");
		}
		return schemaFactory;
	}
	*/
	/**
	 * validate provided document off of provided xsd (must be full path to XSD within this jar)
	 * @param document
	 * @param xsdPath
	 * @return
	 * @throws Exception
	 */
	private boolean validateDocument(String document, String xsdPath) throws Exception {
		boolean valid = false;
		
		SchemaFactory schemaFactory = this.schemaFactory.get();
		System.out.println(Thread.currentThread().getId() + "|SchemaFactory|" + schemaFactory.hashCode() + " fetched schemaFactory ");

		Source xmlSource = new StreamSource(getClass().getResourceAsStream(document));
		//Schema schema = schemaFactory.newSchema(getClass().getResource(xsdPath));
		Schema schema = schemaFactory.newSchema(getClass().getResource(xsdPath));		
		System.out.println(Thread.currentThread().getId() + "|Schema|" + schema.hashCode() + " set new schema on schemaFactory ");
		
		Validator validator = schema.newValidator();
		System.out.println(Thread.currentThread().getId() + "|Validator|" + validator.hashCode()  + " fetched validator from schemafactory ");
		
		validator.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, false);
		try {
            validator.validate(xmlSource);
            valid = true;
            System.out.println(Thread.currentThread().getId() + "|Valid!");
		} catch (Exception e) {
			valid = false;
            System.out.println(Thread.currentThread().getId() + "|Not Valid!");
		}
		return valid;
	}
	

}
