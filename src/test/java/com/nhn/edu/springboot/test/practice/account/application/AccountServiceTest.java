package com.nhn.edu.springboot.test.practice.account.application;

import com.nhn.edu.springboot.test.practice.configuration.SampleConfig;
import com.nhn.edu.springboot.test.practice.account.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * @author myeongju.jung
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)    // !!
public class AccountServiceTest {
    @Autowired
    AccountService service;

    @Test
    public void getAccounts() {
        // given
        // when
        List<Account> accounts = service.getAccounts();
        // then
        assertThat(accounts, hasSize(8));
        accounts.forEach(this::assertAccount);
    }

    private void assertAccount(Account account) {
        assertThat(account.getAccountId(), is(notNullValue()));
        assertThat(account.getUserId(), is(notNullValue()));
        assertThat(account.getName(), is(notNullValue()));
        assertThat(account.getCreatedAt(), is(notNullValue()));
    }

    /**
     * 첫번째 계정을 조회하고 내용을 검증하는 테스트케이스 입니다.
     * 最初のアカウントを照会して、内容を検証するためのテストケースです。
     * 
     * Hint : {@link SampleConfig}
     */
    @Test
    public void getAccount() {
        // given
        Long accountId = 1L;
        // when
        Account account = service.getAccount(accountId);
        // then
        assertThat(account.getAccountId(), is(accountId));
        // TODO 2-1 : 테스트가 통과할 수 있도록 다음의 코드를 수정해 주세요.
        // TODO 2-1 : テストに合格することができるように、次のコードを修正してください。
        assertThat(account.getUserId(), is(""));
        assertThat(account.getCreatedAt(), is(lessThan(null)));
    }
}
