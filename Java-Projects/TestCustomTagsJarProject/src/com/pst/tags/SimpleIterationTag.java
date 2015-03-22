/**
 * 
 */
package com.pst.tags;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Iteration tag, emulates c:forEach
 */
public class SimpleIterationTag extends SimpleTagSupport {

	private Collection<String> collection;
	private String var;
	
	@Override
	public void doTag() throws JspException, IOException {
		//for each item in the collection, place into page scope and invoke jsp body
		if(collection != null) {
			for(String item: collection) {				
				getJspContext().setAttribute(getVar(), item);
				getJspBody().invoke(null);
			}
		}
	}

	/**
	 * @return the collection
	 */
	public Collection getCollection() {
		return collection;
	}

	/**
	 * @param collection the collection to set
	 */
	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	/**
	 * @return the var
	 */
	public String getVar() {
		return var;
	}

	/**
	 * @param var the var to set
	 */
	public void setVar(String var) {
		this.var = var;
	}
}
