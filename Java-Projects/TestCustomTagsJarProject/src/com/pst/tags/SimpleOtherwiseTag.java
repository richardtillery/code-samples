/**
 * 
 */
package com.pst.tags;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Otherwise tag, emulates c:otherwise
 */
public class SimpleOtherwiseTag extends SimpleTagSupport {

	protected final Logger logger = Logger.getLogger(getClass().getName());

	@Override
	public void doTag() throws JspException, IOException {
		if(getParent() instanceof SimpleChooseTag) {
			if(((SimpleChooseTag) getParent()).isChosen() == false) {			
				getJspBody().invoke(null);
			}			
		}
	}

}
