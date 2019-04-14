package com.nhn.edu.springboot.test.practice.account.application;

import com.nhn.edu.springboot.test.practice.account.Account;
import com.nhn.edu.springboot.test.practice.configuration.SampleConfig;
import com.nhn.edu.springboot.test.practice.configuration.TestAccountServiceConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE) 
@Import(TestAccountServiceConfiguration.class)
public class AccountServiceWithTestConfigurationTest {
    @Autowired
    AccountService service;

    @Test
    public void getAccounts() {
        List<Account> accounts = service.getAccounts();
        assertThat(accounts, hasSize(0));
    }

    @Test
    public void getAccount() {
        Long accountId = 1L;
        Account account = service.getAccount(accountId);
        
        assertThat(account.getUserId(), is("ww"));
        assertThat(account.getName(), is("Walter White"));
    }
}
