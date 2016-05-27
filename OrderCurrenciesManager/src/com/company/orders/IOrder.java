package com.company.orders;

/**
 * @author mohamed el kharroubi
 * Interface defining the commun behaviors for all orders objects
 * 
 */
public interface IOrder {

	/*
	 * Methods which checkes if the order is correct by converting order currency 
	 * Order is no valid if no currency found
	 */
	public boolean validate();
	
	/*
	 * Method which converts order currency to euro 
	 * if no currency found the order is no longer valid
	 */
	public boolean convertToEurCurrency();
	
	
	public boolean save();
}
