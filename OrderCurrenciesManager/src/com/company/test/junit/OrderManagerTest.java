package com.company.test.junit;


import org.junit.Test;

import junit.framework.TestCase;


import com.company.exceptions.businessexceptions.BusinessOrderException;
import com.company.manager.OrderManager;

/**
 * @author mohamed EL KHARROUBI
 * Class to test cases processing received order streams  
 */
public class OrderManagerTest extends TestCase {

	/*
	 * A Correct entreprise order stream to be processed
	 */
	String entrepriseStreamOrder = "Entreprise;sender=EntrepriseA;receiver=EntrepriseB;currency=EUR;amount=1000";
	
	/*
	 * A Correct bank order stream to be processed
	 */
	String bankStreamOrder = "Bank;sender=BankA;receiver=BankB;currency=DOLLAR;amount=100000";	
	
	/*
	 * A Correct individual order stream to be processed
	 */
	String individualStreamOrder = "Individual;sender=IndividualA;receiver=IndividualB;currency=YEN;amount=50";	
	
	/*
	 * A NOT Correct  order stream to be rejected
	 */
	String erronedStreamOrder = "ERROR ORDER";	
	
	
	/*
	 * Testing if Entreprise Order Validation is correct and saved
	 * 
	 */
	@Test
	public void testEntrepriseOrderValidation() throws BusinessOrderException {
		assertTrue("Entreprise order is valid", OrderManager.processOrder(entrepriseStreamOrder).validate());
	}

	/*
	 * Testing if Bank Order Validation is correct and saved
	 * 
	 */
	@Test
	public void testBankOrderValidation() throws BusinessOrderException {
		assertTrue("Bank order is valid", OrderManager.processOrder(bankStreamOrder).validate());
	}

	/*
	 * Testing if Individual Order Validation is correct and saved
	 * 
	 */
	@Test
	public void testIndividualOrderValidation() throws BusinessOrderException {
		assertTrue("Individual order is valid", OrderManager.processOrder(individualStreamOrder).validate());
	}
	
	/*
	 * Testing if not correct Order is correct not validated and saved
	 * 
	 */	
	@Test(expected = BusinessOrderException.class)  
	public void testNOKOrderValidation() throws BusinessOrderException {
		try {
			OrderManager.processOrder(erronedStreamOrder).validate();		
		} catch (BusinessOrderException boe) {
			assert(boe.getMessage().contains("INCORRECT ORDER"));
		}
	}
	
	
}
