/**
 * 
 */
package com.pst.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Choose tag, emulates c:choose
 */
public class SimpleChooseTag extends SimpleTagSupport {

	private boolean chosen;
	
	@Override
	public void doTag() throws JspException, IOException {
		chosen = false;
		getJspBody().invoke(null);
	}

	/**
	 * @return the result
	 */
	public boolean isChosen() {
		return chosen;
	}

	/**
	 * @param result the result to set
	 */
	public void setChosen(boolean chosen) {
		this.chosen = chosen;
	}

}
