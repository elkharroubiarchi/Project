/**
 * interface for all order parsers (Text, Json, XML ...)
 */
package com.company.orderparsers;

/**
 * @author mohamed elkharroubi
 * Order interface defines a contract beetween all kinds of orders 
 * all of them must define a parsing method
 */

import com.company.exceptions.businessexceptions.BusinessOrderException;
import com.company.orders.IOrder;

public interface OrderParser {

	
	/**
	 * Method to parse order stream  
	 * @param stream representing order
	 * @return An order of business order elements names and their values
	 */
	public IOrder parse (String stream ) throws BusinessOrderException;
	
}
