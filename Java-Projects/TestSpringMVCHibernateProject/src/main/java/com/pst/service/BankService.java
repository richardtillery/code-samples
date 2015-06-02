/**
 * 
 */
package com.pst.service;

import java.util.Random;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tilleryr
 *
 */
@Component
@Transactional(propagation=Propagation.REQUIRED)
public class BankService {

	@Inject
	PlatformTransactionManager txManager;
	
	public void doTransaction() {
		this.doDebt();
		this.doCredit();
		txManager.commit(null);
	}
	
	public void doDebt() {
		System.out.println(Thread.currentThread().getId() + "|DEBITING...");
        Random rg = new Random();
        int binaryNum = rg.nextInt(8);
        if(binaryNum == 1) {
        	txManager.rollback(null);
        	throw new RuntimeException("TRANSACTION FAILED!!!!!1!");
        }

	}

	public void doCredit() {
		System.out.println(Thread.currentThread().getId() + "|CREDITING...");
	}

}
