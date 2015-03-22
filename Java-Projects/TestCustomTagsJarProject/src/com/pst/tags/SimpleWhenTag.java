/**
 * 
 */
package com.pst.tags;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;


/**
 * When tag, emulates c:when
 */
public class SimpleWhenTag extends SimpleTagSupport {

	protected final Logger logger = Logger.getLogger(getClass().getName());
	private boolean test;
	
	@Override
	public void doTag() throws JspException, IOException {
		if(getParent() instanceof SimpleChooseTag) {
			if(((SimpleChooseTag) getParent()).isChosen() == false && isTest()) {			
				((SimpleChooseTag) getParent()).setChosen(true);			
				getJspBody().invoke(null);
			}			
		}
	}

	/**
	 * @return the test
	 */
	public boolean isTest() {
		return test;
	}

	/**
	 * @param test the test to set
	 */
	public void setTest(boolean test) {
		this.test = test;
	}
	
	

}
