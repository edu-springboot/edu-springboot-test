package com.nhn.edu.springboot.test.practice.account.application;

import com.nhn.edu.springboot.test.practice.account.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAccounts();

    Account getAccount(Long accountId);
}
