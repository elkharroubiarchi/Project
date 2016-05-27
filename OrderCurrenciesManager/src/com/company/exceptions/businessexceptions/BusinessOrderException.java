package com.company.exceptions.businessexceptions;


/**
 * @author mohamed el kharroubi
 * Business Exception thrown in all technical exceptions when processing 
 */
public class BusinessOrderException extends Exception{

	public BusinessOrderException(String streamOrder) {
		if(streamOrder!=null) {
			System.out.println("INCORRECT ORDER: PLEASE CHECK RECEIVED STREAM '" + streamOrder + "'");
		} else {
			System.out.println("INCORRECT ORDER: RECEIVED STREAM IS NULL");
		}
	}
	
	
}
