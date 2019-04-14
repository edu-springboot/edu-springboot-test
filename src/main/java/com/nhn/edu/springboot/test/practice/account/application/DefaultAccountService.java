package com.nhn.edu.springboot.test.practice.account.application;

import com.nhn.edu.springboot.test.practice.account.Account;
import com.nhn.edu.springboot.test.practice.account.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultAccountService implements AccountService {
    private final AccountRepository accountRepository;

    public DefaultAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccount(Long accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }
}
