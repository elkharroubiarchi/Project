package com.company.manager;

import com.company.exceptions.businessexceptions.BusinessOrderException;
import com.company.orderparsers.OrderParser;
import com.company.orderparsers.BankOrderParser;
import com.company.orderparsers.EntrepriseOrderParser;
import com.company.orderparsers.IndividualOrderParser;
import com.company.orders.IOrder;
import com.company.orders.Order;


/**
 * @author mohamed el kharroubi
 * Class which manages all received stream orders, parsing streams, and instancing JAVA orders objects with the right business datas.
 *   	
 */

public class OrderManager {

	
	
	/**
	 * Simulates receiving stream orders and process it to create order java objects
	 * @param stream order
	 */
	public static void receive (String stream) throws BusinessOrderException {
		processOrder(stream);
	}
	
	
	
	/**
	 * Method which process received streams, and instanciates order java objects whith the right business datas
	 * @param stream
	 * @return
	 */
	public static IOrder processOrder(String stream) throws BusinessOrderException{
		
		if(stream.contains("Bank")) {
			
			OrderParser bankParser = new BankOrderParser();
			return bankParser.parse(stream);
			
		} else  
		
		if(stream.contains("Entreprise")) {	
			
			EntrepriseOrderParser entrepriseParser = new EntrepriseOrderParser();
			return entrepriseParser.parse(stream);
			
		}  else 
		
		if (stream.contains("Individual"))  {	
			
			IndividualOrderParser individualParser = new IndividualOrderParser();
			return individualParser.parse(stream);
			
		}  else {
			throw new BusinessOrderException(stream);
		}
	
	}
	
		

}
