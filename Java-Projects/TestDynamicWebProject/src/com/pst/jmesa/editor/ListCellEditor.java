/**
 * 
 */
package com.pst.jmesa.editor;

import java.util.HashMap;
import java.util.List;

import org.jmesa.view.editor.CellEditor;

import com.pst.domain.Person;

/**
 * Editor for lists
 */
public class ListCellEditor implements CellEditor {

	/* (non-Javadoc)
	 * @see org.jmesa.view.editor.CellEditor#getValue(java.lang.Object, java.lang.String, int)
	 */
	@Override
	public Object getValue(Object rowValues, String property, int rowcount) {
		StringBuffer output = new StringBuffer();
		if(rowValues instanceof Person) {
			Person person = (Person) rowValues;				
			List<String> items = person.getHobbies();
			for(String item : items) {
				output.append(item + "<br>");
			}		
		} else {
			List<String> items = (List<String>) ((HashMap) rowValues).get(property);
			for(String item : items) {
				output.append(item + "<br>");
			}						
		}
		return output;
	}

}
