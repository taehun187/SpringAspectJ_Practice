package com.taehun.aspectj.declaringadvice.dao;

import com.taehun.aspectj.declaringadvice.model.Account;

public interface AccountDao {
	
	Account findAccountById(String id); 
	void updateAccount(Account account);

}
