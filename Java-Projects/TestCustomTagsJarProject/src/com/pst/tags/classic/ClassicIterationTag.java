/**
 * 
 */
package com.pst.tags.classic;

import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Iteration Tag - Classic version
 */
public class ClassicIterationTag extends TagSupport {

	private static final long serialVersionUID = -6013451851505041560L;
	
	private Collection<String> collection;
	private String var;

	private String[] array;
	private int currentItem;
	private int totalCount;

	@Override
	public int doStartTag() throws JspException {
		this.array = this.collection.toArray(new String[0]);
		this.currentItem = 0;
		if(this.getCollection() != null) {
			this.totalCount = this.getCollection().size();			
		} else {
			this.totalCount = 0;
		}
		pageContext.setAttribute(getVar(), this.array[this.currentItem++]);			
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		if(this.currentItem < this.totalCount) {
			pageContext.setAttribute(getVar(), this.array[this.currentItem++]);			
			return EVAL_BODY_AGAIN;
		} else {
			return EVAL_BODY_INCLUDE;
		}
	}
	
	@Override
	public int doEndTag() throws JspException {
		//all resetting happens in start tag
		return EVAL_PAGE;
	}

	/**
	 * @return the collection
	 */
	public Collection<String> getCollection() {
		return collection;
	}

	/**
	 * @param collection the collection to set
	 */
	public void setCollection(Collection<String> collection) {
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

	/**
	 * @return the currentItem
	 */
	public int getCurrentItem() {
		return currentItem;
	}

	/**
	 * @param currentItem the currentItem to set
	 */
	public void setCurrentItem(int currentItem) {
		this.currentItem = currentItem;
	}

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
