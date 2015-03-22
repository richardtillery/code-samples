/**
 * 
 */
package com.pst.jmesa.view;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.collections.comparators.NullComparator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jmesa.core.sort.ColumnSort;
import org.jmesa.limit.Limit;
import org.jmesa.limit.Order;
import org.jmesa.limit.Sort;
import org.jmesa.limit.SortSet;

/**
 *
 */
public class CustomColumnSort implements ColumnSort {

	protected final Log logger = LogFactory.getLog(getClass());

	/* (non-Javadoc)
	 * @see org.jmesa.core.sort.ColumnSort#sortItems(java.util.Collection, org.jmesa.limit.Limit)
	 */
	@Override
    public Collection<?> sortItems(Collection<?> items, Limit limit) {

		logger.info("CustomColumnSort : sortItems invoked");
		
		ComparatorChain chain = new ComparatorChain();
        SortSet sortSet = limit.getSortSet();
        for (Sort sort : sortSet.getSorts()) {
            if (sort.getOrder() == Order.ASC) {
            	if(sort.getProperty().contains("hobbies")) {            		
                	chain.addComparator(new BeanComparator(sort.getProperty(), new ListComparator()));            		
            	} else {
                	chain.addComparator(new BeanComparator(sort.getProperty(), new NullComparator()));            		
            	}
            } else if (sort.getOrder() == Order.DESC) {
            	if(sort.getProperty().contains("hobbies")) {            		
                    chain.addComparator(new BeanComparator(sort.getProperty(), new ListComparator()), true);
            	} else {
                    chain.addComparator(new BeanComparator(sort.getProperty(), new NullComparator()), true);
            	}
            }
        }

        if (chain.size() > 0) {
            Collections.sort((List<?>) items, chain);
        }

        return items;
    }

}
