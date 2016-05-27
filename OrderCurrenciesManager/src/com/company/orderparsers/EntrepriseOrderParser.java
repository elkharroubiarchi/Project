package com.company.orderparsers;

import com.company.exceptions.businessexceptions.BusinessOrderException;
import com.company.orders.IOrder;
import com.company.orders.Order;


/**
 * @author mohamed el kharroubi
 * Class which represents an order beetween two Entreprises	
 */

public class EntrepriseOrderParser implements OrderParser{

	/* 
	 * Method to parse Entreprise order stream and extracts business data in map cantaining order 
	 * Stream exo 	"Entreprise;sender=EntrepriseA;receiver=EntrepriseB;currency=EUR;amount=1000"
	 */
	
	public IOrder parse (String stream) throws BusinessOrderException{
		
		Order order = new Order();
		try {
			String [] orderElements = stream.split(";");
			order.setType(orderElements[0]);
			order.setSender(orderElements[1].split("=")[1]);
			order.setReceiver(orderElements[2].split("=")[1]);
			order.setCurrency(orderElements[3].split("=")[1]);
			order.setAmount(new Double(orderElements[4].split("=")[1]).doubleValue() );
		} catch (NullPointerException npe) {
			throw new BusinessOrderException(stream);
		} catch (ArrayIndexOutOfBoundsException qibe) {
			throw new BusinessOrderException(stream);
		}
		return order;
		
	}
	
}
