package com.nhn.edu.springboot.test.practice.configuration;

import com.nhn.edu.springboot.test.practice.account.Account;
import com.nhn.edu.springboot.test.practice.account.application.AccountService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Collections;
import java.util.List;

@TestConfiguration
public class TestAccountServiceConfiguration {
    @Bean
    @Primary
    AccountService accountService() {
        return new AccountService() {
            @Override
            public List<Account> getAccounts() {
                return Collections.emptyList();
            }

            @Override
            public Account getAccount(Long accountId) {
                return Account.forCreate("ww", "Walter White");
            }
        };
    }
}
