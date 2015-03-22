/**
 * 
 */
package com.pst.jmesa.view;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 */
public class ListComparator implements Comparator {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Object obj1, Object obj2) {
		StringBuffer first = new StringBuffer();
		StringBuffer second = new StringBuffer();
		
		for(Object obj : (ArrayList<String>) obj1) {
			first.append(obj);
		}

		for(Object obj : (ArrayList<String>) obj2) {
			second.append(obj);
		}		
		
		return first.toString().compareTo(second.toString());
	}

}
