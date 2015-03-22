/**
 * 
 */
package com.tillery.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author bond
 *
 */
public class RedirectButton extends SimpleTagSupport {

	private String uri;
	
	@Override
	public void doTag() throws JspException, IOException {
		
		String markup = "<button onclick=\"javascript:document.location.replace('" + this.getUri() + "');\">Button</button>";		
		this.getJspContext().getOut().write(markup);		
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}
