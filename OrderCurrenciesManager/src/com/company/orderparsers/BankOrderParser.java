package com.company.orderparsers;

import com.company.exceptions.businessexceptions.BusinessOrderException;
import com.company.orders.IOrder;
import com.company.orders.Order;

/**
 * @author mohamed el kharroubi
 * Class which represents an order beetween two banks	
 */

public class BankOrderParser implements OrderParser{

	/* 
	 * Method to parse Bank order stream and extracts business data, and instanciate an order with the right datas   
	 * Stream Exo "Bank;sender=BankA;receiver=BankB;currency=DOLLAR;amount=100000"
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
			npe.printStackTrace();
			throw new BusinessOrderException(stream);
		} catch (ArrayIndexOutOfBoundsException qibe) {
			qibe.printStackTrace();
			throw new BusinessOrderException(stream);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessOrderException(stream);
		}	
		return order;
		
	}
	
}
