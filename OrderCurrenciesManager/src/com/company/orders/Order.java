package com.company.orders;



/**
 * @author mohamed el kharroubi
 * Class which represents a java representation of received stream order
 * An order can be validated or saved if it is correct 
 */
public class Order implements IOrder {
    
	private String stream;
	
	private String type;
	private String sender;
	private String receiver;
	private String currency;
	private double amount;
	
	public Order() {
	}

	/*
	 * Method Validating order by converting currency 
	 * If validated the order is saved
	 * 
	 */
	public boolean validate() {
		if (this.convertToEurCurrency()) {
			this.save();
			return true;
		} else {
			return false;
		}
	}
	
	
	/*
	 * Method converting all currencies for received order in euro 
	 * If no currency found, the order is no valid 
	 * 
	 */
	public boolean convertToEurCurrency() {
		
		boolean isCorrectlyConverted = true;
		if("EUR".equals(this.currency)) {
			
		} else 
		if ("DOLLAR".equals(this.currency)) {	
			this.setAmount(amount*0.75);
		}  else 			
		if ("YEN".equals(this.currency)) {
			this.setAmount(amount*0.5);
		} else {
			isCorrectlyConverted = false;
		}
		
		return isCorrectlyConverted;
		
	}
	
	/* 
	 * Method called to save the order if it is a correct order
	 * 
	 */
	public boolean save() {
		System.out.println("Saving Valid order " + 
				this.getType() + ", Sender = " + this.getSender() + 
					"  Receiver = " + this.getReceiver() 
						+ " Amount = " + this.getAmount() );
		return true;
	}
	
	
	
	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	


}
