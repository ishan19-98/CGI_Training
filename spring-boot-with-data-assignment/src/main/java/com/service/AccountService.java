package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Account;
import com.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	public String createAccount(Account account) {

		Optional<Account> result = accountRepository.findById(account.getAccno());
		System.out.println(result);
		if (result.isPresent()) {
			return "Account already exists!, Try using differant account number";
		}
		else
		{
			if ((account.getAmount() > 1000)) {
				accountRepository.save(account);
				return "Account is created successfully";
			} else {
				return "Account must be greater than 1000";
			}
		} 
	}

	public String deposit(Account account) {
		Optional<Account> result = accountRepository.findById(account.getAccno());
		if (!result.isPresent()) {
			return "Account Does Not Exists";
		} else {
			if ((account.getAmount() < 50000)) {
				float currentBalance=result.get().getAmount();
				account.setAmount(currentBalance+account.getAmount());
				accountRepository.save(account);
				return "Amount is deposited successfully";
			} else {
				return "Amount deposit failed! PAN Number details are neeeded to deposit amount greater that 50000";
			}
		}
	}


	public String withdraw(Account account) {
		Optional<Account> result = accountRepository.findById(account.getAccno());
		if (!result.isPresent()) {
			return "Account Does Not Exists";
		} else {

			float currentBalance = result.get().getAmount();
			if ((currentBalance > 1000)) {
				if (currentBalance >= account.getAmount()) {
					account.setAmount(currentBalance - account.getAmount());
					accountRepository.save(account);
					return "Amount is withdrawn successfully";
				} else
					return "No Sufficient Amount Balance to withdraw entered amount";
			} else {
				return "Amount withdrawl failed! Your Account balance is less than 1000 Rupees";
			}
		}
	}

	public String checkBalance(Account account) {
		Optional<Account> result = accountRepository.findById(account.getAccno());
		if (!result.isPresent()) {
			return "Account Does Not Exists";
		} else {
			return "Hi "+result.get().getName()+", Your account balance is: "+result.get().getAmount();
		}

	}

}
