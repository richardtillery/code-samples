package com.pst.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleDynamicAttributeTag extends SimpleTagSupport implements DynamicAttributes {

	private String dynamicAttributeName;
	private String dynamicAttributeValue;
	
	@Override
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().write("<div ");
		getJspContext().getOut().write(this.dynamicAttributeName + "=\"" + this.dynamicAttributeValue + "\"");
		getJspContext().getOut().write(" ></div>");
	}

	@Override
	public void setDynamicAttribute(String uri, String localName, Object value)
			throws JspException {
		this.dynamicAttributeName = localName;
		this.dynamicAttributeValue = (String) value;
	}
}
